package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.ehcache.Equipment;
import com.telefonica.eof.repository.EquipmentRepository;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: JdbcEquipmentRepository.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Repositorio de las consultas hechas a la tabla NETWORK_TECHNOLOGY
 */
@Repository
public class JdbcEquipmentRepository implements EquipmentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findEquipmentCid (String networkTechnology,String lob) {
	try {
	    String query = "select CID"
		+ " from  EQUIPMENT"
		+ " where NETWORK_TECHNOLOGY = ?"
		+ " and LOB = ?"
		+ " and IS_SELLABLE  = 'Y'" ;
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{networkTechnology, lob},
		String.class);
	   } catch (EmptyResultDataAccessException e) {
			return null;
		}
	
    }
    
    @Override
    public List<Equipment> EquipmentTable () {
	try {
	    String query = "select CID,LOB, NETWORK_TECHNOLOGY"
		+ " from  EQUIPMENT"
		+ " where IS_SELLABLE  = 'Y'" ;
	
	    return jdbcTemplate.query(query,
				new BeanPropertyRowMapper<>(Equipment.class));
			
	       } catch (EmptyResultDataAccessException e) {
			return null;
	       }
	
    }

}
