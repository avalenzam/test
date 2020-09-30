package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.OffilterBundleRepository;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: JdbcOffilterBundleRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Repositorio de las consultas hechas a la tabla OFFILTER_BUNDLE
 */
@Repository
public class JdbcOffilterBundleRepository implements OffilterBundleRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findPlanCid(String catalogItemId, String installationAddressDepartment , String dealerId, String storeId) {
	try {
	 String query = "select moo.OFFER_CAPTION"
	 	+ " from OFFILTER_BUNDLE ob, MASTER_OF_OFFERS moo"
	 	+ " where moo.OFFER_CID= ?"
	 	+ " and ob.DEPARTAMENTO in (?,'*')"
	 	+ " and ob.DEALER_CODE in (?,'*')"
	 	+ " and ob.STORE_ID in (?,'*')"
	 	+ " and ob.VALIDITY_START_DATE <= CURRENT_DATE"
	 	+ " and ob.VALIDITY_END_DATE >= CURRENT_DATE"
	 	+ " and ob.PRODUCT_OFFER_CODE = moo.OFFER_CAPTION";

	return jdbcTemplate.queryForObject(query,
		new Object[] { catalogItemId, installationAddressDepartment, dealerId, storeId },
		String.class);   
	} catch (EmptyResultDataAccessException e) {
		return null;
	}

	

    }
}
