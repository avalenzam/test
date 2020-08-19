package com.telefonica.eof.repository;

import com.telefonica.eof.entity.BillingOfferMaster;

public interface BillingOfferMasterRepository {
    
    public BillingOfferMaster findBillingOfferBycidBo(String benefitBillingOfferCid);
    public String findCidBoBycaptionBo(String installationFeeBo);

}
