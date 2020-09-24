package com.telefonica.eof.generated.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ObjectWrapper
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-14T17:51:01.594Z")




public class ObjectWrapper extends ProductSpecCharacteristicType  {
  @JsonProperty("objectCharacteristicValue")
  private ObjectCharacteristicValueType objectCharacteristicValue = null;

  public ObjectWrapper objectCharacteristicValue(ObjectCharacteristicValueType objectCharacteristicValue) {
    this.objectCharacteristicValue = objectCharacteristicValue;
    return this;
  }

  /**
   * Value of the characteristic when valueType is object
   * @return objectCharacteristicValue
  **/
  @ApiModelProperty(value = "Value of the characteristic when valueType is object")

  @Valid

  public ObjectCharacteristicValueType getObjectCharacteristicValue() {
    return objectCharacteristicValue;
  }

  public void setObjectCharacteristicValue(ObjectCharacteristicValueType objectCharacteristicValue) {
    this.objectCharacteristicValue = objectCharacteristicValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectWrapper objectWrapper = (ObjectWrapper) o;
    return Objects.equals(this.objectCharacteristicValue, objectWrapper.objectCharacteristicValue) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectCharacteristicValue, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectWrapper {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    objectCharacteristicValue: ").append(toIndentedString(objectCharacteristicValue)).append("\n");
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

