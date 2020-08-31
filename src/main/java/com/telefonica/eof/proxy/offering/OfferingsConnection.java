package com.telefonica.eof.proxy.offering;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.telefonica.globalintegration.header.HeaderInType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsRequestType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

@Service
public class OfferingsConnection {

    @SuppressWarnings("unchecked")
    public JAXBElement<RetrieveOfferingsResponseType> callWebService(String url, RetrieveOfferingsRequestType request, String metodrequest,
	    HeaderInType headerInType){

	WebServiceTemplate webServiceTemplate = new WebServiceTemplate();

	return (JAXBElement<RetrieveOfferingsResponseType>) webServiceTemplate.marshalSendAndReceive(
		new JAXBElement<RetrieveOfferingsRequestType>(new QName(url, metodrequest), RetrieveOfferingsRequestType.class, request),
		new SoapHeaders(headerInType));
    
	
	
    }
}