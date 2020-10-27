
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of FilterInfo
 * 
 * 				Functional struct: The business concepts contained are
 * 					- sourceProductOfferingId: Field sourceProductOfferingId
 * 					- sourceType: Field sourceType
 * 					- actionType: Field actionType
 * 					- customerType: The type of the customer
 * 					- CommercialZoneId: Field CommercialZoneId
 * 					- serviceTechnology: Technology of the service.
 * 					- networkTechnology: Technology of the network or access element.
 * 					- maxSpeed: Field maxSpeed
 * 					- serviceabilityID: Unique identifier that distinguishes a serviceability process (similar concept that SID attribute defined by 'p1:IDBusinessInteractionType')
 * 					- filterFacets: Synonym of KeyValueType (similar concept that SID attribute defined by 'p1:UNIKeyValueType')
 * 					- creditScore: Field creditScore
 * 					- departament: Department of the store
 * 					- storeId: The ID of the store
 * 					- dealerCode: The code of the dealer
 * 					- portInFlag: Port In Flag. (similar concept that SID attribute defined by 'p1:flagBusinessInteractionBusinessInteractionType')
 * 					- planGroup: The group of the plan used
 * 					- planRank: The plan entity (similar concept that SID attribute defined by 'p1:entityIdEntityType')
 * 					- planCommitmentDuration: Field planCommitmentDuration
 * 					- retentionFlag: Synonym of flagBusinessInteraction (similar concept that SID attribute defined by 'p1:flagBusinessInteractionBusinessInteractionType')
 * 					- offerMinInternetSpeed: Synonym of maxSpeed (similar concept that SID attribute defined by 'p1:maxSpeedProductSpecCharacteristicType')
 * 					- offerMaxInternetSpeed: Synonym of maxSpeed (similar concept that SID attribute defined by 'p1:maxSpeedProductSpecCharacteristicType')
 * 					- invoiceCompany: Invoice company (similar concept that SID attribute defined by 'p1:entityIdEntityType')
 * 					- paginationInfo: Synonym of PagingInfo (similar concept that SID attribute defined by 'p1:PagingInfoType')
 * 					- sortCriteria: Synonym of SortCriteria (similar concept that SID attribute defined by 'p1:SortCriteriaType')
 *                                         - offerName: Name of the Offer. Could be sent the name partially.
 * 			
 * 
 * <p>Java class for FilterInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilterInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sourceProductOfferingId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}sourceProductOfferingIdProductOfferingType" minOccurs="0"/&gt;
 *         &lt;element name="sourceType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}sourceTypeProductOfferingType" minOccurs="0"/&gt;
 *         &lt;element name="actionType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}actionTypeProductType" minOccurs="0"/&gt;
 *         &lt;element name="customerType" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}customerTypeIndividualType" minOccurs="0"/&gt;
 *         &lt;element name="CommercialZoneId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}CommercialZoneIdGeographicAreaType" minOccurs="0"/&gt;
 *         &lt;element name="serviceTechnology" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}serviceTechnologyProductLineType" minOccurs="0"/&gt;
 *         &lt;element name="networkTechnology" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}networkTechnologyProductLineType" minOccurs="0"/&gt;
 *         &lt;element name="maxSpeed" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}maxSpeedProductSpecCharacteristicType" minOccurs="0"/&gt;
 *         &lt;element name="serviceabilityID" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}IDBusinessInteractionType" minOccurs="0"/&gt;
 *         &lt;element name="filterFacets" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}UNIKeyValueType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="creditScore" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}creditScoreCustomerType" minOccurs="0"/&gt;
 *         &lt;element name="departament" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}departamentPlaceType" minOccurs="0"/&gt;
 *         &lt;element name="storeId" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}storeIdPlaceType" minOccurs="0"/&gt;
 *         &lt;element name="dealerCode" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}dealerCodePartyType" minOccurs="0"/&gt;
 *         &lt;element name="portInFlag" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}flagBusinessInteractionBusinessInteractionType" minOccurs="0"/&gt;
 *         &lt;element name="planGroup" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}planGroupProductSpecificationType" minOccurs="0"/&gt;
 *         &lt;element name="planRank" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}entityIdEntityType" minOccurs="0"/&gt;
 *         &lt;element name="planCommitmentDuration" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}planCommitmentDurationProductType" minOccurs="0"/&gt;
 *         &lt;element name="retentionFlag" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}flagBusinessInteractionBusinessInteractionType" minOccurs="0"/&gt;
 *         &lt;element name="offerMinInternetSpeed" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}maxSpeedProductSpecCharacteristicType" minOccurs="0"/&gt;
 *         &lt;element name="offerMaxInternetSpeed" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}maxSpeedProductSpecCharacteristicType" minOccurs="0"/&gt;
 *         &lt;element name="invoiceCompany" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}entityIdEntityType" minOccurs="0"/&gt;
 *         &lt;element name="paginationInfo" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}PagingInfoType" minOccurs="0"/&gt;
 *         &lt;element name="sortCriteria" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}SortCriteriaType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}offerNameType" minOccurs="0"/&gt;
 *         &lt;element name="product" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}productType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterInfoType", propOrder = {
    "sourceProductOfferingId",
    "sourceType",
    "actionType",
    "customerType",
    "commercialZoneId",
    "serviceTechnology",
    "networkTechnology",
    "maxSpeed",
    "serviceabilityID",
    "filterFacets",
    "creditScore",
    "departament",
    "storeId",
    "dealerCode",
    "portInFlag",
    "planGroup",
    "planRank",
    "planCommitmentDuration",
    "retentionFlag",
    "offerMinInternetSpeed",
    "offerMaxInternetSpeed",
    "invoiceCompany",
    "paginationInfo",
    "sortCriteria",
    "name",
    "product"
})
public class FilterInfoType {

