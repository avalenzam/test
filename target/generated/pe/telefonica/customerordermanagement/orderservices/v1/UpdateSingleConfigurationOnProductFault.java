
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-11T10:31:14.861-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "UpdateSingleConfigurationOnProductFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class UpdateSingleConfigurationOnProductFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateSingleConfigurationOnProductFault updateSingleConfigurationOnProductFault;

    public UpdateSingleConfigurationOnProductFault() {
        super();
    }
    
    public UpdateSingleConfigurationOnProductFault(String message) {
        super(message);
    }
    
    public UpdateSingleConfigurationOnProductFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UpdateSingleConfigurationOnProductFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateSingleConfigurationOnProductFault updateSingleConfigurationOnProductFault) {
        super(message);
        this.updateSingleConfigurationOnProductFault = updateSingleConfigurationOnProductFault;
    }

    public UpdateSingleConfigurationOnProductFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateSingleConfigurationOnProductFault updateSingleConfigurationOnProductFault, java.lang.Throwable cause) {
        super(message, cause);
        this.updateSingleConfigurationOnProductFault = updateSingleConfigurationOnProductFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateSingleConfigurationOnProductFault getFaultInfo() {
        return this.updateSingleConfigurationOnProductFault;
    }
}
