
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
    "description",
    "id",
    "isMandatory",
    "name",
    "price",
    "priceType",
    "prodPriceAlteration",
    "recurringChargePeriod",
    "taxIncluded",
    "taxRate",
    "taxType",
    "unitOfMeasure"
})
@Data
public class ProductPrice_ {

    @JsonProperty("additionalData")
    public List<AdditionalDatum____> additionalData = null;
    @JsonProperty("description")
    public String description;
    @JsonProperty("id")
    public String id;
    @JsonProperty("isMandatory")
    public Boolean isMandatory;
    @JsonProperty("name")
    public String name;
    @JsonProperty("price")
    public Price__ price;
    @JsonProperty("priceType")
    public String priceType;
    @JsonProperty("prodPriceAlteration")
    public List<ProdPriceAlteration_> prodPriceAlteration = null;
    @JsonProperty("recurringChargePeriod")
    public String recurringChargePeriod;
    @JsonProperty("taxIncluded")
    public Boolean taxIncluded;
    @JsonProperty("taxRate")
    public Integer taxRate;
    @JsonProperty("taxType")
    public String taxType;
    @JsonProperty("unitOfMeasure")
    public UnitOfMeasure___ unitOfMeasure;
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
