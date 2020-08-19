package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.RelationOffersXPlanRepository;

@Repository
public class JdbcRelationOffersXPlanRepository implements RelationOffersXPlanRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findPlanCid  (String productOfferingCatalogId) {
	try {
	    String query = "select rop.PLAN_CID "  
		+ "from  RELATION_OFFERS_X_PLAN rop "  
		+ "inner join RELATIONS_MASTER rm on  rop.RELATION_ID= rm.RELATION_ID "  
		+ "inner join PROPERTY_IN_BILLING_OFFER pibo on rm.CHILD_ID  =  pibo.CID_BO "
		+ "where rop.OFFER_ID = ? "
		+ "and rm.PARENT_ID = '3196251' "
		+ "and rm.CHILD_IS = 'PP' "
		+ "and rm.IS_MANDATORY = '1' "
		+ "and pibo.PROPERTY_NAME = 'Plan BO Indicator' " 
		+ "and pibo.PROPERTY_VALUE = 'Y'" ;
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{productOfferingCatalogId},
		Integer.class);
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	
	 

    }
}
