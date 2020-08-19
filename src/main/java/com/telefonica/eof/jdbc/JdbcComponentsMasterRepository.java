package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.ComponentsMasterRepository;

@Repository
public class JdbcComponentsMasterRepository implements ComponentsMasterRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findNameComponentByCidComponent(String benefitComponentCid) {
	
	try {
	   String query = "select NAME_COMP"
		+ " from COMPONENTS_MASTER"
		+ " where CID_COMPONENT = ?" ;
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{benefitComponentCid},
		String.class); 
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
    }
    

}
