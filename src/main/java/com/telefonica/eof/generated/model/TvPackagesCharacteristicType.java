package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * TvPackagesCharacteristicType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-14T17:51:01.594Z")




public class TvPackagesCharacteristicType   {
  @JsonProperty("packages")
  @Valid
  private List<PackageType> packages = new ArrayList<PackageType>();

  public TvPackagesCharacteristicType packages(List<PackageType> packages) {
    this.packages = packages;
    return this;
  }

  public TvPackagesCharacteristicType addPackagesItem(PackageType packagesItem) {
    this.packages.add(packagesItem);
    return this;
  }

  /**
   * List of subscribed available TV packages
   * @return packages
  **/
  @ApiModelProperty(required = true, value = "List of subscribed available TV packages")
  @NotNull

  @Valid

  public List<PackageType> getPackages() {
    return packages;
  }

  public void setPackages(List<PackageType> packages) {
    this.packages = packages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TvPackagesCharacteristicType tvPackagesCharacteristicType = (TvPackagesCharacteristicType) o;
    return Objects.equals(this.packages, tvPackagesCharacteristicType.packages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TvPackagesCharacteristicType {\n");
    
    sb.append("    packages: ").append(toIndentedString(packages)).append("\n");
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

