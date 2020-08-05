package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RefinedProductType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")

public class RefinedProductType   {
  @JsonProperty("productCharacteristics")
  @Valid
  private List<ProductSpecCharacteristicType> productCharacteristics = null;

  @JsonProperty("subProducts")
  @Valid
  private List<ComposingProductType> subProducts = null;

  public RefinedProductType productCharacteristics(List<ProductSpecCharacteristicType> productCharacteristics) {
    this.productCharacteristics = productCharacteristics;
    return this;
  }

  public RefinedProductType addProductCharacteristicsItem(ProductSpecCharacteristicType productCharacteristicsItem) {
    if (this.productCharacteristics == null) {
      this.productCharacteristics = new ArrayList<ProductSpecCharacteristicType>();
    }
    this.productCharacteristics.add(productCharacteristicsItem);
    return this;
  }

  /**
   * List of specific parameters for the product when included in an specific product Offering that could be configured and/or charged for. This information element can be used as a modifier of a default configuration of a product when incorporated within an specific offering
   * @return productCharacteristics
  **/
  @ApiModelProperty(value = "List of specific parameters for the product when included in an specific product Offering that could be configured and/or charged for. This information element can be used as a modifier of a default configuration of a product when incorporated within an specific offering")

  @Valid

  public List<ProductSpecCharacteristicType> getProductCharacteristics() {
    return productCharacteristics;
  }

  public void setProductCharacteristics(List<ProductSpecCharacteristicType> productCharacteristics) {
    this.productCharacteristics = productCharacteristics;
  }

  public RefinedProductType subProducts(List<ComposingProductType> subProducts) {
    this.subProducts = subProducts;
    return this;
  }

  public RefinedProductType addSubProductsItem(ComposingProductType subProductsItem) {
    if (this.subProducts == null) {
      this.subProducts = new ArrayList<ComposingProductType>();
    }
    this.subProducts.add(subProductsItem);
    return this;
  }

  /**
   * List of individual product identifiers that compose the parent product when included in an specific product Offering. This information element can be used as a modifier of a default configuration of a product when incorporated within an specific offering
   * @return subProducts
  **/
  @ApiModelProperty(value = "List of individual product identifiers that compose the parent product when included in an specific product Offering. This information element can be used as a modifier of a default configuration of a product when incorporated within an specific offering")

  @Valid

  public List<ComposingProductType> getSubProducts() {
    return subProducts;
  }

  public void setSubProducts(List<ComposingProductType> subProducts) {
    this.subProducts = subProducts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RefinedProductType refinedProductType = (RefinedProductType) o;
    return Objects.equals(this.productCharacteristics, refinedProductType.productCharacteristics) &&
        Objects.equals(this.subProducts, refinedProductType.subProducts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCharacteristics, subProducts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RefinedProductType {\n");
    
    sb.append("    productCharacteristics: ").append(toIndentedString(productCharacteristics)).append("\n");
    sb.append("    subProducts: ").append(toIndentedString(subProducts)).append("\n");
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

