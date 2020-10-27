
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of PriceDetails
 * 
 * 				Functional struct: The business concepts contained are
 * 					- priceType: Field priceType (enum values for product offering Price alteration). Identification for the type of individual pricing component
 * 					- description: Generic description
 * 					- price: Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 					- taxAmount: Taxes to be paid. Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 					- priceWithTax: Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 					- minPrice: Minimum value allowed for the price model offering (tax included). This is used when the accepted value is defined as an allowed range instead of a single value. Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 					- maxPrice: Maximum value allowed for the price model offering (tax included). This is used when the accepted value is defined as an allowed range instead of a single value. Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 					- originalAmount: Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 					- originalTaxAmount: Synonym of MoneyType (similar concept that SID attribute defined by 'p1:UNIMoneyType')
 * 			
 * 
 * <p>Java class for PriceDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="priceType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}priceTypeProdAltType"/&gt;
 *         &lt;element name="description" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}descriptionType" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType"/&gt;
 *         &lt;element name="taxAmount" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType" minOccurs="0"/&gt;
 *         &lt;element name="priceWithTax" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType" minOccurs="0"/&gt;
 *         &lt;element name="minPrice" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType" minOccurs="0"/&gt;
 *         &lt;element name="maxPrice" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType" minOccurs="0"/&gt;
 *         &lt;element name="originalAmount" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType"/&gt;
 *         &lt;element name="originalTaxAmount" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIMoneyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceDetailsType", propOrder = {
    "priceType",
    "description",
    "price",
    "taxAmount",
    "priceWithTax",
    "minPrice",
    "maxPrice",
    "originalAmount",
    "originalTaxAmount"
})
public class PriceDetailsType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected PriceTypeProdAltType priceType;
    protected String description;
    @XmlElement(required = true)
    protected UNIMoneyType price;
    protected UNIMoneyType taxAmount;
    protected UNIMoneyType priceWithTax;
    protected UNIMoneyType minPrice;
    protected UNIMoneyType maxPrice;
    @XmlElement(required = true)
    protected UNIMoneyType originalAmount;
    protected UNIMoneyType originalTaxAmount;

    /**
     * Gets the value of the priceType property.
     * 
     * @return
     *     possible object is
     *     {@link PriceTypeProdAltType }
     *     
     */
    public PriceTypeProdAltType getPriceType() {
        return priceType;
    }

    /**
     * Sets the value of the priceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceTypeProdAltType }
     *     
     */
    public void setPriceType(PriceTypeProdAltType value) {
        this.priceType = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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

    /**
     * Gets the value of the taxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the value of the taxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setTaxAmount(UNIMoneyType value) {
        this.taxAmount = value;
    }

    /**
     * Gets the value of the priceWithTax property.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getPriceWithTax() {
        return priceWithTax;
    }

    /**
     * Sets the value of the priceWithTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setPriceWithTax(UNIMoneyType value) {
        this.priceWithTax = value;
    }

    /**
     * Gets the value of the minPrice property.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getMinPrice() {
        return minPrice;
    }

    /**
     * Sets the value of the minPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setMinPrice(UNIMoneyType value) {
        this.minPrice = value;
    }

    /**
     * Gets the value of the maxPrice property.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getMaxPrice() {
        return maxPrice;
    }

    /**
     * Sets the value of the maxPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setMaxPrice(UNIMoneyType value) {
        this.maxPrice = value;
    }

    /**
     * Gets the value of the originalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the value of the originalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setOriginalAmount(UNIMoneyType value) {
        this.originalAmount = value;
    }

    /**
     * Gets the value of the originalTaxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link UNIMoneyType }
     *     
     */
    public UNIMoneyType getOriginalTaxAmount() {
        return originalTaxAmount;
    }

    /**
     * Sets the value of the originalTaxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIMoneyType }
     *     
     */
    public void setOriginalTaxAmount(UNIMoneyType value) {
        this.originalTaxAmount = value;
    }

}
