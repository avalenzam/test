package com.telefonica.eof.ehcache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.repository.OffersPropertiesRepository;
@Component
public class CacheOffersPropertiesCharge {

    @Autowired
    private OffersPropertiesRepository offersPropertiesRepository;
    
    @Cacheable(value = "offers_properties")
    public Map<String, List<OffersProperties>> getOffersProperties() {
	return offersPropertiesRepository.offersPropertiesTable().stream().collect(Collectors.groupingBy(OffersProperties::getOfferCid));
    }
}
