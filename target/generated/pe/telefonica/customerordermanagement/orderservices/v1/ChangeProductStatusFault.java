
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-17T09:35:50.608-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "ChangeProductStatusFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class ChangeProductStatusFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeProductStatusFault changeProductStatusFault;

    public ChangeProductStatusFault() {
        super();
    }
    
    public ChangeProductStatusFault(String message) {
        super(message);
    }
    
    public ChangeProductStatusFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ChangeProductStatusFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeProductStatusFault changeProductStatusFault) {
        super(message);
        this.changeProductStatusFault = changeProductStatusFault;
    }

    public ChangeProductStatusFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeProductStatusFault changeProductStatusFault, java.lang.Throwable cause) {
        super(message, cause);
        this.changeProductStatusFault = changeProductStatusFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.ChangeProductStatusFault getFaultInfo() {
        return this.changeProductStatusFault;
    }
}
