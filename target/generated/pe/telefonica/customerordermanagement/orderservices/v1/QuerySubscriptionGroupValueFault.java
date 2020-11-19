
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-18T18:55:16.872-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "QuerySubscriptionGroupValueFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class QuerySubscriptionGroupValueFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.QuerySubscriptionGroupValueFault querySubscriptionGroupValueFault;

    public QuerySubscriptionGroupValueFault() {
        super();
    }
    
    public QuerySubscriptionGroupValueFault(String message) {
        super(message);
    }
    
    public QuerySubscriptionGroupValueFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public QuerySubscriptionGroupValueFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.QuerySubscriptionGroupValueFault querySubscriptionGroupValueFault) {
        super(message);
        this.querySubscriptionGroupValueFault = querySubscriptionGroupValueFault;
    }

    public QuerySubscriptionGroupValueFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.QuerySubscriptionGroupValueFault querySubscriptionGroupValueFault, java.lang.Throwable cause) {
        super(message, cause);
        this.querySubscriptionGroupValueFault = querySubscriptionGroupValueFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.QuerySubscriptionGroupValueFault getFaultInfo() {
        return this.querySubscriptionGroupValueFault;
    }
}
