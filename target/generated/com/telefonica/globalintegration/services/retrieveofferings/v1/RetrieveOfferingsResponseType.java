
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				This is the output interface of 'retrieveOfferings' operation. The first level fields are:
 * 					- categories: Synonym of CategoryList - retrieveOfferings (similar concept that SID attribute defined by 'p1:CategoryListType')
 * 			
 * 
 * <p>Clase Java para retrieveOfferingsResponseType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="retrieveOfferingsResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categories" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}CategoryListType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveOfferingsResponseType", propOrder = {
    "categories"
})
public class RetrieveOfferingsResponseType {

    protected List<CategoryListType> categories;

    /**
     * Gets the value of the categories property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categories property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategories().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CategoryListType }
     * 
     * 
     */
    public List<CategoryListType> getCategories() {
        if (categories == null) {
            categories = new ArrayList<CategoryListType>();
        }
        return this.categories;
    }

}
