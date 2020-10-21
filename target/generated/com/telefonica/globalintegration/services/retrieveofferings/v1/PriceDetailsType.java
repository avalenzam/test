
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
 * <p>Clase Java para PriceDetailsType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad priceType.
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
     * Define el valor de la propiedad priceType.
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
     * Obtiene el valor de la propiedad description.
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
     * Define el valor de la propiedad description.
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

    /**
     * Obtiene el valor de la propiedad taxAmount.
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
     * Define el valor de la propiedad taxAmount.
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
     * Obtiene el valor de la propiedad priceWithTax.
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
     * Define el valor de la propiedad priceWithTax.
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
     * Obtiene el valor de la propiedad minPrice.
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
     * Define el valor de la propiedad minPrice.
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
     * Obtiene el valor de la propiedad maxPrice.
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
     * Define el valor de la propiedad maxPrice.
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
     * Obtiene el valor de la propiedad originalAmount.
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
     * Define el valor de la propiedad originalAmount.
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
     * Obtiene el valor de la propiedad originalTaxAmount.
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
     * Define el valor de la propiedad originalTaxAmount.
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
