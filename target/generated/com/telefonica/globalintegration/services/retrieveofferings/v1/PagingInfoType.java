
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
 * <p>Java class for PagingInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the pageSize property.
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
     * Sets the value of the pageSize property.
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
     * Gets the value of the pageCount property.
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
     * Sets the value of the pageCount property.
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
     * Gets the value of the pageNumber property.
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
     * Sets the value of the pageNumber property.
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
     * Gets the value of the maxResultCount property.
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
     * Sets the value of the maxResultCount property.
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
