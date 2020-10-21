
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				This is the input interface of 'retrieveOfferings' operation. The first level fields are:
 * 					- customerId: customer ID, length 12
 * 					- productType: Field productType. Indication of the type of product instance registered. Supported values are implementation and application specific (enum values)
 * 					- category: Data for the category creation/update (synonym of CategoryTreeType) (similar concept that SID attribute defined by 'p1:CategoryTreeTypeType')
 * 					- channel.id: Field channel.id. To obtain objects trigerred over an specific channel identified by id
 * 					- product.id: Field product.id
 * 					- productOrderId: Field productOrderId
 * 					- catalogID: Field catalogID
 * 					- productOfferingCatalogId: Synonym of productOfferingCatalogIds (similar concept that SID attribute defined by 'p1:productOfferingCatalogIdsProductOfferingType')
 * 					- filterInfo: Synonym of FilterInfo (similar concept that SID attribute defined by 'p1:FilterInfoType')
 * 			
 * 
 * <p>Clase Java para retrieveOfferingsRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="retrieveOfferingsRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="customerId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}customerIdCustomerType"/&gt;
 *         &lt;element name="productType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productTypeEnumType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="category" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}CategoryTreeTypeType" minOccurs="0"/&gt;
 *         &lt;element name="channel.id" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}channel.idType" minOccurs="0"/&gt;
 *         &lt;element name="product.id" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}product.idType" minOccurs="0"/&gt;
 *         &lt;element name="productOrderId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productOrderIdProductType" minOccurs="0"/&gt;
 *         &lt;element name="catalogID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}catalogIDProductCatalogType" minOccurs="0"/&gt;
 *         &lt;element name="productOfferingCatalogId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productOfferingCatalogIdsProductOfferingType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="filterInfo" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}FilterInfoType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retrieveOfferingsRequestType", propOrder = {
    "customerId",
    "productType",
    "category",
    "channelId",
    "productId",
    "productOrderId",
    "catalogID",
    "productOfferingCatalogId",
    "filterInfo"
})
public class RetrieveOfferingsRequestType {

    @XmlElement(required = true)
    protected BigDecimal customerId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected List<ProductTypeEnumType> productType;
    protected CategoryTreeTypeType category;
    @XmlElement(name = "channel.id")
    protected String channelId;
    @XmlElement(name = "product.id")
    protected String productId;
    protected String productOrderId;
    protected String catalogID;
    protected List<String> productOfferingCatalogId;
    protected FilterInfoType filterInfo;

    /**
     * Obtiene el valor de la propiedad customerId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCustomerId() {
        return customerId;
    }

    /**
     * Define el valor de la propiedad customerId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCustomerId(BigDecimal value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductTypeEnumType }
     * 
     * 
     */
    public List<ProductTypeEnumType> getProductType() {
        if (productType == null) {
            productType = new ArrayList<ProductTypeEnumType>();
        }
        return this.productType;
    }

    /**
     * Obtiene el valor de la propiedad category.
     * 
     * @return
     *     possible object is
     *     {@link CategoryTreeTypeType }
     *     
     */
    public CategoryTreeTypeType getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryTreeTypeType }
     *     
     */
    public void setCategory(CategoryTreeTypeType value) {
        this.category = value;
    }

    /**
     * Obtiene el valor de la propiedad channelId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Define el valor de la propiedad channelId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelId(String value) {
        this.channelId = value;
    }

    /**
     * Obtiene el valor de la propiedad productId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Define el valor de la propiedad productId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductId(String value) {
        this.productId = value;
    }

    /**
     * Obtiene el valor de la propiedad productOrderId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductOrderId() {
        return productOrderId;
    }

    /**
     * Define el valor de la propiedad productOrderId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductOrderId(String value) {
        this.productOrderId = value;
    }

    /**
     * Obtiene el valor de la propiedad catalogID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogID() {
        return catalogID;
    }

    /**
     * Define el valor de la propiedad catalogID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogID(String value) {
        this.catalogID = value;
    }

    /**
     * Gets the value of the productOfferingCatalogId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productOfferingCatalogId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductOfferingCatalogId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProductOfferingCatalogId() {
        if (productOfferingCatalogId == null) {
            productOfferingCatalogId = new ArrayList<String>();
        }
        return this.productOfferingCatalogId;
    }

    /**
     * Obtiene el valor de la propiedad filterInfo.
     * 
     * @return
     *     possible object is
     *     {@link FilterInfoType }
     *     
     */
    public FilterInfoType getFilterInfo() {
        return filterInfo;
    }

    /**
     * Define el valor de la propiedad filterInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterInfoType }
     *     
     */
    public void setFilterInfo(FilterInfoType value) {
        this.filterInfo = value;
    }

}
