package com.telefonica.eof.ehcache;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.telefonica.eof.repository.EquipmentRepository;

@Component
public class CacheEquipmentCharge {


    @Autowired
    private EquipmentRepository equipmentRepository;

    
    @Cacheable(value = "equipment")
    public Map<String, List<Equipment>> getEquipment() {
	return equipmentRepository.EquipmentTable().stream().collect(Collectors.groupingBy(Equipment::getLob));
    }
    
}
