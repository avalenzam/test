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
 * TvPackages
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-14T17:51:01.594Z")




public class TvPackages extends ObjectCharacteristicValueType  {
  @JsonProperty("packages")
  @Valid
  private List<PackageType> packages = new ArrayList<PackageType>();

  public TvPackages packages(List<PackageType> packages) {
    this.packages = packages;
    return this;
  }

  public TvPackages addPackagesItem(PackageType packagesItem) {
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
    TvPackages tvPackages = (TvPackages) o;
    return Objects.equals(this.packages, tvPackages.packages) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packages, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TvPackages {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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

