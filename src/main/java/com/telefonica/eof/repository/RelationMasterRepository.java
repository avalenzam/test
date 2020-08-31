package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;

public interface RelationMasterRepository {
    
    public List<RelationMaster> findBillingOfferActive (String productOfferingCatalogId, String svaIdComponente);
    public List<String> findBillingOfferByBoType (String cidBo);
    public List<RelationMaster> validateIdComponente ( String cidBo, String propertyValue );
    public List<String> findParentIdByChildId(String billingOfferId );
    public Sps findSpsIdAndName(String parentId );
    public String findSpsDiscountName (String benefitThemePackSpsCid );
    public Sps findComponentIdAndName (String defSpsBo, String vProductOfferingID );
    public List<RelationMaster> findSvasByRootCid (String vProductOfferingID );
    public String findRelationId (String productOfferingCatalogId, String parentId );
    public String findRelationIdByrelationCidRoot (String parentId, String productOfferingCatalogId) ;

}
