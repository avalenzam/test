
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ProductConfigurationActionList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ProductConfigurationActionList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="productConfigurationAction" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ProductConfigurationAction" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductConfigurationActionList", propOrder = {
    "productConfigurationAction"
})
public class ProductConfigurationActionList {

    protected List<ProductConfigurationAction> productConfigurationAction;

    /**
     * Gets the value of the productConfigurationAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productConfigurationAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductConfigurationAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductConfigurationAction }
     * 
     * 
     */
    public List<ProductConfigurationAction> getProductConfigurationAction() {
        if (productConfigurationAction == null) {
            productConfigurationAction = new ArrayList<ProductConfigurationAction>();
        }
        return this.productConfigurationAction;
    }

}
