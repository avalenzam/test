
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of PlanBODetails
 * 
 * 				Functional struct: The business concepts contained are
 *                                         - billingOfferId: ID of the BO
 * 					- billingOfferCode: The code of the billing offer
 * 					- billingOfferName: Name of the Price Plan for the Offer (similar concept that SID attribute defined by 'p1:catalogNameCatalogSpecificationType')
 * 					- priceDetails: Synonym of PriceDetails (similar concept that SID attribute defined by 'p1:PriceDetailsType')
 * 					- priceList: Synonym of Pricing (similar concept that SID attribute defined by 'p1:PricingType')
 * 					- planInfo: Synonym of KeyValueType (similar concept that SID attribute defined by 'p1:UNIKeyValueType')
 * 			
 * 
 * <p>Java class for PlanBODetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlanBODetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billingOfferId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}billingOfferIdProductOfferingType" minOccurs="0"/&gt;
 *         &lt;element name="billingOfferCode" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}billingOfferCodeProductOfferingType"/&gt;
 *         &lt;element name="billingOfferName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}catalogNameCatalogSpecificationType"/&gt;
 *         &lt;element name="priceDetails" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}PriceDetailsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="priceList" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}PricingType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="planInfo" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIKeyValueType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="productSpecContainmentID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productSpecContainmentIDType" minOccurs="0"/&gt;
 *         &lt;element name="pricePlanSpecContainmentID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}pricePlanSpecContainmentIDType" minOccurs="0"/&gt;
 *         &lt;element name="image" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}imageType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlanBODetailsType", propOrder = {
    "billingOfferId",
    "billingOfferCode",
    "billingOfferName",
    "priceDetails",
    "priceList",
    "planInfo",
    "productSpecContainmentID",
    "pricePlanSpecContainmentID",
    "image"
})
public class PlanBODetailsType {

    protected String billingOfferId;
    @XmlElement(required = true)
    protected String billingOfferCode;
    @XmlElement(required = true)
    protected String billingOfferName;
    protected List<PriceDetailsType> priceDetails;
    protected List<PricingType> priceList;
    protected List<UNIKeyValueType> planInfo;
    protected String productSpecContainmentID;
    protected String pricePlanSpecContainmentID;
    protected String image;

    /**
     * Gets the value of the billingOfferId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingOfferId() {
        return billingOfferId;
    }

    /**
     * Sets the value of the billingOfferId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingOfferId(String value) {
        this.billingOfferId = value;
    }

    /**
     * Gets the value of the billingOfferCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingOfferCode() {
        return billingOfferCode;
    }

    /**
     * Sets the value of the billingOfferCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingOfferCode(String value) {
        this.billingOfferCode = value;
    }

    /**
     * Gets the value of the billingOfferName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillingOfferName() {
        return billingOfferName;
    }

    /**
     * Sets the value of the billingOfferName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillingOfferName(String value) {
        this.billingOfferName = value;
    }

    /**
     * Gets the value of the priceDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceDetailsType }
     * 
     * 
     */
    public List<PriceDetailsType> getPriceDetails() {
        if (priceDetails == null) {
            priceDetails = new ArrayList<PriceDetailsType>();
        }
        return this.priceDetails;
    }

    /**
     * Gets the value of the priceList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PricingType }
     * 
     * 
     */
    public List<PricingType> getPriceList() {
        if (priceList == null) {
            priceList = new ArrayList<PricingType>();
        }
        return this.priceList;
    }

    /**
     * Gets the value of the planInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UNIKeyValueType }
     * 
     * 
     */
    public List<UNIKeyValueType> getPlanInfo() {
        if (planInfo == null) {
            planInfo = new ArrayList<UNIKeyValueType>();
        }
        return this.planInfo;
    }

    /**
     * Gets the value of the productSpecContainmentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductSpecContainmentID() {
        return productSpecContainmentID;
    }

    /**
     * Sets the value of the productSpecContainmentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductSpecContainmentID(String value) {
        this.productSpecContainmentID = value;
    }

    /**
     * Gets the value of the pricePlanSpecContainmentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricePlanSpecContainmentID() {
        return pricePlanSpecContainmentID;
    }

    /**
     * Sets the value of the pricePlanSpecContainmentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricePlanSpecContainmentID(String value) {
        this.pricePlanSpecContainmentID = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

}
