
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RetrieveProductOrderStatusRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductOrderStatusRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveProductOrderStatusRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveProductOrderStatusRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductOrderStatusRequest_type", propOrder = {
    "retrieveProductOrderStatusRequestData"
})
public class RetrieveProductOrderStatusRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveProductOrderStatusRequest_data", required = true)
    protected RetrieveProductOrderStatusRequestDataType retrieveProductOrderStatusRequestData;

    /**
     * Gets the value of the retrieveProductOrderStatusRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveProductOrderStatusRequestDataType }
     *     
     */
    public RetrieveProductOrderStatusRequestDataType getRetrieveProductOrderStatusRequestData() {
        return retrieveProductOrderStatusRequestData;
    }

    /**
     * Sets the value of the retrieveProductOrderStatusRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveProductOrderStatusRequestDataType }
     *     
     */
    public void setRetrieveProductOrderStatusRequestData(RetrieveProductOrderStatusRequestDataType value) {
        this.retrieveProductOrderStatusRequestData = value;
    }

}
