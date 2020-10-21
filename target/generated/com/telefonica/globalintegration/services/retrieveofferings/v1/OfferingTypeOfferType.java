
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of OfferingType - retrieveOfferings
 * 
 * 				Functional struct: The business concepts contained are
 * 					- businessType: The business type of item
 * 					- catalogItemId: The catalog id of the item (similar concept that SID attribute defined by 'p1:offeringIdCatalogSpecificationType')
 * 					- name: Field name. Contains the name of a person, product, etc.
 * 					- description: Generic description
 * 					- image: Field image
 * 					- banner: Field banner
 * 					- displayName: ContactÂ´s suggested name to display in user interfaces (e.g. in an instant messaging buddy list)
 * 					- catalogItemType: Field catalogItemType
 * 					- relationId: The relation ID (similar concept that SID attribute defined by 'p1:offeringIdCatalogSpecificationType')
 * 					- correlationId: Field correlationId
 * 					- lifeCycleStatus: Field lifeCycleStatus
 * 					- parentCatalogItemID: Field parentCatalogItemID
 * 					- parentCatalogItemName: Field parentCatalogItemName
 * 					- parentCurrentStatus: Field parentCurrentStatus
 * 					- parentAssignedID: Field parentAssignedID
 * 					- planType: The type of plan
 * 					- topRecommended: Field topRecommended
 * 					- productType: Field productType. Indication of the type of product instance registered. Supported values are implementation and application specific (enum values)
 * 					- compatibleWithDevice: Indication for device compatibly
 * 					- minNumOfSubscribers: Field minNumOfSubscribers
 * 					- numOfSubscribers: Field numOfSubscribers
 * 					- sharedPlan: Indicates if the plan is a shared plan
 * 					- containingOfferings: Synonym of ContainingOffering (similar concept that SID attribute defined by 'p1:ContainingOfferingOfferType')
 * 					- isBundle: Indicates if the product is part of a bundle
 * 					- bundledDetails: Synonym of BundleSearchResult (similar concept that SID attribute defined by 'p1:BundleSearchResultOfferType')
 * 					- additionalData: Synonym of KeyValueType (any further information needed by the server for the component) (similar concept that SID attribute defined by 'p1:UNIKeyValueType')
 * 					- attachments: Synonym of Attachment - retrieveOfferings (similar concept that SID attribute defined by 'p1:AttachmentOfferingsType')
 * 					- planBoList: Synonym of PlanBODetails (similar concept that SID attribute defined by 'p1:PlanBODetailsType')
 * 					- priceDetails: Synonym of PriceDetails (similar concept that SID attribute defined by 'p1:PriceDetailsType')
 * 					- children: Synonym of OfferingType - retrieveOfferings (similar concept that SID attribute defined by 'p1:OfferingTypeOfferType')
 * 			
 * 
 * <p>Clase Java para OfferingTypeOfferType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OfferingTypeOfferType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="businessType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}businessTypeProductType" minOccurs="0"/&gt;
 *         &lt;element name="catalogItemId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}offeringIdCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="catalogItemCode" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}offeringIdCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}nameType" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}descriptionType" minOccurs="0"/&gt;
 *         &lt;element name="image" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}imageURLType" minOccurs="0"/&gt;
 *         &lt;element name="banner" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}bannerURLType" minOccurs="0"/&gt;
 *         &lt;element name="displayName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIdisplayNameType" minOccurs="0"/&gt;
 *         &lt;element name="catalogItemType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}catalogItemTypeProductCatalogType" minOccurs="0"/&gt;
 *         &lt;element name="relationId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}offeringIdCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="correlationId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}correlationIdProductType" minOccurs="0"/&gt;
 *         &lt;element name="lifeCycleStatus" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}lifeCycleStatusProductType" minOccurs="0"/&gt;
 *         &lt;element name="parentCatalogItemID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}parentCatalogItemIDProductCatalogType" minOccurs="0"/&gt;
 *         &lt;element name="parentCatalogItemName" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}parentCatalogItemNameProductCatalogType" minOccurs="0"/&gt;
 *         &lt;element name="parentCurrentStatus" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}parentCurrentStatusProductType" minOccurs="0"/&gt;
 *         &lt;element name="parentAssignedID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}parentAssignedIDProductType" minOccurs="0"/&gt;
 *         &lt;element name="planType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}planTypeCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="topRecommended" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}topRecommendedProductType" minOccurs="0"/&gt;
 *         &lt;element name="productType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productTypeEnumType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="compatibleWithDevice" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}compatibleWithDeviceCatalogSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="minNumOfSubscribers" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}minNumOfSubscribersProductType" minOccurs="0"/&gt;
 *         &lt;element name="numOfSubscribers" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}numOfSubscribersProductType" minOccurs="0"/&gt;
 *         &lt;element name="sharedPlan" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}sharedPlanPlanType" minOccurs="0"/&gt;
 *         &lt;element name="isBundle" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}isBundleType" minOccurs="0"/&gt;
 *         &lt;element name="additionalData" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIKeyValueType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="attachments" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}AttachmentOfferingsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="planBoList" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}PlanBODetailsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="priceDetails" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}PriceDetailsType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="children" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}OfferingTypeOfferType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="productOfferingProductSpecID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productOfferingProductSpecIDType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OfferingTypeOfferType", propOrder = {
    "businessType",
    "catalogItemId",
    "catalogItemCode",
    "name",
    "description",
    "image",
    "banner",
    "displayName",
    "catalogItemType",
    "relationId",
    "correlationId",
    "lifeCycleStatus",
    "parentCatalogItemID",
    "parentCatalogItemName",
    "parentCurrentStatus",
    "parentAssignedID",
    "planType",
    "topRecommended",
    "productType",
    "compatibleWithDevice",
    "minNumOfSubscribers",
    "numOfSubscribers",
    "sharedPlan",
    "isBundle",
    "additionalData",
    "attachments",
    "planBoList",
    "priceDetails",
    "children",
    "productOfferingProductSpecID"
})
public class OfferingTypeOfferType {

