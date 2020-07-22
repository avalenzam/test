package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.repository.RelationMasterRepository;

@Repository
public class JdbcRelationMasterRepository implements RelationMasterRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<RelationMaster> getBoActive (String productOfferingCatalogId, String svaIdComponente) {
	String query = "select DISTINCT pibo.CID_BO, rm.CHILD_ID, bom.CAPTION_BO,"
		+ " rm.NAME_CHILD, rm.PARENT_ID, rm.NAME_PARENT, pibo.DURATION_VALUE " 
		+ " from RELATIONS_MASTER rm"
		+ " inner join BILLING_OFFER_MASTER bom on rm.CHILD_ID = bom.CID_BO"
		+ " inner join PROPERTY_IN_BILLING_OFFER pibo on rm.CHILD_ID  = pibo.CID_BO"
		+ " WHERE rm.ROOT_CID = ?"
		+ " AND rm.PARENT_ID = ?"
		+ " AND rm.CHILD_IS = 'PP'"
		+ " AND rm.default_quantity = 0"
		+ " AND rm.minimum_quantity = 0"
		+ " AND rm.maximum_quantity > 0"
		+ " AND pibo.PROPERTY_NAME = 'Salesenddate'"
		+ " AND ( TO_DATE(SUBSTR(pibo.PROPERTY_VALUE,1,10), 'YYYY-MM-DD' ) >= CURRENT_DATE"
		+ " or pibo.PROPERTY_VALUE is null)";
	
	List<RelationMaster> cidBoActive = jdbcTemplate.queryForList(query,
		new Object[]{productOfferingCatalogId, svaIdComponente },
		RelationMaster.class);
	
	return cidBoActive;

    }
    
    @Override
    public List<String> getBoByBoType (String cidBo) {
	String query = "select DISTINCT pibo.CID_BO" 
		+ " from RELATIONS_MASTER rm"
		+ " WHERE pibo.CID_BO IN (?)"
		+ " AND pibo.PROPERTY_NAME = 'BO Type'"
		+ " AND pibo.PROPERTY_VALUE !=  'Retention'";
	
	List<String> cidBoBoType = jdbcTemplate.queryForList(query,
		new Object[]{cidBo},
		String.class);
	
	return cidBoBoType;

    }
    
    @Override
    public List<RelationMaster> validateIdComponente ( String cidBo, String propertyValue ) {
	String query = "select DISTINCT pibo.CID_BO, rm.CHILD_ID, bom.CAPTION_BO,"
		+ " rm.NAME_CHILD, rm.PARENT_ID, rm.NAME_PARENT, pibo.DURATION_VALUE " 
		+ " from RELATIONS_MASTER rm"
		+ " inner join BILLING_OFFER_MASTER bom on rm.CHILD_ID = bom.CID_BO"
		+ " inner join PROPERTY_IN_BILLING_OFFER pibo on rm.CHILD_ID  = pibo.CID_BO"
		+ " WHERE pibo.CID_BO  = ?"
		+ " AND pibo.PROPERTY_NAME = 'BO Type'"
		+ " AND pibo.PROPERTY_VALUE "+ propertyValue;
	
	List<RelationMaster> billingOfferList = jdbcTemplate.query(query,
		new Object[]{cidBo},
		new BeanPropertyRowMapper<>(RelationMaster.class));
	
	return billingOfferList;

    }
    
    @Override
    public List<String> getParentId(String billingOfferId ) {
	String query = "select parent_id "
		+ "from relations_master b "
		+ "where b.child_id = ? ";
	
	List<String> parentId = jdbcTemplate.queryForList(query,
		new Object[]{billingOfferId},
		String.class);
	
	return parentId;
    }
    
    @Override
    public Sps getSpsIdAndName(String parentId ) {
	String query = "select a.parent_id, a.name_parent"
		+ " from relations_master a"
		+ " where a.child_id in (?)"
		+ " and a.parente_is = 'PR'";
	
	List<Sps> spsIdAndName = jdbcTemplate.query(query,
		new Object[]{parentId},
		new BeanPropertyRowMapper<>(Sps.class));
	
	return spsIdAndName.get(0);
    }
    
    @Override
    public String getDiscountSpsName (String benefitThemePackSpsCid ) {
   	String query = "select name_parent"
   		+ " from relations_master"
   		+ " where parent_id = ?"
   		+ " and parente_is = 'PR'";
   	
   	 return jdbcTemplate.queryForObject(query,
   		new Object[]{benefitThemePackSpsCid},
   		String.class);
   	
       }
    
    
    
    

}
