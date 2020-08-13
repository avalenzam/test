
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveFriendsAndFamilyNumbersRequest_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveFriendsAndFamilyNumbersRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productComponent" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductComponent_RetrieveFriendsAndFamilyNumbersRequest" minOccurs="0"/&gt;
 *         &lt;element name="serviceFilterInfoList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FilterList_RetrieveFriendsAndFamilyNumbersRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveFriendsAndFamilyNumbersRequest_data_type", propOrder = {
    "productComponent",
    "serviceFilterInfoList"
})
public class RetrieveFriendsAndFamilyNumbersRequestDataType {

    protected ProductComponentRetrieveFriendsAndFamilyNumbersRequest productComponent;
    protected FilterListRetrieveFriendsAndFamilyNumbersRequest serviceFilterInfoList;

    /**
     * Gets the value of the productComponent property.
     * 
     * @return
     *     possible object is
     *     {@link ProductComponentRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public ProductComponentRetrieveFriendsAndFamilyNumbersRequest getProductComponent() {
        return productComponent;
    }

    /**
     * Sets the value of the productComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductComponentRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public void setProductComponent(ProductComponentRetrieveFriendsAndFamilyNumbersRequest value) {
        this.productComponent = value;
    }

    /**
     * Gets the value of the serviceFilterInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link FilterListRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public FilterListRetrieveFriendsAndFamilyNumbersRequest getServiceFilterInfoList() {
        return serviceFilterInfoList;
    }

    /**
     * Sets the value of the serviceFilterInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterListRetrieveFriendsAndFamilyNumbersRequest }
     *     
     */
    public void setServiceFilterInfoList(FilterListRetrieveFriendsAndFamilyNumbersRequest value) {
        this.serviceFilterInfoList = value;
    }

}
