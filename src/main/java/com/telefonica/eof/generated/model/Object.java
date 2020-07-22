package com.telefonica.eof.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.telefonica.eof.generated.model.ObjectCharacteristicValueType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicType;
import com.telefonica.eof.generated.model.TimePeriodType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Object
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")

public class Object extends ProductSpecCharacteristicType  {
  @JsonProperty("objectCharacteristicValue")
  private ObjectCharacteristicValueType objectCharacteristicValue = null;

  public Object objectCharacteristicValue(ObjectCharacteristicValueType objectCharacteristicValue) {
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
    Object object = (Object) o;
    return Objects.equals(this.objectCharacteristicValue, object.objectCharacteristicValue) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectCharacteristicValue, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Object {\n");
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

