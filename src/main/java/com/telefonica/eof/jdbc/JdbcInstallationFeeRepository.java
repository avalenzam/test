package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.entity.InstallationFee;
import com.telefonica.eof.repository.InstallationFeeRepository;
@Repository
public class JdbcInstallationFeeRepository implements InstallationFeeRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public InstallationFee findBoUpfront(String action, String lob, String upfrontIndId) {
	try {
	    String query = "select INSTALLATION_FEE_BO, PRODUCT_FOR_INST_FEE"
		+ " from INSTALLATION_FEE"
		+ " where ORDER_ACTION_TYPE = ?"
		+ " and OFFER_TYPE  = ?"
		+ " and UPFRONT_IND = ?"
		+ " and QUAD  = 'Y'";
	 
	List<InstallationFee> boUpfront = jdbcTemplate.query(query,
			new Object[]{action, lob, upfrontIndId},
			new BeanPropertyRowMapper<>(InstallationFee.class));

	
	 return boUpfront.size()>0 ? boUpfront.get(0):null;
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
	
    }

}
