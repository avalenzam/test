
package com.telefonica.globalintegration.header;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.globalintegration.header package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HeaderIn_QNAME = new QName("http://telefonica.com/globalIntegration/header", "HeaderIn");
    private final static QName _HeaderOut_QNAME = new QName("http://telefonica.com/globalIntegration/header", "HeaderOut");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.globalintegration.header
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HeaderInType }
     * 
     */
    public HeaderInType createHeaderInType() {
        return new HeaderInType();
    }

    /**
     * Create an instance of {@link HeaderOutType }
     * 
     */
    public HeaderOutType createHeaderOutType() {
        return new HeaderOutType();
    }

    /**
     * Create an instance of {@link VarArgType }
     * 
     */
    public VarArgType createVarArgType() {
        return new VarArgType();
    }

    /**
     * Create an instance of {@link ArgType }
     * 
     */
    public ArgType createArgType() {
        return new ArgType();
    }

    /**
     * Create an instance of {@link ValuesType }
     * 
     */
    public ValuesType createValuesType() {
        return new ValuesType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderInType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://telefonica.com/globalIntegration/header", name = "HeaderIn")
    public JAXBElement<HeaderInType> createHeaderIn(HeaderInType value) {
        return new JAXBElement<HeaderInType>(_HeaderIn_QNAME, HeaderInType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderOutType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://telefonica.com/globalIntegration/header", name = "HeaderOut")
    public JAXBElement<HeaderOutType> createHeaderOut(HeaderOutType value) {
        return new JAXBElement<HeaderOutType>(_HeaderOut_QNAME, HeaderOutType.class, null, value);
    }

}
