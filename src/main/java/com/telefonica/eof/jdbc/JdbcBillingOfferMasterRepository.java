package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public BillingOfferMaster findBillingOfferBycidBo(String benefitBillingOfferCid) {
       try {
	String query = "select CID_BO, NAME_BO, DESCRIPTION_TEXT"
		+ " from BILLING_OFFER_MASTER"
		+ " where CID_BO = ?" ;
	
	 
	 List<BillingOfferMaster> billingOfferName = jdbcTemplate.query(query,
		 new Object[]{benefitBillingOfferCid},
			new BeanPropertyRowMapper<>(BillingOfferMaster.class));
		
	 return billingOfferName.size()>0 ? billingOfferName.get(0):null;
       } catch (EmptyResultDataAccessException e) {
		return null;
       }
	
		 
    }
   
   @Override
   public String findCidBoBycaptionBo(String installationFeeBo) {
       try {
	String query = "select CID_BO"
		+ " from BILLING_OFFER_MASTER"
		+ " where CAPTION_BO = ?" ;
	return jdbcTemplate.queryForObject(query,
		 new Object[]{installationFeeBo},
		 String.class);
       } catch (EmptyResultDataAccessException e) {
		return null;
	}
       
		
		 
   }
}
