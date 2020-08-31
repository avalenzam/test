package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.TbconfigItemRepository;

@Repository
public class JdbcTbconfigItemRepository implements TbconfigItemRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Integer findParameterValue() {
	try {
	  String query = "select PARAMETER_VALUE"
		+ " from TBCONFIG_ITEM"
		+ " where PARAMETER_NAME = 'MAX_ALLOWED_STBs_FOR_RISKY_CUSTOMER'" ;
	
	return jdbcTemplate.queryForObject(query,Integer.class);
	  
	} catch (EmptyResultDataAccessException e) {
		return null;
	}	 
    }
}
