
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para UpdateSingleConfigurationOnProductRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="UpdateSingleConfigurationOnProductRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UpdateSingleConfigurationOnProductRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}UpdateSingleConfigurationOnProductRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSingleConfigurationOnProductRequest_type", propOrder = {
    "updateSingleConfigurationOnProductRequestData"
})
public class UpdateSingleConfigurationOnProductRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "UpdateSingleConfigurationOnProductRequest_data", required = true)
    protected UpdateSingleConfigurationOnProductRequestDataType updateSingleConfigurationOnProductRequestData;

    /**
     * Obtiene el valor de la propiedad updateSingleConfigurationOnProductRequestData.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSingleConfigurationOnProductRequestDataType }
     *     
     */
    public UpdateSingleConfigurationOnProductRequestDataType getUpdateSingleConfigurationOnProductRequestData() {
        return updateSingleConfigurationOnProductRequestData;
    }

    /**
     * Define el valor de la propiedad updateSingleConfigurationOnProductRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSingleConfigurationOnProductRequestDataType }
     *     
     */
    public void setUpdateSingleConfigurationOnProductRequestData(UpdateSingleConfigurationOnProductRequestDataType value) {
        this.updateSingleConfigurationOnProductRequestData = value;
    }

}
