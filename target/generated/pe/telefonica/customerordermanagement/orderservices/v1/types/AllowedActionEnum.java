
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AllowedActionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AllowedActionEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RM"/&gt;
 *     &lt;enumeration value="SU"/&gt;
 *     &lt;enumeration value="RS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AllowedActionEnum")
@XmlEnum
public enum AllowedActionEnum {

    RM,
    SU,
    RS;

    public String value() {
        return name();
    }

    public static AllowedActionEnum fromValue(String v) {
        return valueOf(v);
    }

}
