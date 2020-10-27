
package pe.telefonica.customerordermanagement.orderservices.v1.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SortCriterionList_Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SortCriterionList_Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sortCriterion" type="{http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types}SortCriterion_RetrieveFriendsAndFamilyNumbersRequest" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortCriterionList_Filter_FilterList_RetrieveFriendsAndFamilyNumbersRequest", propOrder = {
    "sortCriterion"
})
public class SortCriterionListFilterFilterListRetrieveFriendsAndFamilyNumbersRequest {

    protected List<SortCriterionRetrieveFriendsAndFamilyNumbersRequest> sortCriterion;

    /**
     * Gets the value of the sortCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SortCriterionRetrieveFriendsAndFamilyNumbersRequest }
     * 
     * 
     */
    public List<SortCriterionRetrieveFriendsAndFamilyNumbersRequest> getSortCriterion() {
        if (sortCriterion == null) {
            sortCriterion = new ArrayList<SortCriterionRetrieveFriendsAndFamilyNumbersRequest>();
        }
        return this.sortCriterion;
    }

}