    protected String sourceProductOfferingId;
    protected String sourceType;
    protected String actionType;
    protected String customerType;
    @XmlElement(name = "CommercialZoneId")
    protected String commercialZoneId;
    protected String serviceTechnology;
    protected String networkTechnology;
    protected String maxSpeed;
    protected String serviceabilityID;
    protected List<UNIKeyValueType> filterFacets;
    protected String creditScore;
    protected String departament;
    protected String storeId;
    protected String dealerCode;
    protected String portInFlag;
    protected String planGroup;
    protected String planRank;
    protected String planCommitmentDuration;
    protected String retentionFlag;
    protected String offerMinInternetSpeed;
    protected String offerMaxInternetSpeed;
    protected String invoiceCompany;
    protected PagingInfoType paginationInfo;
    protected List<SortCriteriaType> sortCriteria;
    protected String name;
    protected String product;

    /**
     * Gets the value of the sourceProductOfferingId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceProductOfferingId() {
        return sourceProductOfferingId;
    }

    /**
     * Sets the value of the sourceProductOfferingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceProductOfferingId(String value) {
        this.sourceProductOfferingId = value;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceType(String value) {
        this.sourceType = value;
    }

    /**
     * Gets the value of the actionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionType() {
        return actionType;
    }

    /**
     * Sets the value of the actionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionType(String value) {
        this.actionType = value;
    }

    /**
     * Gets the value of the customerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerType() {
        return customerType;
    }

    /**
     * Sets the value of the customerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerType(String value) {
        this.customerType = value;
    }

    /**
     * Gets the value of the commercialZoneId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommercialZoneId() {
        return commercialZoneId;
    }

    /**
     * Sets the value of the commercialZoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommercialZoneId(String value) {
        this.commercialZoneId = value;
    }

    /**
     * Gets the value of the serviceTechnology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceTechnology() {
        return serviceTechnology;
    }

    /**
     * Sets the value of the serviceTechnology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceTechnology(String value) {
        this.serviceTechnology = value;
    }

    /**
     * Gets the value of the networkTechnology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkTechnology() {
        return networkTechnology;
    }

    /**
     * Sets the value of the networkTechnology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkTechnology(String value) {
        this.networkTechnology = value;
    }

    /**
     * Gets the value of the maxSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the value of the maxSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxSpeed(String value) {
        this.maxSpeed = value;
    }

    /**
     * Gets the value of the serviceabilityID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceabilityID() {
        return serviceabilityID;
    }

    /**
     * Sets the value of the serviceabilityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceabilityID(String value) {
        this.serviceabilityID = value;
    }

    /**
     * Gets the value of the filterFacets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filterFacets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilterFacets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UNIKeyValueType }
     * 
     * 
     */
    public List<UNIKeyValueType> getFilterFacets() {
        if (filterFacets == null) {
            filterFacets = new ArrayList<UNIKeyValueType>();
        }
        return this.filterFacets;
    }

