
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChangeProductStatusRequest_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeProductStatusRequest_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productComponent" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductComponent_ChangeProductStatusRequest" minOccurs="0"/&gt;
 *         &lt;element name="productOrder" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductOrder" minOccurs="0"/&gt;
 *         &lt;element name="orderAction" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}OrderAction"/&gt;
 *         &lt;element name="activity" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ActivityInformation_ChangeProductStatusRequest" minOccurs="0"/&gt;
 *         &lt;element name="reporterName" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ReporterName" minOccurs="0"/&gt;
 *         &lt;element name="reporterDetails" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ReporterDetails" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeProductStatusRequest_data_type", propOrder = {
    "productComponent",
    "productOrder",
    "orderAction",
    "activity",
    "reporterName",
    "reporterDetails"
})
public class ChangeProductStatusRequestDataType {

    protected ProductComponentChangeProductStatusRequest productComponent;
    protected ProductOrder productOrder;
    @XmlElement(required = true)
    protected OrderAction orderAction;
    protected ActivityInformationChangeProductStatusRequest activity;
    protected ReporterName reporterName;
    protected ReporterDetails reporterDetails;

    /**
     * Gets the value of the productComponent property.
     * 
     * @return
     *     possible object is
     *     {@link ProductComponentChangeProductStatusRequest }
     *     
     */
    public ProductComponentChangeProductStatusRequest getProductComponent() {
        return productComponent;
    }

    /**
     * Sets the value of the productComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductComponentChangeProductStatusRequest }
     *     
     */
    public void setProductComponent(ProductComponentChangeProductStatusRequest value) {
        this.productComponent = value;
    }

    /**
     * Gets the value of the productOrder property.
     * 
     * @return
     *     possible object is
     *     {@link ProductOrder }
     *     
     */
    public ProductOrder getProductOrder() {
        return productOrder;
    }

    /**
     * Sets the value of the productOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductOrder }
     *     
     */
    public void setProductOrder(ProductOrder value) {
        this.productOrder = value;
    }

    /**
     * Gets the value of the orderAction property.
     * 
     * @return
     *     possible object is
     *     {@link OrderAction }
     *     
     */
    public OrderAction getOrderAction() {
        return orderAction;
    }

    /**
     * Sets the value of the orderAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderAction }
     *     
     */
    public void setOrderAction(OrderAction value) {
        this.orderAction = value;
    }

    /**
     * Gets the value of the activity property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityInformationChangeProductStatusRequest }
     *     
     */
    public ActivityInformationChangeProductStatusRequest getActivity() {
        return activity;
    }

    /**
     * Sets the value of the activity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityInformationChangeProductStatusRequest }
     *     
     */
    public void setActivity(ActivityInformationChangeProductStatusRequest value) {
        this.activity = value;
    }

    /**
     * Gets the value of the reporterName property.
     * 
     * @return
     *     possible object is
     *     {@link ReporterName }
     *     
     */
    public ReporterName getReporterName() {
        return reporterName;
    }

    /**
     * Sets the value of the reporterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReporterName }
     *     
     */
    public void setReporterName(ReporterName value) {
        this.reporterName = value;
    }

    /**
     * Gets the value of the reporterDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ReporterDetails }
     *     
     */
    public ReporterDetails getReporterDetails() {
        return reporterDetails;
    }

    /**
     * Sets the value of the reporterDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReporterDetails }
     *     
     */
    public void setReporterDetails(ReporterDetails value) {
        this.reporterDetails = value;
    }

}
