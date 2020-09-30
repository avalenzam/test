package com.telefonica.eof.ehcache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.telefonica.eof.repository.EquipmentRepository;



@Component
public class EquipmentCharge {
    
    @Autowired
    private EquipmentRepository listEquipmentRepository;

    @Cacheable(value = "equipment")
    public List<Equipment> getEquipment() {
System.out.println("entro carga cache");
	return listEquipmentRepository.EquipmentTable();
    }
    
    @Cacheable(value = "equipment")
    public String getEquipmentByIndex(String networkTechnology, String lob) {
System.out.println("entro carga cache index");
	return listEquipmentRepository.findEquipmentCid(networkTechnology, lob);
    }
}
