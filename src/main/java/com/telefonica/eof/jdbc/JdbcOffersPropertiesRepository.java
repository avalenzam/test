package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.repository.OffersPropertiesRepository;

@Repository
public class JdbcOffersPropertiesRepository implements OffersPropertiesRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OffersProperties> getByOfferCid(String productOfferingCatalogId) {
	
	 String query = "select PROPERTY_VALUE, NAME_OF_PROPERTY "
	 	+ "from OFFERS_PROPERTIES "
	 	+ "where OFFER_CID = ?"
	 	+ "and NAME_OF_PROPERTY in ('LOB Type', 'Retention') ";
	 
	 List<OffersProperties> offersProperties = jdbcTemplate.query(query,
			new Object[]{productOfferingCatalogId },
			new BeanPropertyRowMapper<>(OffersProperties.class));

	
	return offersProperties;
    }
    
    @Override
    public String getSpsId(String productOfferingCatalogId) {
	
	 String query = "select property_value"
	 	+ " from OFFERS_PROPERTIES"
	 	+ " where OFFER_CID = ?"
	 	+ " and name_of_property = 'DEF_SPS_ID'";
	 
	 String spsId = jdbcTemplate.queryForObject(query,
			new Object[]{productOfferingCatalogId },
			String.class);
	return spsId;
    }

}
