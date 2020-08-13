
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
 * <p>Java class for PricingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the technology property.
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
     * Sets the value of the technology property.
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
     * Gets the value of the downloadSpeed property.
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
     * Sets the value of the downloadSpeed property.
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
     * Gets the value of the price property.
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
     * Sets the value of the price property.
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
