
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para ChangeFunPackResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ChangeFunPackResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ChangeFunPackResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ChangeFunPackResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeFunPackResponse_type", propOrder = {
    "changeFunPackResponseData"
})
public class ChangeFunPackResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "ChangeFunPackResponse_data", required = true)
    protected ChangeFunPackResponseDataType changeFunPackResponseData;

    /**
     * Obtiene el valor de la propiedad changeFunPackResponseData.
     * 
     * @return
     *     possible object is
     *     {@link ChangeFunPackResponseDataType }
     *     
     */
    public ChangeFunPackResponseDataType getChangeFunPackResponseData() {
        return changeFunPackResponseData;
    }

    /**
     * Define el valor de la propiedad changeFunPackResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeFunPackResponseDataType }
     *     
     */
    public void setChangeFunPackResponseData(ChangeFunPackResponseDataType value) {
        this.changeFunPackResponseData = value;
    }

}
