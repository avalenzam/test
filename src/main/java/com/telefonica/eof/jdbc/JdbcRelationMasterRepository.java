package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public List<RelationMaster> findBillingOfferActive (String productOfferingCatalogId, String svaIdComponente) {
	try {
	  String query = "select DISTINCT pibo.CID_BO, rm.CHILD_ID, bom.CAPTION_BO,"
		+ " rm.NAME_CHILD, rm.PARENT_ID, rm.NAME_PARENT, pibo.DURATION_VALUE, rm.RELATION_ID " 
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
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	

    }
    
    @Override
    public List<String> findBillingOfferByBoType (String cidBo) {
	try {
	    String query = "select DISTINCT pibo.CID_BO" 
		+ " from RELATIONS_MASTER rm"
		+ " inner join PROPERTY_IN_BILLING_OFFER pibo on rm.CHILD_ID  = pibo.CID_BO"
		+ " WHERE pibo.CID_BO IN (?)"
		+ " AND pibo.PROPERTY_NAME = 'BO Type'"
		+ " AND pibo.PROPERTY_VALUE !=  'Retention'";
	
	List<String> cidBoBoType = jdbcTemplate.queryForList(query,
		new Object[]{cidBo},
		String.class);
	
	return cidBoBoType;
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	

    }
    
    @Override
    public List<RelationMaster> validateIdComponente ( String cidBo, String propertyValue ) {
	
	try {
	    String query = "select DISTINCT pibo.CID_BO, rm.CHILD_ID, bom.CAPTION_BO,"
		+ " rm.NAME_CHILD, rm.PARENT_ID, rm.NAME_PARENT, pibo.DURATION_VALUE, rm.RELATION_ID " 
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
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	

    }
    
    @Override
    public List<String> findParentIdByChildId(String billingOfferId ) {
	try {
	    String query = "select parent_id "
		+ "from relations_master b "
		+ "where b.child_id = ? ";
	
	List<String> parentId = jdbcTemplate.queryForList(query,
		new Object[]{billingOfferId},
		String.class);
	
	return parentId;
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	
    }
    
    @Override
    public Sps findSpsIdAndName(String parentId ) {
	try {
	    String query = "select a.parent_id, a.name_parent"
		+ " from relations_master a"
		+ " where a.child_id in (?)"
		+ " and a.parente_is = 'PR'";
	
	List<Sps> spsList = jdbcTemplate.query(query,
		new Object[]{parentId},
		new BeanPropertyRowMapper<>(Sps.class));
	
	return spsList.size()>0 ? spsList.get(0):null;
	
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
	
    }
    
    @Override
    public String findSpsDiscountName (String benefitThemePackSpsCid ) {
	try {
	    String query = "select name_parent"
   		+ " from relations_master"
   		+ " where parent_id = ?"
   		+ " and parente_is = 'PR'";
   	
   	 return jdbcTemplate.queryForObject(query,
   		new Object[]{benefitThemePackSpsCid},
   		String.class);
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
   	
   	
       }
    
    @Override
    public Sps findComponentIdAndName (String defSpsBo, String vProductOfferingID ) {
	try {
	    String query = "select rm.parent_id, rm.name_parent"
   		+ " from relations_master rm, BILLING_OFFER_MASTER bim, MASTER_CHANN_PACK_WITH_PROPERT mcp"
   		+ " where rm.child_id = bim.cid_bo"
   		+ " and caption_bo = substr( ? ,1,"
   		+ " decode(instr(?,';')-1,-1,"
   		+ " length(?),"
   		+ " instr(?,';')-1))"
   		+ " and rm.root_cid = ?"
   		+ " and ROWNUM = 1";

   	List<Sps> spsList = jdbcTemplate.query(query,
   		new Object[]{defSpsBo, defSpsBo, defSpsBo, defSpsBo, vProductOfferingID},
		new BeanPropertyRowMapper<>(Sps.class));
   
   	return spsList.size()>0 ? spsList.get(0):null;
   	
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
   	
	
       }
    
    @Override
    public List<RelationMaster> findSvasByRootCid (String vProductOfferingID ) {
	try {
	    String query = "select rm.PARENT_ID, bom.CID_BO, bom.NAME_BO "
   		+ " from relations_master rm, BILLING_OFFER_MASTER bom" 
   		+ " where rm.root_cid = ?" 
   		+ " and rm.is_mandatory = '1'"  
   		+ " and rm.PARENT_ID in ('2723922', '3239962')"  
   		+ " and bom.CID_BO = rm.CHILD_ID";
   	
  
   	return jdbcTemplate.query(query,
		new Object[]{vProductOfferingID},
		new BeanPropertyRowMapper<>(RelationMaster.class));
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
   	
	
       }
    
    @Override
    public String findRelationId (String productOfferingCatalogId, String parentId ) {
	try {
	    String query = "select RELATION_ID"
   		+ " from relations_master"
   		+ " where regexp_replace(ROOT_CID, '\\W','') = TRIM(?)"
   		+ " and CHILD_ID = ?";
   	
	    return jdbcTemplate.queryForObject(query,
   		new Object[]{productOfferingCatalogId, parentId },
   		String.class);
   	
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
   	
       }
    @Override
    public String findRelationIdByrelationCidRoot (String parentId, String productOfferingCatalogId) {
	try {
	    String query = "select DISTINCT relation_id"
	    	+ " from relations_master where CHILD_ID = ?"
	    	+ " and regexp_replace(ROOT_CID, '\\W','')"
	    	+ " in (SELECT TRIM(TO_CHAR(CID_CHILD))"
	    	+ " from RELATION_ROOT_CID where ROOT_CID = ? )";
   	
	    return jdbcTemplate.queryForObject(query,
   		new Object[]{parentId, productOfferingCatalogId},
   		String.class);
   	
	} catch (EmptyResultDataAccessException e) {
		return null;
	}
   	
       }
    
    
    
    
    
    

}
