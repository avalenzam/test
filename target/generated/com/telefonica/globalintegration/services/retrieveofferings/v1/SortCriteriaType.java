
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
 * <p>Clase Java para SortCriteriaType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad propertyName.
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
     * Define el valor de la propiedad propertyName.
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
     * Obtiene el valor de la propiedad isAscending.
     * 
     */
    public boolean isIsAscending() {
        return isAscending;
    }

    /**
     * Define el valor de la propiedad isAscending.
     * 
     */
    public void setIsAscending(boolean value) {
        this.isAscending = value;
    }

}
