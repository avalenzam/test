package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.MasterOfOffersRepository;

@Repository
public class JdbcMasterOfOffersRepository implements MasterOfOffersRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findOfferCaption(String productOfferingCatalogId) {
	try {
	  String query = "select OFFER_CAPTION"
		+ " from MASTER_OF_OFFERS"
		+ " where OFFER_CID = ? ";
	
	return	jdbcTemplate.queryForObject(query,
		new Object[]{productOfferingCatalogId},
		String.class);  
	} catch (EmptyResultDataAccessException e) {
		return null;
   }
	
	
	
    }
    
    
}
