package com.telefonica.eof;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.eof.dto.DiscountParamsDto;
import com.telefonica.eof.dto.SvaBenefitParamsDto;
import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.entity.WirelineServiceBenefits;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.MasterOfOffersRepository;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.PropertyInBillingOfferRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.RelationOffersXPlanRepository;
import com.telefonica.eof.repository.SvaOfferingRepository;
import com.telefonica.eof.repository.VasBenefitsRepository;
import com.telefonica.eof.repository.WirelineServiceBenefitsRepository;

@SpringBootTest
class ShakaElegibleoffersFiApplicationTests {

    @Autowired
    private MasterOfOffersRepository	      masterOfOffersRepository;
    @Autowired
    private OffersPropertiesRepository	      offersPropertiesRepository;
    @Autowired
    private SvaOfferingRepository	      svaOfferingRepository;
    @Autowired
    private RelationMasterRepository	      relationMasterRepository;
    @Autowired
    private RelationOffersXPlanRepository     relationOffersXPlanRepository;
    @Autowired
    private PropertyInBillingOfferRepository  propertyInBillingOfferRepository;
    @Autowired
    private PricePropertiesRepository	      pricePropertiesRepository;
    @Autowired
    private VasBenefitsRepository	      vasBenefitsRepository;
    @Autowired
    private ComponentsMasterRepository	      componentsMasterRepository;
    @Autowired
    private BillingOfferMasterRepository      billingOfferMasterRepository;
    @Autowired
    private WirelineServiceBenefitsRepository wirelineServiceBenefitsRepository;

    private String productOfferingCatalogId = "34459665";
    private String broadbandMinDlDataRate   = null;

    @Test
    void MasterOfOffersRepositoryTest() {
	String offerCaption = masterOfOffersRepository.findByOfferCid(productOfferingCatalogId);
	System.out.println(offerCaption);
    }

