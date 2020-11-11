
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para ModifyServiceResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ModifyServiceResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ModifyServiceResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ModifyServiceResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyServiceResponse_type", propOrder = {
    "modifyServiceResponseData"
})
public class ModifyServiceResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "ModifyServiceResponse_data", required = true)
    protected ModifyServiceResponseDataType modifyServiceResponseData;

    /**
     * Obtiene el valor de la propiedad modifyServiceResponseData.
     * 
     * @return
     *     possible object is
     *     {@link ModifyServiceResponseDataType }
     *     
     */
    public ModifyServiceResponseDataType getModifyServiceResponseData() {
        return modifyServiceResponseData;
    }

    /**
     * Define el valor de la propiedad modifyServiceResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyServiceResponseDataType }
     *     
     */
    public void setModifyServiceResponseData(ModifyServiceResponseDataType value) {
        this.modifyServiceResponseData = value;
    }

}
