package com.telefonica.eof.business.sva;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.dto.SvaBenefitParamsDto;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.generated.model.BenefitType;
import com.telefonica.eof.generated.model.CharacteristicBenefitType;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.PriceTypeEnum;
import com.telefonica.eof.generated.model.ComposingProductType;
import com.telefonica.eof.generated.model.MoneyType;
import com.telefonica.eof.generated.model.OfferingType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicValueType;
import com.telefonica.eof.generated.model.RefinedProductType;
import com.telefonica.eof.generated.model.StringWrapper;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.MasterOfOffersRepository;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.RelationOffersXPlanRepository;
import com.telefonica.eof.repository.SvaOfferingRepository;
import com.telefonica.eof.repository.UpfrontRepository;
import com.telefonica.eof.repository.VasBenefitsRepository;

@Component
public class Sva {

    @Autowired
    private MasterOfOffersRepository	     masterOfOffersRepository;
    @Autowired
    private OffersPropertiesRepository	     offersPropertiesRepository;
    @Autowired
    private SvaOfferingRepository	     svaOfferingRepository;
    @Autowired
    private RelationMasterRepository	     relationMasterRepository;
    @Autowired
    private RelationOffersXPlanRepository    relationOffersXPlanRepository;
//    @Autowired
//    private PropertyInBillingOfferRepository propertyInBillingOfferRepository;
    @Autowired
    private PricePropertiesRepository	     pricePropertiesRepository;
    @Autowired
    private VasBenefitsRepository	     vasBenefitsRepository;
    @Autowired
    private ComponentsMasterRepository	     componentsMasterRepository;
    @Autowired
    private BillingOfferMasterRepository     billingOfferMasterRepository;
    @Autowired
    private UpfrontRepository		     upfrontRepository;

