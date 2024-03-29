package com.telefonica.eof;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.DiscountParamsDto;
import com.telefonica.eof.dto.SvaBenefitParamsDto;
import com.telefonica.eof.entity.BillingOfferMaster;
import com.telefonica.eof.entity.InstallationFee;
import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.entity.Upfront;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.entity.WirelineServiceBenefits;
import com.telefonica.eof.pojo.productInventory.ProductInventoryResponseDto;
import com.telefonica.eof.proxy.productInventory.ParqueUnificadoConnection;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.DomainWithValidValuesRepository;
import com.telefonica.eof.repository.EquipmentRepository;
import com.telefonica.eof.repository.InstalFeeNoRiskRepository;
import com.telefonica.eof.repository.InstallationFeeRepository;
import com.telefonica.eof.repository.MasterOfOffersRepository;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.repository.OffilterBundleRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.PropertyInBillingOfferRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.RelationOffersXPlanRepository;
import com.telefonica.eof.repository.StbSettingRepository;
import com.telefonica.eof.repository.SvaOfferingRepository;
import com.telefonica.eof.repository.UpfrontRepository;
import com.telefonica.eof.repository.VasBenefitsRepository;
import com.telefonica.eof.repository.WirelineServiceBenefitsRepository;
import com.telefonica.globalintegration.services.retrieveofferings.v1.ProductTypeEnumType;

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
    @Autowired
    private EquipmentRepository		      equipmentRepository;
    @Autowired
    private StbSettingRepository	      stbSettingRepository;
    @Autowired
    private DomainWithValidValuesRepository   domainWithValidValuesRepository;
    @Autowired
    private UpfrontRepository		      upfrontRepository;
    @Autowired
    private InstallationFeeRepository	      installationFeeRepository;
    @Autowired
    private InstalFeeNoRiskRepository	      instalFeeNoRiskRepository;
    @Autowired
    private ParqueUnificadoConnection	      parqueUnificadoConnection;
    @Autowired
    private OffilterBundleRepository offilterBundleRepository;

    private String productOfferingCatalogId = "34459665";
    private String broadbandMinDlDataRate   = null;
    private String networkTecnology	    = "FTTH";
    private String currentOffering	    = "3240962";
    private String vProductOfferingID	    = "34418915";

    @Test
    void parqueUnificadoConnectionTest() {
	try {
	    List<ProductInventoryResponseDto> x = parqueUnificadoConnection.callRestService("14318987", "landline");
	    System.out.println(x);
	} catch (Exception e) {
	    System.out.println(e.getCause());
	}

    }

    @Test
    void MasterOfOffersRepositoryTest() {
	String offerCaption = masterOfOffersRepository.findOfferCaption(productOfferingCatalogId);
	System.out.println(offerCaption);
    }

    @Test
    void OffersPropertiesRepositoryTest() {
	List<OffersProperties> offersProperties = offersPropertiesRepository.findPropertyValue(productOfferingCatalogId);

	String retention = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("Retention"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	String lobType = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("LOB type"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	System.out.println(retention);

	if ("Y".equalsIgnoreCase(retention)) {

	    System.out.println("logica get retention :" + lobType);
	} else {
	    System.out.println("logica get idcomponent :" + lobType);
	}

	String spsId = offersPropertiesRepository.findSpsIdByofferCid("34488365");
	String arr[] = spsId.split(";", 0);
	String firstWord = arr[0];
	System.out.println(firstWord);
    }

    @Test
    void SvaOfferingRepositoryTest() {
	String query = "(" + Constant.ASTERISK_QUERY + Constant.COMMA + Constant.NULL + ")";
	List<String> idComponents = svaOfferingRepository.findIdComponent("Wireline", null, query);
	System.out.println(idComponents.toString());

    }

    @Test
    void RelationOffersXPlanRepositoryTest() {
	Integer maxSTBsallowed = relationOffersXPlanRepository.findPlanCid(productOfferingCatalogId);
	System.out.println(maxSTBsallowed);
    }

    @Test
    void RelationMasterRepositoryTest() {

	List<RelationMaster> svas = relationMasterRepository.findSvasByRootCid("34325311");
	System.out.println(svas);
	String discoutnSpsName = relationMasterRepository.findSpsDiscountName("32979711");
	System.out.println(discoutnSpsName);
	List<RelationMaster> cidBoList = relationMasterRepository.findBillingOfferActive(productOfferingCatalogId, "3196671");
	System.out.println(cidBoList);
	String cidBoString = cidBoList.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));
	List<String> billingOfferList = relationMasterRepository.findBillingOfferByBoType(cidBoString);
	System.out.println(billingOfferList);

	Sps spsIdAndName = relationMasterRepository.findSpsIdAndName("'7111','7731'");
	System.out.println(spsIdAndName);

	String relationId;
	relationId = relationMasterRepository.findRelationId("3197521", "34414515");
	System.out.println("relation id " + relationId);
	if (StringUtil.isNullOrEmpty(relationId) && StringUtil.isNullOrEmpty(relationId)) {
	    relationId = relationMasterRepository.findRelationIdByrelationCidRoot("34414515", "34325311");
	    System.out.println("relationId if :" + relationId);
	}

    }

    // @Test
    // void PropertyInBillingOfferRepositoryTest() {
    // String propertyValue =
    // propertyInBillingOfferRepository.getPropertyValue(planCid);
    // System.out.println(propertyValue);
    // }

    @Test
    void ComponentsMasterRepositoryTest() {
	String componentsMaster = componentsMasterRepository.findNameComponentByCidComponent("3196671");
	System.out.println(componentsMaster);
    }

    @Test
    void BillingOfferMasterRepositoryTest() {
	BillingOfferMaster billingOfferMaster = billingOfferMasterRepository.findBillingOfferBycidBo("33145411");
	System.out.println(billingOfferMaster);
    }

    @Test
    void VasBenefitsRepositoryTest() {

	SvaBenefitParamsDto svaBenefitParamsDto = new SvaBenefitParamsDto();
	svaBenefitParamsDto.setChannelId(Constant.NULL);
	svaBenefitParamsDto.setOfferCaption("MonoTVDigital");
	svaBenefitParamsDto.setAction(null);
	svaBenefitParamsDto.setIsPortability(null);
	svaBenefitParamsDto.setOrderSubType(null);
	svaBenefitParamsDto.setBroadbandConnection(null);
	svaBenefitParamsDto.setNetworkTechnology(null);
	svaBenefitParamsDto.setCommercialAreaId(null);
	svaBenefitParamsDto.setParentId("32979411");
	svaBenefitParamsDto.setIDcomponente("3196671");

	VasBenefits vasBenefits = vasBenefitsRepository.findSvaBenefits(svaBenefitParamsDto, "= 'NA'", "= 'NA'");
	System.out.println(vasBenefits);
    }

    @Test
    void PricePropertyRepositoryTest() {
	PriceProperties priceInfo = pricePropertiesRepository.findPriceInfo("1033761");
	System.out.println(priceInfo);
	List<PriceProperties> discountDetail = pricePropertiesRepository.findDiscountPriceDetail("34126411");
	String price = discountDetail.stream().filter(x -> x.getNamePropAbp().equals("Discount value")).map(p -> p.getValueAbp())
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

	List<WirelineServiceBenefits> discount = wirelineServiceBenefitsRepository.findBenefits(discountParamsDto);
	System.out.println(discount);

	discount.forEach(x -> {
	    if (StringUtil.isNullOrEmpty(x.getSpeed())) {
		System.out.println("entro null");
	    }

	});
    }

    @Test
    void DomainWithValidValuesRepositoryTest() {
	String stbSetting = domainWithValidValuesRepository.findValidValueByCaption(2);
	System.out.println(stbSetting);
	String nameComponent = domainWithValidValuesRepository.findNameComponentByvalidValue(stbSetting);
	System.out.println(nameComponent);
    }

    @Test
    void UpfrontRepositoryRepositoryTest() {
	Integer score = 1234 % 10;
	System.out.println(score);
	List<Upfront> upfront = upfrontRepository.findUpfront();
	System.out.println(upfront);
	String uf = upfront.stream().filter(x -> x.getUpfrontIndDesc().contains(score.toString())).map(p -> p.getUpfrontIndId())
		.collect(Collectors.joining());
	System.out.println(uf);
	System.out.println("1,2,3,4".contains("4"));
    }
    
    @Test
    void OffilterBundleRepositoryTest() {
	 List<String> numberList = new ArrayList<>();
	numberList.add("1");
	numberList.add("2");
	numberList.add("34492865");
	System.out.println(numberList);
	String planCid = offilterBundleRepository.findPlanCid("34492865", null, null, null);
	System.out.println(planCid);
	numberList.removeIf(x -> x.contains(planCid));
	System.out.println(numberList);
    }

    @Test
    void GetAditionalComponentTest() {

	String offerCaption = masterOfOffersRepository.findOfferCaption(productOfferingCatalogId);

	String propertyValueLT = offersPropertiesRepository.findPropertyValue(productOfferingCatalogId).stream()
		.filter(x -> x.getNameOfProperty().equals("LOB Type")).map(p -> p.getPropertyValue()).collect(Collectors.joining());

	System.out.println(propertyValueLT);

	List<String> idComponentList = svaOfferingRepository.findIdComponent(propertyValueLT, null, null).stream()
		.filter(x -> x.matches("3196671|3197701|3239962|34105211")).collect(Collectors.toList());

	System.out.println(idComponentList);

	// String s =
	// idComponentList.stream().map(Object::toString).collect(Collectors.joining("',
	// '","'", "'"));
	// System.out.println("s = "+ s);

	idComponentList.forEach(idComponent -> {
	    List<RelationMaster> cidBoActive = relationMasterRepository.findBillingOfferActive(productOfferingCatalogId, idComponent);

	    String cidBoCurrentDateString = cidBoActive.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	    List<String> cidBoBoType = relationMasterRepository.findBillingOfferByBoType(cidBoCurrentDateString);
	    System.out.println(cidBoBoType);

	    String cidBoBoTypeString = cidBoBoType.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	    List<RelationMaster> billingOfferList = null;

	    if ("3196671".equals(idComponent)) {
		String propertyValue = " in ('FULL','HD')";
		billingOfferList = relationMasterRepository.validateIdComponente(cidBoBoTypeString, propertyValue);
		// TODO VERIFICAR SI EL SPID TRAE SOLO UN VALOR O VARIOS SIEMPRE
		String spsId = offersPropertiesRepository.findSpsIdByofferCid(productOfferingCatalogId);

		if (spsId.length() > 0) {
		    String arr[] = spsId.split(";", 0);
		    String spsPropertyValue = arr[0];
		    System.out.println(spsPropertyValue);
		    List<String> parentIdList = relationMasterRepository.findParentIdByChildId(spsPropertyValue);

		    for (String parentId : parentIdList) {
			billingOfferList.removeIf(x -> x.getChildId().contains(parentId));
		    }

		}
		System.out.println(billingOfferList);

	    } else if (idComponent.matches("3197701|3239962|34105211")) {
		String propertyValue = " is null";
		billingOfferList = relationMasterRepository.validateIdComponente(cidBoBoTypeString, propertyValue);
	    }

	    billingOfferList.forEach(billingOffer -> {
		List<String> parentIdList = relationMasterRepository.findParentIdByChildId(billingOffer.getChildId());
		String parentId = parentIdList.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));
		Sps spsIdAndName = relationMasterRepository.findSpsIdAndName(parentId);
		String priceType;
		String amount;
		PriceProperties priceInfo = pricePropertiesRepository.findPriceInfo(billingOffer.getChildId());
		if ("OC".equals(priceInfo.getRevenueType())) {
		    priceType = "one time";
		    amount = priceInfo.getValueAbp();
		} else {
		    priceType = "recurring";
		    amount = priceInfo.getValueAbp();
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

		if (StringUtil.isNullOrEmpty(broadbandMinDlDataRate)) {
		    dataRateFrom = "= 'NA'";
		    dataRateTo = "= 'NA'";
		} else {
		    dataRateFrom = "<= " + broadbandMinDlDataRate;
		    dataRateTo = ">= " + broadbandMinDlDataRate;

		}
		VasBenefits vasBenefits = vasBenefitsRepository.findSvaBenefits(svaBenefitParamsDto, dataRateFrom, dataRateTo);
		System.out.println(vasBenefits.toString());

	    });

	});

    }

    @SuppressWarnings("unused")
    @Test
    void aditionalSvaTest() {
	// productOfferingCatalogId;
	// lob bb = 34456865
	// bundleLob tv= 34483865

	String field = "DownloadSpeed:120,DownloadSpeed:200";
	Integer velocidad = 200;
	System.out.println(field.split(","));

	Boolean flagModemPremium;
	Boolean flagUltraWifi;
	// TODO debe ir el parametro VProductOfferingID
	List<OffersProperties> offersProperties = offersPropertiesRepository.findPropertyValue("34483865");

	String lob;

	lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("LOB")).map(p -> p.getPropertyValue())
		.collect(Collectors.joining());

	System.out.println(lob);

	if ("null".equalsIgnoreCase(lob) || StringUtil.isNullOrEmpty(lob)) {

	    lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("Bundle LOBs"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(lob);
	}

	if (lob.matches("Internet|BB")) {

	    String minSpeedPremium = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase("Minimum Download Speed for Premium"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());

	    System.out.println("minSpeedPremium :" + minSpeedPremium);

	    if (Integer.parseInt(minSpeedPremium) <= velocidad) {
		flagModemPremium = true;
	    } else {
		flagModemPremium = false;
	    }
	    System.out.println("flagModemPremium :" + flagModemPremium);

	    String minSpeedWifi = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase("Minimum Speed for Loaned Ultra WiFi"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());

	    System.out.println("minSpeedWifi :" + minSpeedWifi);

	    if (Integer.parseInt(minSpeedWifi) <= velocidad) {
		flagUltraWifi = true;
	    } else {
		flagUltraWifi = false;
	    }

	    System.out.println("flagUltraWifi :" + flagUltraWifi);
	} else {
	    flagModemPremium = false;
	    flagUltraWifi = false;
	}

	String defSpsId = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("DEF_SPS_ID"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	System.out.println("defSpsId :" + defSpsId);

	String defSpsBo = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("DEF_SPS_BO"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	System.out.println("defSpsBo :" + defSpsBo);
	System.out.println("lob :" + lob);

	// Obtener Tipo de Modem

	String equipmentCid = equipmentRepository.findEquipmentCid(networkTecnology, lob);
	System.out.println(equipmentCid);

	if (!"null".equalsIgnoreCase(equipmentCid) || !StringUtil.isNullOrEmpty(equipmentCid)) {
	    System.out.println("equipmentCid existe");

	    String nameComp = componentsMasterRepository.findNameComponentByCidComponent(equipmentCid);
	    System.out.println(nameComp);

	}

	if (flagModemPremium = true) {
	    System.out.println("llenar response");

	} else {

	}

	// Obtener STB (Decodificadores)

	if (lob.contains("TV")) {
	    System.out.println("entro tv");
	    String stbNewOffer;

	    if (velocidad != null) {
		stbNewOffer = stbSettingRepository.findStbSettingWithSpeed(null, vProductOfferingID, velocidad);
		System.out.println(stbNewOffer);
	    } else {
		stbNewOffer = stbSettingRepository.findStbSettingWithoutSpeed(null, vProductOfferingID);
		System.out.println(stbNewOffer);
	    }

	    List<String> stbNewOfferList = Arrays.asList(stbNewOffer.split(","));

	    List<OffersProperties> propertyValue = offersPropertiesRepository.findPropertyValue(currentOffering);

	    String currentOfferLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("LOB"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(currentOfferLob);

	    String currentOfferBundleLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("Bundle LOBs"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(currentOfferBundleLob);

	    if (!currentOfferBundleLob.contains("TV") && !currentOfferLob.contains("TV")) {
		System.out.println("cumple condicion");
		String stbCurrentOffer;
		if (currentOffering != null) {
		    stbCurrentOffer = stbSettingRepository.findStbSettingWithSpeed(null, vProductOfferingID, velocidad);
		    System.out.println(stbNewOffer);
		} else {
		    stbCurrentOffer = stbSettingRepository.findStbSettingWithoutSpeed(null, vProductOfferingID);
		    System.out.println(stbNewOffer);
		}

		List<String> stbCurrentOfferList = Arrays.asList(stbCurrentOffer.split(","));

		Integer rankSTB = 0;
		Integer currentRankSTB = 0;

		for (String stbSettingNew : stbNewOfferList) {
		    Integer caption = domainWithValidValuesRepository.findCaptionByvalidValue(stbSettingNew.trim());
		    if (caption > rankSTB) {
			rankSTB = caption;
		    }
		}

		for (String stbSettingCurrent : stbCurrentOfferList) {
		    Integer caption = domainWithValidValuesRepository.findCaptionByvalidValue(stbSettingCurrent.trim());
		    if (caption > rankSTB) {
			currentRankSTB = caption;
		    }
		}

		if (rankSTB > currentRankSTB) {
		    // llenar response
		} else {
		    // llenar response
		}

	    }

	}

	// Obtener bloque de canales de la oferta

	if (!(Constant.NULL.equalsIgnoreCase(defSpsBo) || StringUtil.isNullOrEmpty(defSpsBo))) {
	    System.out.println(defSpsBo);
	    System.out.println(vProductOfferingID);
	    Sps idAndNameComponent = relationMasterRepository.findComponentIdAndName(defSpsBo, vProductOfferingID);
	    List<String> defSpsBoList = Arrays.asList(defSpsBo.split(","));
	    List<String> defSpsIdList = Arrays.asList(defSpsId.split(","));

	    defSpsBoList.forEach(bo -> {
		BillingOfferMaster billingOffer = billingOfferMasterRepository.findBillingOfferBycidBo(bo);
		PriceProperties valueAbp = pricePropertiesRepository.findPriceInfo(billingOffer.getCidBo());

		// llenar response

	    });

	    defSpsIdList.forEach(id -> {
		String nameParent = relationMasterRepository.findSpsDiscountName(id);
		// llenar response
	    });

	}

	// 5. Obtener otros SVAs (Multidestino y MCafee)

	List<RelationMaster> svas = relationMasterRepository.findSvasByRootCid(vProductOfferingID);
	svas.forEach(sva -> {
	    String nameComp = componentsMasterRepository.findNameComponentByCidComponent(sva.getParentId());
	});

    }

    @Test
    void getUpfrontFija() {

	Integer score = 1230 % 10;
	System.out.println(score);
	List<Upfront> upfront = upfrontRepository.findUpfront();
	System.out.println(upfront);
	String uf = upfront.stream().filter(x -> x.getUpfrontIndDesc().contains(score.toString())).map(p -> p.getUpfrontIndId())
		.collect(Collectors.joining());
	System.out.println(uf);

	InstallationFee installationFee = installationFeeRepository.findBoUpfront("2228", "Voice+Internet+TV", uf);
	System.out.println(installationFee);

	BigDecimal upfrontPrice;

	String cidBo = billingOfferMasterRepository.findCidBoBycaptionBo(installationFee.getInstallationFeeBo());
	System.out.println(cidBo);

	if ("Y".equalsIgnoreCase(uf)) {

	    upfrontPrice = pricePropertiesRepository.findUpfrontPrice(installationFee.getInstallationFeeBo());
	    System.out.println("upfront Y : " + upfrontPrice);
	} else {
	    upfrontPrice = instalFeeNoRiskRepository.findRate(null, null);
	    System.out.println("upfront N : " + upfrontPrice);
	}
    }

    @Test
    void Test() {

	List<ProductTypeEnumType> productTypeEnumList = new ArrayList<>();

	String productType = "landline,cableTv,broadband";
	List<String> items = Arrays.asList(productType.split(","));

	items.forEach(item -> {

	    productTypeEnumList.add(ProductTypeEnumType.fromValue(item));
	});

	// productTypeEnumList.add(ProductTypeEnumType.fromValue("mt"));

	System.out.println(productTypeEnumList);

	// String field = "DownloadSpeed: 120,DownloadSpeed: 200";
	//
	//
	// if (field.contains("DownloadSpeed")) {
	// List<String> items = Arrays.asList(field.split(","));
	// List<String> items2 = new ArrayList<String>();
	// items.forEach(item->{
	// items2.add(Arrays.asList(item.split(":")).get(1));
	// });
	//
	// items2.forEach(item->{
	//
	// System.out.println(item.trim());
	// });
	// }

	// String sps1 = "HD, SMART HD";
	// List<String> sps1list = Arrays.asList(sps1.split(","));
	// System.out.println(sps1list);
	// String sps2 = "HD, SMART HD";
	// List<String> sps2list = Arrays.asList(sps2.split(","));
	// System.out.println(sps1list);
	//
	// List<Integer> numberList = new ArrayList<>();
	// numberList.add(1);
	// numberList.add(10);
	//
	// System.err.println(numberList);
	//// Integer rankSTB = Collections.max(numberList);
	//
	// Integer rankSTB = 0;
	//
	// for (String x : sps1list ) {
	// System.out.println(x.trim());
	// Integer caption = domainWithValidValuesRepository.getCaption(x.trim());
	// System.out.println("caption :" + caption);
	// if (caption > rankSTB) {
	// System.out.println("caption if :" + caption);
	// rankSTB = caption;
	// }
	// }
	//
	//
	// System.out.println("rankSTB = " + rankSTB);

    }

}
