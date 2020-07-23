package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * StringWrapper
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-23T14:31:29.634Z")

public class StringWrapper extends ProductSpecCharacteristicType  {
  @JsonProperty("productSpecCharacteristicValue")
  @Valid
  private List<ProductSpecCharacteristicValueType> productSpecCharacteristicValue = null;

  public StringWrapper productSpecCharacteristicValue(List<ProductSpecCharacteristicValueType> productSpecCharacteristicValue) {
    this.productSpecCharacteristicValue = productSpecCharacteristicValue;
    return this;
  }

  public StringWrapper addProductSpecCharacteristicValueItem(ProductSpecCharacteristicValueType productSpecCharacteristicValueItem) {
    if (this.productSpecCharacteristicValue == null) {
      this.productSpecCharacteristicValue = new ArrayList<ProductSpecCharacteristicValueType>();
    }
    this.productSpecCharacteristicValue.add(productSpecCharacteristicValueItem);
    return this;
  }

  /**
   * List of values that could be configured for a given characteristic when valueType is different from object
   * @return productSpecCharacteristicValue
  **/
  @ApiModelProperty(value = "List of values that could be configured for a given characteristic when valueType is different from object")

  @Valid

  public List<ProductSpecCharacteristicValueType> getProductSpecCharacteristicValue() {
    return productSpecCharacteristicValue;
  }

  public void setProductSpecCharacteristicValue(List<ProductSpecCharacteristicValueType> productSpecCharacteristicValue) {
    this.productSpecCharacteristicValue = productSpecCharacteristicValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringWrapper stringWrapper = (StringWrapper) o;
    return Objects.equals(this.productSpecCharacteristicValue, stringWrapper.productSpecCharacteristicValue) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productSpecCharacteristicValue, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StringWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    productSpecCharacteristicValue: ").append(toIndentedString(productSpecCharacteristicValue)).append("\n");
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

