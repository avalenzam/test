
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for RetrieveProductHeaderRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductHeaderRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveProductHeaderRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveProductHeaderRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductHeaderRequest_type", propOrder = {
    "retrieveProductHeaderRequestData"
})
public class RetrieveProductHeaderRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveProductHeaderRequest_data", required = true)
    protected RetrieveProductHeaderRequestDataType retrieveProductHeaderRequestData;

    /**
     * Gets the value of the retrieveProductHeaderRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveProductHeaderRequestDataType }
     *     
     */
    public RetrieveProductHeaderRequestDataType getRetrieveProductHeaderRequestData() {
        return retrieveProductHeaderRequestData;
    }

    /**
     * Sets the value of the retrieveProductHeaderRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveProductHeaderRequestDataType }
     *     
     */
    public void setRetrieveProductHeaderRequestData(RetrieveProductHeaderRequestDataType value) {
        this.retrieveProductHeaderRequestData = value;
    }

}
