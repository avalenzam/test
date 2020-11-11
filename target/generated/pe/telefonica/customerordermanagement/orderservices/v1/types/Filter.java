
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Filter complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Filter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filterCriteriaList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}FilterCriterionList"/&gt;
 *         &lt;element name="sortCriteriaList" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SortCriterionList" minOccurs="0"/&gt;
 *         &lt;element name="maxRowCount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
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
@XmlType(name = "Filter", propOrder = {
    "filterCriteriaList",
    "sortCriteriaList",
    "maxRowCount"
})
public class Filter {

    @XmlElement(required = true)
    protected FilterCriterionList filterCriteriaList;
    protected SortCriterionList sortCriteriaList;
    protected BigInteger maxRowCount;

    /**
     * Obtiene el valor de la propiedad filterCriteriaList.
     * 
     * @return
     *     possible object is
     *     {@link FilterCriterionList }
     *     
     */
    public FilterCriterionList getFilterCriteriaList() {
        return filterCriteriaList;
    }

    /**
     * Define el valor de la propiedad filterCriteriaList.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterCriterionList }
     *     
     */
    public void setFilterCriteriaList(FilterCriterionList value) {
        this.filterCriteriaList = value;
    }

    /**
     * Obtiene el valor de la propiedad sortCriteriaList.
     * 
     * @return
     *     possible object is
     *     {@link SortCriterionList }
     *     
     */
    public SortCriterionList getSortCriteriaList() {
        return sortCriteriaList;
    }

    /**
     * Define el valor de la propiedad sortCriteriaList.
     * 
     * @param value
     *     allowed object is
     *     {@link SortCriterionList }
     *     
     */
    public void setSortCriteriaList(SortCriterionList value) {
        this.sortCriteriaList = value;
    }

    /**
     * Obtiene el valor de la propiedad maxRowCount.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxRowCount() {
        return maxRowCount;
    }

    /**
     * Define el valor de la propiedad maxRowCount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxRowCount(BigInteger value) {
        this.maxRowCount = value;
    }

}
