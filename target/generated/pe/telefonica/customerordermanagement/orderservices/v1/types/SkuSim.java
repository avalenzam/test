
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SkuSim complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SkuSim"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="skuSIM" minOccurs="0"&gt;
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
@XmlType(name = "SkuSim", propOrder = {
    "skuSIM"
})
public class SkuSim {

    protected String skuSIM;

    /**
     * Obtiene el valor de la propiedad skuSIM.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkuSIM() {
        return skuSIM;
    }

    /**
     * Define el valor de la propiedad skuSIM.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkuSIM(String value) {
        this.skuSIM = value;
    }

}
