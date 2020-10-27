
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ActivityInformation_RetrieveExternalStockUnitRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ActivityInformation_RetrieveExternalStockUnitRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="15"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="sourceChannel" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="usercode" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="20"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityInformation_RetrieveExternalStockUnitRequest", propOrder = {
    "name",
    "sourceChannel",
    "usercode"
})
public class ActivityInformationRetrieveExternalStockUnitRequest {

    protected String name;
    protected String sourceChannel;
    protected String usercode;

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad sourceChannel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceChannel() {
        return sourceChannel;
    }

    /**
     * Define el valor de la propiedad sourceChannel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceChannel(String value) {
        this.sourceChannel = value;
    }

    /**
     * Obtiene el valor de la propiedad usercode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * Define el valor de la propiedad usercode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsercode(String value) {
        this.usercode = value;
    }

}
