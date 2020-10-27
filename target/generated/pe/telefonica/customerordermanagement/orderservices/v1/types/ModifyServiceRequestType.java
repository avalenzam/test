
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para ModifyServiceRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ModifyServiceRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ModifyServiceRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ModifyServiceRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyServiceRequest_type", propOrder = {
    "modifyServiceRequestData"
})
public class ModifyServiceRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "ModifyServiceRequest_data", required = true)
    protected ModifyServiceRequestDataType modifyServiceRequestData;

    /**
     * Obtiene el valor de la propiedad modifyServiceRequestData.
     * 
     * @return
     *     possible object is
     *     {@link ModifyServiceRequestDataType }
     *     
     */
    public ModifyServiceRequestDataType getModifyServiceRequestData() {
        return modifyServiceRequestData;
    }

    /**
     * Define el valor de la propiedad modifyServiceRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyServiceRequestDataType }
     *     
     */
    public void setModifyServiceRequestData(ModifyServiceRequestDataType value) {
        this.modifyServiceRequestData = value;
    }

}