    @Test
    void OffersPropertiesRepositoryTest() {
	List<OffersProperties> offersProperties = offersPropertiesRepository.getPropertyValue(productOfferingCatalogId);
	
	String retention = offersProperties.stream()
		.filter(x -> x.getNameOfProperty().equalsIgnoreCase("Retention"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	String lobType = offersProperties.stream()
		.filter(x -> x.getNameOfProperty().equalsIgnoreCase("LOB type"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());
	
	System.out.println(retention);
	
	if ("Y".equalsIgnoreCase(retention)) {
	    
	    System.out.println("logica get retention :" + lobType);
	}else {
	    System.out.println("logica get idcomponent :" + lobType);
	}
	
	
	String spsId = offersPropertiesRepository.getSpsId("34488365");
	String arr[] = spsId.split(";", 0);
	String firstWord = arr[0];
	System.out.println(firstWord);
    }

    @Test
    void SvaOfferingRepositoryTest() {
	String query = "('*', null)";
	List<String> idComponents = svaOfferingRepository.getIdComponent("Wireline", null, query);
	System.out.println(idComponents.toString());

    }

    @Test
    void RelationOffersXPlanRepositoryTest() {
	Integer maxSTBsallowed = relationOffersXPlanRepository.getMxSTBsallowed(productOfferingCatalogId);
	System.out.println(maxSTBsallowed);
	System.out.println("hola mundo");
    }

    @Test
    void RelationMasterRepositoryTest() {
	
	String  discoutnSpsName = relationMasterRepository.getDiscountSpsName("32979711");
	System.out.println(discoutnSpsName);
	List<RelationMaster> cidBoList = relationMasterRepository.getBoActive(productOfferingCatalogId, "3196671");
	System.out.println(cidBoList);

	StringBuilder stringBuilder = new StringBuilder();

	cidBoList.forEach(bo -> {
	    String value = "'" + bo.getCidBo() + "',";
	    stringBuilder.append(value);
	    System.out.println(bo.getCidBo());
	});
	String cidBoString = stringBuilder.substring(0, stringBuilder.length() - 1);

	List<String> billingOfferList = relationMasterRepository.getBoByBoType(cidBoString);
	System.out.println(billingOfferList);

	Sps spsIdAndName = relationMasterRepository.getSpsIdAndName("'7111','7731'");
	System.out.println(spsIdAndName);
    }

    // @Test
    // void PropertyInBillingOfferRepositoryTest() {
    // String propertyValue =
    // propertyInBillingOfferRepository.getPropertyValue(planCid);
    // System.out.println(propertyValue);
    // }

    @Test
    void ComponentsMasterRepositoryTest() {
	String componentsMaster = componentsMasterRepository.getComponentName("3196671");
	System.out.println(componentsMaster);
    }

    @Test
    void BillingOfferMasterRepositoryTest() {
	String billingOfferMaster = billingOfferMasterRepository.getBillingOfferName("33145411");
	System.out.println(billingOfferMaster);
    }

    @Test
    void VasBenefitsRepositoryTest() {

	SvaBenefitParamsDto svaBenefitParamsDto = new SvaBenefitParamsDto();
	svaBenefitParamsDto.setChannelId(null);
	svaBenefitParamsDto.setOfferCaption("MonoTVDigital");
	svaBenefitParamsDto.setAction(null);
	svaBenefitParamsDto.setIsPortability(null);
	svaBenefitParamsDto.setOrderSubType(null);
	svaBenefitParamsDto.setBroadbandConnection(null);
	svaBenefitParamsDto.setNetworkTechnology(null);
	svaBenefitParamsDto.setCommercialAreaId(null);
	svaBenefitParamsDto.setParentId("32979411");
	svaBenefitParamsDto.setIDcomponente("3196671");

	VasBenefits vasBenefits = vasBenefitsRepository.getSvaBenefits(svaBenefitParamsDto, "= 'NA'", "= 'NA'");
	System.out.println(vasBenefits);
    }

    @Test
    void PricePropertyRepositoryTest() {
	PriceProperties priceInfo = pricePropertiesRepository.getPriceInfo("1033761");
	System.out.println(priceInfo);
	List<PriceProperties> discountDetail = pricePropertiesRepository.getDiscountPriceDetail("34126411");
	String price = discountDetail.stream()
		.filter(x -> x.getNamePropAbp().equals("Discount value"))
		.map(p -> p.getValueAbp())
		.collect(Collectors.joining());
	System.out.println(discountDetail);
	System.out.println(price);
    }

    @Test
    void WirelineServiceBenefitsRepositoryTest() {

	DiscountParamsDto discountParamsDto = new DiscountParamsDto();
	discountParamsDto.setChannelId(null);
	discountParamsDto.setCatalogItemID("DuoInternetEstandarDigitalHD");
	discountParamsDto.setAction("PR");
	discountParamsDto.setIsPortability(null);
	discountParamsDto.setCurrentOffering("Y");
	discountParamsDto.setBroadbandConnection(null);
	discountParamsDto.setNetworkTechnology("FTTH");
	discountParamsDto.setCommercialAreaId(null);
	discountParamsDto.setDownloadSpeed("10");

	List<WirelineServiceBenefits> discount = wirelineServiceBenefitsRepository.getDiscount(discountParamsDto);
	System.out.println(discount);
    }

    @Test
    void GetAditionalComponentTest() {

	String offerCaption = masterOfOffersRepository.findByOfferCid(productOfferingCatalogId);

	String propertyValueLT = offersPropertiesRepository.getPropertyValue(productOfferingCatalogId).stream()
		.filter(x -> x.getNameOfProperty().equals("LOB Type")).map(p -> p.getPropertyValue()).collect(Collectors.joining());

	System.out.println(propertyValueLT);

	List<String> idComponentList = svaOfferingRepository.getIdComponent(propertyValueLT, null, null).stream()
		.filter(x -> x.matches("3196671|3197701|3239962|34105211")).collect(Collectors.toList());

	System.out.println(idComponentList);
	//
	// String s =
	// idComponentList.stream().map(Object::toString).collect(Collectors.joining("',
	// '","'", "'"));
	// System.out.println("s = "+ s);

	// idComponentList.forEach(idComponent -> {
	// List<String> cidBoActive =
	// relationMasterRepository.getBoActive(productOfferingCatalogId, idComponent);
	//
	// String cidBoCurrentDateString = cidBoActive.stream()
	// .map(Object::toString)
	// .collect(Collectors.joining("', '","'", "'"));
	//
	// List<String> cidBoBoType =
	// relationMasterRepository.getBoByBoType(cidBoCurrentDateString);
	// System.out.println(cidBoBoType);
	//
	// String cidBoBoTypeString = cidBoBoType.stream()
	// .map(Object::toString)
	// .collect(Collectors.joining("', '","'", "'"));
	//
	// List<RelationMaster> billingOfferList = null;
	//
	//
	// if ("3196671".equals(idComponent)) {
	// String propertyValue= " in ('FULL','HD')";
	// billingOfferList =
	// relationMasterRepository.validateIdComponente(cidBoBoTypeString,
	// propertyValue);
	// //TODO VERIFICAR SI EL SPID TRAE SOLO UN VALOR O VARIOS SIEMPRE
	// String spsId = offersPropertiesRepository.getSpsId(productOfferingCatalogId);
	//
	// if (spsId.length() > 0) {
	// String arr[] = spsId.split(";", 0);
	// String spsPropertyValue = arr[0];
	// System.out.println(spsPropertyValue);
	// List<String> parentIdList =
	// relationMasterRepository.getParentId(spsPropertyValue);
	//
	// parentIdList.forEach(parentId ->{
	//// TODO DESCOMENTAR EL REMOVER OFERTAS
	// // billingOfferList.removeIf(x -> x.getChildId().contains(parentId));
	// });
	// }
	// System.out.println(billingOfferList);
	//
	//
	// }else if (idComponent.matches("3197701|3239962|34105211")) {
	// String propertyValue= " is null";
	// billingOfferList =
	// relationMasterRepository.validateIdComponente(cidBoBoTypeString,
	// propertyValue);
	// }
	//
	//
	//
	// billingOfferList.forEach(billingOffer ->{
	// List<String> parentIdList =
	// relationMasterRepository.getParentId(billingOffer.getChildId());
	// String parentId = parentIdList.stream()
	// .map(Object::toString)
	// .collect(Collectors.joining("', '","'", "'"));
	// Sps spsIdAndName = relationMasterRepository.getSpsIdAndName(parentId);
	// String priceType;
	// String amount;
	// PriceProperties priceInfo =
	// pricePropertiesRepository.getPriceInfo(billingOffer.getChildId());
	// if ("OC".equals(priceInfo.getRevenueType())) {
	// priceType = "one time";
	// amount = priceInfo.getValueAbp();
	// }else {
	// priceType = "recurring";
	// amount = priceInfo.getValueAbp();
	// }
	//
	// SvaBenefitParamsDto svaBenefitParamsDto= new SvaBenefitParamsDto();
	// svaBenefitParamsDto.setChannelId(null);
	// svaBenefitParamsDto.setOfferCaption(offerCaption);
	// svaBenefitParamsDto.setAction(null);
	// svaBenefitParamsDto.setIsPortability(null);
	// svaBenefitParamsDto.setOrderSubType(null);
	// svaBenefitParamsDto.setBroadbandConnection(null);
	// svaBenefitParamsDto.setNetworkTechnology(null);
	// svaBenefitParamsDto.setCommercialAreaId(null);
	// svaBenefitParamsDto.setParentId(spsIdAndName.getParentId());
	// svaBenefitParamsDto.setIDcomponente(idComponent);
	//
	// String dataRateFrom;
	// String dataRateTo;
	//
	// if (StringUtil.isNullOrEmpty(broadbandMinDlDataRate)) {
	// dataRateFrom ="= 'NA'";
	// dataRateTo = "= 'NA'";
	// }else {
	// dataRateFrom ="<= "+ broadbandMinDlDataRate;
	// dataRateTo = ">= "+ broadbandMinDlDataRate;
	//
	// }
	// VasBenefits vasBenefits =
	// vasBenefitsRepository.getSvaBenefits(svaBenefitParamsDto, dataRateFrom ,
	// dataRateTo);
	// System.out.println(vasBenefits.toString());
	//
	// });
	//
	//
	// });
	//
    }

    @Test
    void Test() {

	
	BigDecimal price = new BigDecimal("10");
	BigDecimal igv = new BigDecimal(0.18);
	BigDecimal total = price.multiply(igv).add(price);
	
	System.out.println(total);


    }

}
