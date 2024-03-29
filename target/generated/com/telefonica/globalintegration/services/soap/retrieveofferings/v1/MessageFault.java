
package com.telefonica.globalintegration.services.soap.retrieveofferings.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.15
 * 2020-11-18T18:55:03.221-05:00
 * Generated source version: 3.1.15
 */

@WebFault(name = "MessageFault", targetNamespace = "http://telefonica.com/globalIntegration/fault")
public class MessageFault extends Exception {
    
    private com.telefonica.globalintegration.fault.OperationFaultType messageFault;

    public MessageFault() {
        super();
    }
    
    public MessageFault(String message) {
        super(message);
    }
    
    public MessageFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public MessageFault(String message, com.telefonica.globalintegration.fault.OperationFaultType messageFault) {
        super(message);
        this.messageFault = messageFault;
    }

    public MessageFault(String message, com.telefonica.globalintegration.fault.OperationFaultType messageFault, java.lang.Throwable cause) {
        super(message, cause);
        this.messageFault = messageFault;
    }

    public com.telefonica.globalintegration.fault.OperationFaultType getFaultInfo() {
        return this.messageFault;
    }
}
