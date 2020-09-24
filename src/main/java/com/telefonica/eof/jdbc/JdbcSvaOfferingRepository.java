package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.SvaOfferingRepository;

@Repository
public class JdbcSvaOfferingRepository implements SvaOfferingRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> findIdComponent(String lobType, String tipoOperation, String flagRetencion) {
	try {
	  String query = "SELECT IDCOMPONENTE FROM SVAOffering  WHERE"
		+ " LOB_TYPE= ?"
		+ " AND TIPO_OPERATION IN ('*', ?)"
		+ " AND FLAG_RETENCIÓN IN (" + flagRetencion + ")"
		+ " AND FECHA_INICIO <= CURRENT_DATE" 
		+ " AND FECHA_FIN  >=  CURRENT_DATE" ;
	
	return jdbcTemplate.queryForList(query,
		new Object[]{lobType, tipoOperation},
		String.class);
	
	 
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	
    }

   

}
