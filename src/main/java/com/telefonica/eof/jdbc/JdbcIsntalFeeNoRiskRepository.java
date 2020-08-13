package com.telefonica.eof.jdbc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.InstalFeeNoRiskRepository;

@Repository
public class JdbcIsntalFeeNoRiskRepository implements InstalFeeNoRiskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal getUpfrontPrice(String channelId, String installationAddressDepartment) {

	String query = "SELECT rate" + " FROM INSTAL_FEE_NO_RISK"
		+ " where SALE_CHANNEL in (?, 'ALL')"
		+ " and INSTAL_ADDR_DEPART in (?, 'ALL')"
		+ " and QUAD_CONV_IND = 'Y'" 
		+ " and EFFECTIVE_DATE <= CURRENT_DATE"
		+ " and EXPIRATION_DATE >= CURRENT_DATE";

	return jdbcTemplate.queryForObject(query,
		new Object[] { channelId, installationAddressDepartment },
		BigDecimal.class);

    }
}
