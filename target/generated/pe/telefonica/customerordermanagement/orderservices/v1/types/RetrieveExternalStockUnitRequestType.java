
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReq;


/**
 * <p>Clase Java para RetrieveExternalStockUnitRequest_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RetrieveExternalStockUnitRequest_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefRequestHeader/V1}TefHeaderReq"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RetrieveExternalStockUnitRequest_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}RetrieveExternalStockUnitRequest_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveExternalStockUnitRequest_type", propOrder = {
    "retrieveExternalStockUnitRequestData"
})
public class RetrieveExternalStockUnitRequestType
    extends TefHeaderReq
{

    @XmlElement(name = "RetrieveExternalStockUnitRequest_data", required = true)
    protected RetrieveExternalStockUnitRequestDataType retrieveExternalStockUnitRequestData;

    /**
     * Obtiene el valor de la propiedad retrieveExternalStockUnitRequestData.
     * 
     * @return
     *     possible object is
     *     {@link RetrieveExternalStockUnitRequestDataType }
     *     
     */
    public RetrieveExternalStockUnitRequestDataType getRetrieveExternalStockUnitRequestData() {
        return retrieveExternalStockUnitRequestData;
    }

    /**
     * Define el valor de la propiedad retrieveExternalStockUnitRequestData.
     * 
     * @param value
     *     allowed object is
     *     {@link RetrieveExternalStockUnitRequestDataType }
     *     
     */
    public void setRetrieveExternalStockUnitRequestData(RetrieveExternalStockUnitRequestDataType value) {
        this.retrieveExternalStockUnitRequestData = value;
    }

}
