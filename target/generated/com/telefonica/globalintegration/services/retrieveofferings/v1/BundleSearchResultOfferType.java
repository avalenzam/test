
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of BundleSearchResult - retrieveOfferings
 * 
 * 				Functional struct: The business concepts contained are
 * 					- planName: The name of the plan
 * 					- offeringName: Synonym of planName (similar concept that SID attribute defined by 'p1:planNameCatalogSpecificationType')
 * 					- image: Field image
 * 					- displayName: ContactÂ´s suggested name to display in user interfaces (e.g. in an instant messaging buddy list)
 * 			
 * 
 * <p>Java class for BundleSearchResultOfferType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BundleSearchResultOfferType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="planName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}planNameCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="offeringName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}planNameCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="image" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}imageURLType" minOccurs="0"/&gt;
 *         &lt;element name="displayName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIdisplayNameType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BundleSearchResultOfferType", propOrder = {
    "planName",
    "offeringName",
    "image",
    "displayName"
})
public class BundleSearchResultOfferType {

    protected String planName;
    protected String offeringName;
    protected String image;
    protected String displayName;

    /**
     * Gets the value of the planName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Sets the value of the planName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanName(String value) {
        this.planName = value;
    }

    /**
     * Gets the value of the offeringName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferingName() {
        return offeringName;
    }

    /**
     * Sets the value of the offeringName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferingName(String value) {
        this.offeringName = value;
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

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

}
