package com.telefonica.eof.business.offering;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.DiscountParamsDto;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.WirelineServiceBenefits;
import com.telefonica.eof.pojo.benefits.BenefitsResponse;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.WirelineServiceBenefitsRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: Benefit.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: El servicio obtiene los beneficios de la oferta fija
 */

@Component
public class Benefit {

    @Autowired
    private WirelineServiceBenefitsRepository wirelineServiceBenefitsRepository;
    @Autowired
    private PricePropertiesRepository	      pricePropertiesRepository;
    @Autowired
    private ComponentsMasterRepository	      componentsMasterRepository;
    @Autowired
    private RelationMasterRepository	      relationMasterRepository;
    @Autowired
    private BillingOfferMasterRepository      billingOfferMasterRepository;

    public List<BenefitsResponse> getBenefitDiscount(OffersBenefitsRequestDto offersBenefitsRequestDto, String amdocsCatalogItemID,
	    String amdocsDownloadSpeed) {

	List<BenefitsResponse> benefitsResponseList = new ArrayList<>();
	BenefitsResponse benefitsResponse = new BenefitsResponse();

	String currentOffering;

	if (Constant.NULL.equalsIgnoreCase(offersBenefitsRequestDto.getCurrentOffering())
		|| StringUtil.isNullOrEmpty(offersBenefitsRequestDto.getCurrentOffering())) {
	    currentOffering = Constant.NO;
	} else {
	    currentOffering = Constant.YES;
	}

	DiscountParamsDto discountParamsDto = new DiscountParamsDto();
	discountParamsDto.setChannelId(offersBenefitsRequestDto.getChannelId());
	discountParamsDto.setCatalogItemID("DuoInternetEstandarDigitalHD");
	discountParamsDto.setAction(offersBenefitsRequestDto.getAction());
	discountParamsDto.setIsPortability(offersBenefitsRequestDto.getIsPortability());
	discountParamsDto.setCurrentOffering(currentOffering);
	discountParamsDto.setBroadbandConnection(offersBenefitsRequestDto.getBroadband().getConnection());
	discountParamsDto.setNetworkTechnology(offersBenefitsRequestDto.getNetworkTechnology());
	discountParamsDto.setCommercialAreaId(offersBenefitsRequestDto.getCommercialAreaId());
	discountParamsDto.setDownloadSpeed(amdocsDownloadSpeed);

	List<WirelineServiceBenefits> discountList = wirelineServiceBenefitsRepository.findBenefits(discountParamsDto);

	discountList.forEach(discountOffer -> {
	    String nameComp = componentsMasterRepository.findNameComponentByCidComponent(discountOffer.getBenefitsComponentCid());
	    List<PriceProperties> discountDetail = pricePropertiesRepository
		    .findDiscountPriceDetail(discountOffer.getBenefitBillingOfferCid());
	    String valueAbp = discountDetail.stream().filter(x -> x.getNamePropAbp().equals(Constant.DISCOUNT_VALUE)).map(p -> p.getValueAbp())
		    .collect(Collectors.joining());
	    String valueAbpType = discountDetail.stream().filter(x -> x.getNamePropAbp().equals(Constant.DISCOUNT_TYPE)).map(p -> p.getValueAbp())
		    .collect(Collectors.joining());

	    String spsName = relationMasterRepository.findSpsDiscountName(discountOffer.getBenefitThemePackSpsCid());
	    String nameBo = billingOfferMasterRepository.findBillingOfferBycidBo(discountOffer.getBenefitBillingOfferCid()).getNameBo();

	    benefitsResponse.setBenefits(discountOffer);
	    benefitsResponse.setNameComp(nameComp);
	    benefitsResponse.setValueAbpType(valueAbpType);
	    benefitsResponse.setValueAbp(valueAbp);
	    benefitsResponse.setSpsName(spsName);
	    benefitsResponse.setNameBo(nameBo);
	    
	    benefitsResponseList.add(benefitsResponse);

	    
	});

	return benefitsResponseList;
    }

   

    
}
