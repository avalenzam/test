
package pe.telefonica.customerordermanagement.orderservices.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-10-22T10:36:06.994-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "CreateTokenFnFFault", targetNamespace = "http://telefonica.pe/CustomerOrderManagement/OrderServices/V1/types")
public class CreateTokenFnFFault extends Exception {
    
    private pe.telefonica.customerordermanagement.orderservices.v1.types.CreateTokenFnFFault createTokenFnFFault;

    public CreateTokenFnFFault() {
        super();
    }
    
    public CreateTokenFnFFault(String message) {
        super(message);
    }
    
    public CreateTokenFnFFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public CreateTokenFnFFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.CreateTokenFnFFault createTokenFnFFault) {
        super(message);
        this.createTokenFnFFault = createTokenFnFFault;
    }

    public CreateTokenFnFFault(String message, pe.telefonica.customerordermanagement.orderservices.v1.types.CreateTokenFnFFault createTokenFnFFault, java.lang.Throwable cause) {
        super(message, cause);
        this.createTokenFnFFault = createTokenFnFFault;
    }

    public pe.telefonica.customerordermanagement.orderservices.v1.types.CreateTokenFnFFault getFaultInfo() {
        return this.createTokenFnFFault;
    }
}
