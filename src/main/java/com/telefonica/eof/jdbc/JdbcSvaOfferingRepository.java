package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.SvaOfferingRepository;

@Repository
public class JdbcSvaOfferingRepository implements SvaOfferingRepository{
    //TODO descomentar el query
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getIdComponent(String lobType, String tipoOperation, String flagRetencion) {
	String query = "SELECT IDCOMPONENTE FROM SVAOffering  WHERE"
		+ " LOB_TYPE= ?"
		+ " AND TIPO_OPERATION IN ('*', ?)"
		+ " AND FLAG_RETENCIÓN IN " + flagRetencion
		+ " AND FECHA_INICIO <= CURRENT_DATE" ;
//		+ " AND FECHA_FIN  >=  CURRENT_DATE" ;
	
	List<String> idComponent = jdbcTemplate.queryForList(query,
		new Object[]{lobType, tipoOperation},
		String.class);
	
	return idComponent;
    }

   

}
