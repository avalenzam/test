
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveExternalStockUnitRequest_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveExternalStockUnitRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="device" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}DeviceInformation"/&gt;
 *         &lt;element name="activity" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ActivityInformation_RetrieveExternalStockUnitRequest" minOccurs="0"/&gt;
 *         &lt;element name="store" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Store" minOccurs="0"/&gt;
 *         &lt;element name="product" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SubscriptionType" minOccurs="0"/&gt;
 *         &lt;element name="price" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Price" minOccurs="0"/&gt;
 *         &lt;element name="simPrice" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}Price" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveExternalStockUnitRequest_data_type", propOrder = {
    "device",
    "activity",
    "store",
    "product",
    "price",
    "simPrice"
})
public class RetrieveExternalStockUnitRequestDataType {

    @XmlElement(required = true)
    protected DeviceInformation device;
    protected ActivityInformationRetrieveExternalStockUnitRequest activity;
    protected Store store;
    protected SubscriptionType product;
    protected Price price;
    protected Price simPrice;

    /**
     * Obtiene el valor de la propiedad device.
     * 
     * @return
     *     possible object is
     *     {@link DeviceInformation }
     *     
     */
    public DeviceInformation getDevice() {
        return device;
    }

    /**
     * Define el valor de la propiedad device.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceInformation }
     *     
     */
    public void setDevice(DeviceInformation value) {
        this.device = value;
    }

    /**
     * Obtiene el valor de la propiedad activity.
     * 
     * @return
     *     possible object is
     *     {@link ActivityInformationRetrieveExternalStockUnitRequest }
     *     
     */
    public ActivityInformationRetrieveExternalStockUnitRequest getActivity() {
        return activity;
    }

    /**
     * Define el valor de la propiedad activity.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityInformationRetrieveExternalStockUnitRequest }
     *     
     */
    public void setActivity(ActivityInformationRetrieveExternalStockUnitRequest value) {
        this.activity = value;
    }

    /**
     * Obtiene el valor de la propiedad store.
     * 
     * @return
     *     possible object is
     *     {@link Store }
     *     
     */
    public Store getStore() {
        return store;
    }

    /**
     * Define el valor de la propiedad store.
     * 
     * @param value
     *     allowed object is
     *     {@link Store }
     *     
     */
    public void setStore(Store value) {
        this.store = value;
    }

    /**
     * Obtiene el valor de la propiedad product.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionType }
     *     
     */
    public SubscriptionType getProduct() {
        return product;
    }

    /**
     * Define el valor de la propiedad product.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionType }
     *     
     */
    public void setProduct(SubscriptionType value) {
        this.product = value;
    }

    /**
     * Obtiene el valor de la propiedad price.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPrice(Price value) {
        this.price = value;
    }

    /**
     * Obtiene el valor de la propiedad simPrice.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getSimPrice() {
        return simPrice;
    }

    /**
     * Define el valor de la propiedad simPrice.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setSimPrice(Price value) {
        this.simPrice = value;
    }

}
