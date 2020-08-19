package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.EquipmentRepository;

@Repository
public class JdbcEquipmentRepository implements EquipmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findEquipmentCid (String networkTechnology,String lob) {
	try {
	    String query = "select CID"
		+ " from  EQUIPMENT"
		+ " where NETWORK_TECHNOLOGY = ?"
		+ " and LOB = ?"
		+ " and IS_SELLABLE  = 'Y'" ;
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{networkTechnology, lob},
		String.class);
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
    }

}
