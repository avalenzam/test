
package com.telefonica.globalintegration.services.retrieveofferings.v1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Structure of PagingInfo
 * 
 * 				Functional struct: The business concepts contained are
 * 					- pageSize: Field pageSize
 * 					- pageCount: Field pageCount
 * 					- pageNumber: Field pageNumber
 * 					- maxResultCount: Field maxResultCount
 * 			
 * 
 * <p>Clase Java para PagingInfoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PagingInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pageSize" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}pageSizeIntegerValueType"/&gt;
 *         &lt;element name="pageCount" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}pageCountIntegerValueType"/&gt;
 *         &lt;element name="pageNumber" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}pageNumberIntegerValueType"/&gt;
 *         &lt;element name="maxResultCount" type="{http://telefonica.com/globalIntegration/services/retrieveOfferings/v1}maxResultCountIntegerValueType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PagingInfoType", propOrder = {
    "pageSize",
    "pageCount",
    "pageNumber",
    "maxResultCount"
})
public class PagingInfoType {

    @XmlElement(required = true)
    protected BigDecimal pageSize;
    @XmlElement(required = true)
    protected BigDecimal pageCount;
    @XmlElement(required = true)
    protected BigDecimal pageNumber;
    @XmlElement(required = true)
    protected BigDecimal maxResultCount;

    /**
     * Obtiene el valor de la propiedad pageSize.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPageSize() {
        return pageSize;
    }

    /**
     * Define el valor de la propiedad pageSize.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPageSize(BigDecimal value) {
        this.pageSize = value;
    }

    /**
     * Obtiene el valor de la propiedad pageCount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPageCount() {
        return pageCount;
    }

    /**
     * Define el valor de la propiedad pageCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPageCount(BigDecimal value) {
        this.pageCount = value;
    }

    /**
     * Obtiene el valor de la propiedad pageNumber.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPageNumber() {
        return pageNumber;
    }

    /**
     * Define el valor de la propiedad pageNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPageNumber(BigDecimal value) {
        this.pageNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad maxResultCount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxResultCount() {
        return maxResultCount;
    }

    /**
     * Define el valor de la propiedad maxResultCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxResultCount(BigDecimal value) {
        this.maxResultCount = value;
    }

}
