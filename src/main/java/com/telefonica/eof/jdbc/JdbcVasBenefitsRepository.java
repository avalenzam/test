package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.dto.SvaBenefitParamsDto;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.repository.VasBenefitsRepository;

@Repository
public class JdbcVasBenefitsRepository implements VasBenefitsRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
   @Override
    public  VasBenefits  findSvaBenefits(SvaBenefitParamsDto svaBenefitParamsDto, String dataRateFrom, String dataRateTo) {
       try {
	
	 String query = "SELECT BENEFIT_COMPONENT_CID, BENEFIT_THEME_PACK_SPS_CID,"
	 	+ " BENEFIT_BILLING_OFFER_CID, SPEED, \"DURATION\""
	 	+ " FROM VAS_BENEFITS"
	 	+ " WHERE EFFECTIVE_START_DATE <= CURRENT_DATE"
	 	+ " AND EFFECTIVE_END_DATE >= CURRENT_DATE"
	 	+ " AND SALES_CHANNEL in (?,'*')"
	 	+ " AND PO_CODE = ?"
	 	+ " AND ORDER_ACTION_TYPE in (?,'*')"
	 	+ " AND PORTIN_IND in (?,'*')"
	 	+ " AND REPLACE_OFFER_IND in (?,'*')"
	 	+ " AND SOURCE_TECHNOLOGY in (?,'*')"
	 	+ " AND TARGET_TECHNOLOGY in (?,'*')"
	 	+ " AND COMMERCIAL_ZONE in (?,'*')"
	 	+ " AND DOWNLOAD_SPEED_FROM " + dataRateFrom
	 	+ " AND DOWNLOAD_SPEED_TO " + dataRateTo
	 	+ " AND TRIGGERING_SPS_ID in ( ?, NULL)"
	 	+ " AND TRIGGERING_SERVICE_COMP_CID = ?";
	 	

	 List<VasBenefits> svaBenefits = jdbcTemplate.query(query,
			new Object[]{
				svaBenefitParamsDto.getChannelId(),
				svaBenefitParamsDto.getOfferCaption(),
				svaBenefitParamsDto.getAction(),
				svaBenefitParamsDto.getIsPortability(),
				svaBenefitParamsDto.getOrderSubType(),
				svaBenefitParamsDto.getBroadbandConnection(),
				svaBenefitParamsDto.getNetworkTechnology(),
				svaBenefitParamsDto.getCommercialAreaId(),
				svaBenefitParamsDto.getParentId(),
				svaBenefitParamsDto.getIDcomponente()},
			new BeanPropertyRowMapper<>(VasBenefits.class));
	  
	 return svaBenefits.size()>0 ? svaBenefits.get(0):null;
       } catch (EmptyResultDataAccessException e) {
		return null;
       }
	
    }

}
