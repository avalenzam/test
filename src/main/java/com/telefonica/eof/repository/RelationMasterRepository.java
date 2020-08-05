package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;

public interface RelationMasterRepository {
    
    public List<RelationMaster> getBoActive (String productOfferingCatalogId, String svaIdComponente);
    public List<String> getBoByBoType (String cidBo);
    public List<RelationMaster> validateIdComponente ( String cidBo, String propertyValue );
    public List<String> getParentId(String billingOfferId );
    public Sps getSpsIdAndName(String parentId );
    public String getDiscountSpsName (String benefitThemePackSpsCid );
    public Sps getIdAndNameComponent (String defSpsBo, String vProductOfferingID );
    public List<RelationMaster> getSvas (String vProductOfferingID );

}
