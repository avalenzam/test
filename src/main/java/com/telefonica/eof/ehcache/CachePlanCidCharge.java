package com.telefonica.eof.ehcache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.telefonica.eof.repository.OffilterBundleRepository;

@Component
public class CachePlanCidCharge {

    @Autowired
    private OffilterBundleRepository offilterBundleRepository;
    
    @Cacheable(value = "plan_cid")
    public Map<String, List<PlanCid>> getPlanCid() {
	return offilterBundleRepository.planCid().stream().collect(Collectors.groupingBy(PlanCid::getOfferCid));
    }
}
