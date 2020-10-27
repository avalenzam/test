
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FNFBODetailsList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FNFBODetailsList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billingOffers" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FNFBODetails" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FNFBODetailsList", propOrder = {
    "billingOffers"
})
public class FNFBODetailsList {

    @XmlElement(required = true)
    protected List<FNFBODetails> billingOffers;

    /**
     * Gets the value of the billingOffers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the billingOffers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBillingOffers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FNFBODetails }
     * 
     * 
     */
    public List<FNFBODetails> getBillingOffers() {
        if (billingOffers == null) {
            billingOffers = new ArrayList<FNFBODetails>();
        }
        return this.billingOffers;
    }

}
