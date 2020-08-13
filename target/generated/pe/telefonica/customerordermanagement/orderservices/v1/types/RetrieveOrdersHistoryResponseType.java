
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for RetrieveOrdersHistoryResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveOrdersHistoryResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveOrdersHistoryResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveOrdersHistoryResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveOrdersHistoryResponse_type", propOrder = {
    "retrieveOrdersHistoryResponseData"
})
public class RetrieveOrdersHistoryResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RetrieveOrdersHistoryResponse_data", required = true)
    protected RetrieveOrdersHistoryResponseDataType retrieveOrdersHistoryResponseData;

    /**
     * Gets the value of the retrieveOrdersHistoryResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveOrdersHistoryResponseDataType }
     *     
     */
    public RetrieveOrdersHistoryResponseDataType getRetrieveOrdersHistoryResponseData() {
        return retrieveOrdersHistoryResponseData;
    }

    /**
     * Sets the value of the retrieveOrdersHistoryResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveOrdersHistoryResponseDataType }
     *     
     */
    public void setRetrieveOrdersHistoryResponseData(RetrieveOrdersHistoryResponseDataType value) {
        this.retrieveOrdersHistoryResponseData = value;
    }

}
