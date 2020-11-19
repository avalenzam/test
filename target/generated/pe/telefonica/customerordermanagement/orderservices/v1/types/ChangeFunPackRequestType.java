
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Java class for ChangeFunPackRequest_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeFunPackRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChangeFunPackRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ChangeFunPackRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeFunPackRequest_type", propOrder = {
    "changeFunPackRequestData"
})
public class ChangeFunPackRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "ChangeFunPackRequest_data", required = true)
    protected ChangeFunPackRequestDataType changeFunPackRequestData;

    /**
     * Gets the value of the changeFunPackRequestData property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeFunPackRequestDataType }
     *     
     */
    public ChangeFunPackRequestDataType getChangeFunPackRequestData() {
        return changeFunPackRequestData;
    }

    /**
     * Sets the value of the changeFunPackRequestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeFunPackRequestDataType }
     *     
     */
    public void setChangeFunPackRequestData(ChangeFunPackRequestDataType value) {
        this.changeFunPackRequestData = value;
    }

}
