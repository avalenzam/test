
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para productTypeEnumType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="productTypeEnumType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="mobile"/&gt;
 *     &lt;enumeration value="landline"/&gt;
 *     &lt;enumeration value="ipTv"/&gt;
 *     &lt;enumeration value="cableTv"/&gt;
 *     &lt;enumeration value="email"/&gt;
 *     &lt;enumeration value="broadband"/&gt;
 *     &lt;enumeration value="bundle"/&gt;
 *     &lt;enumeration value="sva"/&gt;
 *     &lt;enumeration value="sim"/&gt;
 *     &lt;enumeration value="ShEq"/&gt;
 *     &lt;enumeration value="bolton"/&gt;
 *     &lt;enumeration value="dth"/&gt;
 *     &lt;enumeration value="streamingTv"/&gt;
 *     &lt;enumeration value="accessories"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "productTypeEnumType")
@XmlEnum
public enum ProductTypeEnumType {

    @XmlEnumValue("mobile")
    MOBILE("mobile"),
    @XmlEnumValue("landline")
    LANDLINE("landline"),
    @XmlEnumValue("ipTv")
    IP_TV("ipTv"),
    @XmlEnumValue("cableTv")
    CABLE_TV("cableTv"),
    @XmlEnumValue("email")
    EMAIL("email"),
    @XmlEnumValue("broadband")
    BROADBAND("broadband"),
    @XmlEnumValue("bundle")
    BUNDLE("bundle"),
    @XmlEnumValue("sva")
    SVA("sva"),
    @XmlEnumValue("sim")
    SIM("sim"),
    @XmlEnumValue("ShEq")
    SH_EQ("ShEq"),
    @XmlEnumValue("bolton")
    BOLTON("bolton"),
    @XmlEnumValue("dth")
    DTH("dth"),
    @XmlEnumValue("streamingTv")
    STREAMING_TV("streamingTv"),
    @XmlEnumValue("accessories")
    ACCESSORIES("accessories");
    private final String value;

    ProductTypeEnumType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ProductTypeEnumType fromValue(String v) {
        for (ProductTypeEnumType c: ProductTypeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
