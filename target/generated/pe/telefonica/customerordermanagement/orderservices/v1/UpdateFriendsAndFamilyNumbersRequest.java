
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-08-05T12:28:04.116-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "UpdateFriendsAndFamilyNumbersRequest", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class UpdateFriendsAndFamilyNumbersRequest extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersRequestType updateFriendsAndFamilyNumbersRequest;

    public UpdateFriendsAndFamilyNumbersRequest() {
        super();
    }
    
    public UpdateFriendsAndFamilyNumbersRequest(String message) {
        super(message);
    }
    
    public UpdateFriendsAndFamilyNumbersRequest(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public UpdateFriendsAndFamilyNumbersRequest(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersRequestType updateFriendsAndFamilyNumbersRequest) {
        super(message);
        this.updateFriendsAndFamilyNumbersRequest = updateFriendsAndFamilyNumbersRequest;
    }

    public UpdateFriendsAndFamilyNumbersRequest(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersRequestType updateFriendsAndFamilyNumbersRequest, java.lang.Throwable cause) {
        super(message, cause);
        this.updateFriendsAndFamilyNumbersRequest = updateFriendsAndFamilyNumbersRequest;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.UpdateFriendsAndFamilyNumbersRequestType getFaultInfo() {
        return this.updateFriendsAndFamilyNumbersRequest;
    }
}
