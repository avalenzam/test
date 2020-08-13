
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for RetrieveExternalStockUnitResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveExternalStockUnitResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveExternalStockUnitResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveExternalStockUnitResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveExternalStockUnitResponse_type", propOrder = {
    "retrieveExternalStockUnitResponseData"
})
public class RetrieveExternalStockUnitResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RetrieveExternalStockUnitResponse_data", required = true)
    protected RetrieveExternalStockUnitResponseDataType retrieveExternalStockUnitResponseData;

    /**
     * Gets the value of the retrieveExternalStockUnitResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveExternalStockUnitResponseDataType }
     *     
     */
    public RetrieveExternalStockUnitResponseDataType getRetrieveExternalStockUnitResponseData() {
        return retrieveExternalStockUnitResponseData;
    }

    /**
     * Sets the value of the retrieveExternalStockUnitResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveExternalStockUnitResponseDataType }
     *     
     */
    public void setRetrieveExternalStockUnitResponseData(RetrieveExternalStockUnitResponseDataType value) {
        this.retrieveExternalStockUnitResponseData = value;
    }

}
