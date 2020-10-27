
package pe.telefonica.teferror.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para codeType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="codeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="layer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tamSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="legacySystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="api" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "codeType", propOrder = {
    "service",
    "operation",
    "layer",
    "tamSystem",
    "legacySystem",
    "api",
    "error"
})
public class CodeType {

    @XmlElement(required = true)
    protected String service;
    @XmlElement(required = true)
    protected String operation;
    @XmlElement(required = true)
    protected String layer;
    @XmlElement(required = true)
    protected String tamSystem;
    @XmlElement(required = true)
    protected String legacySystem;
    @XmlElement(required = true)
    protected String api;
    @XmlElement(required = true)
    protected String error;

    /**
     * Obtiene el valor de la propiedad service.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * Define el valor de la propiedad service.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

    /**
     * Obtiene el valor de la propiedad operation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Define el valor de la propiedad operation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Obtiene el valor de la propiedad layer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayer() {
        return layer;
    }

    /**
     * Define el valor de la propiedad layer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayer(String value) {
        this.layer = value;
    }

    /**
     * Obtiene el valor de la propiedad tamSystem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTamSystem() {
        return tamSystem;
    }

    /**
     * Define el valor de la propiedad tamSystem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTamSystem(String value) {
        this.tamSystem = value;
    }

    /**
     * Obtiene el valor de la propiedad legacySystem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegacySystem() {
        return legacySystem;
    }

    /**
     * Define el valor de la propiedad legacySystem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegacySystem(String value) {
        this.legacySystem = value;
    }

    /**
     * Obtiene el valor de la propiedad api.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApi() {
        return api;
    }

    /**
     * Define el valor de la propiedad api.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApi(String value) {
        this.api = value;
    }

    /**
     * Obtiene el valor de la propiedad error.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Define el valor de la propiedad error.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }

}
