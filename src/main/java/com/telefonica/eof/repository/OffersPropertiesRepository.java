package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.entity.OffersProperties;

public interface OffersPropertiesRepository {
    
    public List<OffersProperties> getByOfferCid(String productOfferingCatalogId);
    public String getSpsId(String productOfferingCatalogId);

}
