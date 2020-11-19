
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RetrieveExternalStockUnitRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveExternalStockUnitRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveExternalStockUnitRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveExternalStockUnitRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveExternalStockUnitRequest_type", propOrder = {
    "retrieveExternalStockUnitRequestData"
})
public class RetrieveExternalStockUnitRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveExternalStockUnitRequest_data", required = true)
    protected RetrieveExternalStockUnitRequestDataType retrieveExternalStockUnitRequestData;

    /**
     * Gets the value of the retrieveExternalStockUnitRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveExternalStockUnitRequestDataType }
     *     
     */
    public RetrieveExternalStockUnitRequestDataType getRetrieveExternalStockUnitRequestData() {
        return retrieveExternalStockUnitRequestData;
    }

    /**
     * Sets the value of the retrieveExternalStockUnitRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveExternalStockUnitRequestDataType }
     *     
     */
    public void setRetrieveExternalStockUnitRequestData(RetrieveExternalStockUnitRequestDataType value) {
        this.retrieveExternalStockUnitRequestData = value;
    }

}
