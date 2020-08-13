
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalData",
    "category",
    "characteristic",
    "description",
    "href",
    "id",
    "name",
    "parentAssignproductId",
    "place",
    "productPrice",
    "productRelationship",
    "productSpec",
    "productType",
    "publicId",
    "relatedParty",
    "startDate",
    "tags",
    "terminationDate"
})
@Data
public class Product {

    @JsonProperty("additionalData")
    public List<AdditionalDatum___> additionalData = null;
    @JsonProperty("category")
    public List<Category_> category = null;
    @JsonProperty("characteristic")
    public List<Characteristic_> characteristic = null;
    @JsonProperty("description")
    public String description;
    @JsonProperty("href")
    public String href;
    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("parentAssignproductId")
    public String parentAssignproductId;
    @JsonProperty("place")
    public List<Place_> place = null;
    @JsonProperty("productPrice")
    public List<ProductPrice_> productPrice = null;
    @JsonProperty("productRelationship")
    public List<Object> productRelationship = null;
    @JsonProperty("productSpec")
    public ProductSpec productSpec;
    @JsonProperty("productType")
    public String productType;
    @JsonProperty("publicId")
    public String publicId;
    @JsonProperty("relatedParty")
    public List<RelatedParty> relatedParty = null;
    @JsonProperty("startDate")
    public String startDate;
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
