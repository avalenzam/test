package com.telefonica.eof.business.offering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.dto.DiscountParamsDto;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.WirelineServiceBenefits;
import com.telefonica.eof.generated.model.BenefitType;
import com.telefonica.eof.generated.model.CharacteristicBenefitType;
import com.telefonica.eof.generated.model.MoneyType;
import com.telefonica.eof.generated.model.OfferingType;
import com.telefonica.eof.generated.model.PriceBenefitType;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.WirelineServiceBenefitsRepository;

@Component
public class Discount {

    @Autowired
    private WirelineServiceBenefitsRepository wirelineServiceBenefitsRepository;
    @Autowired
    private PricePropertiesRepository	      pricePropertiesRepository;
    @Autowired
    private ComponentsMasterRepository	     componentsMasterRepository;
    @Autowired
    private RelationMasterRepository	      relationMasterRepository;
    @Autowired
    private BillingOfferMasterRepository billingOfferMasterRepository;

    // TODO CAMBIAR PARAMETRO AMDOCS POR EL RESPONSE DE AMDOCS, VER DOCUMENTACION
    public List<OfferingType> getBenefitDiscount(OffersBenefitsRequestDto offersBenefitsRequestDto, String amdocsCatalogItemID,
	    String amdocsCurrentOffering, String amdocsDownloadSpeed) {

	String currentOffering;

	if (StringUtil.isNullOrEmpty(amdocsCurrentOffering)) {
	    currentOffering = "N";
	} else {
	    currentOffering = "Y";
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
	
	List<WirelineServiceBenefits> discountList = wirelineServiceBenefitsRepository.getDiscount(discountParamsDto);
	
	List<BenefitType> benefitTypeList = new ArrayList<>();
	List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();
	List<PriceBenefitType> priceBenefitsList =  new ArrayList<>();
	
	discountList.forEach(discountOffer -> {
	    String nameComp = componentsMasterRepository.getComponentName(discountOffer.getBenefitsComponentCid());
	    List<PriceProperties> discountDetail = pricePropertiesRepository.getDiscountPriceDetail(discountOffer.getBenefitBillingOfferCid());
	    String valueAbp = discountDetail.stream()
		    .filter(x -> x.getNamePropAbp().equals("Discount value"))
		    .map(p -> p.getValueAbp())
		    .collect(Collectors.joining());
	    String valueAbpType = discountDetail.stream()
		    .filter(x -> x.getNamePropAbp().equals("Discount type"))
		    .map(p -> p.getValueAbp())
		    .collect(Collectors.joining());
	    BigDecimal value = new BigDecimal(valueAbp);
	    BigDecimal valueIgv = igvCalculator(valueAbp);
	    String spsName = relationMasterRepository.getDiscountSpsName(discountOffer.getBenefitThemePackSpsCid());
	    String boName = billingOfferMasterRepository.getBillingOfferName(discountOffer.getBenefitBillingOfferCid());
	    
	    BenefitType benefitType = new BenefitType();
	    PriceBenefitType priceBenefit = new PriceBenefitType();
	    MoneyType moneyType =new MoneyType();
	    MoneyType moneyType1 =new MoneyType();
	    CharacteristicBenefitType characteristics1 = new CharacteristicBenefitType();
	    CharacteristicBenefitType characteristics2 = new CharacteristicBenefitType();
	    CharacteristicBenefitType characteristics3 = new CharacteristicBenefitType();
	    CharacteristicBenefitType characteristics4 = new CharacteristicBenefitType();
	    CharacteristicBenefitType characteristics5 = new CharacteristicBenefitType();
	    CharacteristicBenefitType characteristics6 = new CharacteristicBenefitType();
	    
	    benefitType.setId(discountOffer.getBenefitsComponentCid());
	    benefitType.setName(nameComp);
	    benefitType.setDownloadSpeed(discountOffer.getSpeed());
	    benefitType.setType(discountOffer.getLob());
	    characteristics1.setKey("spsId");
	    characteristics1.setValue(discountOffer.getBenefitThemePackSpsCid());
	    characteristics2.setKey("spsName");
	    characteristics2.setValue(spsName);
	    characteristics3.setKey("BOID");
	    characteristics3.setValue(discountOffer.getBenefitBillingOfferCid());
	    characteristics4.setKey("BOName");
	    characteristics4.setValue(boName);
	    characteristics5.setKey("duration");
	    characteristics5.setValue(discountOffer.getDuration());
	    characteristics6.setKey("NightInd");
	    characteristics6.setValue(discountOffer.getNightInd());
	    
	    if ("Monetary".equalsIgnoreCase(valueAbpType)) {
		
		priceBenefit.setPriceType("recurring");
		moneyType.setAmount(value);
		moneyType.setUnits("PEN");
	   	priceBenefit.setPrice(moneyType);
	   	moneyType1.setAmount(valueIgv);
	   	moneyType1.setUnits("PEN");
	   	priceBenefit.setPriceWithTax(moneyType1);
	   	
	   	
	   	priceBenefitsList.add(priceBenefit);
	   	benefitType.setPriceBenefits(priceBenefitsList);
	    }
	   
	    characteristicsList.add(characteristics1);
	    characteristicsList.add(characteristics2);
	    characteristicsList.add(characteristics3);
	    characteristicsList.add(characteristics4);
	    characteristicsList.add(characteristics5);
	    characteristicsList.add(characteristics6);
	    benefitType.setCharacteristics(characteristicsList);
	    benefitTypeList.add(benefitType);
	});


	return null;
    }

    private BigDecimal igvCalculator(String amount) {

   	BigDecimal price = new BigDecimal(amount);
   	BigDecimal igv = new BigDecimal(0.18);
   	BigDecimal total = price.multiply(igv).add(price);
   	return total;
       }
}
