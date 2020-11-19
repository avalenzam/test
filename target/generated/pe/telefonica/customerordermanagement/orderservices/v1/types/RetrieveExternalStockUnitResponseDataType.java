
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveExternalStockUnitResponse_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveExternalStockUnitResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="skuDevice" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SkuDevice"/&gt;
 *         &lt;element name="skuSim" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SkuSim"/&gt;
 *         &lt;element name="skuError" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SkuError"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveExternalStockUnitResponse_data_type", propOrder = {
    "skuDevice",
    "skuSim",
    "skuError"
})
public class RetrieveExternalStockUnitResponseDataType {

    @XmlElement(required = true)
    protected SkuDevice skuDevice;
    @XmlElement(required = true)
    protected SkuSim skuSim;
    @XmlElement(required = true)
    protected SkuError skuError;

    /**
     * Gets the value of the skuDevice property.
     * 
     * @return
     *     possible object is
     *     {@link SkuDevice }
     *     
     */
    public SkuDevice getSkuDevice() {
        return skuDevice;
    }

    /**
     * Sets the value of the skuDevice property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkuDevice }
     *     
     */
    public void setSkuDevice(SkuDevice value) {
        this.skuDevice = value;
    }

    /**
     * Gets the value of the skuSim property.
     * 
     * @return
     *     possible object is
     *     {@link SkuSim }
     *     
     */
    public SkuSim getSkuSim() {
        return skuSim;
    }

    /**
     * Sets the value of the skuSim property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkuSim }
     *     
     */
    public void setSkuSim(SkuSim value) {
        this.skuSim = value;
    }

    /**
     * Gets the value of the skuError property.
     * 
     * @return
     *     possible object is
     *     {@link SkuError }
     *     
     */
    public SkuError getSkuError() {
        return skuError;
    }

    /**
     * Sets the value of the skuError property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkuError }
     *     
     */
    public void setSkuError(SkuError value) {
        this.skuError = value;
    }

}
