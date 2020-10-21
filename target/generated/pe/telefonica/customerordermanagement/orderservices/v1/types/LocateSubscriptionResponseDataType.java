
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para LocateSubscriptionResponse_data_type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="LocateSubscriptionResponse_data_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numbers" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}NumbersList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocateSubscriptionResponse_data_type", propOrder = {
    "numbers"
})
public class LocateSubscriptionResponseDataType {

    @XmlElement(required = true)
    protected NumbersList numbers;

    /**
     * Obtiene el valor de la propiedad numbers.
     * 
     * @return
     *     possible object is
     *     {@link NumbersList }
     *     
     */
    public NumbersList getNumbers() {
        return numbers;
    }

    /**
     * Define el valor de la propiedad numbers.
     * 
     * @param value
     *     allowed object is
     *     {@link NumbersList }
     *     
     */
    public void setNumbers(NumbersList value) {
        this.numbers = value;
    }

}
