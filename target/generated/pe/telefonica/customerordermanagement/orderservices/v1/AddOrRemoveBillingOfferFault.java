
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-10-22T10:36:06.867-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "AddOrRemoveBillingOfferFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class AddOrRemoveBillingOfferFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.AddOrRemoveBillingOfferFault addOrRemoveBillingOfferFault;

    public AddOrRemoveBillingOfferFault() {
        super();
    }
    
    public AddOrRemoveBillingOfferFault(String message) {
        super(message);
    }
    
    public AddOrRemoveBillingOfferFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public AddOrRemoveBillingOfferFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.AddOrRemoveBillingOfferFault addOrRemoveBillingOfferFault) {
        super(message);
        this.addOrRemoveBillingOfferFault = addOrRemoveBillingOfferFault;
    }

    public AddOrRemoveBillingOfferFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.AddOrRemoveBillingOfferFault addOrRemoveBillingOfferFault, java.lang.Throwable cause) {
        super(message, cause);
        this.addOrRemoveBillingOfferFault = addOrRemoveBillingOfferFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.AddOrRemoveBillingOfferFault getFaultInfo() {
        return this.addOrRemoveBillingOfferFault;
    }
}