    protected String businessType;
    protected String catalogItemId;
    protected String catalogItemCode;
    protected String name;
    protected String description;
    protected String image;
    protected String banner;
    protected String displayName;
    protected String catalogItemType;
    protected String relationId;
    protected String correlationId;
    protected String lifeCycleStatus;
    protected String parentCatalogItemID;
    protected String parentCatalogItemName;
    protected String parentCurrentStatus;
    protected String parentAssignedID;
    protected String planType;
    protected Boolean topRecommended;
    @XmlSchemaType(name = "string")
    protected List<ProductTypeEnumType> productType;
    protected String compatibleWithDevice;
    protected String minNumOfSubscribers;
    protected String numOfSubscribers;
    protected String sharedPlan;
    protected Boolean isBundle;
    protected List<UNIKeyValueType> additionalData;
    protected List<AttachmentOfferingsType> attachments;
    protected List<PlanBODetailsType> planBoList;
    protected List<PriceDetailsType> priceDetails;
    protected List<OfferingTypeOfferType> children;
    protected String productOfferingProductSpecID;

    /**
     * Obtiene el valor de la propiedad businessType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * Define el valor de la propiedad businessType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessType(String value) {
        this.businessType = value;
    }

    /**
     * Obtiene el valor de la propiedad catalogItemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogItemId() {
        return catalogItemId;
    }

    /**
     * Define el valor de la propiedad catalogItemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogItemId(String value) {
        this.catalogItemId = value;
    }

    /**
     * Obtiene el valor de la propiedad catalogItemCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogItemCode() {
        return catalogItemCode;
    }

    /**
     * Define el valor de la propiedad catalogItemCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogItemCode(String value) {
        this.catalogItemCode = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad image.
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
     * Define el valor de la propiedad image.
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
     * Obtiene el valor de la propiedad banner.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanner() {
        return banner;
    }

    /**
     * Define el valor de la propiedad banner.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanner(String value) {
        this.banner = value;
    }

    /**
     * Obtiene el valor de la propiedad displayName.
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
     * Define el valor de la propiedad displayName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
    }

    /**
     * Obtiene el valor de la propiedad catalogItemType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogItemType() {
        return catalogItemType;
    }

    /**
     * Define el valor de la propiedad catalogItemType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogItemType(String value) {
        this.catalogItemType = value;
    }

    /**
     * Obtiene el valor de la propiedad relationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationId() {
        return relationId;
    }

    /**
     * Define el valor de la propiedad relationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationId(String value) {
        this.relationId = value;
    }

    /**
     * Obtiene el valor de la propiedad correlationId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Define el valor de la propiedad correlationId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationId(String value) {
        this.correlationId = value;
    }

    /**
     * Obtiene el valor de la propiedad lifeCycleStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    /**
     * Define el valor de la propiedad lifeCycleStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLifeCycleStatus(String value) {
        this.lifeCycleStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad parentCatalogItemID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCatalogItemID() {
        return parentCatalogItemID;
    }

    /**
     * Define el valor de la propiedad parentCatalogItemID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCatalogItemID(String value) {
        this.parentCatalogItemID = value;
    }

    /**
     * Obtiene el valor de la propiedad parentCatalogItemName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCatalogItemName() {
        return parentCatalogItemName;
    }

    /**
     * Define el valor de la propiedad parentCatalogItemName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCatalogItemName(String value) {
        this.parentCatalogItemName = value;
    }

    /**
     * Obtiene el valor de la propiedad parentCurrentStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentCurrentStatus() {
        return parentCurrentStatus;
    }

    /**
     * Define el valor de la propiedad parentCurrentStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentCurrentStatus(String value) {
        this.parentCurrentStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad parentAssignedID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentAssignedID() {
        return parentAssignedID;
    }

    /**
     * Define el valor de la propiedad parentAssignedID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentAssignedID(String value) {
        this.parentAssignedID = value;
    }

    /**
     * Obtiene el valor de la propiedad planType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanType() {
        return planType;
    }

    /**
     * Define el valor de la propiedad planType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanType(String value) {
        this.planType = value;
    }

    /**
     * Obtiene el valor de la propiedad topRecommended.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTopRecommended() {
        return topRecommended;
    }

    /**
     * Define el valor de la propiedad topRecommended.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTopRecommended(Boolean value) {
        this.topRecommended = value;
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
     * Obtiene el valor de la propiedad compatibleWithDevice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompatibleWithDevice() {
        return compatibleWithDevice;
    }

    /**
     * Define el valor de la propiedad compatibleWithDevice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompatibleWithDevice(String value) {
        this.compatibleWithDevice = value;
    }

    /**
     * Obtiene el valor de la propiedad minNumOfSubscribers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinNumOfSubscribers() {
        return minNumOfSubscribers;
    }

    /**
     * Define el valor de la propiedad minNumOfSubscribers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinNumOfSubscribers(String value) {
        this.minNumOfSubscribers = value;
    }

    /**
     * Obtiene el valor de la propiedad numOfSubscribers.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumOfSubscribers() {
        return numOfSubscribers;
    }

    /**
     * Define el valor de la propiedad numOfSubscribers.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumOfSubscribers(String value) {
        this.numOfSubscribers = value;
    }

    /**
     * Obtiene el valor de la propiedad sharedPlan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedPlan() {
        return sharedPlan;
    }

    /**
     * Define el valor de la propiedad sharedPlan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedPlan(String value) {
        this.sharedPlan = value;
    }

    /**
     * Obtiene el valor de la propiedad isBundle.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsBundle() {
        return isBundle;
    }

    /**
     * Define el valor de la propiedad isBundle.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsBundle(Boolean value) {
        this.isBundle = value;
    }

    /**
     * Gets the value of the additionalData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UNIKeyValueType }
     * 
     * 
     */
    public List<UNIKeyValueType> getAdditionalData() {
        if (additionalData == null) {
            additionalData = new ArrayList<UNIKeyValueType>();
        }
        return this.additionalData;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachmentOfferingsType }
     * 
     * 
     */
    public List<AttachmentOfferingsType> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<AttachmentOfferingsType>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the planBoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planBoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanBoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlanBODetailsType }
     * 
     * 
     */
    public List<PlanBODetailsType> getPlanBoList() {
        if (planBoList == null) {
            planBoList = new ArrayList<PlanBODetailsType>();
        }
        return this.planBoList;
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
     * Gets the value of the children property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the children property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildren().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OfferingTypeOfferType }
     * 
     * 
     */
    public List<OfferingTypeOfferType> getChildren() {
        if (children == null) {
            children = new ArrayList<OfferingTypeOfferType>();
        }
        return this.children;
    }

    /**
     * Obtiene el valor de la propiedad productOfferingProductSpecID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductOfferingProductSpecID() {
        return productOfferingProductSpecID;
    }

    /**
     * Define el valor de la propiedad productOfferingProductSpecID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductOfferingProductSpecID(String value) {
        this.productOfferingProductSpecID = value;
    }

}
