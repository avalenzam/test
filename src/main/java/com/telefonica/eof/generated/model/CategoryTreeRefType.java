package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CategoryTreeRefType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-17T23:56:34.536Z")




public class CategoryTreeRefType extends CategoryRefType  {
  @JsonProperty("children")
  @Valid
  private List<CategoryTreeRefType> children = null;

  public CategoryTreeRefType children(List<CategoryTreeRefType> children) {
    this.children = children;
    return this;
  }

  public CategoryTreeRefType addChildrenItem(CategoryTreeRefType childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<CategoryTreeRefType>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * Children of the current node
   * @return children
  **/
  @ApiModelProperty(value = "Children of the current node")

  @Valid

  public List<CategoryTreeRefType> getChildren() {
    return children;
  }

  public void setChildren(List<CategoryTreeRefType> children) {
    this.children = children;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryTreeRefType categoryTreeRefType = (CategoryTreeRefType) o;
    return Objects.equals(this.children, categoryTreeRefType.children) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(children, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryTreeRefType {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

