
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para RetrieveServiceByMaskResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveServiceByMaskResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveServiceByMaskResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveServiceByMaskResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveServiceByMaskResponse_type", propOrder = {
    "retrieveServiceByMaskResponseData"
})
public class RetrieveServiceByMaskResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "RetrieveServiceByMaskResponse_data", required = true)
    protected RetrieveServiceByMaskResponseDataType retrieveServiceByMaskResponseData;

    /**
     * Obtiene el valor de la propiedad retrieveServiceByMaskResponseData.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveServiceByMaskResponseDataType }
     *     
     */
    public RetrieveServiceByMaskResponseDataType getRetrieveServiceByMaskResponseData() {
        return retrieveServiceByMaskResponseData;
    }

    /**
     * Define el valor de la propiedad retrieveServiceByMaskResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveServiceByMaskResponseDataType }
     *     
     */
    public void setRetrieveServiceByMaskResponseData(RetrieveServiceByMaskResponseDataType value) {
        this.retrieveServiceByMaskResponseData = value;
    }

}
