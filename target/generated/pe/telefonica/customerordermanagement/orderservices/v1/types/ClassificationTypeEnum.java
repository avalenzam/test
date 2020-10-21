
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ClassificationTypeEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ClassificationTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="General"/&gt;
 *     &lt;enumeration value="Discrete"/&gt;
 *     &lt;enumeration value="Range"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ClassificationTypeEnum")
@XmlEnum
public enum ClassificationTypeEnum {

    @XmlEnumValue("General")
    GENERAL("General"),
    @XmlEnumValue("Discrete")
    DISCRETE("Discrete"),
    @XmlEnumValue("Range")
    RANGE("Range");
    private final String value;

    ClassificationTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClassificationTypeEnum fromValue(String v) {
        for (ClassificationTypeEnum c: ClassificationTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
