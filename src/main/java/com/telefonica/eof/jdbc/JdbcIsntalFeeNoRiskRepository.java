package com.telefonica.eof.jdbc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.InstalFeeNoRiskRepository;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: JdbcIsntalFeeNoRiskRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Repositorio de las consultas hechas a la tabla INSTAL_FEE_NO_RISK
 */
@Repository
public class JdbcIsntalFeeNoRiskRepository implements InstalFeeNoRiskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal findRate(String channelId, String installationAddressDepartment) {
	try {
	 String query = "SELECT DISTINCT rate"
		+ " FROM INSTAL_FEE_NO_RISK"
		+ " where SALE_CHANNEL in (?, 'ALL')"
		+ " and INSTAL_ADDR_DEPART in (?, 'ALL')"
		+ " and QUAD_CONV_IND = 'Y'" 
		+ " and EFFECTIVE_DATE <= CURRENT_DATE"
		+ " and EXPIRATION_DATE >= CURRENT_DATE";

	return jdbcTemplate.queryForObject(query,
		new Object[] { channelId, installationAddressDepartment },
		BigDecimal.class);   
	} catch (EmptyResultDataAccessException e) {
		return null;
	}

	

    }
}