    /**
     * Gets the value of the creditScore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditScore() {
        return creditScore;
    }

    /**
     * Sets the value of the creditScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditScore(String value) {
        this.creditScore = value;
    }

    /**
     * Gets the value of the departament property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartament() {
        return departament;
    }

    /**
     * Sets the value of the departament property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartament(String value) {
        this.departament = value;
    }

    /**
     * Gets the value of the storeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * Sets the value of the storeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreId(String value) {
        this.storeId = value;
    }

    /**
     * Gets the value of the dealerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDealerCode() {
        return dealerCode;
    }

    /**
     * Sets the value of the dealerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDealerCode(String value) {
        this.dealerCode = value;
    }

    /**
     * Gets the value of the portInFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortInFlag() {
        return portInFlag;
    }

    /**
     * Sets the value of the portInFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortInFlag(String value) {
        this.portInFlag = value;
    }

    /**
     * Gets the value of the planGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanGroup() {
        return planGroup;
    }

    /**
     * Sets the value of the planGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanGroup(String value) {
        this.planGroup = value;
    }

    /**
     * Gets the value of the planRank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanRank() {
        return planRank;
    }

    /**
     * Sets the value of the planRank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanRank(String value) {
        this.planRank = value;
    }

    /**
     * Gets the value of the planCommitmentDuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanCommitmentDuration() {
        return planCommitmentDuration;
    }

    /**
     * Sets the value of the planCommitmentDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanCommitmentDuration(String value) {
        this.planCommitmentDuration = value;
    }

    /**
     * Gets the value of the retentionFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetentionFlag() {
        return retentionFlag;
    }

    /**
     * Sets the value of the retentionFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetentionFlag(String value) {
        this.retentionFlag = value;
    }

    /**
     * Gets the value of the offerMinInternetSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferMinInternetSpeed() {
        return offerMinInternetSpeed;
    }

    /**
     * Sets the value of the offerMinInternetSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferMinInternetSpeed(String value) {
        this.offerMinInternetSpeed = value;
    }

    /**
     * Gets the value of the offerMaxInternetSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferMaxInternetSpeed() {
        return offerMaxInternetSpeed;
    }

    /**
     * Sets the value of the offerMaxInternetSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferMaxInternetSpeed(String value) {
        this.offerMaxInternetSpeed = value;
    }

    /**
     * Gets the value of the invoiceCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    /**
     * Sets the value of the invoiceCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceCompany(String value) {
        this.invoiceCompany = value;
    }

    /**
     * Gets the value of the paginationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PagingInfoType }
     *     
     */
    public PagingInfoType getPaginationInfo() {
        return paginationInfo;
    }

    /**
     * Sets the value of the paginationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PagingInfoType }
     *     
     */
    public void setPaginationInfo(PagingInfoType value) {
        this.paginationInfo = value;
    }

    /**
     * Gets the value of the sortCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SortCriteriaType }
     * 
     * 
     */
    public List<SortCriteriaType> getSortCriteria() {
        if (sortCriteria == null) {
            sortCriteria = new ArrayList<SortCriteriaType>();
        }
        return this.sortCriteria;
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
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

}