    public List<OfferingType> GetSvaTypeSva(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	String query = "'*'," + offersBenefitsRequestDto.getIsRetention().toString();
	String flagType = "sva";

	String offerCaption = masterOfOffersRepository.findOfferCaption(offersBenefitsRequestDto.getProductOfferingCatalogId());
	Integer maxSTBsallowed = relationOffersXPlanRepository.findPlanCid(offersBenefitsRequestDto.getProductOfferingCatalogId());


	Integer score = offersBenefitsRequestDto.getCreditScore()%10;
	String upfront = upfrontRepository.getUpfront().stream().filter(x -> x.getUpfrontIndDesc().contains(score.toString()))
		.map(p -> p.getUpfrontIndId()).collect(Collectors.joining());

//
//	if ("Y".equalsIgnoreCase(upfront)) {
//
//	  
//	} else {
//	  
//	}

	List<String> idComponentList = getAditionalComponent(offersBenefitsRequestDto.getProductOfferingCatalogId(),
		offersBenefitsRequestDto.getAction(), query);

	List<OfferingType> offeringTypeList = new ArrayList<>();

	idComponentList.forEach(idComponent -> {

	    List<RelationMaster> billingOfferList = getBillingOffer(offersBenefitsRequestDto.getProductOfferingCatalogId(), idComponent,
		    flagType);

	    OfferingType offeringType = new OfferingType();

	    List<ComposingProductType> productSpecificationList = new ArrayList<>();
	    List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
	    List<ComponentProdOfferPriceType> productPriceList = new ArrayList<>();
	    List<BenefitType> benefitTypeList = new ArrayList<>();

	    billingOfferList.forEach(billingOffer -> {

		PriceTypeEnum priceType;

		BigDecimal amount;

		Sps spsIdAndName = getSpsIdAndName(billingOffer.getChildId());

//		String upfront = upfrontRepository.getUpfront().stream()
//			.filter(x -> x.getUpfrontIndDesc().contains(offersBenefitsRequestDto.getCreditScore().toString()))
//			.map(p -> p.getUpfrontIndId()).collect(Collectors.joining());
//	
//		if ("Y".equalsIgnoreCase(upfront) && billingOffer.getParentId().contains("3192682|3192742|3192652") ) {
//		  // TODO remuevo esos sva  
//		}
		
		
		PriceProperties priceInfo = pricePropertiesRepository.getPriceInfo(billingOffer.getChildId());

		if ("OC".equalsIgnoreCase(priceInfo.getRevenueType())) {
		    priceType = ComponentProdOfferPriceType.PriceTypeEnum.ONE_TIME;
		    amount = igvCalculator(priceInfo.getValueAbp());
		} else {
		    priceType = ComponentProdOfferPriceType.PriceTypeEnum.RECURRING;
		    amount = igvCalculator(priceInfo.getValueAbp());
		}

		SvaBenefitParamsDto svaBenefitParamsDto = new SvaBenefitParamsDto();
		svaBenefitParamsDto.setChannelId(null);
		svaBenefitParamsDto.setOfferCaption(offerCaption);
		svaBenefitParamsDto.setAction(null);
		svaBenefitParamsDto.setIsPortability(null);
		svaBenefitParamsDto.setOrderSubType(null);
		svaBenefitParamsDto.setBroadbandConnection(null);
		svaBenefitParamsDto.setNetworkTechnology(null);
		svaBenefitParamsDto.setCommercialAreaId(null);
		svaBenefitParamsDto.setParentId(spsIdAndName.getParentId());
		svaBenefitParamsDto.setIDcomponente(idComponent);

		String dataRateFrom;

		String dataRateTo;

		if (offersBenefitsRequestDto.getBroadband().getMinDlDataRate() != null) {
		    dataRateFrom = "= 'NA'";
		    dataRateTo = "= 'NA'";
		} else {
		    dataRateFrom = "<= " + offersBenefitsRequestDto.getBroadband().getMinDlDataRate();
		    dataRateTo = ">= " + offersBenefitsRequestDto.getBroadband().getMinDlDataRate();

		}
		VasBenefits vasBenefits = vasBenefitsRepository.getSvaBenefits(svaBenefitParamsDto, dataRateFrom, dataRateTo);
		String nameComp = componentsMasterRepository.getComponentName(vasBenefits.getBenefitComponentCid());
		String parentName = relationMasterRepository.getSpsIdAndName(vasBenefits.getBenefitThemePackSpsCid()).getParentName();
		String nameBo = billingOfferMasterRepository.getBillingOfferName(idComponent).getNameBo();

		ComposingProductType productSpecification = new ComposingProductType();
		// ProductSpecCharacteristicType productCharacteristics1 = new
		// ProductSpecCharacteristicType();
		// ProductSpecCharacteristicType productCharacteristics2 = new
		// ProductSpecCharacteristicType();

		ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();
		BenefitType benefitType = new BenefitType();
		List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();
		CharacteristicBenefitType characteristics1 = new CharacteristicBenefitType();
		CharacteristicBenefitType characteristics2 = new CharacteristicBenefitType();
		CharacteristicBenefitType characteristics3 = new CharacteristicBenefitType();
		CharacteristicBenefitType characteristics4 = new CharacteristicBenefitType();

		MoneyType moneyType = new MoneyType();
		RefinedProductType refinedProductType = new RefinedProductType();

		productSpecification.setId(billingOffer.getChildId());
		productSpecification.setName(billingOffer.getNameChild());
		productSpecification.setProductType(ComposingProductType.ProductTypeEnum.SVA);
		if ("3197701".equals(idComponent)) {
		    productSpecification.setMaxCardinality(maxSTBsallowed);
		}
		//
		// productCharacteristics1.setName("SPSID");
		// productCharacteristics1.setDescription("String");

		StringWrapper productCharacteristics1 = new StringWrapper();
		List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList1 = new ArrayList<>();
		ProductSpecCharacteristicValueType productSpecCharacteristicValue1 = new ProductSpecCharacteristicValueType();
		productCharacteristics1.setName("SPSID");
		productCharacteristics1.setDescription("String");
		productSpecCharacteristicValue1.setValue(spsIdAndName.getParentId());
		productSpecCharacteristicValueTypeList1.add(productSpecCharacteristicValue1);
		productCharacteristics1.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList1);

		StringWrapper productCharacteristics2 = new StringWrapper();
		List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList2 = new ArrayList<>();
		ProductSpecCharacteristicValueType productSpecCharacteristicValue2 = new ProductSpecCharacteristicValueType();
		productCharacteristics2.setName("SPSID");
		productCharacteristics2.setDescription("String");
		productSpecCharacteristicValue1.setValue(spsIdAndName.getParentId());
		productSpecCharacteristicValueTypeList2.add(productSpecCharacteristicValue2);
		productCharacteristics2.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList2);

		productCharacteristicsList.add(productCharacteristics1);
		productCharacteristicsList.add(productCharacteristics2);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProductType);

		productPrice.setName("Precio SVA");
		productPrice.setPriceType(priceType);
		moneyType.setUnits("PEN");
		productPrice.setPrice(moneyType);
		productPrice.setTaxAmount(moneyType);
		moneyType.setAmount(amount);
		productPrice.setTaxAmount(moneyType);

		benefitType.setId(vasBenefits.getBenefitComponentCid());
		benefitType.setName(nameComp);
		benefitType.setDownloadSpeed(vasBenefits.getSpeed());
		characteristics1.setKey("spsID");
		characteristics1.setValue(vasBenefits.getBenefitThemePackSpsCid());
		characteristics2.setKey("spsName");
		characteristics2.setValue(parentName);
		characteristics3.setKey("BOName");
		characteristics3.setValue(nameBo);
		characteristics4.setKey("duration");
		characteristics4.setValue(vasBenefits.getDuration());
		characteristicsList.add(characteristics1);
		characteristicsList.add(characteristics2);
		characteristicsList.add(characteristics3);
		characteristicsList.add(characteristics4);
		benefitType.setCharacteristics(characteristicsList);

		benefitTypeList.add(benefitType);
		productPriceList.add(productPrice);
		productSpecificationList.add(productSpecification);

		offeringType.setName(billingOffer.getNameParent());

	    });

