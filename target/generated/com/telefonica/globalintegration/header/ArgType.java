
package com.telefonica.globalintegration.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Este elemento queda definido por un tipo complejo y variable en cuya finalidad es permitir cubrir las necesidades particulares de trasmision de informacion del contexto de aplicacion, no relacionada con conceptos de negocio, en las interacciones entre dos sistemas. La estructura propuesta esta formada por un grupo con pares clave-multivalor. No queda recomendado el uso de este elemento por parte de los sistemas salvo en escenarios con necesidades muy concretas.
 * 
 * <p>Java class for argType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="argType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="key" type="{http://telefonica.com/globalIntegration/header}keyType"/&gt;
 *         &lt;element name="values" type="{http://telefonica.com/globalIntegration/header}valuesType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "argType", propOrder = {
    "key",
    "values"
})
public class ArgType {

    @XmlElement(required = true)
    protected String key;
    @XmlElement(required = true)
    protected ValuesType values;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link ValuesType }
     *     
     */
    public ValuesType getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValuesType }
     *     
     */
    public void setValues(ValuesType value) {
        this.values = value;
    }

}
