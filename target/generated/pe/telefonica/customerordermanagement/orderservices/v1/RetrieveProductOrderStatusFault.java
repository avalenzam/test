
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-18T18:55:16.934-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "RetrieveProductOrderStatusFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class RetrieveProductOrderStatusFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductOrderStatusFault retrieveProductOrderStatusFault;

    public RetrieveProductOrderStatusFault() {
        super();
    }
    
    public RetrieveProductOrderStatusFault(String message) {
        super(message);
    }
    
    public RetrieveProductOrderStatusFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetrieveProductOrderStatusFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductOrderStatusFault retrieveProductOrderStatusFault) {
        super(message);
        this.retrieveProductOrderStatusFault = retrieveProductOrderStatusFault;
    }

    public RetrieveProductOrderStatusFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductOrderStatusFault retrieveProductOrderStatusFault, java.lang.Throwable cause) {
        super(message, cause);
        this.retrieveProductOrderStatusFault = retrieveProductOrderStatusFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductOrderStatusFault getFaultInfo() {
        return this.retrieveProductOrderStatusFault;
    }
}
