
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para NumbersList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="NumbersList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numberExtended" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}TelephoneNumberExtended" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumbersList", propOrder = {
    "numberExtended"
})
public class NumbersList {

    @XmlElement(required = true)
    protected List<TelephoneNumberExtended> numberExtended;

    /**
     * Gets the value of the numberExtended property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numberExtended property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNumberExtended().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TelephoneNumberExtended }
     * 
     * 
     */
    public List<TelephoneNumberExtended> getNumberExtended() {
        if (numberExtended == null) {
            numberExtended = new ArrayList<TelephoneNumberExtended>();
        }
        return this.numberExtended;
    }

}
