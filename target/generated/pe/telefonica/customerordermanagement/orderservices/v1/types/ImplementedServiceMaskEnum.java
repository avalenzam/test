
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ImplementedServiceMaskEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ImplementedServiceMaskEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="SERVICE_ONLY"/&gt;
 *     &lt;enumeration value="SERVICE_AND_ATTRIBUTES_FOR_READONLY"/&gt;
 *     &lt;enumeration value="SERVICE_AND_ATTRIBUTES_FOR_MODIFICATION"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ImplementedServiceMaskEnum")
@XmlEnum
public enum ImplementedServiceMaskEnum {

    NONE,
    SERVICE_ONLY,
    SERVICE_AND_ATTRIBUTES_FOR_READONLY,
    SERVICE_AND_ATTRIBUTES_FOR_MODIFICATION;

    public String value() {
        return name();
    }

    public static ImplementedServiceMaskEnum fromValue(String v) {
        return valueOf(v);
    }

}
