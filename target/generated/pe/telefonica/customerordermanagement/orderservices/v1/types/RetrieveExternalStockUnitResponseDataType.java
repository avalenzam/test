
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RetrieveExternalStockUnitResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad skuDevice.
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
     * Define el valor de la propiedad skuDevice.
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
     * Obtiene el valor de la propiedad skuSim.
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
     * Define el valor de la propiedad skuSim.
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
     * Obtiene el valor de la propiedad skuError.
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
     * Define el valor de la propiedad skuError.
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
