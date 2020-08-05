package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.entity.BillingOfferMaster;
import com.telefonica.eof.repository.BillingOfferMasterRepository;

@Repository
public class JdbcBillingOfferMasterRepository implements BillingOfferMasterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   @Override
    public BillingOfferMaster getBillingOfferName(String benefitBillingOfferCid) {
	String query = "select CID_BO, NAME_BO, DESCRIPTION_TEXT"
		+ " from BILLING_OFFER_MASTER"
		+ " where CID_BO = ?" ;
	
	 
	 List<BillingOfferMaster> billingOfferName = jdbcTemplate.query(query,
		 new Object[]{benefitBillingOfferCid},
			new BeanPropertyRowMapper<>(BillingOfferMaster.class));
		
		return billingOfferName.get(0);
		 
    }
   
   @Override
   public String getCidBo(String installationFeeBo) {
	String query = "select CID_BO"
		+ " from BILLING_OFFER_MASTER"
		+ " where CAPTION_BO = ?" ;
	
	 
	return jdbcTemplate.queryForObject(query,
		 new Object[]{installationFeeBo},
		 String.class);
		
		 
   }
}
