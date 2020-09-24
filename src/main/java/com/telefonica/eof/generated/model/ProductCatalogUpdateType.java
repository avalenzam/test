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
 * ProductCatalogUpdateType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-14T17:51:01.594Z")




public class ProductCatalogUpdateType   {
  @JsonProperty("products")
  @Valid
  private List<ProductSpecificationType> products = new ArrayList<ProductSpecificationType>();

  @JsonProperty("isIncremental")
  private Boolean isIncremental = null;

  public ProductCatalogUpdateType products(List<ProductSpecificationType> products) {
    this.products = products;
    return this;
  }

  public ProductCatalogUpdateType addProductsItem(ProductSpecificationType productsItem) {
    this.products.add(productsItem);
    return this;
  }

  /**
   * List of products to update catalog
   * @return products
  **/
  @ApiModelProperty(required = true, value = "List of products to update catalog")
  @NotNull

  @Valid

  public List<ProductSpecificationType> getProducts() {
    return products;
  }

  public void setProducts(List<ProductSpecificationType> products) {
    this.products = products;
  }

  public ProductCatalogUpdateType isIncremental(Boolean isIncremental) {
    this.isIncremental = isIncremental;
    return this;
  }

  /**
   * Indicates whether the provided list of products is Incremental (true) or Total (false). Incremental means that the list of products in the request message includes the modification of currently stored products in the catalog or new products to be added. Total means that the list of products in the request message provides the new whole list of products that substitutes completely the existing catalog
   * @return isIncremental
  **/
  @ApiModelProperty(required = true, value = "Indicates whether the provided list of products is Incremental (true) or Total (false). Incremental means that the list of products in the request message includes the modification of currently stored products in the catalog or new products to be added. Total means that the list of products in the request message provides the new whole list of products that substitutes completely the existing catalog")
  @NotNull


  public Boolean isIsIncremental() {
    return isIncremental;
  }

  public void setIsIncremental(Boolean isIncremental) {
    this.isIncremental = isIncremental;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductCatalogUpdateType productCatalogUpdateType = (ProductCatalogUpdateType) o;
    return Objects.equals(this.products, productCatalogUpdateType.products) &&
        Objects.equals(this.isIncremental, productCatalogUpdateType.isIncremental);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products, isIncremental);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCatalogUpdateType {\n");
    
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    isIncremental: ").append(toIndentedString(isIncremental)).append("\n");
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

