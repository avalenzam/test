package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.DomainWithValidValuesRepository;

@Repository
public class JdbcDomainWithValidValuesRepository implements DomainWithValidValuesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getCaption (String spsSetting) {
	String query = "select CAPTION"
		+ " from DOMAIN_WITH_VALID_VALUES"
		+ " where VALID_VALUE = ?"
		+ " and DOMAIN_NAME = 'AbsSTBsRank'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{spsSetting},
		Integer.class);
    }
    
    @Override
    public String getStbSetting (Integer rankSTB) {
	String query = "select VALID_VALUE"
		+ " from DOMAIN_WITH_VALID_VALUES"
		+ " where CAPTION = ?"
		+ " and DOMAIN_NAME = 'AbsSTBsRank'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{rankSTB},
		String.class);
    }
    
    @Override
    public String getNameComponent (String stbSetting) {
	String query = "select CAPTION"
		+ " from DOMAIN_WITH_VALID_VALUES"
		+ " where VALID_VALUE = ?"
		+ " and DOMAIN_NAME = 'AbsSTBType'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{stbSetting},
		String.class);
    }
}
