package com.telefonica.eof.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.telefonica.eof.generated.model.MoneyType;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpFrontType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")

public class UpFrontType   {
  @JsonProperty("indicator")
  private String indicator = null;

  @JsonProperty("price")
  private MoneyType price = null;

  public UpFrontType indicator(String indicator) {
    this.indicator = indicator;
    return this;
  }

  /**
   * Un identificador único para el modelo de penalización. Y: Indica que si aplica cobr de upfrint N: No aplica conbro de upfront
   * @return indicator
  **/
  @ApiModelProperty(value = "Un identificador único para el modelo de penalización. Y: Indica que si aplica cobr de upfrint N: No aplica conbro de upfront")


  public String getIndicator() {
    return indicator;
  }

  public void setIndicator(String indicator) {
    this.indicator = indicator;
  }

  public UpFrontType price(MoneyType price) {
    this.price = price;
    return this;
  }

  /**
   * Es el precio del upfront
   * @return price
  **/
  @ApiModelProperty(value = "Es el precio del upfront")

  @Valid

  public MoneyType getPrice() {
    return price;
  }

  public void setPrice(MoneyType price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpFrontType upFrontType = (UpFrontType) o;
    return Objects.equals(this.indicator, upFrontType.indicator) &&
        Objects.equals(this.price, upFrontType.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(indicator, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpFrontType {\n");
    
    sb.append("    indicator: ").append(toIndentedString(indicator)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

