
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LocateSubscriptionRequest_data_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocateSubscriptionRequest_data_type"&gt;
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
@XmlType(name = "LocateSubscriptionRequest_data_type", propOrder = {
    "numbers"
})
public class LocateSubscriptionRequestDataType {

    @XmlElement(required = true)
    protected NumbersList numbers;

    /**
     * Gets the value of the numbers property.
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
     * Sets the value of the numbers property.
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
