package com.telefonica.eof.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.business.offering.AditionalSva;
import com.telefonica.eof.business.offering.Benefit;
import com.telefonica.eof.business.offering.OfferFilter;
import com.telefonica.eof.business.offering.UpfrontFija;
import com.telefonica.eof.business.sva.Sva;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.commons.Util;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.ehcache.CacheOffersPropertiesCharge;
import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.exception.HttpException;
import com.telefonica.eof.generated.model.BenefitType;
import com.telefonica.eof.generated.model.CategoryTreeType;
import com.telefonica.eof.generated.model.CharacteristicBenefitType;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.PriceTypeEnum;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.RecurringChargePeriodEnum;
import com.telefonica.eof.generated.model.ComposingOfferingType;
import com.telefonica.eof.generated.model.ComposingProductType;
import com.telefonica.eof.generated.model.ComposingProductType.ProductTypeEnum;
import com.telefonica.eof.generated.model.KeyValueType;
import com.telefonica.eof.generated.model.MoneyType;
import com.telefonica.eof.generated.model.OfferingType;
import com.telefonica.eof.generated.model.OfferingType.BillingMethodEnum;
import com.telefonica.eof.generated.model.PaginationInfoType;
import com.telefonica.eof.generated.model.PriceBenefitType;
import com.telefonica.eof.generated.model.ProductInstanceRefType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicValueType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicValueType.ValueTypeEnum;
import com.telefonica.eof.generated.model.RefinedProductType;
import com.telefonica.eof.generated.model.ResponseType;
import com.telefonica.eof.generated.model.UpFrontType;
import com.telefonica.eof.pojo.aditionalSva.AditionalSvaResponse;
import com.telefonica.eof.pojo.aditionalSva.ModemResponse;
import com.telefonica.eof.pojo.benefits.BenefitsResponse;
import com.telefonica.eof.pojo.productInventory.ProductInventoryResponseDto;
import com.telefonica.eof.pojo.sva.SvaResponse;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;
import com.telefonica.eof.proxy.offering.Offerings;
import com.telefonica.eof.proxy.productInventory.ParqueUnificadoConnection;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryListType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryTreeTypeType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.OfferingTypeOfferType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PagingInfoOutputType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PlanBODetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceDetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceTypeProdAltType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PricingType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.ProductTypeEnumType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: OffersBenefitsService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: El servicio obtiene el listado de todas las ofertas y
 *               beneficios
 */

@Service
public class OffersBenefitsService implements OfferBenefitsServiceI {

    @Autowired
    private AditionalSva		aditionalSva;
    @Autowired
    private UpfrontFija			upfrontFija;
    @Autowired
    private Offerings			offerings;
    @Autowired
    private Benefit			benefit;
    @Autowired
    private Sva				sva;
    @Autowired
    private OfferFilter			offerFilter;
    @Autowired
    private ParqueUnificadoConnection	parqueUnificadoConnection;
    @Autowired
    private CacheOffersPropertiesCharge	cacheOffersPropertiesCharge;

    /**
     * Metodo principal. Retorna el response poblado con las ofertas, beneficios y
     * SVA's adicionales
     * 
     * @param offersBenefitsRequestDto:
     *            request que viene del front
     * @return List<OfferingType> : lista de ofertas y beneficios
     * @throws Exception
     */

    public ResponseType getOfferBenefitsFi(OffersBenefitsRequestDto offersBenefitsRequestDto) throws HttpException {
	 try {
	ResponseType responseType = new ResponseType();

	List<OfferingType> offeringTypeList = new ArrayList<>();
	PaginationInfoType paginationInfo = new PaginationInfoType();

	String productType = offersBenefitsRequestDto.getProduct().getType();

	if (productType.contains(Constant.SVA)) {
	    List<OfferingType> svaList = getSva(offersBenefitsRequestDto);
	    if (Boolean.FALSE.equals(Util.isEmptyOrNullList(svaList))) {
		svaList.forEach(offeringSva -> offeringTypeList.add(offeringSva));
	    }
	} else {

	    List<OfferingType> offerBenefitsList = getOfferAndBenefit(offersBenefitsRequestDto).getOfferings();

	    paginationInfo = getOfferAndBenefit(offersBenefitsRequestDto).getPaginationInfo();

	    if (Boolean.FALSE.equals(Util.isEmptyOrNullList(offerBenefitsList))) {
		offerBenefitsList.forEach(offering -> offeringTypeList.add(offering));
	    }
	}

	responseType.setOfferings(offeringTypeList);
	responseType.setPaginationInfo(paginationInfo);

	return responseType;
	 } catch (Exception e) {
	 throw HttpException.HttpExceptionResponse(e);
	 }
    }

    /**
     * El metodo retorna el response poblado de las ofertas y beneficios con
     * respecto a la informacion de AMDOCS
     * 
     * @param: offersBenefitsRequestDto
     *             request que viene del front
     * @return ResponseType: ofertas y beneficios
     */

