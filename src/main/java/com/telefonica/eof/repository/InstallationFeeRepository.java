package com.telefonica.eof.repository;

import com.telefonica.eof.entity.InstallationFee;

public interface InstallationFeeRepository {
    
    public InstallationFee getBoUpfront(String action, String lob, String upfrontIndId);

}
