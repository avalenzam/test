package com.telefonica.eof.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.telefonica.eof.commons.WSProperties;

@Configuration
public class SoapClientConfig {
	
	@Autowired
	private WSProperties prop;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPaths(
        		"pe.telefonica.customerordermanagement.orderservices.v1.types",
				"pe.telefonica.teferror.v1",
				"pe.telefonica.tefrequestheader.v1",
				"pe.telefonica.tefresponseheader.v1",
				"com.telefonica.globalintegration.fault",
				"com.telefonica.globalintegration.header",
				"com.telefonica.globalintegration.services.retrieveofferings.v1");
        return marshaller;
    }
    
	@Bean(name = "penaltyWS")
	public WebServiceTemplate penaltyConfigWs() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(marshaller());
		webServiceTemplate.setUnmarshaller(marshaller());
		webServiceTemplate.setDefaultUri(prop.getUrlPenaltyService());
		webServiceTemplate.setMessageSender(wsMessageSender());
		return webServiceTemplate;
	}
	
	@Bean(name = "offeringsWS")
	public WebServiceTemplate offeringsConfigWs() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(marshaller());
		webServiceTemplate.setUnmarshaller(marshaller());
		webServiceTemplate.setDefaultUri(prop.getUrlOfferingsService());
		webServiceTemplate.setMessageSender(wsMessageSender());
		return webServiceTemplate;
	}

	@Bean
	public WebServiceMessageSender wsMessageSender() {
		HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
		sender.setConnectionTimeout(prop.getConnectiontimeout());
		sender.setReadTimeout(prop.getReadtimeout());
		return sender;
	}
	
}
