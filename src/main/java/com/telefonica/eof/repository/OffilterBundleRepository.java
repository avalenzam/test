package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.ehcache.PlanCid;

public interface OffilterBundleRepository {
    
    public String findPlanCid(String catalogItemId, String installationAddressDepartment , String dealerId, String storeId);

    public List<PlanCid> planCid();

}
