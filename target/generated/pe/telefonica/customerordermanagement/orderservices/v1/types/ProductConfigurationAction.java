
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ProductConfigurationAction complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ProductConfigurationAction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="actionType" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ActionTypeEnum"/&gt;
 *         &lt;element name="itemCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="itemInstanceID" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="attributeList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}ServiceCharacteristicValueList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductConfigurationAction", propOrder = {
    "actionType",
    "itemCode",
    "itemInstanceID",
    "attributeList"
})
public class ProductConfigurationAction {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ActionTypeEnum actionType;
    @XmlElement(required = true)
    protected String itemCode;
    protected String itemInstanceID;
    protected ServiceCharacteristicValueList attributeList;

    /**
     * Obtiene el valor de la propiedad actionType.
     * 
     * @return
     *     possible object is
     *     {@link ActionTypeEnum }
     *     
     */
    public ActionTypeEnum getActionType() {
        return actionType;
    }

    /**
     * Define el valor de la propiedad actionType.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionTypeEnum }
     *     
     */
    public void setActionType(ActionTypeEnum value) {
        this.actionType = value;
    }

    /**
     * Obtiene el valor de la propiedad itemCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Define el valor de la propiedad itemCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemCode(String value) {
        this.itemCode = value;
    }

    /**
     * Obtiene el valor de la propiedad itemInstanceID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemInstanceID() {
        return itemInstanceID;
    }

    /**
     * Define el valor de la propiedad itemInstanceID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemInstanceID(String value) {
        this.itemInstanceID = value;
    }

    /**
     * Obtiene el valor de la propiedad attributeList.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCharacteristicValueList }
     *     
     */
    public ServiceCharacteristicValueList getAttributeList() {
        return attributeList;
    }

    /**
     * Define el valor de la propiedad attributeList.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCharacteristicValueList }
     *     
     */
    public void setAttributeList(ServiceCharacteristicValueList value) {
        this.attributeList = value;
    }

}
