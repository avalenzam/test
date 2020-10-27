
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RetrieveOrdersHistoryRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveOrdersHistoryRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveOrdersHistoryRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveOrdersHistoryRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveOrdersHistoryRequest_type", propOrder = {
    "retrieveOrdersHistoryRequestData"
})
public class RetrieveOrdersHistoryRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveOrdersHistoryRequest_data", required = true)
    protected RetrieveOrdersHistoryRequestDataType retrieveOrdersHistoryRequestData;

    /**
     * Gets the value of the retrieveOrdersHistoryRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveOrdersHistoryRequestDataType }
     *     
     */
    public RetrieveOrdersHistoryRequestDataType getRetrieveOrdersHistoryRequestData() {
        return retrieveOrdersHistoryRequestData;
    }

    /**
     * Sets the value of the retrieveOrdersHistoryRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveOrdersHistoryRequestDataType }
     *     
     */
    public void setRetrieveOrdersHistoryRequestData(RetrieveOrdersHistoryRequestDataType value) {
        this.retrieveOrdersHistoryRequestData = value;
    }

}
