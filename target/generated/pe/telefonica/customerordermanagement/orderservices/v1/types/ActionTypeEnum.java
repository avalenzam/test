
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActionTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActionTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="AD"/&gt;
 *     &lt;enumeration value="RM"/&gt;
 *     &lt;enumeration value="UP"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActionTypeEnum")
@XmlEnum
public enum ActionTypeEnum {

    AD,
    RM,
    UP;

    public String value() {
        return name();
    }

    public static ActionTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
