package com.telefonica.eof.repository;

import java.math.BigDecimal;
import java.util.List;

import com.telefonica.eof.entity.PriceProperties;

public interface PricePropertiesRepository {
    
    public PriceProperties findPriceInfo(String childId);
    public List<PriceProperties> findDiscountPriceDetail (String benefitBillingOfferCid);
    public BigDecimal findUpfrontPrice (String installationFeeBo);
    

}
