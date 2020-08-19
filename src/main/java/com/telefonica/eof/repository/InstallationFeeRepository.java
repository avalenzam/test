package com.telefonica.eof.repository;

import com.telefonica.eof.entity.InstallationFee;

public interface InstallationFeeRepository {
    
    public InstallationFee findBoUpfront(String action, String lob, String upfrontIndId);

}
