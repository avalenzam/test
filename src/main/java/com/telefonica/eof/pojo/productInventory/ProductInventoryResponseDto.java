
package com.telefonica.eof.pojo.productInventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: ProductInventoryResponseDto.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion con el servicio del productInventory
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalData",
    "agreement",
    "billingAccount",
    "category",
    "characteristic",
    "creatingOrder",
    "description",
    "href",
    "id",
    "isBundle",
    "isCustomerVisible",
    "modifyingOrders",
    "name",
    "orderDate",
    "paymentMean",
    "place",
    "productOffering",
    "productPrice",
    "productRelationship",
    "productSerialNumber",
    "productSpec",
    "productType",
    "publicId",
    "realizingResource",
    "relatedObject",
    "relatedParty",
    "startDate",
    "status",
    "subStatus",
    "tags",
    "terminationDate"
})
@Data
public class ProductInventoryResponseDto {

    @JsonProperty("additionalData")
    public List<AdditionalDatum> additionalData = null;
    @JsonProperty("agreement")
    public List<Agreement> agreement = null;
    @JsonProperty("billingAccount")
    public List<BillingAccount> billingAccount = null;
    @JsonProperty("category")
    public List<Category> category = null;
    @JsonProperty("characteristic")
    public List<Characteristic> characteristic = null;
    @JsonProperty("creatingOrder")
    public CreatingOrder creatingOrder;
    @JsonProperty("description")
    public String description;
    @JsonProperty("href")
    public String href;
    @JsonProperty("id")
    public String id;
    @JsonProperty("isBundle")
    public Boolean isBundle;
    @JsonProperty("isCustomerVisible")
    public Boolean isCustomerVisible;
    @JsonProperty("modifyingOrders")
    public List<ModifyingOrder> modifyingOrders = null;
    @JsonProperty("name")
    public String name;
    @JsonProperty("orderDate")
    public String orderDate;
    @JsonProperty("paymentMean")
    public PaymentMean paymentMean;
    @JsonProperty("place")
    public List<Place> place = null;
    @JsonProperty("productOffering")
    public ProductOffering productOffering;
    @JsonProperty("productPrice")
    public List<ProductPrice> productPrice = null;
    @JsonProperty("productRelationship")
    public List<ProductRelationship> productRelationship = null;
    @JsonProperty("productSerialNumber")
    public String productSerialNumber;
    @JsonProperty("productSpec")
    public ProductSpec_ productSpec;
    @JsonProperty("productType")
    public String productType;
    @JsonProperty("publicId")
    public String publicId;
    @JsonProperty("realizingResource")
    public List<RealizingResource> realizingResource = null;
    @JsonProperty("relatedObject")
    public List<RelatedObject> relatedObject = null;
    @JsonProperty("relatedParty")
    public List<RelatedParty_> relatedParty = null;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("status")
    public String status;
    @JsonProperty("subStatus")
    public String subStatus;
    @JsonProperty("tags")
    public List<String> tags = null;
    @JsonProperty("terminationDate")
    public String terminationDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
