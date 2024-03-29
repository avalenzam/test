
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-18T18:55:16.806-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "RetrieveOrdersHistoryFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class RetrieveOrdersHistoryFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveOrdersHistoryFault retrieveOrdersHistoryFault;

    public RetrieveOrdersHistoryFault() {
        super();
    }
    
    public RetrieveOrdersHistoryFault(String message) {
        super(message);
    }
    
    public RetrieveOrdersHistoryFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public RetrieveOrdersHistoryFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveOrdersHistoryFault retrieveOrdersHistoryFault) {
        super(message);
        this.retrieveOrdersHistoryFault = retrieveOrdersHistoryFault;
    }

    public RetrieveOrdersHistoryFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveOrdersHistoryFault retrieveOrdersHistoryFault, java.lang.Throwable cause) {
        super(message, cause);
        this.retrieveOrdersHistoryFault = retrieveOrdersHistoryFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveOrdersHistoryFault getFaultInfo() {
        return this.retrieveOrdersHistoryFault;
    }
}
