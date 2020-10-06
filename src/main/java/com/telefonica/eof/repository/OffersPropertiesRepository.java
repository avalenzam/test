package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.entity.OffersProperties;

public interface OffersPropertiesRepository {
    
    public List<OffersProperties> findPropertyValue(String productOfferingCatalogId);
    public String findSpsIdByofferCid(String productOfferingCatalogId);
    public List<OffersProperties> offersPropertiesTable();

}