	    offeringType.setId(idComponent);

	    offeringType.setBenefits(benefitTypeList);
	    offeringType.setProductOfferingPrice(productPriceList);
	    offeringType.setProductSpecification(productSpecificationList);

	    offeringTypeList.add(offeringType);

	});

	return offeringTypeList;

    }

    public List<OfferingType> getSvaTypeRetention(OffersBenefitsRequestDto offersBenefitsRequestDto) {
	String query = offersBenefitsRequestDto.getIsRetention().toString();
	String flagType = "retention";
	List<OfferingType> offeringTypeList = new ArrayList<>();

	String offerCaption = masterOfOffersRepository.findOfferCaption(offersBenefitsRequestDto.getProductOfferingCatalogId());

	List<String> idComponentList = getAditionalComponent(offersBenefitsRequestDto.getProductOfferingCatalogId(),
		offersBenefitsRequestDto.getAction(), query);

	idComponentList.forEach(idComponent -> {
	    List<RelationMaster> billingOfferList = getBillingOffer(offersBenefitsRequestDto.getProductOfferingCatalogId(), idComponent,
		    flagType);

	    OfferingType offeringType = new OfferingType();
	    List<ComposingProductType> productSpecificationList = new ArrayList<>();
	    List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();

	    billingOfferList.forEach(billingOffer -> {

		ComposingProductType productSpecification = new ComposingProductType();
		ProductSpecCharacteristicType productCharacteristics1 = new ProductSpecCharacteristicType();
		ProductSpecCharacteristicType productCharacteristics2 = new ProductSpecCharacteristicType();
		RefinedProductType refinedProductType = new RefinedProductType();

		productSpecification.setId(billingOffer.getChildId());
		productSpecification.setName(billingOffer.getNameChild());
		// TODO FALTA CORREGIR el enum debe ser SVA RETENCION
		productSpecification.setProductType(ComposingProductType.ProductTypeEnum.SVA);
		productSpecification.setPeriodDuration(billingOffer.getDurationValue());

		productCharacteristics1.setName("SPSID");
		productCharacteristics1.setDescription("String");
		productCharacteristics2.setName("NombreSPS");
		productCharacteristics2.setDescription("String");
		productCharacteristicsList.add(productCharacteristics1);
		productCharacteristicsList.add(productCharacteristics2);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProductType);

		productSpecificationList.add(productSpecification);
		offeringType.setName(billingOffer.getNameParent());
		offeringType.setProductSpecification(productSpecificationList);

	    });

	    offeringType.setId(idComponent);
	    offeringTypeList.add(offeringType);

	});

	return offeringTypeList;

    }

    private List<String> getAditionalComponent(String productOfferingCatalogId, String action, String query) {

	String propertyValueLT = offersPropertiesRepository.getPropertyValue(productOfferingCatalogId).stream()
		.filter(x -> x.getNameOfProperty().equals("LOB Type")).map(p -> p.getPropertyValue()).collect(Collectors.joining());

	List<String> idComponentList = svaOfferingRepository.getIdComponent(propertyValueLT, action, query).stream()
		.filter(x -> x.matches("3196671|3197701|3239962|34105211")).collect(Collectors.toList());

	return idComponentList;
    }

    private List<RelationMaster> getBillingOffer(String productOfferingCatalogId, String idComponent, String tyflagTypepe) {

	List<RelationMaster> billingOfferList = null;

	if ("sva".equalsIgnoreCase(tyflagTypepe)) {

	    List<RelationMaster> cidBoActive = relationMasterRepository.getBoActive(productOfferingCatalogId, idComponent);

	    String cidBoCurrentDateString = cidBoActive.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	    List<String> cidBoBoType = relationMasterRepository.getBoByBoType(cidBoCurrentDateString);

	    String cidBoBoTypeString = cidBoBoType.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	    if ("3196671".equalsIgnoreCase(idComponent)) {
		String propertyValue = " in ('FULL','HD')";
		billingOfferList = relationMasterRepository.validateIdComponente(cidBoBoTypeString, propertyValue);
		String spsId = offersPropertiesRepository.getSpsId(productOfferingCatalogId);

		if (spsId.length() > 0) {
		    String arr[] = spsId.split(";", 0);
		    String spsPropertyValue = arr[0];
		    List<String> parentIdList = relationMasterRepository.getParentId(spsPropertyValue);

		    parentIdList.forEach(parentId -> {
			// TODO DESCOMENTAR REMOVE
			// billingOfferList.removeIf(x -> x.getChildId().contains(parentId));
		    });
		}

	    } else if (idComponent.matches("3197701|3239962|34105211")) {
		String propertyValue = " is null";
		billingOfferList = relationMasterRepository.validateIdComponente(cidBoBoTypeString, propertyValue);
	    }

	} else {
	    billingOfferList = relationMasterRepository.getBoActive(productOfferingCatalogId, idComponent);
	}
	return billingOfferList;

    }

    private Sps getSpsIdAndName(String billingOfferChildId) {

	List<String> parentIdList = relationMasterRepository.getParentId(billingOfferChildId);
	String parentId = parentIdList.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));
	Sps spsIdAndName = relationMasterRepository.getSpsIdAndName(parentId);

	return spsIdAndName;
    }

    private BigDecimal igvCalculator(String amount) {

	BigDecimal price = new BigDecimal(amount);
	BigDecimal igv = new BigDecimal(0.18);
	BigDecimal total = price.multiply(igv).add(price);
	return total;
    }

}
