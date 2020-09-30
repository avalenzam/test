package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.ehcache.Equipment;

public interface EquipmentRepository {
    
    public String findEquipmentCid (String networkTechnology,String lob) ;

    public List<Equipment> EquipmentTable();

}
