package com.telefonica.globalintegration.services.soap.retrieveofferings.v1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * OSB Service
 *
 * This class was generated by Apache CXF 3.1.15
 * 2020-10-22T10:36:03.445-05:00
 * Generated source version: 3.1.15
 * 
 */
@WebServiceClient(name = "retrieveOfferings_v1", 
                  wsdlLocation = "file:/D:/proyectos/NUEVO_MOTOR/shaka-elegiblefoffers-fi/src/main/resources/static/ro/v1.wsdl",
                  targetNamespace = "http://telefonica.com/globalIntegration/services/SOAP/retrieveOfferings/v1") 
public class RetrieveOfferingsV1_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://telefonica.com/globalIntegration/services/SOAP/retrieveOfferings/v1", "retrieveOfferings_v1");
    public final static QName RetrieveOfferingsV1 = new QName("http://telefonica.com/globalIntegration/services/SOAP/retrieveOfferings/v1", "retrieveOfferings_v1");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/proyectos/NUEVO_MOTOR/shaka-elegiblefoffers-fi/src/main/resources/static/ro/v1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RetrieveOfferingsV1_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/D:/proyectos/NUEVO_MOTOR/shaka-elegiblefoffers-fi/src/main/resources/static/ro/v1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RetrieveOfferingsV1_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RetrieveOfferingsV1_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RetrieveOfferingsV1_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public RetrieveOfferingsV1_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RetrieveOfferingsV1_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RetrieveOfferingsV1_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns RetrieveOfferingsV1
     */
    @WebEndpoint(name = "retrieveOfferings_v1")
    public RetrieveOfferingsV1 getRetrieveOfferingsV1() {
        return super.getPort(RetrieveOfferingsV1, RetrieveOfferingsV1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RetrieveOfferingsV1
     */
    @WebEndpoint(name = "retrieveOfferings_v1")
    public RetrieveOfferingsV1 getRetrieveOfferingsV1(WebServiceFeature... features) {
        return super.getPort(RetrieveOfferingsV1, RetrieveOfferingsV1.class, features);
    }

}
