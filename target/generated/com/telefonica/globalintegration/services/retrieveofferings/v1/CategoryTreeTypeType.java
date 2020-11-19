
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of CategoryTreeType
 * 
 * 				Functional struct: The business concepts contained are
 * 					- id: Unique identifier for an entity (e.g.: customer or customer financial account)
 * 					- href: A resource URI pointing to the resource that stores the entity detailed information
 * 					- name: Name identification for an element (e.g.:in a metadata pair)
 * 					- subcategories: Next level of categories allocated to the component, intended to allow additional segmentation. A product offering may belong to more than one category/subcategory. Synonym for CategoryTreeType (similar concept that SID attribute defined by 'p1:CategoryTreeTypeType')
 * 			
 * 
 * <p>Java class for CategoryTreeTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoryTreeTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIentityIdType"/&gt;
 *         &lt;element name="href" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}hrefType" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNInameType" minOccurs="0"/&gt;
 *         &lt;element name="subcategories" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}CategoryTreeTypeType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryTreeTypeType", propOrder = {
    "id",
    "href",
    "name",
    "subcategories"
})
public class CategoryTreeTypeType {

    @XmlElement(required = true)
    protected String id;
    protected String href;
    protected String name;
    protected CategoryTreeTypeType subcategories;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the subcategories property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryTreeTypeType }
     *     
     */
    public CategoryTreeTypeType getSubcategories() {
        return subcategories;
    }

    /**
     * Sets the value of the subcategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryTreeTypeType }
     *     
     */
    public void setSubcategories(CategoryTreeTypeType value) {
        this.subcategories = value;
    }

}
