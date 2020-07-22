package com.telefonica.eof.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.telefonica.eof.generated.model.PackageType;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Information for TV type products, providing details on available TV packages
 */
@ApiModel(description = "Information for TV type products, providing details on available TV packages")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-06-04T16:40:09.794Z")

public class TvPackageType   {
  @JsonProperty("packages")
  @Valid
  private List<PackageType> packages = null;

  public TvPackageType packages(List<PackageType> packages) {
    this.packages = packages;
    return this;
  }

  public TvPackageType addPackagesItem(PackageType packagesItem) {
    if (this.packages == null) {
      this.packages = new ArrayList<PackageType>();
    }
    this.packages.add(packagesItem);
    return this;
  }

  /**
   * List of subscribed available TV packages
   * @return packages
  **/
  @ApiModelProperty(value = "List of subscribed available TV packages")

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
    TvPackageType tvPackageType = (TvPackageType) o;
    return Objects.equals(this.packages, tvPackageType.packages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TvPackageType {\n");
    
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

