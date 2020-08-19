
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-08-16T16:12:13.735-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "RetrieveProductHeaderFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class RetrieveProductHeaderFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductHeaderFault retrieveProductHeaderFault;

    public RetrieveProductHeaderFault() {
        super();
    }
    
    public RetrieveProductHeaderFault(String message) {
        super(message);
    }
    
    public RetrieveProductHeaderFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetrieveProductHeaderFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductHeaderFault retrieveProductHeaderFault) {
        super(message);
        this.retrieveProductHeaderFault = retrieveProductHeaderFault;
    }

    public RetrieveProductHeaderFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductHeaderFault retrieveProductHeaderFault, java.lang.Throwable cause) {
        super(message, cause);
        this.retrieveProductHeaderFault = retrieveProductHeaderFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveProductHeaderFault getFaultInfo() {
        return this.retrieveProductHeaderFault;
    }
}
