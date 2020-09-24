
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.globalintegration.services.retrieveofferings.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RetrieveOfferingsRequest_QNAME = new QName("http://telefonica.com/globalIntegration/services/retrieveOfferings/v1", "retrieveOfferingsRequest");
    private final static QName _RetrieveOfferingsResponse_QNAME = new QName("http://telefonica.com/globalIntegration/services/retrieveOfferings/v1", "retrieveOfferingsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.globalintegration.services.retrieveofferings.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveOfferingsRequestType }
     * 
     */
    public RetrieveOfferingsRequestType createRetrieveOfferingsRequestType() {
        return new RetrieveOfferingsRequestType();
    }

    /**
     * Create an instance of {@link RetrieveOfferingsResponseType }
     * 
     */
    public RetrieveOfferingsResponseType createRetrieveOfferingsResponseType() {
        return new RetrieveOfferingsResponseType();
    }

    /**
     * Create an instance of {@link CategoryTreeTypeType }
     * 
     */
    public CategoryTreeTypeType createCategoryTreeTypeType() {
        return new CategoryTreeTypeType();
    }

    /**
     * Create an instance of {@link FilterInfoType }
     * 
     */
    public FilterInfoType createFilterInfoType() {
        return new FilterInfoType();
    }

    /**
     * Create an instance of {@link CategoryListType }
     * 
     */
    public CategoryListType createCategoryListType() {
        return new CategoryListType();
    }

    /**
     * Create an instance of {@link UNIKeyValueType }
     * 
     */
    public UNIKeyValueType createUNIKeyValueType() {
        return new UNIKeyValueType();
    }

    /**
     * Create an instance of {@link PagingInfoType }
     * 
     */
    public PagingInfoType createPagingInfoType() {
        return new PagingInfoType();
    }

    /**
     * Create an instance of {@link SortCriteriaType }
     * 
     */
    public SortCriteriaType createSortCriteriaType() {
        return new SortCriteriaType();
    }

    /**
     * Create an instance of {@link PagingInfoOutputType }
     * 
     */
    public PagingInfoOutputType createPagingInfoOutputType() {
        return new PagingInfoOutputType();
    }

    /**
     * Create an instance of {@link OfferingTypeOfferType }
     * 
     */
    public OfferingTypeOfferType createOfferingTypeOfferType() {
        return new OfferingTypeOfferType();
    }

    /**
     * Create an instance of {@link ContainingOfferingOfferType }
     * 
     */
    public ContainingOfferingOfferType createContainingOfferingOfferType() {
        return new ContainingOfferingOfferType();
    }

    /**
     * Create an instance of {@link AttachmentOfferingsType }
     * 
     */
    public AttachmentOfferingsType createAttachmentOfferingsType() {
        return new AttachmentOfferingsType();
    }

    /**
     * Create an instance of {@link PlanBODetailsType }
     * 
     */
    public PlanBODetailsType createPlanBODetailsType() {
        return new PlanBODetailsType();
    }

    /**
     * Create an instance of {@link PriceDetailsType }
     * 
     */
    public PriceDetailsType createPriceDetailsType() {
        return new PriceDetailsType();
    }

    /**
     * Create an instance of {@link PricingType }
     * 
     */
    public PricingType createPricingType() {
        return new PricingType();
    }

    /**
     * Create an instance of {@link UNIMoneyType }
     * 
     */
    public UNIMoneyType createUNIMoneyType() {
        return new UNIMoneyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveOfferingsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://telefonica.com/globalIntegration/services/retrieveOfferings/v1", name = "retrieveOfferingsRequest")
    public JAXBElement<RetrieveOfferingsRequestType> createRetrieveOfferingsRequest(RetrieveOfferingsRequestType value) {
        return new JAXBElement<RetrieveOfferingsRequestType>(_RetrieveOfferingsRequest_QNAME, RetrieveOfferingsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveOfferingsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://telefonica.com/globalIntegration/services/retrieveOfferings/v1", name = "retrieveOfferingsResponse")
    public JAXBElement<RetrieveOfferingsResponseType> createRetrieveOfferingsResponse(RetrieveOfferingsResponseType value) {
        return new JAXBElement<RetrieveOfferingsResponseType>(_RetrieveOfferingsResponse_QNAME, RetrieveOfferingsResponseType.class, null, value);
    }

}
