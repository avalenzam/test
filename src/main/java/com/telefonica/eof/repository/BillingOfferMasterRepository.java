package com.telefonica.eof.repository;

import com.telefonica.eof.entity.BillingOfferMaster;

public interface BillingOfferMasterRepository {
    
    public BillingOfferMaster getBillingOfferName(String benefitBillingOfferCid);
    public String getCidBo(String installationFeeBo);

}
