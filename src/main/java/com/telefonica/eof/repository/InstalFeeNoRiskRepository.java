package com.telefonica.eof.repository;

import java.math.BigDecimal;

public interface InstalFeeNoRiskRepository {
    
    public BigDecimal getUpfrontPrice(String channelId, String installationAddressDepartment);

}
