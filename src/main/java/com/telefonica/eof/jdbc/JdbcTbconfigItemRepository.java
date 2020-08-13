package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.telefonica.eof.repository.TbconfigItemRepository;

public class JdbcTbconfigItemRepository implements TbconfigItemRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Integer findParameterValue() {
	String query = "select PARAMETER_VALUE"
		+ " from TBCONFIG_ITEM"
		+ " where PARAMETER_NAME = 'MAX_ALLOWED_STBs_FOR_RISKY_CUSTOMER'" ;
	
	Integer propertyValue = jdbcTemplate.queryForObject(query,Integer.class);
	
	return propertyValue;
    }
}