    private ResponseType getOfferAndBenefit(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	RetrieveOfferingsResponseType rort = offerings.consult(offersBenefitsRequestDto);

	ResponseType responseType = new ResponseType();

	List<OfferingType> offeringTypeList = new ArrayList<>();

	for (CategoryListType categories : rort.getCategories()) {
	    Boolean isInternet = Boolean.FALSE;
	    Integer downloadSpeedSum = 0;
	    for (OfferingTypeOfferType offering : categories.getOfferings()) {

		// TODO ANEXO 3, FILTRAR LAS OFERTA.

		if (Objects.nonNull(offering)) {

		    Boolean planCid = offerFilter.offerFilter(offersBenefitsRequestDto, offering.getCatalogItemId());

		    if (Boolean.TRUE.equals(planCid)) {

			String vProductOfferingID = offering.getCatalogItemId();
			Map<String, List<OffersProperties>> offersPropertiesMap = cacheOffersPropertiesCharge.getOffersProperties();
			List<OffersProperties> offersProperties = offersPropertiesMap.get(vProductOfferingID);
			String downloadSpeed = null;
			BigDecimal amount = BigDecimal.valueOf(0);

			for (OfferingTypeOfferType children : offering.getChildren()) {

			    if (ProductTypeEnumType.BROADBAND.equals(children.getProductType().get(0))) {
				isInternet = Boolean.TRUE;
				List<PricingType> priceList = children.getPlanBoList().get(0).getPriceList();
				if (Boolean.FALSE.equals(priceList.isEmpty())) {

				    // TODO VERIFICAR QUE VELOCIODAD Y PRECIO OBTENER, AMDOCS TRAE VARIOS
				    for (PricingType price : priceList) {
					downloadSpeedSum += 1;
					downloadSpeed = price.getDownloadSpeed();
					amount = price.getPrice().getAmount();

					offeringTypeList.add(fillOfferingType(offering, children, downloadSpeed, offersBenefitsRequestDto,
						offersProperties, amount, categories));

				    }

				}

			    }

			}
			if (Boolean.FALSE.equals(isInternet)) {

			    offeringTypeList.add(fillOfferingType(offering, null, downloadSpeed, offersBenefitsRequestDto, offersProperties,
				    amount, categories));

			}

		    }
		}
	    }
	    // TODO PAGINACION
	    if (Boolean.FALSE.equals(Util.isEmptyOrNullList(offeringTypeList))) {
		responseType.setPaginationInfo(fillPaginationInfo(categories.getPaginationInfo(), isInternet, downloadSpeedSum,
			offersBenefitsRequestDto.getPaginationInfo().getPage()));
	    }

	}

	responseType.setOfferings(offeringTypeList);

	return responseType;
    }

    private OfferingType fillOfferingType(OfferingTypeOfferType offering, OfferingTypeOfferType childrenInternet, String downloadSpeed,
	    OffersBenefitsRequestDto offersBenefitsRequestDto, List<OffersProperties> offersProperties, BigDecimal amount,
	    CategoryListType categories) {

	OfferingType offeringType = new OfferingType();
	List<CategoryTreeType> categoryList = new ArrayList<>();
	List<ComposingOfferingType> bundledProductOfferingList = new ArrayList<>();
	List<ComposingProductType> productSpecificationList = new ArrayList<>();
	List<ComponentProdOfferPriceType> productOfferingPriceList = new ArrayList<>();
	List<KeyValueType> additionalDataList = new ArrayList<>();

	String vProductOfferingID = offering.getCatalogItemId();
	ProductTypeEnumType productType = childrenInternet.getProductType().get(0);

	offeringType.setId(offering.getCatalogItemId());
	offeringType.setHref(Constant.HREF + offering.getCatalogItemId());
	offeringType.setCode(offering.getCatalogItemId());
	offeringType.setCatalogItemType(offering.getCatalogItemType());
	// offeringType.setProductOfferingProductSpecID(offering.getProductOfferingProductSpecID());

	if (ProductTypeEnumType.BROADBAND.equals(productType)) {
	    String offeringName = offering.getName() + " " + downloadSpeed + " " + Constant.MBPS;
	    offeringType.setName(offeringName);

	} else {

	    offeringType.setName(offering.getName());
	}

	AditionalSvaResponse aditionalSvaResponse = aditionalSva.getAditionalSva(vProductOfferingID, downloadSpeed,
		offersBenefitsRequestDto, offersProperties);

	offeringType.setDescription(offering.getDescription());
	BillingMethodEnum billingMethodEnum = BillingMethodEnum.fromValue(offering.getPlanType());
	offeringType.setBillingMethod(billingMethodEnum);
	offeringType.setIsBundle(offering.isIsBundle());

	for (OfferingTypeOfferType children : offering.getChildren()) {

	    ProductTypeEnumType childreProductType = children.getProductType().get(0);

	  
		ComposingProductType productSpecification = new ComposingProductType();
		RefinedProductType refinedProduct = new RefinedProductType();
		List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
		List<ComponentProdOfferPriceType> productPriceList = new ArrayList<>();
		List<ComposingProductType> subProductsList = new ArrayList<>();

		if (!children.getPlanBoList().isEmpty()) {

		    bundledProductOfferingList.add(fillBundledProductOffering(children));
		}

		productSpecification.setId(children.getCatalogItemId());
		productSpecification.setHref(Constant.HREF + children.getCatalogItemId());

		if (ProductTypeEnumType.BROADBAND.equals(childreProductType)) {
		    productSpecification.setName(children.getName() + " " + downloadSpeed + " " + Constant.MBPS);
		} else {
		    productSpecification.setName(children.getName());
		}

		if (ProductTypeEnumType.SH_EQ.equals(childreProductType)) {
		    productSpecification.setProductType(ProductTypeEnum.DEVICE);
		} else if (ProductTypeEnumType.CABLE_TV.toString().equalsIgnoreCase(childreProductType.toString())) {
		    productSpecification.setProductType(ProductTypeEnum.CABLETV);
		} else {
		    productSpecification.setProductType(ProductTypeEnum.fromValue(childreProductType.toString().toLowerCase()));

		}
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PRODUCTOFFERINGPRODUCTSPECID,
			ValueTypeEnum.STRINGWRAPPER, children.getProductOfferingProductSpecID()));

