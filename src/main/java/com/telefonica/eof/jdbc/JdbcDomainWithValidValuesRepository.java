package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.DomainWithValidValuesRepository;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: JdbcDomainWithValidValuesRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Repositorio de las consultas hechas a la tabla DOMAIN_WITH_VALID_VALUES
 */
@Repository
public class JdbcDomainWithValidValuesRepository implements DomainWithValidValuesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findCaptionByvalidValue (String spsSetting) {
	try {
	    String query = "select CAPTION"
		+ " from DOMAIN_WITH_VALID_VALUES"
		+ " where VALID_VALUE = ?"
		+ " and DOMAIN_NAME = 'AbsSTBsRank'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{spsSetting},
		Integer.class);
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
    }
    
    @Override
    public String findValidValueByCaption (Integer rankSTB) {
	try {
	    String query = "select VALID_VALUE"
		+ " from DOMAIN_WITH_VALID_VALUES"
		+ " where CAPTION = ?"
		+ " and DOMAIN_NAME = 'AbsSTBsRank'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{rankSTB},
		String.class);
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
    }
    
    @Override
    public String findNameComponentByvalidValue (String stbSetting) {
	try {
	    String query = "select CAPTION"
		+ " from DOMAIN_WITH_VALID_VALUES"
		+ " where VALID_VALUE = ?"
		+ " and DOMAIN_NAME = 'AbsSTBType'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{stbSetting},
		String.class);
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
    }
}
