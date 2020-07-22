package com.telefonica.eof.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.dto.DiscountParamsDto;
import com.telefonica.eof.entity.WirelineServiceBenefits;
import com.telefonica.eof.repository.WirelineServiceBenefitsRepository;

@Repository
public class JdbcWirelineServiceBenefitsRepository implements WirelineServiceBenefitsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
   @Override
    public  List<WirelineServiceBenefits>  getDiscount(DiscountParamsDto discountParamsDto ) {
	
	 String query = "select  BENEFIT_COMPONENT_CID, BENEFIT_THEME_PACK_SPS_CID,"
	 	+ " BENEFIT_BILLING_OFFER_CID, SPEED, DURATION, NIGHT_IND, LOB"
	 	+ " from WIRELINE_SERVICE_BENEFITS"
	 	+ " where EFFECTIVE_START_DATE <= current_date"
	 	+ " and EFFECTIVE_END_DATE >= current_date"
	 	+ " and SALES_CHANNEL in (?,'*')"
	 	+ " and PO_CODE = ?"
	 	+ " and ORDER_ACTION_TYPE in (?,'*')"
	 	+ " and PORTIN_IND in (?,'*')"
	 	+ " and REPLACE_OFFER_IND in (?, '*')"
	 	+ " and SOURCE_TECHNOLOGY in (?,'*')"
	 	+ " and TARGET_TECHNOLOGY in (?,'*')"
	 	+ " and COMMERCIAL_ZONE in (?,'*')"
	 	+ " and LOB in ('TV', 'VOIC')"
	 	+ " and DOWNLOAD_SPEED_FROM = 'NA'"
	 	+ " and DOWNLOAD_SPEED_TO = 'NA'"
	 	+ " UNION"
	 	+ " select  BENEFIT_COMPONENT_CID, BENEFIT_THEME_PACK_SPS_CID,"
	 	+ " BENEFIT_BILLING_OFFER_CID, SPEED, DURATION, NIGHT_IND, LOB"
	 	+ " from WIRELINE_SERVICE_BENEFITS"
	 	+ " where EFFECTIVE_START_DATE <= current_date"
	 	+ " and EFFECTIVE_END_DATE>= current_date"
	 	+ " and SALES_CHANNEL in (?,'*')"
	 	+ " and PO_CODE = ?"
	 	+ " and ORDER_ACTION_TYPE in (?,'*')"
	 	+ " and PORTIN_IND in (?,'*')"
	 	+ " and REPLACE_OFFER_IND in (?, '*')"
	 	+ " and SOURCE_TECHNOLOGY in (?,'*')"
	 	+ " and TARGET_TECHNOLOGY in (?,'*')"
	 	+ " and COMMERCIAL_ZONE in (?,'*')"
	 	+ " and LOB = 'BB'"
	 	+ " and DOWNLOAD_SPEED_FROM <= ?"
	 	+ " and DOWNLOAD_SPEED_TO >= ?";
	 	

	 return jdbcTemplate.query(query,
			new Object[]{
				discountParamsDto.getChannelId(),
				discountParamsDto.getCatalogItemID(),
				discountParamsDto.getAction(),
				discountParamsDto.getIsPortability(),
				discountParamsDto.getCurrentOffering(),
				discountParamsDto.getBroadbandConnection(),
				discountParamsDto.getNetworkTechnology(),
				discountParamsDto.getCommercialAreaId(),
				discountParamsDto.getChannelId(),
				discountParamsDto.getCatalogItemID(),
				discountParamsDto.getAction(),
				discountParamsDto.getIsPortability(),
				discountParamsDto.getCurrentOffering(),
				discountParamsDto.getBroadbandConnection(),
				discountParamsDto.getNetworkTechnology(),
				discountParamsDto.getCommercialAreaId(),
				discountParamsDto.getDownloadSpeed(),
				discountParamsDto.getDownloadSpeed()},
			new BeanPropertyRowMapper<>(WirelineServiceBenefits.class));

    }


}
