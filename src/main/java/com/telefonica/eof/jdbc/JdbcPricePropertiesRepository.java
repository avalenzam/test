package com.telefonica.eof.jdbc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.repository.PricePropertiesRepository;

@Repository
public class JdbcPricePropertiesRepository implements PricePropertiesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public PriceProperties findPriceInfo(String childId) {
	try {
	   String query = "select VALUE_ABP , REVENUE_TYPE , NAME_PROP_ABP"
		+ " from PRICE_PROPERTIES"
		+ " where NAME_PROP_ABP = 'Rate'"
		+ " and BILLING_OFFER_CID = ?";
	 
	List<PriceProperties> priceInfo = jdbcTemplate.query(query,
			new Object[]{childId},
			new BeanPropertyRowMapper<>(PriceProperties.class));

	
	return !priceInfo.isEmpty() ? priceInfo.get(0):null;
    
	} catch (EmptyResultDataAccessException e) {
		return null;
   }
	} 
	
    
    @Override
    public List<PriceProperties> findDiscountPriceDetail (String benefitBillingOfferCid) {
	try {
	   String query = "select VALUE_ABP , NAME_PROP_ABP"
		+ " from PRICE_PROPERTIES"
		+ " where NAME_PROP_ABP in ('Discount type','Discount value')"
		+ " and BILLING_OFFER_CID = ?";
	 
	return jdbcTemplate.query(query,
		new Object[]{benefitBillingOfferCid},
		new BeanPropertyRowMapper<>(PriceProperties.class)); 
	} catch (EmptyResultDataAccessException e) {
		return null;
   }
	
	
	  
    }
    
    @Override
    public BigDecimal findUpfrontPrice (String installationFeeBo) {
	try {
	    String query = "select VALUE_ABP"
		+ " from PRICE_PROPERTIES pp, BILLING_OFFER_MASTER bom"
		+ " where pp.NAME_PROP_ABP = 'Rate'"
		+ " and pp.BILLING_OFFER_CID = bom.CID_BO"
		+ " and bom.CAPTION_BO = ?";
	 
	return jdbcTemplate.queryForObject(query,
		new Object[]{installationFeeBo},
		BigDecimal.class);
	  
	} catch (EmptyResultDataAccessException e) {
		return null;
   }
	
	
    }

}
