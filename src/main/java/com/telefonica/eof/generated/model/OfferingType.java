package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * OfferingType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")

public class OfferingType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("correlationId")
  private String correlationId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("currentPlanRelationID")
  private String currentPlanRelationID = null;

  @JsonProperty("category")
  @Valid
  private List<CategoryTreeType> category = null;

  @JsonProperty("isPromotion")
  private Boolean isPromotion = null;

  /**
   * How this offered product is billed
   */
  public enum BillingMethodEnum {
    PREPAID("prepaid"),
    
    POSTPAID("postpaid"),
    
    CONTROL("control"),
    
    HYBRID("hybrid");

    private String value;

    BillingMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BillingMethodEnum fromValue(String text) {
      for (BillingMethodEnum b : BillingMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("billingMethod")
  private BillingMethodEnum billingMethod = null;

  @JsonProperty("channel")
  @Valid
  private List<ChannelInfoType> channel = null;

  @JsonProperty("frameworkAgreement")
  private String frameworkAgreement = null;

  @JsonProperty("customerId")
  private String customerId = null;

  @JsonProperty("compatibleProducts")
  @Valid
  private List<ProductInstanceRefType> compatibleProducts = null;

  @JsonProperty("isBundle")
  private Boolean isBundle = null;

  @JsonProperty("offeringUrl")
  private String offeringUrl = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("bundledProductOffering")
  @Valid
  private List<ComposingOfferingType> bundledProductOffering = null;

  @JsonProperty("productSpecification")
  @Valid
  private List<ComposingProductType> productSpecification = null;

  @JsonProperty("isDowngrade")
  private Boolean isDowngrade = null;

  @JsonProperty("productOfferingPrice")
  @Valid
  private List<ComponentProdOfferPriceType> productOfferingPrice = null;

  /**
   * Status of the offering within the catalog
   */
  public enum LifeCycleStatusEnum {
    DRAFT("draft"),
    
    ACTIVE("active"),
    
    EXPIRED("expired");

    private String value;

    LifeCycleStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LifeCycleStatusEnum fromValue(String text) {
      for (LifeCycleStatusEnum b : LifeCycleStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("lifeCycleStatus")
  private LifeCycleStatusEnum lifeCycleStatus = null;

  @JsonProperty("offeringPenalties")
  @Valid
  private List<PenaltyType> offeringPenalties = null;

  @JsonProperty("upFront")
  private UpFrontType upFront = null;

  @JsonProperty("benefits")
  @Valid
  private List<BenefitType> benefits = null;

  @JsonProperty("additionalData")
  @Valid
  private List<KeyValueType> additionalData = null;

  public OfferingType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique Identifier within the server for the offering reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique Identifier within the server for the offering reported")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public OfferingType href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A resource URI pointing to the resource in the OB that stores the detailed information of the offering
   * @return href
  **/
  @ApiModelProperty(required = true, value = "A resource URI pointing to the resource in the OB that stores the detailed information of the offering")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public OfferingType correlationId(String correlationId) {
    this.correlationId = correlationId;
    return this;
  }

  /**
   * Unique identifier for the offering within the client, used to synchronize and map internal identifiers between server and client
   * @return correlationId
  **/
  @ApiModelProperty(value = "Unique identifier for the offering within the client, used to synchronize and map internal identifiers between server and client")


  public String getCorrelationId() {
    return correlationId;
  }

  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
  }

  public OfferingType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A human readable offering name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "A human readable offering name")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OfferingType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A human readable offering short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable offering short description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OfferingType currentPlanRelationID(String currentPlanRelationID) {
    this.currentPlanRelationID = currentPlanRelationID;
    return this;
  }

  /**
   * Id del plan actual de la billing offer
   * @return currentPlanRelationID
  **/
  @ApiModelProperty(value = "Id del plan actual de la billing offer")


  public String getCurrentPlanRelationID() {
    return currentPlanRelationID;
  }

  public void setCurrentPlanRelationID(String currentPlanRelationID) {
    this.currentPlanRelationID = currentPlanRelationID;
  }

  public OfferingType category(List<CategoryTreeType> category) {
    this.category = category;
    return this;
  }

  public OfferingType addCategoryItem(CategoryTreeType categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<CategoryTreeType>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of categories/subcategories allocated to the offering, intended to allow segmentation A product offering may belong to more than one category/subcategory. Each service may define its own categories and levels in the tree
   * @return category
  **/
  @ApiModelProperty(value = "List of categories/subcategories allocated to the offering, intended to allow segmentation A product offering may belong to more than one category/subcategory. Each service may define its own categories and levels in the tree")

  @Valid

  public List<CategoryTreeType> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryTreeType> category) {
    this.category = category;
  }

  public OfferingType isPromotion(Boolean isPromotion) {
    this.isPromotion = isPromotion;
    return this;
  }

  /**
   * Indicates if the offering is a promotion
   * @return isPromotion
  **/
  @ApiModelProperty(value = "Indicates if the offering is a promotion")


  public Boolean isIsPromotion() {
    return isPromotion;
  }

  public void setIsPromotion(Boolean isPromotion) {
    this.isPromotion = isPromotion;
  }

  public OfferingType billingMethod(BillingMethodEnum billingMethod) {
    this.billingMethod = billingMethod;
    return this;
  }

  /**
   * How this offered product is billed
   * @return billingMethod
  **/
  @ApiModelProperty(value = "How this offered product is billed")


  public BillingMethodEnum getBillingMethod() {
    return billingMethod;
  }

  public void setBillingMethod(BillingMethodEnum billingMethod) {
    this.billingMethod = billingMethod;
  }

  public OfferingType channel(List<ChannelInfoType> channel) {
    this.channel = channel;
    return this;
  }

  public OfferingType addChannelItem(ChannelInfoType channelItem) {
    if (this.channel == null) {
      this.channel = new ArrayList<ChannelInfoType>();
    }
    this.channel.add(channelItem);
    return this;
  }

  /**
   * Defines the channels that can be used for selling the product offering
   * @return channel
  **/
  @ApiModelProperty(value = "Defines the channels that can be used for selling the product offering")

  @Valid

  public List<ChannelInfoType> getChannel() {
    return channel;
  }

  public void setChannel(List<ChannelInfoType> channel) {
    this.channel = channel;
  }

  public OfferingType frameworkAgreement(String frameworkAgreement) {
    this.frameworkAgreement = frameworkAgreement;
    return this;
  }

  /**
   * Unique identifier of the framework agreement associated to the offering
   * @return frameworkAgreement
  **/
  @ApiModelProperty(value = "Unique identifier of the framework agreement associated to the offering")


  public String getFrameworkAgreement() {
    return frameworkAgreement;
  }

  public void setFrameworkAgreement(String frameworkAgreement) {
    this.frameworkAgreement = frameworkAgreement;
  }

  public OfferingType customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Unique Identifier for the customer that is the specific target to the offering
   * @return customerId
  **/
  @ApiModelProperty(value = "Unique Identifier for the customer that is the specific target to the offering")


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public OfferingType compatibleProducts(List<ProductInstanceRefType> compatibleProducts) {
    this.compatibleProducts = compatibleProducts;
    return this;
  }

  public OfferingType addCompatibleProductsItem(ProductInstanceRefType compatibleProductsItem) {
    if (this.compatibleProducts == null) {
      this.compatibleProducts = new ArrayList<ProductInstanceRefType>();
    }
    this.compatibleProducts.add(compatibleProductsItem);
    return this;
  }

  /**
   * Indication of an existing product already acquired by the customer that is compatible with the offering
   * @return compatibleProducts
  **/
  @ApiModelProperty(value = "Indication of an existing product already acquired by the customer that is compatible with the offering")

  @Valid

  public List<ProductInstanceRefType> getCompatibleProducts() {
    return compatibleProducts;
  }

  public void setCompatibleProducts(List<ProductInstanceRefType> compatibleProducts) {
    this.compatibleProducts = compatibleProducts;
  }

  public OfferingType isBundle(Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * Indicates if the offering is a bundle of other offerings (true) or it is a single offering for a bundle of multiple products (false)
   * @return isBundle
  **/
  @ApiModelProperty(required = true, value = "Indicates if the offering is a bundle of other offerings (true) or it is a single offering for a bundle of multiple products (false)")
  @NotNull


  public Boolean isIsBundle() {
    return isBundle;
  }

  public void setIsBundle(Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public OfferingType offeringUrl(String offeringUrl) {
    this.offeringUrl = offeringUrl;
    return this;
  }

  /**
   * A URL that can provide additional information of the offer (e.g.: weblink with a downloadable description brochure)
   * @return offeringUrl
  **/
  @ApiModelProperty(value = "A URL that can provide additional information of the offer (e.g.: weblink with a downloadable description brochure)")


  public String getOfferingUrl() {
    return offeringUrl;
  }

  public void setOfferingUrl(String offeringUrl) {
    this.offeringUrl = offeringUrl;
  }

  public OfferingType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The validity for the product in the catalog. If not enDate included in the structure then no ending date for validity is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the product in the catalog. If not enDate included in the structure then no ending date for validity is defined")

  @Valid

  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public OfferingType bundledProductOffering(List<ComposingOfferingType> bundledProductOffering) {
    this.bundledProductOffering = bundledProductOffering;
    return this;
  }

  public OfferingType addBundledProductOfferingItem(ComposingOfferingType bundledProductOfferingItem) {
    if (this.bundledProductOffering == null) {
      this.bundledProductOffering = new ArrayList<ComposingOfferingType>();
    }
    this.bundledProductOffering.add(bundledProductOfferingItem);
    return this;
  }

  /**
   * List of codes and URIs providing the resource address for the individual offerings included in the bundle offering
   * @return bundledProductOffering
  **/
  @ApiModelProperty(value = "List of codes and URIs providing the resource address for the individual offerings included in the bundle offering")

  @Valid

  public List<ComposingOfferingType> getBundledProductOffering() {
    return bundledProductOffering;
  }

  public void setBundledProductOffering(List<ComposingOfferingType> bundledProductOffering) {
    this.bundledProductOffering = bundledProductOffering;
  }

  public OfferingType productSpecification(List<ComposingProductType> productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  public OfferingType addProductSpecificationItem(ComposingProductType productSpecificationItem) {
    if (this.productSpecification == null) {
      this.productSpecification = new ArrayList<ComposingProductType>();
    }
    this.productSpecification.add(productSpecificationItem);
    return this;
  }

  /**
   * List of codes and URIs providing the resource address for the products included in the offering. If the offer is for a single product (isBundle set to false) then the list will have one single entry
   * @return productSpecification
  **/
  @ApiModelProperty(value = "List of codes and URIs providing the resource address for the products included in the offering. If the offer is for a single product (isBundle set to false) then the list will have one single entry")

  @Valid

  public List<ComposingProductType> getProductSpecification() {
    return productSpecification;
  }

  public void setProductSpecification(List<ComposingProductType> productSpecification) {
    this.productSpecification = productSpecification;
  }

  public OfferingType isDowngrade(Boolean isDowngrade) {
    this.isDowngrade = isDowngrade;
    return this;
  }

  /**
   * When reporting the offerings that are intended for an specific customer/account, this paremeter indicates if the offering is a downgrade of any of the existing offerings subscribed by the customer/account
   * @return isDowngrade
  **/
  @ApiModelProperty(value = "When reporting the offerings that are intended for an specific customer/account, this paremeter indicates if the offering is a downgrade of any of the existing offerings subscribed by the customer/account")


  public Boolean isIsDowngrade() {
    return isDowngrade;
  }

  public void setIsDowngrade(Boolean isDowngrade) {
    this.isDowngrade = isDowngrade;
  }

  public OfferingType productOfferingPrice(List<ComponentProdOfferPriceType> productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  public OfferingType addProductOfferingPriceItem(ComponentProdOfferPriceType productOfferingPriceItem) {
    if (this.productOfferingPrice == null) {
      this.productOfferingPrice = new ArrayList<ComponentProdOfferPriceType>();
    }
    this.productOfferingPrice.add(productOfferingPriceItem);
    return this;
  }

  /**
   * List of price models available for the offering
   * @return productOfferingPrice
  **/
  @ApiModelProperty(value = "List of price models available for the offering")

  @Valid

  public List<ComponentProdOfferPriceType> getProductOfferingPrice() {
    return productOfferingPrice;
  }

  public void setProductOfferingPrice(List<ComponentProdOfferPriceType> productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
  }

  public OfferingType lifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
    return this;
  }

  /**
   * Status of the offering within the catalog
   * @return lifeCycleStatus
  **/
  @ApiModelProperty(value = "Status of the offering within the catalog")


  public LifeCycleStatusEnum getLifeCycleStatus() {
    return lifeCycleStatus;
  }

  public void setLifeCycleStatus(LifeCycleStatusEnum lifeCycleStatus) {
    this.lifeCycleStatus = lifeCycleStatus;
  }

  public OfferingType offeringPenalties(List<PenaltyType> offeringPenalties) {
    this.offeringPenalties = offeringPenalties;
    return this;
  }

  public OfferingType addOfferingPenaltiesItem(PenaltyType offeringPenaltiesItem) {
    if (this.offeringPenalties == null) {
      this.offeringPenalties = new ArrayList<PenaltyType>();
    }
    this.offeringPenalties.add(offeringPenaltiesItem);
    return this;
  }

  /**
   * List of penalties that can be applied to the product offering
   * @return offeringPenalties
  **/
  @ApiModelProperty(value = "List of penalties that can be applied to the product offering")

  @Valid

  public List<PenaltyType> getOfferingPenalties() {
    return offeringPenalties;
  }

  public void setOfferingPenalties(List<PenaltyType> offeringPenalties) {
    this.offeringPenalties = offeringPenalties;
  }

  public OfferingType upFront(UpFrontType upFront) {
    this.upFront = upFront;
    return this;
  }

  /**
   * Objeto que indica si se debe cobrar por la instalación del serivicio fijo
   * @return upFront
  **/
  @ApiModelProperty(value = "Objeto que indica si se debe cobrar por la instalación del serivicio fijo")

  @Valid

  public UpFrontType getUpFront() {
    return upFront;
  }

  public void setUpFront(UpFrontType upFront) {
    this.upFront = upFront;
  }

  public OfferingType benefits(List<BenefitType> benefits) {
    this.benefits = benefits;
    return this;
  }

  public OfferingType addBenefitsItem(BenefitType benefitsItem) {
    if (this.benefits == null) {
      this.benefits = new ArrayList<BenefitType>();
    }
    this.benefits.add(benefitsItem);
    return this;
  }

  /**
   * Beneficios asociados a la oferta
   * @return benefits
  **/
  @ApiModelProperty(value = "Beneficios asociados a la oferta")

  @Valid

  public List<BenefitType> getBenefits() {
    return benefits;
  }

  public void setBenefits(List<BenefitType> benefits) {
    this.benefits = benefits;
  }

  public OfferingType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public OfferingType addAdditionalDataItem(KeyValueType additionalDataItem) {
    if (this.additionalData == null) {
      this.additionalData = new ArrayList<KeyValueType>();
    }
    this.additionalData.add(additionalDataItem);
    return this;
  }

  /**
   * Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any additional metadata that may be needed to define the entity (implementation and application specific). It is recommended not to make use of this information element, this extension capability will be removed from UNICA design guidelines")

  @Valid

  public List<KeyValueType> getAdditionalData() {
    return additionalData;
  }

  public void setAdditionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferingType offeringType = (OfferingType) o;
    return Objects.equals(this.id, offeringType.id) &&
        Objects.equals(this.href, offeringType.href) &&
        Objects.equals(this.correlationId, offeringType.correlationId) &&
        Objects.equals(this.name, offeringType.name) &&
        Objects.equals(this.description, offeringType.description) &&
        Objects.equals(this.currentPlanRelationID, offeringType.currentPlanRelationID) &&
        Objects.equals(this.category, offeringType.category) &&
        Objects.equals(this.isPromotion, offeringType.isPromotion) &&
        Objects.equals(this.billingMethod, offeringType.billingMethod) &&
        Objects.equals(this.channel, offeringType.channel) &&
        Objects.equals(this.frameworkAgreement, offeringType.frameworkAgreement) &&
        Objects.equals(this.customerId, offeringType.customerId) &&
        Objects.equals(this.compatibleProducts, offeringType.compatibleProducts) &&
        Objects.equals(this.isBundle, offeringType.isBundle) &&
        Objects.equals(this.offeringUrl, offeringType.offeringUrl) &&
        Objects.equals(this.validFor, offeringType.validFor) &&
        Objects.equals(this.bundledProductOffering, offeringType.bundledProductOffering) &&
        Objects.equals(this.productSpecification, offeringType.productSpecification) &&
        Objects.equals(this.isDowngrade, offeringType.isDowngrade) &&
        Objects.equals(this.productOfferingPrice, offeringType.productOfferingPrice) &&
        Objects.equals(this.lifeCycleStatus, offeringType.lifeCycleStatus) &&
        Objects.equals(this.offeringPenalties, offeringType.offeringPenalties) &&
        Objects.equals(this.upFront, offeringType.upFront) &&
        Objects.equals(this.benefits, offeringType.benefits) &&
        Objects.equals(this.additionalData, offeringType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, correlationId, name, description, currentPlanRelationID, category, isPromotion, billingMethod, channel, frameworkAgreement, customerId, compatibleProducts, isBundle, offeringUrl, validFor, bundledProductOffering, productSpecification, isDowngrade, productOfferingPrice, lifeCycleStatus, offeringPenalties, upFront, benefits, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OfferingType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    currentPlanRelationID: ").append(toIndentedString(currentPlanRelationID)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    isPromotion: ").append(toIndentedString(isPromotion)).append("\n");
    sb.append("    billingMethod: ").append(toIndentedString(billingMethod)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    frameworkAgreement: ").append(toIndentedString(frameworkAgreement)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    compatibleProducts: ").append(toIndentedString(compatibleProducts)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    offeringUrl: ").append(toIndentedString(offeringUrl)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    bundledProductOffering: ").append(toIndentedString(bundledProductOffering)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    isDowngrade: ").append(toIndentedString(isDowngrade)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
    sb.append("    lifeCycleStatus: ").append(toIndentedString(lifeCycleStatus)).append("\n");
    sb.append("    offeringPenalties: ").append(toIndentedString(offeringPenalties)).append("\n");
    sb.append("    upFront: ").append(toIndentedString(upFront)).append("\n");
    sb.append("    benefits: ").append(toIndentedString(benefits)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

