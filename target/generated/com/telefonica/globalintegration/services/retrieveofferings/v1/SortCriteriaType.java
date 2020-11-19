
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of SortCriteria
 * 
 * 				Functional struct: The business concepts contained are
 * 					- propertyName: Field propertyName
 * 					- isAscending: Field isAscending
 * 			
 * 
 * <p>Java class for SortCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="propertyName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}propertyNameStringValueType"/&gt;
 *         &lt;element name="isAscending" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}isAscendingBooleanValueType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortCriteriaType", propOrder = {
    "propertyName",
    "isAscending"
})
public class SortCriteriaType {

    @XmlElement(required = true)
    protected String propertyName;
    protected boolean isAscending;

    /**
     * Gets the value of the propertyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the isAscending property.
     * 
     */
    public boolean isIsAscending() {
        return isAscending;
    }

    /**
     * Sets the value of the isAscending property.
     * 
     */
    public void setIsAscending(boolean value) {
        this.isAscending = value;
    }

}
