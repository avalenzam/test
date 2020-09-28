package com.telefonica.eof.proxy.offering;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.telefonica.globalintegration.header.HeaderInType;
import com.telefonica.globalintegration.header.ObjectFactory;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsRequestType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: June. 2020
 * @FileName: OfferingsConnection.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los metodos necesarios para conectarse al servicio
 *               soap de ofertas.
 * 
 */
@Service
public class OfferingsConnection {

    @Autowired
    @Qualifier("offeringsWS")
    private WebServiceTemplate webServiceTemplate;

    @SuppressWarnings("unchecked")

    /***
     * Método que envia un request a un servicio soap.
     * 
     * @param url
     *            : Url del servicio soap.
     * @param request
     *            : Request que será enviada al servicio soap.
     * @param metodoRequest
     *            : Método utilizado para enviar el request.
     * @return Response del servicio soap.
     */
    public JAXBElement<RetrieveOfferingsResponseType> callWebService(String url, 
	    RetrieveOfferingsRequestType request, String metodrequest,HeaderInType headerInType) {

	    ObjectFactory of =  new ObjectFactory();
	
	JAXBElement<HeaderInType> test = of.createHeaderIn(headerInType);
	
	return (JAXBElement<RetrieveOfferingsResponseType>) webServiceTemplate.marshalSendAndReceive(
		new JAXBElement<RetrieveOfferingsRequestType>(new QName(url, metodrequest),
			RetrieveOfferingsRequestType.class, request),
		new SoapHeaders(test));
 
    }
}
