
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-18T18:55:17.279-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "RetrieveServiceByMaskFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class RetrieveServiceByMaskFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveServiceByMaskFault retrieveServiceByMaskFault;

    public RetrieveServiceByMaskFault() {
        super();
    }
    
    public RetrieveServiceByMaskFault(String message) {
        super(message);
    }
    
    public RetrieveServiceByMaskFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetrieveServiceByMaskFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveServiceByMaskFault retrieveServiceByMaskFault) {
        super(message);
        this.retrieveServiceByMaskFault = retrieveServiceByMaskFault;
    }

    public RetrieveServiceByMaskFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveServiceByMaskFault retrieveServiceByMaskFault, java.lang.Throwable cause) {
        super(message, cause);
        this.retrieveServiceByMaskFault = retrieveServiceByMaskFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveServiceByMaskFault getFaultInfo() {
        return this.retrieveServiceByMaskFault;
    }
}
