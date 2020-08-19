package com.telefonica.eof.repository;

import java.math.BigDecimal;

public interface InstalFeeNoRiskRepository {
    
    public BigDecimal findRate(String channelId, String installationAddressDepartment);

}
