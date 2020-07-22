package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PriceProperties getPriceInfo(String childId) {
	
	String query = "select VALUE_ABP , REVENUE_TYPE , NAME_PROP_ABP"
		+ " from PRICE_PROPERTIES"
		+ " where NAME_PROP_ABP = 'Rate'"
		+ " and BILLING_OFFER_CID = ?";
	 
	List<PriceProperties> priceInfo = jdbcTemplate.query(query,
			new Object[]{childId},
			new BeanPropertyRowMapper<>(PriceProperties.class));

	
	return  priceInfo.get(0);
    }
    
    @Override
    public List<PriceProperties> getDiscountPriceDetail (String benefitBillingOfferCid) {
	
	String query = "select VALUE_ABP , NAME_PROP_ABP"
		+ " from PRICE_PROPERTIES"
		+ " where NAME_PROP_ABP in ('Discount type','Discount value')"
		+ " and BILLING_OFFER_CID = ?";
	 
	return jdbcTemplate.query(query,
		new Object[]{benefitBillingOfferCid},
		new BeanPropertyRowMapper<>(PriceProperties.class));
	  
    }

}
