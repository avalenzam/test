package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.StbSettingRepository;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: JdbcStbSettingRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Repositorio de las consultas hechas a la tabla STB_SETTING
 */
@Repository
public class JdbcStbSettingRepository implements StbSettingRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findStbSettingWithSpeed (String channelId, String vProductOfferingID, Integer velocidad ) {
	try {
	    String query = "select STB_SETTINGS"
		+ " from STB_SETTING"
		+ " where SALES_CHANNEL in (?, 'All')"
		+ " and PO_CODE = ?"
		+ " and CAST(SPEED_FROM AS NUMBER) <= ?"
		+ " and CAST(SPEED_TO AS NUMBER) >= ?";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{channelId, vProductOfferingID, velocidad, velocidad },
		String.class);
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	
    }
    
    @Override
    public String findStbSettingWithoutSpeed (String channelId, String vProductOfferingID) {
	try {
	    String query = "select STB_SETTINGS"
		+ " from STB_SETTING"
		+ " where SALES_CHANNEL in (?, 'All')"
		+ " and PO_CODE = ?"
		+ " and SPEED_FROM = 'N/A'"
		+ " and SPEED_TO  = 'N/A'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{channelId, vProductOfferingID },
		String.class);
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	
    }
    

}
