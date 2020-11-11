
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para RetrieveServiceByMaskRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveServiceByMaskRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveServiceByMaskRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveServiceByMaskRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveServiceByMaskRequest_type", propOrder = {
    "retrieveServiceByMaskRequestData"
})
public class RetrieveServiceByMaskRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveServiceByMaskRequest_data", required = true)
    protected RetrieveServiceByMaskRequestDataType retrieveServiceByMaskRequestData;

    /**
     * Obtiene el valor de la propiedad retrieveServiceByMaskRequestData.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveServiceByMaskRequestDataType }
     *     
     */
    public RetrieveServiceByMaskRequestDataType getRetrieveServiceByMaskRequestData() {
        return retrieveServiceByMaskRequestData;
    }

    /**
     * Define el valor de la propiedad retrieveServiceByMaskRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveServiceByMaskRequestDataType }
     *     
     */
    public void setRetrieveServiceByMaskRequestData(RetrieveServiceByMaskRequestDataType value) {
        this.retrieveServiceByMaskRequestData = value;
    }

}
