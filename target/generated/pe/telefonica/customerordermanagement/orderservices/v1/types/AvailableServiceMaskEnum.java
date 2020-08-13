
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AvailableServiceMaskEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AvailableServiceMaskEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NONE"/&gt;
 *     &lt;enumeration value="SERVICE_ONLY"/&gt;
 *     &lt;enumeration value="SERVICE_AND_ATTRIBUTES_FOR_MODIFICATION"/&gt;
 *     &lt;enumeration value="SERVICE_AND_ATTRIBUTES_FOR_READONLY"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AvailableServiceMaskEnum")
@XmlEnum
public enum AvailableServiceMaskEnum {

    NONE,
    SERVICE_ONLY,
    SERVICE_AND_ATTRIBUTES_FOR_MODIFICATION,
    SERVICE_AND_ATTRIBUTES_FOR_READONLY;

    public String value() {
        return name();
    }

    public static AvailableServiceMaskEnum fromValue(String v) {
        return valueOf(v);
    }

}
