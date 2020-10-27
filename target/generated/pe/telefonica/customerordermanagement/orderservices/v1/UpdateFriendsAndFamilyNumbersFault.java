
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-10-22T10:36:06.956-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "UpdateFriendsAndFamilyNumbersFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class UpdateFriendsAndFamilyNumbersFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersFault updateFriendsAndFamilyNumbersFault;

    public UpdateFriendsAndFamilyNumbersFault() {
        super();
    }
    
    public UpdateFriendsAndFamilyNumbersFault(String message) {
        super(message);
    }
    
    public UpdateFriendsAndFamilyNumbersFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UpdateFriendsAndFamilyNumbersFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersFault updateFriendsAndFamilyNumbersFault) {
        super(message);
        this.updateFriendsAndFamilyNumbersFault = updateFriendsAndFamilyNumbersFault;
    }

    public UpdateFriendsAndFamilyNumbersFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersFault updateFriendsAndFamilyNumbersFault, java.lang.Throwable cause) {
        super(message, cause);
        this.updateFriendsAndFamilyNumbersFault = updateFriendsAndFamilyNumbersFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersFault getFaultInfo() {
        return this.updateFriendsAndFamilyNumbersFault;
    }
}
