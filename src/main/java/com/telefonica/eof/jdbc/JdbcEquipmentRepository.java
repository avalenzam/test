package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.EquipmentRepository;

@Repository
public class JdbcEquipmentRepository implements EquipmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getEquipmentCid (String networkTechnology,String lob) {
	String query = "select CID"
		+ " from  EQUIPMENT"
		+ " where NETWORK_TECHNOLOGY = ?"
		+ " and LOB = ?"
		+ " and IS_SELLABLE  = 'Y'" ;
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{networkTechnology, lob},
		String.class);
    }

}
