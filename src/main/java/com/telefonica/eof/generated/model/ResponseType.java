package com.telefonica.eof.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.telefonica.eof.generated.model.OfferingType;
import com.telefonica.eof.generated.model.PaginationInfoType;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResponseType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")

public class ResponseType   {
  @JsonProperty("offerings")
  @Valid
  private List<OfferingType> offerings = null;

  @JsonProperty("paginationInfo")
  private PaginationInfoType paginationInfo = null;

  public ResponseType offerings(List<OfferingType> offerings) {
    this.offerings = offerings;
    return this;
  }

  public ResponseType addOfferingsItem(OfferingType offeringsItem) {
    if (this.offerings == null) {
      this.offerings = new ArrayList<OfferingType>();
    }
    this.offerings.add(offeringsItem);
    return this;
  }

  /**
   * 
   * @return offerings
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OfferingType> getOfferings() {
    return offerings;
  }

  public void setOfferings(List<OfferingType> offerings) {
    this.offerings = offerings;
  }

  public ResponseType paginationInfo(PaginationInfoType paginationInfo) {
    this.paginationInfo = paginationInfo;
    return this;
  }

  /**
   * 
   * @return paginationInfo
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PaginationInfoType getPaginationInfo() {
    return paginationInfo;
  }

  public void setPaginationInfo(PaginationInfoType paginationInfo) {
    this.paginationInfo = paginationInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseType responseType = (ResponseType) o;
    return Objects.equals(this.offerings, responseType.offerings) &&
        Objects.equals(this.paginationInfo, responseType.paginationInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offerings, paginationInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseType {\n");
    
    sb.append("    offerings: ").append(toIndentedString(offerings)).append("\n");
    sb.append("    paginationInfo: ").append(toIndentedString(paginationInfo)).append("\n");
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

