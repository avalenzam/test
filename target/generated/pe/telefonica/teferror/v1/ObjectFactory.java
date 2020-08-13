
package pe.telefonica.teferror.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.telefonica.teferror.v1 package. 
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

    private final static QName _ErrorTrace_QNAME = new QName("http://telefonica.pe/TefError/V1", "errorTrace");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.telefonica.teferror.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorTraceType }
     * 
     */
    public ErrorTraceType createErrorTraceType() {
        return new ErrorTraceType();
    }

    /**
     * Create an instance of {@link CodeType }
     * 
     */
    public CodeType createCodeType() {
        return new CodeType();
    }

    /**
     * Create an instance of {@link DetailsType }
     * 
     */
    public DetailsType createDetailsType() {
        return new DetailsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorTraceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://telefonica.pe/TefError/V1", name = "errorTrace")
    public JAXBElement<ErrorTraceType> createErrorTrace(ErrorTraceType value) {
        return new JAXBElement<ErrorTraceType>(_ErrorTrace_QNAME, ErrorTraceType.class, null, value);
    }

}
