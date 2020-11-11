
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import pe.telefonica.tefresponseheader.v1.TefHeaderRes;


/**
 * <p>Clase Java para QuerySubscriptionGroupValueResponse_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="QuerySubscriptionGroupValueResponse_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://telefonica.pe/TefResponseHeader/V1}TefHeaderRes"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QuerySubscriptionGroupValueResponse_data" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}QuerySubscriptionGroupValueResponse_data_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuerySubscriptionGroupValueResponse_type", propOrder = {
    "querySubscriptionGroupValueResponseData"
})
public class QuerySubscriptionGroupValueResponseType
    extends TefHeaderRes
{

    @XmlElement(name = "QuerySubscriptionGroupValueResponse_data", required = true)
    protected QuerySubscriptionGroupValueResponseDataType querySubscriptionGroupValueResponseData;

    /**
     * Obtiene el valor de la propiedad querySubscriptionGroupValueResponseData.
     * 
     * @return
     *     possible object is
     *     {@link QuerySubscriptionGroupValueResponseDataType }
     *     
     */
    public QuerySubscriptionGroupValueResponseDataType getQuerySubscriptionGroupValueResponseData() {
        return querySubscriptionGroupValueResponseData;
    }

    /**
     * Define el valor de la propiedad querySubscriptionGroupValueResponseData.
     * 
     * @param value
     *     allowed object is
     *     {@link QuerySubscriptionGroupValueResponseDataType }
     *     
     */
    public void setQuerySubscriptionGroupValueResponseData(QuerySubscriptionGroupValueResponseDataType value) {
        this.querySubscriptionGroupValueResponseData = value;
    }

}
