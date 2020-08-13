
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filterCriteriaList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FilterCriterionList_Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest"/&gt;
 *         &lt;element name="sortCriteriaList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SortCriterionList_Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest" minOccurs="0"/&gt;
 *         &lt;element name="maxRowCount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest", propOrder = {
    "filterCriteriaList",
    "sortCriteriaList",
    "maxRowCount"
})
public class FilterFilterListRetrieveFriendsAndFamilyNumbersRequest {

    @XmlElement(required = true)
    protected FilterCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest filterCriteriaList;
    protected SortCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest sortCriteriaList;
    protected BigInteger maxRowCount;

    /**
     * Gets the value of the filterCriteriaList property.
     * 
     * @return
     *     possible object is
     *     {@link FilterCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public FilterCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest getFilterCriteriaList() {
        return filterCriteriaList;
    }

    /**
     * Sets the value of the filterCriteriaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public void setFilterCriteriaList(FilterCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest value) {
        this.filterCriteriaList = value;
    }

    /**
     * Gets the value of the sortCriteriaList property.
     * 
     * @return
     *     possible object is
     *     {@link SortCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public SortCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest getSortCriteriaList() {
        return sortCriteriaList;
    }

    /**
     * Sets the value of the sortCriteriaList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public void setSortCriteriaList(SortCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest value) {
        this.sortCriteriaList = value;
    }

    /**
     * Gets the value of the maxRowCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxRowCount() {
        return maxRowCount;
    }

    /**
     * Sets the value of the maxRowCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxRowCount(BigInteger value) {
        this.maxRowCount = value;
    }

}
