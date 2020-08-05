package com.telefonica.eof.repository;

import java.math.BigDecimal;
import java.util.List;

import com.telefonica.eof.entity.PriceProperties;

public interface PricePropertiesRepository {
    
    public PriceProperties getPriceInfo(String childId);
    public List<PriceProperties> getDiscountPriceDetail (String benefitBillingOfferCid);
    public BigDecimal getUpfrontPrice (String installationFeeBo);
    

}
