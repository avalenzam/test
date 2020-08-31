package com.telefonica.eof.repository;

public interface OffilterBundleRepository {
    
    public String findPlanCid(String catalogItemId, String installationAddressDepartment , String dealerId, String storeId);

}
