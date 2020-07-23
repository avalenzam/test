package com.telefonica.eof.generated.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProductSpecCharacteristicType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "valueType", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = ModelBoolean.class, name = "_boolean"),
  @JsonSubTypes.Type(value = StringWrapper.class, name = "string"),
  @JsonSubTypes.Type(value = NumericWrapper.class, name = "numeric"),
  @JsonSubTypes.Type(value = DecimalWrapper.class, name = "decimal"),
  @JsonSubTypes.Type(value = ObjectWrapper.class, name = "object"),
  @JsonSubTypes.Type(value = TextWrapper.class, name = "text"),
  @JsonSubTypes.Type(value = IntegerWrapper.class, name = "integer"),
})

public class ProductSpecCharacteristicType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Indicates the kind of value that the characteristic can take
   */
  public enum ValueTypeEnum {
    INTEGER("integer"),
    
    DECIMAL("decimal"),
    
    STRING("string"),
    
    BOOLEAN("boolean"),
    
    NUMERIC("numeric"),
    
    TEXT("text"),
    
    OBJECT("object");

    private String value;

    ValueTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ValueTypeEnum fromValue(String text) {
      for (ValueTypeEnum b : ValueTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("valueType")
  private ValueTypeEnum valueType = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  public ProductSpecCharacteristicType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier for the product characteristic
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier for the product characteristic")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProductSpecCharacteristicType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product characteristic
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the product characteristic")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductSpecCharacteristicType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains the characteristic
   * @return description
  **/
  @ApiModelProperty(value = "A narrative that explains the characteristic")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductSpecCharacteristicType valueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * Indicates the kind of value that the characteristic can take
   * @return valueType
  **/
  @ApiModelProperty(required = true, value = "Indicates the kind of value that the characteristic can take")
  @NotNull


  public ValueTypeEnum getValueType() {
    return valueType;
  }

  public void setValueType(ValueTypeEnum valueType) {
    this.valueType = valueType;
  }

  public ProductSpecCharacteristicType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period of time for which a characteristic is applicable
   * @return validFor
  **/
  @ApiModelProperty(value = "The period of time for which a characteristic is applicable")

  @Valid

  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductSpecCharacteristicType productSpecCharacteristicType = (ProductSpecCharacteristicType) o;
    return Objects.equals(this.id, productSpecCharacteristicType.id) &&
        Objects.equals(this.name, productSpecCharacteristicType.name) &&
        Objects.equals(this.description, productSpecCharacteristicType.description) &&
        Objects.equals(this.valueType, productSpecCharacteristicType.valueType) &&
        Objects.equals(this.validFor, productSpecCharacteristicType.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, valueType, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSpecCharacteristicType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

