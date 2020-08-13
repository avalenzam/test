
package com.telefonica.globalintegration.fault;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.globalintegration.fault package. 
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

    private final static QName _MessageFault_QNAME = new QName("http://telefonica.com/globalIntegration/fault", "MessageFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.globalintegration.fault
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OperationFaultType }
     * 
     */
    public OperationFaultType createOperationFaultType() {
        return new OperationFaultType();
    }

    /**
     * Create an instance of {@link ExceptionProtocolType }
     * 
     */
    public ExceptionProtocolType createExceptionProtocolType() {
        return new ExceptionProtocolType();
    }

    /**
     * Create an instance of {@link AppDetailType }
     * 
     */
    public AppDetailType createAppDetailType() {
        return new AppDetailType();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://telefonica.com/globalIntegration/fault", name = "MessageFault")
    public JAXBElement<OperationFaultType> createMessageFault(OperationFaultType value) {
        return new JAXBElement<OperationFaultType>(_MessageFault_QNAME, OperationFaultType.class, null, value);
    }

}
