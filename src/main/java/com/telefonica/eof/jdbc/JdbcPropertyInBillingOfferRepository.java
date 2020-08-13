package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.PropertyInBillingOfferRepository;

@Repository
public class JdbcPropertyInBillingOfferRepository implements PropertyInBillingOfferRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Integer getPropertyValue(Integer planCid) {
	String query = "SELECT PROPERTY_VALUE FROM PROPERTY_IN_BILLING_OFFER"
		+ " WHERE  CID_BO = ? "
		+ " and PROPERTY_NAME ='Max STBs allowed'" ;
	
	Integer propertyValue = jdbcTemplate.queryForObject(query, new Object[]{planCid},Integer.class);
	
	return propertyValue;
    }

}
