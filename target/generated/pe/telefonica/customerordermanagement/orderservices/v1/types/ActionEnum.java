
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ActionEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ActionEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SU"/&gt;
 *     &lt;enumeration value="RE"/&gt;
 *     &lt;enumeration value="CE"/&gt;
 *     &lt;enumeration value="LS"/&gt;
 *     &lt;enumeration value="RL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActionEnum")
@XmlEnum
public enum ActionEnum {

    SU,
    RE,
    CE,
    LS,
    RL;

    public String value() {
        return name();
    }

    public static ActionEnum fromValue(String v) {
        return valueOf(v);
    }

}
