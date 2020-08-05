package com.telefonica.eof.jdbc;

import java.math.BigDecimal;

public interface InstalFeeNoRiskRepository {
    
    public BigDecimal getUpfrontPrice(String channelId, String installationAddressDepartment);

}
