
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateFriendsAndFamilyNumbersRequest_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFriendsAndFamilyNumbersRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productComponent" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductComponent" minOccurs="0"/&gt;
 *         &lt;element name="productOrder" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOrder_UpdateFriendsAndFamilyNumbersRequest" minOccurs="0"/&gt;
 *         &lt;element name="friendsAndFamilyComponnent" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FNFComponent"/&gt;
 *         &lt;element name="activity" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ActivityInformation" minOccurs="0"/&gt;
 *         &lt;element name="addDestinationList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}TelephoneNumberFNFList" minOccurs="0"/&gt;
 *         &lt;element name="removeDestinationList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}TelephoneNumberFNFList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFriendsAndFamilyNumbersRequest_data_type", propOrder = {
    "productComponent",
    "productOrder",
    "friendsAndFamilyComponnent",
    "activity",
    "addDestinationList",
    "removeDestinationList"
})
public class UpdateFriendsAndFamilyNumbersRequestDataType {

    protected ProductComponent productComponent;
    protected ProductOrderUpdateFriendsAndFamilyNumbersRequest productOrder;
    @XmlElement(required = true)
    protected FNFComponent friendsAndFamilyComponnent;
    protected ActivityInformation activity;
    protected TelephoneNumberFNFList addDestinationList;
    protected TelephoneNumberFNFList removeDestinationList;

    /**
     * Gets the value of the productComponent property.
     * 
     * @return
     *     possible object is
     *     {@link ProductComponent }
     *     
     */
    public ProductComponent getProductComponent() {
        return productComponent;
    }

    /**
     * Sets the value of the productComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductComponent }
     *     
     */
    public void setProductComponent(ProductComponent value) {
        this.productComponent = value;
    }

    /**
     * Gets the value of the productOrder property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOrderUpdateFriendsAndFamilyNumbersRequest }
     *     
     */
    public ProductOrderUpdateFriendsAndFamilyNumbersRequest getProductOrder() {
        return productOrder;
    }

    /**
     * Sets the value of the productOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOrderUpdateFriendsAndFamilyNumbersRequest }
     *     
     */
    public void setProductOrder(ProductOrderUpdateFriendsAndFamilyNumbersRequest value) {
        this.productOrder = value;
    }

    /**
     * Gets the value of the friendsAndFamilyComponnent property.
     * 
     * @return
     *     possible object is
     *     {@link FNFComponent }
     *     
     */
    public FNFComponent getFriendsAndFamilyComponnent() {
        return friendsAndFamilyComponnent;
    }

    /**
     * Sets the value of the friendsAndFamilyComponnent property.
     * 
     * @param value
     *     allowed object is
     *     {@link FNFComponent }
     *     
     */
    public void setFriendsAndFamilyComponnent(FNFComponent value) {
        this.friendsAndFamilyComponnent = value;
    }

    /**
     * Gets the value of the activity property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityInformation }
     *     
     */
    public ActivityInformation getActivity() {
        return activity;
    }

    /**
     * Sets the value of the activity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityInformation }
     *     
     */
    public void setActivity(ActivityInformation value) {
        this.activity = value;
    }

    /**
     * Gets the value of the addDestinationList property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumberFNFList }
     *     
     */
    public TelephoneNumberFNFList getAddDestinationList() {
        return addDestinationList;
    }

    /**
     * Sets the value of the addDestinationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumberFNFList }
     *     
     */
    public void setAddDestinationList(TelephoneNumberFNFList value) {
        this.addDestinationList = value;
    }

    /**
     * Gets the value of the removeDestinationList property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumberFNFList }
     *     
     */
    public TelephoneNumberFNFList getRemoveDestinationList() {
        return removeDestinationList;
    }

    /**
     * Sets the value of the removeDestinationList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumberFNFList }
     *     
     */
    public void setRemoveDestinationList(TelephoneNumberFNFList value) {
        this.removeDestinationList = value;
    }

}
