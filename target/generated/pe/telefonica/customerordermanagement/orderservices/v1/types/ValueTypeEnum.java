
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para valueTypeEnum.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="valueTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Boolean"/&gt;
 *     &lt;enumeration value="Char"/&gt;
 *     &lt;enumeration value="Double"/&gt;
 *     &lt;enumeration value="Date"/&gt;
 *     &lt;enumeration value="Numeric"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "valueTypeEnum")
@XmlEnum
public enum ValueTypeEnum {

    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Char")
    CHAR("Char"),
    @XmlEnumValue("Double")
    DOUBLE("Double"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Numeric")
    NUMERIC("Numeric");
    private final String value;

    ValueTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValueTypeEnum fromValue(String v) {
        for (ValueTypeEnum c: ValueTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
