
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para UpdateFriendsAndFamilyNumbersRequest_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad productComponent.
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
     * Define el valor de la propiedad productComponent.
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
     * Obtiene el valor de la propiedad productOrder.
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
     * Define el valor de la propiedad productOrder.
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
     * Obtiene el valor de la propiedad friendsAndFamilyComponnent.
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
     * Define el valor de la propiedad friendsAndFamilyComponnent.
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
     * Obtiene el valor de la propiedad activity.
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
     * Define el valor de la propiedad activity.
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
     * Obtiene el valor de la propiedad addDestinationList.
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
     * Define el valor de la propiedad addDestinationList.
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
     * Obtiene el valor de la propiedad removeDestinationList.
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
     * Define el valor de la propiedad removeDestinationList.
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
