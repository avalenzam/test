package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.BillingOfferMasterRepository;

@Repository
public class JdbcBillingOfferMasterRepository implements BillingOfferMasterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   @Override
    public String getBillingOfferName(String benefitBillingOfferCid) {
	String query = "select NAME_BO"
		+ " from BILLING_OFFER_MASTER"
		+ " where CID_BO = ?" ;
	
	 return jdbcTemplate.queryForObject(query,
		new Object[]{benefitBillingOfferCid},
		String.class);
		 
    }
}
