
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of Attachment - retrieveOfferings
 * 
 * 				Functional struct: The business concepts contained are
 * 					- purpose: Field purpose of the attachment
 * 					- attachmentLocation: Field attachmentLocation
 * 					- attachmentType: Field attachmentType
 * 			
 * 
 * <p>Java class for AttachmentOfferingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachmentOfferingsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="purpose" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}purposeAttachmentType" minOccurs="0"/&gt;
 *         &lt;element name="attachmentLocation" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}attachmentLocationAttachmentType"/&gt;
 *         &lt;element name="attachmentType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}attachmentTypeStringValueType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentOfferingsType", propOrder = {
    "purpose",
    "attachmentLocation",
    "attachmentType"
})
public class AttachmentOfferingsType {

    protected String purpose;
    @XmlElement(required = true)
    protected String attachmentLocation;
    @XmlElement(required = true)
    protected String attachmentType;

    /**
     * Gets the value of the purpose property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurpose(String value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the attachmentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentLocation() {
        return attachmentLocation;
    }

    /**
     * Sets the value of the attachmentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentLocation(String value) {
        this.attachmentLocation = value;
    }

    /**
     * Gets the value of the attachmentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttachmentType() {
        return attachmentType;
    }

    /**
     * Sets the value of the attachmentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttachmentType(String value) {
        this.attachmentType = value;
    }

}
