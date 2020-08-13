
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Java class for RetrieveProductHeaderResponse_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveProductHeaderResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveProductHeaderResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveProductHeaderResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveProductHeaderResponse_type", propOrder = {
    "retrieveProductHeaderResponseData"
})
public class RetrieveProductHeaderResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RetrieveProductHeaderResponse_data", required = true)
    protected RetrieveProductHeaderResponseDataType retrieveProductHeaderResponseData;

    /**
     * Gets the value of the retrieveProductHeaderResponseData property.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveProductHeaderResponseDataType }
     *     
     */
    public RetrieveProductHeaderResponseDataType getRetrieveProductHeaderResponseData() {
        return retrieveProductHeaderResponseData;
    }

    /**
     * Sets the value of the retrieveProductHeaderResponseData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveProductHeaderResponseDataType }
     *     
     */
    public void setRetrieveProductHeaderResponseData(RetrieveProductHeaderResponseDataType value) {
        this.retrieveProductHeaderResponseData = value;
    }

}
