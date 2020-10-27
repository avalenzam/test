
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of Pricing
 * 
 * 				Functional struct: The business concepts contained are
 * 					- technology: Service Technology
 * 					- downloadSpeed: Download speed of the product
 * 					- price: Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 			
 * 
 * <p>Clase Java para PricingType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PricingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="technology" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}technologyServiceType"/&gt;
 *         &lt;element name="downloadSpeed" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}downloadSpeedProductSpecificationType"/&gt;
 *         &lt;element name="price" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PricingType", propOrder = {
    "technology",
    "downloadSpeed",
    "price"
})
public class PricingType {

    @XmlElement(required = true)
    protected String technology;
    @XmlElement(required = true)
    protected String downloadSpeed;
    @XmlElement(required = true)
    protected UNIMoneyType price;

    /**
     * Obtiene el valor de la propiedad technology.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * Define el valor de la propiedad technology.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechnology(String value) {
        this.technology = value;
    }

    /**
     * Obtiene el valor de la propiedad downloadSpeed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadSpeed() {
        return downloadSpeed;
    }

    /**
     * Define el valor de la propiedad downloadSpeed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadSpeed(String value) {
        this.downloadSpeed = value;
    }

    /**
     * Obtiene el valor de la propiedad price.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setPrice(UNIMoneyType value) {
        this.price = value;
    }

}