		productCharacteristicsList.add(
			fillProductCharacteristics(null, Constant.BUSINESS_TYPE, ValueTypeEnum.STRINGWRAPPER, children.getBusinessType()));
		productCharacteristicsList.add(
			fillProductCharacteristics(null, Constant.DISPLAY_NAME, ValueTypeEnum.STRINGWRAPPER, children.getDisplayName()));
		productCharacteristicsList
			.add(fillProductCharacteristics(null, Constant.RELATION_ID, ValueTypeEnum.STRINGWRAPPER, children.getRelationId()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.CORRELATION_ID, ValueTypeEnum.STRINGWRAPPER,
			children.getCorrelationId()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_CATALOG_ITEM_ID,
			ValueTypeEnum.STRINGWRAPPER, children.getParentCatalogItemID()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_CATALOG_ITEM_NAME,
			ValueTypeEnum.STRINGWRAPPER, children.getParentCatalogItemName()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_CURRENT_STATUS, ValueTypeEnum.STRINGWRAPPER,
			children.getParentCurrentStatus()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_ASSIGNED_ID, ValueTypeEnum.STRINGWRAPPER,
			children.getParentAssignedID()));
		productCharacteristicsList
			.add(fillProductCharacteristics(null, Constant.PLAN_TYPE, ValueTypeEnum.STRINGWRAPPER, children.getPlanType()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.TOP_RECOMMENDED, ValueTypeEnum.STRINGWRAPPER,
			Objects.nonNull(children.isTopRecommended()) ? Boolean.toString(children.isTopRecommended()) : null));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.COMPATIBLE_WITH_DEVICE,
			ValueTypeEnum.STRINGWRAPPER, Optional.ofNullable(children.getCompatibleWithDevice()).map(x -> x).orElse(null)));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.MIN_NUM_SUBSCRIBERS, ValueTypeEnum.STRINGWRAPPER,
			children.getMinNumOfSubscribers()));
		productCharacteristicsList.add(fillProductCharacteristics(null, Constant.NUM_SUBSCRIBERS, ValueTypeEnum.STRINGWRAPPER,
			children.getNumOfSubscribers()));
		productCharacteristicsList
			.add(fillProductCharacteristics(null, Constant.SHARED_PLAN, ValueTypeEnum.STRINGWRAPPER, children.getSharedPlan()));
		productCharacteristicsList
			.add(fillProductCharacteristics(null, Constant.IMAGE, ValueTypeEnum.STRINGWRAPPER, children.getImage()));
		productCharacteristicsList
			.add(fillProductCharacteristics(null, Constant.BANNER, ValueTypeEnum.STRINGWRAPPER, children.getBanner()));

		children.getAdditionalData().forEach(additionalData -> {

		    if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(additionalData.getValue()))) {
			productCharacteristicsList.add(fillProductCharacteristics(null, additionalData.getKey(),
				ValueTypeEnum.STRINGWRAPPER, additionalData.getValue()));

		    }

		});

		if (!children.getPriceDetails().isEmpty()) {
		    for (PriceDetailsType priceDetail : children.getPriceDetails()) {

			ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();

			if (PriceTypeProdAltType.RECURRING_ALLOWANCE.equals(priceDetail.getPriceType())) {
			    productPrice.setPriceType(PriceTypeEnum.RECURRING);
			} else if (PriceTypeProdAltType.ONE_TIME_ALLOWANCE.equals(priceDetail.getPriceType())) {
			    productPrice.setPriceType(PriceTypeEnum.ONE_TIME);
			}

			productPrice.setPrice(
				fillMoneyType(priceDetail.getPrice().getAmount(), priceDetail.getPrice().getUnits(), Boolean.FALSE));
			productPrice.setMinPrice(
				fillMoneyType(priceDetail.getMinPrice().getAmount(), priceDetail.getMinPrice().getUnits(), Boolean.FALSE));
			productPrice.setMaxPrice(
				fillMoneyType(priceDetail.getMaxPrice().getAmount(), priceDetail.getMaxPrice().getUnits(), Boolean.FALSE));
			productPrice.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
				priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
			productPrice.setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
				priceDetail.getOriginalAmount().getUnits(), Boolean.TRUE));
			productPriceList.add(productPrice);
		    }
		}

		for (PlanBODetailsType planBo : children.getPlanBoList()) {

		    if (ProductTypeEnumType.BROADBAND.equals(productType)) {

			planBo.getPriceList().forEach(priceList -> {

			    ComponentProdOfferPriceType productPricePo = new ComponentProdOfferPriceType();
			    List<KeyValueType> additionalDataPlanBoList = new ArrayList<>();

			    productPricePo.setName(Constant.PRECIO_VELOCIDAD + priceList.getDownloadSpeed() + Constant.MBPS);
			    productPricePo.setPriceType(PriceTypeEnum.RECURRING);
			    productPricePo.setRecurringChargePeriod(RecurringChargePeriodEnum.MONTHLY);
			    productPricePo.setPriceWithTax(
				    fillMoneyType(priceList.getPrice().getAmount(), priceList.getPrice().getUnits(), Boolean.TRUE));
			    productPricePo.setPrice(
				    fillMoneyType(priceList.getPrice().getAmount(), priceList.getPrice().getUnits(), Boolean.FALSE));

			    additionalDataPlanBoList.add(fillAdittionalData(Constant.TECNOLOGY, priceList.getTechnology()));
			    additionalDataPlanBoList.add(fillAdittionalData(Constant.DOWNLOAD_SPEED, priceList.getDownloadSpeed()));

			    productPricePo.setAdditionalData(additionalDataPlanBoList);
			    productPricePo.setProductSpecContainmentID(planBo.getProductSpecContainmentID());
			    productPricePo.setPricePlanSpecContainmentID(planBo.getPricePlanSpecContainmentID());

			    productPriceList.add(productPricePo);

			});

		    } else {
			ComponentProdOfferPriceType productPricePo = new ComponentProdOfferPriceType();
			List<KeyValueType> additionalDataPlanBoList = new ArrayList<>();

			productPricePo.setId(planBo.getBillingOfferId());
			productPricePo.setCode(planBo.getBillingOfferCode());
			productPricePo.setName(planBo.getBillingOfferName());
			productPricePo.setProductSpecContainmentID(planBo.getProductSpecContainmentID());
			productPricePo.setPricePlanSpecContainmentID(planBo.getPricePlanSpecContainmentID());

			if (ProductTypeEnumType.BROADBAND.equals(productType)) {
			    productPricePo.setDescription(Constant.PLAN_INTERNET);
			} else if (ProductTypeEnumType.CABLE_TV.equals(productType)) {
			    productPricePo.setDescription(Constant.PLAN_TV);
			} else if (ProductTypeEnumType.LANDLINE.equals(productType)) {
			    productPricePo.setDescription(Constant.PLAN_VOZ);
			} else if (ProductTypeEnumType.SH_EQ.equals(productType)) {
			    productPricePo.setDescription(Constant.PLAN_EQ_COMPARTIDO);
			}

			for (PriceDetailsType priceDetail : planBo.getPriceDetails()) {

			    productPricePo.setPrice(
				    fillMoneyType(priceDetail.getPrice().getAmount(), priceDetail.getPrice().getUnits(), Boolean.FALSE));
			    productPricePo.setMinPrice(fillMoneyType(priceDetail.getMinPrice().getAmount(),
				    priceDetail.getMinPrice().getUnits(), Boolean.FALSE));
			    productPricePo.setMaxPrice(fillMoneyType(priceDetail.getMaxPrice().getAmount(),
				    priceDetail.getMaxPrice().getUnits(), Boolean.FALSE));
			    productPricePo.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
				    priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
			    productPricePo.setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
				    priceDetail.getOriginalAmount().getUnits(), Boolean.TRUE));

			}

			planBo.getPlanInfo().forEach(planInfo -> {

			    additionalDataPlanBoList.add(fillAdittionalData(planInfo.getKey(), planInfo.getValue()));
			    productPricePo.setAdditionalData(additionalDataPlanBoList);
			});

			productPriceList.add(productPricePo);
		    }

		}

		// TODO ANEXO 1 SVA INCLUIDOS

		subProductsList.add(svsincluding(aditionalSvaResponse, childreProductType));

		refinedProduct.setSubProducts(subProductsList);
		refinedProduct.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProduct);
		productSpecification.setProductPrice(productPriceList);
		productSpecificationList.add(productSpecification);
	    
	}

	for (PriceDetailsType priceDetail : offering.getPriceDetails()) {

	    ComponentProdOfferPriceType productOfferingPrice = new ComponentProdOfferPriceType();

	    productOfferingPrice.setName(priceDetail.getDescription());
	    productOfferingPrice.setDescription(Constant.OFFER_PRICE_DESCRIPTION);

	    if (PriceTypeProdAltType.RECURRING_ALLOWANCE.equals(priceDetail.getPriceType())) {
		productOfferingPrice.setPriceType(PriceTypeEnum.RECURRING);
	    } else if (PriceTypeProdAltType.ONE_TIME_ALLOWANCE.equals(priceDetail.getPriceType())) {
		productOfferingPrice.setPriceType(PriceTypeEnum.ONE_TIME);
	    }

	    if (ProductTypeEnumType.BROADBAND.equals(productType)) {
		productOfferingPrice.setPrice(fillMoneyType(priceDetail.getOriginalAmount().getAmount().add(amount),
			priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
		productOfferingPrice.setPriceWithTax(fillMoneyType(priceDetail.getOriginalAmount().getAmount().add(amount),
			priceDetail.getOriginalAmount().getUnits(), Boolean.TRUE));
		productOfferingPrice.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount().add(amount),
			priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
		productOfferingPrice.setOriginalTaxAmount(fillMoneyType(
			priceDetail.getOriginalAmount().getAmount().add(Objects.nonNull(amount) ? Util.addIgv(amount) : BigDecimal.ZERO),
			priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
	    } else {
		productOfferingPrice.setPrice(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
			priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
		productOfferingPrice.setPriceWithTax(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
			priceDetail.getOriginalAmount().getUnits(), Boolean.TRUE));
		productOfferingPrice.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
			priceDetail.getOriginalAmount().getUnits(), Boolean.FALSE));
		productOfferingPrice.setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
			priceDetail.getOriginalAmount().getUnits(), Boolean.TRUE));
	    }

	    productOfferingPriceList.add(productOfferingPrice);

	}

	additionalDataList.add(fillAdittionalData(Constant.IMAGE, offering.getImage()));
	additionalDataList.add(fillAdittionalData(Constant.BANNER, offering.getBanner()));
	additionalDataList.add(fillAdittionalData(Constant.DISPLAY_NAME, offering.getDisplayName()));
	additionalDataList.add(fillAdittionalData(Constant.RELATION_ID, offering.getRelationId()));
	additionalDataList.add(fillAdittionalData(Constant.ID_ASSIGNED_ITEM, offering.getCorrelationId()));
	additionalDataList.add(fillAdittionalData(Constant.PARENT_CATALOG_ITEM_ID, offering.getParentCatalogItemID()));
	additionalDataList.add(fillAdittionalData(Constant.PARENT_CATALOG_ITEM_NAME, offering.getParentCatalogItemName()));
	additionalDataList.add(fillAdittionalData(Constant.PARENT_CURRENT_STATUS, offering.getParentCurrentStatus()));
	additionalDataList.add(fillAdittionalData(Constant.PARENT_ASSIGNED_ID, offering.getParentAssignedID()));
	additionalDataList.add(fillAdittionalData(Constant.TOP_RECOMMENDED,
		Objects.nonNull(offering.isTopRecommended()) ? Boolean.toString(offering.isTopRecommended()) : null));
	additionalDataList
		.add(fillAdittionalData(Constant.PRODUCRT_TYPE, Optional.ofNullable(productType).map(x -> x.toString()).orElse(null)));
	additionalDataList.add(fillAdittionalData(Constant.COMPATIBLE_WITH_DEVICE, offering.getCompatibleWithDevice()));
	additionalDataList.add(fillAdittionalData(Constant.MIN_NUM_SUBSCRIBERS, offering.getMinNumOfSubscribers()));
	additionalDataList.add(fillAdittionalData(Constant.NUM_SUBSCRIBERS, offering.getNumOfSubscribers()));
	additionalDataList.add(fillAdittionalData(Constant.SHARED_PLAN, offering.getSharedPlan()));

	offering.getAdditionalData()
		.forEach(additionalData -> additionalDataList.add(fillAdittionalData(additionalData.getKey(), additionalData.getValue())));

	// TODO ANEXO 2 UPFRONT

	UpfrontFijaResponse upfrontFijaResponse = upfrontFija.getUpfrontFija(offersBenefitsRequestDto,
		aditionalSvaResponse.getOfferData().getLob());

	UpFrontType upFront = new UpFrontType();
	MoneyType price = new MoneyType();

	price.setAmount(upfrontFijaResponse.getValueAbp());
	price.setUnits(Constant.PERUVIAN_COIN);

	additionalDataList.add(fillAdittionalData(Constant.INSTALLATION_FEE_BO, upfrontFijaResponse.getCidBo()));
	additionalDataList.add(fillAdittionalData(Constant.PRODUCT_FOR_INST_FEE, upfrontFijaResponse.getProductForInstFee()));
	upFront.setPrice(price);
	upFront.setIndicator(upfrontFijaResponse.getIndicator());

	offeringType.setUpFront(upFront);

	// TODO BENEFICIOS
	offeringType.setBenefits(getBenefits(offersBenefitsRequestDto, vProductOfferingID, downloadSpeed));

	// if (Boolean.TRUE.equals(filterOffer)) {

	offeringType.setCurrentPlanRelationID(categories.getCurrentPlanRelationId());

	if (categories.getCategory() != null) {

	    categoryList.add(fillCategory(categories.getCategory()));
	}

	offeringType.setBundledProductOffering(bundledProductOfferingList);
	offeringType.setProductSpecification(productSpecificationList);
	offeringType.setAdditionalData(additionalDataList.stream().filter(x -> Objects.nonNull(x)).collect(Collectors.toList()));
	offeringType.setCategory(categoryList);
	offeringType.setProductOfferingPrice(productOfferingPriceList);

	// }

	String productPublicId = offersBenefitsRequestDto.getProduct().getPublicId();
	String productTypeRequest = offersBenefitsRequestDto.getProduct().getType();

	if (StringUtil.isNullOrEmpty(productPublicId) && StringUtil.isNullOrEmpty(productTypeRequest)) {

	    List<ProductInventoryResponseDto> productInventory = parqueUnificadoConnection.callRestService(productPublicId,
		    productTypeRequest);

	    offeringType.setCompatibleProducts(fillCompatibleProducts(productInventory));
	}

	return offeringType;
    }

    /**
     * El metodo retorna los campos poblados con los SVAS incluidos, obtenidos con
     * en la clase AdditionalSva
     * 
     * @param aditionalSvaResponse:
     *            response del metodo de los SVA adicionales de la oferta
     * @param productType:
     *            tipo de producto
     * @return ComposingProductType: campos poblados
     */
    private ComposingProductType svsincluding(AditionalSvaResponse aditionalSvaResponse, ProductTypeEnumType productType) {

	ComposingProductType offeringSubProducts = new ComposingProductType();
	RefinedProductType refinedProductType = new RefinedProductType();
	List<ComposingProductType> subProductsList = new ArrayList<>();

	List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();

	if (ProductTypeEnumType.SH_EQ.equals(productType)) {
	    ModemResponse modem = aditionalSvaResponse.getModem();
	    subProductsList.add(fillSubProducts(modem.getEquipmentCid(), modem.getNameComp(), ProductTypeEnum.DEVICE));

	    if (Boolean.TRUE.equals(aditionalSvaResponse.getOfferData().getFlagModemPremium())) {

		productCharacteristicsList.add(fillProductCharacteristics(Constant.EQUIPMENT_SUB_TYPE, Constant.SUB_TIPO_EQUIPO,
			ValueTypeEnum.STRINGWRAPPER, Constant.PREMIUM));

	    } else {

		productCharacteristicsList.add(fillProductCharacteristics(Constant.EQUIPMENT_SUB_TYPE, Constant.SUB_TIPO_EQUIPO,
			ValueTypeEnum.STRINGWRAPPER, Constant.BASICA));
	    }
	    refinedProductType.setSubProducts(subProductsList);
	    refinedProductType.setProductCharacteristics(productCharacteristicsList);
	}

	if (ProductTypeEnumType.CABLE_TV.equals(productType)) {

	    aditionalSvaResponse.getDecos().forEach(decos -> {
		subProductsList.add(fillSubProducts(Constant.STB, decos.getCaption(), ProductTypeEnum.DEVICE));
		productCharacteristicsList.add(fillProductCharacteristics(Constant.STB_TYPE, Constant.TIPO_DECODIFICADOR,
			ValueTypeEnum.STRINGWRAPPER, decos.getStbSetting()));
		refinedProductType.setSubProducts(subProductsList);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);

	    });

	}

	if (!(Constant.NULL.equalsIgnoreCase(aditionalSvaResponse.getOfferData().getDefSpsBo())
		|| StringUtil.isNullOrEmpty(aditionalSvaResponse.getOfferData().getDefSpsBo()))
		&& ProductTypeEnumType.CABLE_TV.equals(productType)) {

	    aditionalSvaResponse.getChannelBlock().forEach(channelBlock -> {

		subProductsList.add(fillSubProducts(channelBlock.getFdIdParent(), channelBlock.getFdNameParent(), ProductTypeEnum.SVA));

		productCharacteristicsList.add(fillProductCharacteristics(channelBlock.getCidBo(), Constant.BILLING_OFFER,
			ValueTypeEnum.STRINGWRAPPER, channelBlock.getDescriptionText()));

		productCharacteristicsList.add(fillProductCharacteristics(channelBlock.getDefSpsId(), Constant.SPSID,
			ValueTypeEnum.STRINGWRAPPER, channelBlock.getCNameParent()));
		refinedProductType.setSubProducts(subProductsList);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);

	    });

	}

	aditionalSvaResponse.getOtherSvas().forEach(otherSvas -> {

	    if (ProductTypeEnumType.BROADBAND.equals(productType) && Constant.MCAFEE.equals(otherSvas.getParentId())
		    || ProductTypeEnumType.LANDLINE.equals(productType) && Constant.MULTIDESTINO.equals(otherSvas.getParentId())) {

		subProductsList.add(fillSubProducts(otherSvas.getParentId(), otherSvas.getNameComp(), ProductTypeEnum.SVA));

		productCharacteristicsList.add(fillProductCharacteristics(otherSvas.getCidBo(), Constant.BILLING_OFFER,
			ValueTypeEnum.STRINGWRAPPER, otherSvas.getNameBo()));

		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		refinedProductType.setSubProducts(subProductsList);
	    }
	});

	offeringSubProducts.setRefinedProduct(refinedProductType);

	return offeringSubProducts;
    }

    /**
     * El metodo retorna los campos poblados con los beneficios obtenidos con en la
     * clase Benefit
     * 
     * @param offersBenefitsRequestDto:
     *            request que viene del front
     * @param vProductOfferingID:
     *            se obtiene del response de AMDOCS
     * @param downloadSpeed:
     *            se obtiene del response de AMDOCS
     * @return List<BenefitType>: listado con los campos poblados
     */
    private List<BenefitType> getBenefits(OffersBenefitsRequestDto offersBenefitsRequestDto, String vProductOfferingID,
	    String downloadSpeed) {

	List<BenefitsResponse> benefitList = benefit.getBenefitDiscount(offersBenefitsRequestDto, vProductOfferingID, downloadSpeed);

	List<BenefitType> benefitTypeList = new ArrayList<>();
	List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();
	List<PriceBenefitType> priceBenefitsList = new ArrayList<>();

	benefitList.forEach(benefits -> {

	    BenefitType benefitType = new BenefitType();
	    PriceBenefitType priceBenefit = new PriceBenefitType();

	    benefitType.setId(benefits.getBenefits().getBenefitComponentCid());
	    benefitType.setName(benefits.getNameComp());
	    benefitType.setDownloadSpeed(benefits.getBenefits().getSpeed());
	    benefitType.setType(benefits.getBenefits().getLob());

	    characteristicsList.add(fillCharacteristics(Constant.SPS_ID, benefits.getBenefits().getBenefitThemePackSpsCid()));
	    characteristicsList.add(fillCharacteristics(Constant.SPS_NAME, benefits.getSpsName()));
	    characteristicsList.add(fillCharacteristics(Constant.BO_ID, benefits.getBenefits().getBenefitBillingOfferCid()));
	    characteristicsList.add(fillCharacteristics(Constant.BO_NAME, benefits.getNameBo()));
	    characteristicsList.add(fillCharacteristics(Constant.DURATION, benefits.getBenefits().getDuration()));
	    characteristicsList.add(fillCharacteristics(Constant.NIGHT_ID, benefits.getBenefits().getNightInd()));

	    if (Constant.MONETARY.equalsIgnoreCase(benefits.getValueAbpType())) {

		BigDecimal value = new BigDecimal(benefits.getValueAbp());

		priceBenefit.setPriceType(Constant.RECURRING);

		priceBenefit.setPrice(fillMoneyType(value, Constant.PERUVIAN_COIN, Boolean.FALSE));
		priceBenefit.setPriceWithTax(fillMoneyType(value, Constant.PERUVIAN_COIN, Boolean.TRUE));

		priceBenefitsList.add(priceBenefit);
		benefitType.setPriceBenefits(priceBenefitsList);
	    }

	    benefitType.setCharacteristics(characteristicsList);
	    benefitTypeList.add(benefitType);
	});

	return benefitTypeList;

    }

    /**
     * El metodo retorna los campos poblados con los SVA's obtenidos con en la clase
     * SVA
     * 
     * @param offersBenefitsRequestDto:
     *            request que viene del front
     * @return List<OfferingType>: listado con los campos poblados
     */

    private List<OfferingType> getSva(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	List<OfferingType> offeringTypeList = new ArrayList<>();

	List<String> productOfferingCatalogIdList = Arrays.asList(offersBenefitsRequestDto.getProductOfferingCatalogId().split(","));

	productOfferingCatalogIdList.forEach(productOfferingCatalogId -> {

	    Map<String, List<OffersProperties>> offersPropertiesMap = cacheOffersPropertiesCharge.getOffersProperties();
	    List<OffersProperties> propertyValueList = offersPropertiesMap.get(productOfferingCatalogId);
	    String retention = null;
	    
	    for (OffersProperties propertyValue: propertyValueList) {
		if (propertyValue.getNameOfProperty().equalsIgnoreCase(Constant.RETENTION)) {
		    retention = propertyValue.getPropertyValue();
		}
	    }

	    String flagRetention;

	    if (Boolean.TRUE.equals(offersBenefitsRequestDto.getIsRetention())) {
		flagRetention = "'" + Constant.YES + "'";
	    } else {
		flagRetention = "'" + Constant.NO + "'";
	    }

	    List<SvaResponse> svaResponseList;

	    if (Constant.YES.equalsIgnoreCase(retention) && Boolean.TRUE.equals(offersBenefitsRequestDto.getIsRetention())) {

		svaResponseList = sva.getSvaTypeRetention(offersBenefitsRequestDto, flagRetention, propertyValueList,
			productOfferingCatalogId);
		if (!(svaResponseList == null || svaResponseList.isEmpty())) {
		    svaResponseList.forEach(svaResponse -> {

			OfferingType offeringType = new OfferingType();
			List<ComposingProductType> productSpecificationList = new ArrayList<>();

			svaResponse.getBillingOffer().forEach(billingOffer -> {

			    ComposingProductType productSpecification = new ComposingProductType();
			    RefinedProductType refinedProductType = new RefinedProductType();
			    List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
			    List<ComponentProdOfferPriceType> productPriceList = new ArrayList<>();
			    ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();

			    productSpecification.setId(billingOffer.getBillingOffer().getChildId());
			    productSpecification.setName(billingOffer.getBillingOffer().getNameChild());

			    productSpecification.setProductType(ProductTypeEnum.SVA);
			    productSpecification.setPeriodDuration(billingOffer.getBillingOffer().getDurationValue());

			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.SPSID, ValueTypeEnum.STRINGWRAPPER,
				    billingOffer.getSpsIdAndName().getParentId()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.NOMBRE_SPS,
				    ValueTypeEnum.STRINGWRAPPER, billingOffer.getSpsIdAndName().getNameParent()));

			    refinedProductType.setProductCharacteristics(productCharacteristicsList);
			    productSpecification.setRefinedProduct(refinedProductType);

			    productPrice.setName(Constant.PRECIO_SVA);
			    productPrice.setProductSpecContainmentID(billingOffer.getBillingOffer().getRelationId());
			    productPrice.setPricePlanSpecContainmentID(billingOffer.getRelationId());
			    productPriceList.add(productPrice);
			    productSpecification.setProductPrice(productPriceList);

			    productSpecificationList.add(productSpecification);
			    offeringType.setName(billingOffer.getBillingOffer().getNameParent());

			});

			offeringType.setId(svaResponse.getIdComponent());
			offeringType.setProductSpecification(productSpecificationList);
			offeringTypeList.add(offeringType);

		    });
		}

	    } else {
		svaResponseList = sva.getSvaTypeSva(offersBenefitsRequestDto, flagRetention, propertyValueList, productOfferingCatalogId);

		if (!(svaResponseList == null || svaResponseList.isEmpty())) {
		    svaResponseList.forEach(svaResponse -> {

			OfferingType offeringType = new OfferingType();
			List<ComposingProductType> productSpecificationList = new ArrayList<>();
			List<BenefitType> benefitTypeList = new ArrayList<>();

			svaResponse.getBillingOffer().forEach(billingOffer -> {

			    ComposingProductType productSpecification = new ComposingProductType();
			    RefinedProductType refinedProductType = new RefinedProductType();
			    List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
			    List<ComponentProdOfferPriceType> productPriceList = new ArrayList<>();
			    ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();

			    productSpecification.setId(billingOffer.getBillingOffer().getChildId());
			    productSpecification.setName(billingOffer.getBillingOffer().getNameChild());
			    productSpecification.setProductType(ComposingProductType.ProductTypeEnum.SVA);

			    if (Constant.STB.equals(svaResponse.getIdComponent())) {
				productSpecification.setMaxCardinality(billingOffer.getMaxSTBsallowed());
			    }

			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.SPSID, ValueTypeEnum.STRINGWRAPPER,
				    billingOffer.getSpsIdAndName().getParentId()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.NOMBRE_SPS,
				    ValueTypeEnum.STRINGWRAPPER, billingOffer.getSpsIdAndName().getNameParent()));

			    refinedProductType.setProductCharacteristics(productCharacteristicsList);
			    productSpecification.setRefinedProduct(refinedProductType);

			    productPrice.setName(Constant.PRECIO_SVA);
			    productPrice.setPriceType(billingOffer.getPriceType());
			    productPrice.setPrice(fillMoneyType(billingOffer.getAmount(), Constant.PERUVIAN_COIN, Boolean.FALSE));
			    productPrice.setProductSpecContainmentID(billingOffer.getBillingOffer().getRelationId());
			    productPrice.setPricePlanSpecContainmentID(billingOffer.getRelationId());

			    productPrice.setTaxAmount(fillMoneyType(billingOffer.getAmount(), Constant.PERUVIAN_COIN, Boolean.TRUE));

			    productPriceList.add(productPrice);
			    productSpecification.setProductPrice(productPriceList);

			    if (Objects.nonNull(billingOffer.getVasBenefits())) {

				BenefitType benefitType = new BenefitType();
				List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();

				benefitType.setId(billingOffer.getVasBenefits().getBenefitComponentCid());
				benefitType.setName(billingOffer.getNameComp());
				benefitType.setDownloadSpeed(billingOffer.getVasBenefits().getSpeed());

				characteristicsList.add(
					fillCharacteristics(Constant.SPS_ID, billingOffer.getVasBenefits().getBenefitThemePackSpsCid()));
				characteristicsList.add(fillCharacteristics(Constant.SPS_NAME, billingOffer.getParentName()));
				characteristicsList.add(
					fillCharacteristics(Constant.BO_CODE, billingOffer.getVasBenefits().getBenefitBillingOfferCid()));
				characteristicsList.add(fillCharacteristics(Constant.BO_NAME, billingOffer.getNameBo()));
				characteristicsList
					.add(fillCharacteristics(Constant.DURATION, billingOffer.getVasBenefits().getDuration()));
				benefitType.setCharacteristics(characteristicsList.stream()
					.filter(x -> Boolean.FALSE.equals(StringUtil.isNullOrEmpty(x.getValue())))
					.collect(Collectors.toList()));

				benefitTypeList.add(benefitType);
			    }

			    productSpecificationList.add(productSpecification);

			    offeringType.setName(billingOffer.getBillingOffer().getNameParent());

			});

			offeringType.setBenefits(benefitTypeList);
			offeringType.setId(svaResponse.getIdComponent());
			offeringType.setProductSpecification(productSpecificationList);
			offeringTypeList.add(offeringType);

		    });
		}

	    }
	});

	return offeringTypeList;

    }

    /**
     * Metodo para poblar los campos de ProductCharacteristics
     * 
     * @param name:
     *            nombre del productCharacteristics
     * @param enumValue:
     *            valueType del productCharacteristics
     * @param value:
     *            valor del productCharacteristics
     * @return StringWrapper: atributos poblados
     */
    private ProductSpecCharacteristicType fillProductCharacteristics(String id, String name, ValueTypeEnum enumValue, String value) {

	ProductSpecCharacteristicType productCharacteristics = new ProductSpecCharacteristicType();
	List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
	ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

	if (id != null) {
	    productCharacteristics.setId(id);
	    productCharacteristics.setName(name);
	    productSpecCharacteristicValue.setValue(value);
	    productSpecCharacteristicValue.setValueType(enumValue);
	} else {
	    productCharacteristics.setName(name);
	    productSpecCharacteristicValue.setValueType(enumValue);
	    productSpecCharacteristicValue.setValue(value);
	}

	productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
	productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);
	return productCharacteristics;
    }

    /**
     * Metodo para poblar los campos de AdittionalData
     * 
     * @param key
     * @param value
     * @return KeyValueType: atributos poblados
     */
    private KeyValueType fillAdittionalData(String key, String value) {

	KeyValueType adittionalData = null;

	if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(value))) {
	    adittionalData = new KeyValueType();
	    adittionalData.setKey(key);
	    adittionalData.setValue(value);
	}

	return adittionalData;
    }

    /**
     * Metodo para poblar los campos de Characteristics
     * 
     * @param key
     * @param value
     * @return CharacteristicBenefitType: atributos poblados
     */
    private CharacteristicBenefitType fillCharacteristics(String key, String value) {

	CharacteristicBenefitType characteristics = new CharacteristicBenefitType();

	if (Boolean.FALSE.equals(StringUtil.isNullOrEmpty(value))) {
	    characteristics.setKey(key);
	    characteristics.setValue(value);
	}

	return characteristics;
    }

    /**
     * Metodo para poblar el atributo MoneyType
     * 
     * @param amount
     *            : monto
     * @param units
     *            : unidad monetaria
     * @param igv
     *            : agregar igv
     * @return MoneyType: atributos poblados
     */
    private MoneyType fillMoneyType(BigDecimal amount, String units, Boolean igv) {

	MoneyType moneyType = new MoneyType();
	if (Objects.nonNull(amount)) {
	    if (Boolean.TRUE.equals(igv)) {
		amount = Util.addIgv(amount);
	    }
	    moneyType.setAmount(Util.roundValue(amount));
	    moneyType.setUnits(StringUtil.isNullOrEmpty(units) ? Constant.PERUVIAN_COIN : units);
	}

	return moneyType;
    }

    /**
     * Metodo para poblar el atributo MoneyType
     * 
     * @param id:
     *            id del subpoducto, en caso no necesitarse, se enviara null
     * @param name:
     *            nombre del subproducto
     * @param name:
     *            nombre del subproducto
     * @param productType:
     *            tipo del subproducto
     * @return ComposingProductType: atributos poblados
     */

    private ComposingProductType fillSubProducts(String id, String name, ProductTypeEnum productType) {

	ComposingProductType subProducts = new ComposingProductType();
	subProducts.setId(id);
	subProducts.setName(name);
	subProducts.setProductType(productType);

	return subProducts;
    }

    /**
     * Metodo para poblar el atributo BundledProductOffering
     * 
     * @param children:
     *            campo children del offering retornado por AMDOCS
     * @return ComposingOfferingType: atributos poblados
     */
    private ComposingOfferingType fillBundledProductOffering(OfferingTypeOfferType children) {

	ComposingOfferingType bundledProductOffering = new ComposingOfferingType();
	bundledProductOffering.setName(children.getName());
	bundledProductOffering.setPlanName(children.getPlanBoList().get(0).getBillingOfferName());
	bundledProductOffering.setDisplayName(children.getDescription());
	bundledProductOffering.setImage(children.getImage());

	return bundledProductOffering;
    }

    /**
     * Metodo para poblar el atributo Category
     * 
     * @param categories:
     *            campo category del response AMDOCS
     * @return CategoryTreeType: atributos poblados
     */
    private CategoryTreeType fillCategory(CategoryTreeTypeType categories) {

	CategoryTreeType category = new CategoryTreeType();
	CategoryTreeType subcategories = new CategoryTreeType();

	category.setId(categories.getId());
	category.setHref(categories.getHref());
	category.setName(categories.getName());

	subcategories.setId(Optional.ofNullable(categories.getSubcategories()).map(CategoryTreeTypeType::getId).orElse(null));
	subcategories.setHref(Optional.ofNullable(categories.getSubcategories()).map(CategoryTreeTypeType::getHref).orElse(null));
	subcategories.setName(Optional.ofNullable(categories.getSubcategories()).map(CategoryTreeTypeType::getName).orElse(null));
	category.setSubcategories(subcategories);

	return category;
    }

    /**
     * Metodo para poblar el Pagination
     * 
     * @param paginationInfo:
     *            campo que viene del response AMDOCS
     * @param isInternet:
     *            variable que indica si la oferta posee internet
     * @param downloadSpeed:
     *            variable de la velocidad del internet
     * @return PaginationInfoType: atributos poblados
     */
    private PaginationInfoType fillPaginationInfo(PagingInfoOutputType paginationInfo, Boolean isInternet, Integer downloadSpeed,
	    Integer page) {

	PaginationInfoType paginationInfoType = new PaginationInfoType();

	BigDecimal totalPages;
	BigDecimal totalResults;
	paginationInfoType.last(false);
	paginationInfoType.setFirst(false);

	if (Boolean.TRUE.equals(isInternet)) {

	    BigDecimal speed = new BigDecimal(downloadSpeed);
	    totalPages = paginationInfo.getTotalResultsInCategory().add(speed).divide(paginationInfo.getItemsPerCategory(), 0, BigDecimal.ROUND_HALF_UP );
	    totalResults = paginationInfo.getTotalResultsInCategory().add(speed);
	    paginationInfoType.setTotalPages(totalPages.intValue());
	    paginationInfoType.setTotalResults(totalResults.intValue());
	} else {
	    totalPages = paginationInfo.getTotalResultsInCategory().divide(paginationInfo.getItemsPerCategory());
	    totalResults = paginationInfo.getTotalResultsInCategory();
	    paginationInfoType.setTotalPages(totalPages.intValue());
	    paginationInfoType.setTotalResults(totalResults.intValue());
	}

	if (Boolean.TRUE.equals(paginationInfo.isHasMore())) {
	    paginationInfoType.last(true);
	}

	paginationInfoType.setItemsPerPage(paginationInfo.getItemsPerPage().intValue());

	if (page == 1) {
	    paginationInfoType.setFirst(true);
	}

	return paginationInfoType;
    }

    /**
     * Metodo para poblar el CompatibleProducts
     * 
     * @param productInventory:
     *            response del servicio ProductInventory
     * @return List<ProductInstanceRefType>: atributos poblados
     */

    private List<ProductInstanceRefType> fillCompatibleProducts(List<ProductInventoryResponseDto> productInventory) {

	List<ProductInstanceRefType> compatibleProductsList = new ArrayList<>();
	ProductInstanceRefType compatibleProducts = new ProductInstanceRefType();

	compatibleProducts.setId(productInventory.get(0).getId());
	compatibleProducts.setHref(productInventory.get(0).getHref());
	compatibleProducts.setName(productInventory.get(0).getName());
	compatibleProducts.setPublicId(productInventory.get(0).getPublicId());
	compatibleProducts.setDescription(productInventory.get(0).getDescription());
	compatibleProducts.setProductType((com.telefonica.eof.generated.model.ProductInstanceRefType.ProductTypeEnum
		.fromValue(productInventory.get(0).getProductType())));

	compatibleProductsList.add(compatibleProducts);

	return compatibleProductsList;
    }

}
