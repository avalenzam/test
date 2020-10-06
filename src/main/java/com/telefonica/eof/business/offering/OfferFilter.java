package com.telefonica.eof.business.offering;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.ehcache.CachePlanCidCharge;
import com.telefonica.eof.ehcache.PlanCid;

@Component
public class OfferFilter {

    @Autowired
    private CachePlanCidCharge cachePlanCidCharge;

    public Boolean offerFilter(OffersBenefitsRequestDto offersBenefitsRequestDto, String catalogItemId) {

	Map<String, List<PlanCid>> planCidMap = cachePlanCidCharge.getPlanCid();
	List<PlanCid> planCidList = planCidMap.get(catalogItemId);
	Boolean plancid = false;

	if (!(planCidList == null || planCidList.isEmpty())) {
	    plancid = planCidList.stream()
		    .anyMatch(x -> x.getDepartamento().equalsIgnoreCase(Constant.ASTERISK)
			    || x.getDepartamento().equalsIgnoreCase(offersBenefitsRequestDto.getInstallationAddressDepartment())
				    && x.getDealerCode().equalsIgnoreCase(Constant.ASTERISK)
			    || x.getDealerCode().equalsIgnoreCase(offersBenefitsRequestDto.getDealerId())
				    && x.getStoreId().equalsIgnoreCase(Constant.ASTERISK)
			    || x.getStoreId().equalsIgnoreCase(offersBenefitsRequestDto.getSiteId()));
	}

	return plancid;

    }
}
