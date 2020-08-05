package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.entity.Upfront;
import com.telefonica.eof.repository.UpfrontRepository;

@Repository
public class JdbcUpfrontRepository implements UpfrontRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Upfront> getUpfront () {
	String query = "select UPFRONT_IND_DESC, UPFRONT_IND_ID"
		+ " from UPFRONT_IND";
	
	List<Upfront> upfront = jdbcTemplate.query(query,
		new BeanPropertyRowMapper<>(Upfront.class));
	
	return upfront;

    }
}
