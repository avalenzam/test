package com.telefonica.eof.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.business.offering.AditionalSva;
import com.telefonica.eof.business.offering.Benefit;
import com.telefonica.eof.business.offering.UpfrontFija;
import com.telefonica.eof.business.sva.Sva;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.commons.Util;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.entity.OffersProperties;
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
import com.telefonica.eof.generated.model.ProductSpecCharacteristicType.ValueTypeEnum;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicValueType;
import com.telefonica.eof.generated.model.RefinedProductType;
import com.telefonica.eof.generated.model.ResponseType;
import com.telefonica.eof.generated.model.StringWrapper;
import com.telefonica.eof.generated.model.UpFrontType;
import com.telefonica.eof.pojo.aditionalSva.AditionalSvaResponse;
import com.telefonica.eof.pojo.aditionalSva.ModemResponse;
import com.telefonica.eof.pojo.benefits.BenefitsResponse;
import com.telefonica.eof.pojo.productInventory.ProductInventoryResponseDto;
import com.telefonica.eof.pojo.sva.SvaResponse;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;
import com.telefonica.eof.proxy.offering.Offerings;
import com.telefonica.eof.proxy.productInventory.ParqueUnificadoConnection;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.repository.OffilterBundleRepository;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryListType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryTreeTypeType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.OfferingTypeOfferType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PagingInfoOutputType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PlanBODetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceDetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceTypeProdAltType;
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
    private AditionalSva	       aditionalSva;
    @Autowired
    private UpfrontFija		       upfrontFija;
    @Autowired
    private Offerings		       offerings;
    @Autowired
    private Benefit		       benefit;
    @Autowired
    private Sva			       sva;
    @Autowired
    private ParqueUnificadoConnection  parqueUnificadoConnection;
    @Autowired
    private OffersPropertiesRepository offersPropertiesRepository;
    @Autowired
    private OffilterBundleRepository   offilterBundleRepository;

    /**
     * Metodo principal. Retorna el response poblado con las ofertas, beneficios y
     * SVA's adicionales
     * 
     * @param offersBenefitsRequestDto:
     *            request que viene del front
     * @return List<OfferingType> : lista de ofertas y beneficios
     * @throws Exception
     */

    public ResponseType getOfferBenefitsFi(OffersBenefitsRequestDto offersBenefitsRequestDto) throws Exception {
	try {
	    ResponseType responseType = new ResponseType();

	    List<OfferingType> offeringTypeList = new ArrayList<>();

	    List<OfferingType> svaList = getSva(offersBenefitsRequestDto);
	    svaList.forEach(offeringSva -> offeringTypeList.add(offeringSva));

	    List<OfferingType> offerBenefitsList = getOfferAndBenefit(offersBenefitsRequestDto).getOfferings();

	    PaginationInfoType paginationInfo = getOfferAndBenefit(offersBenefitsRequestDto).getPaginationInfo();

	    offerBenefitsList.forEach(offering -> offeringTypeList.add(offering));

	    responseType.setOfferings(offeringTypeList);
	    responseType.setPaginationInfo(paginationInfo);

	    return responseType;
	} catch (Exception e) {
	    throw new Exception(e);
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

	    OfferingType offeringType = new OfferingType();
	    List<CategoryTreeType> categoryList = new ArrayList<>();
	    List<ComposingOfferingType> bundledProductOfferingList = new ArrayList<>();
	    List<ComposingProductType> productSpecificationList = new ArrayList<>();
	    // List<ComponentProdOfferPriceType> productOfferingPriceList = new
	    // ArrayList<>();
	    List<KeyValueType> additionalDataList = new ArrayList<>();

	    Boolean isInternet = false;
	    String downloadSpeed = null;

	    for (OfferingTypeOfferType offering : categories.getOfferings()) {

		// TODO ANEXO 3, FILTRAR LAS OFERTA.

		if (offering != null) {
		    String offer = offilterBundleRepository.findPlanCid(offering.getCatalogItemId(),
			    offersBenefitsRequestDto.getInstallationAddressDepartment(), offersBenefitsRequestDto.getDealerId(),
			    offersBenefitsRequestDto.getSiteId());

		    if (!(StringUtil.isNullOrEmpty(offer))) {

			ComposingProductType productSpecification = new ComposingProductType();
			RefinedProductType refinedProduct = new RefinedProductType();
			List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
			List<ComponentProdOfferPriceType> productPriceList = new ArrayList<>();
			List<ComposingProductType> subProductsList = new ArrayList<>();

			offeringType.setId(offering.getCatalogItemId());
			offeringType.setHref(Constant.HREF_OFFERING);
			offeringType.setCode(offering.getCatalogItemId());
			offeringType.setCatalogItemType(offering.getCatalogItemType());
			offeringType.setProductOfferingProductSpecID(offering.getProductOfferingProductSpecID());

			ProductTypeEnumType productType = null;
			BigDecimal amount = BigDecimal.valueOf(0);
			String vProductOfferingID = offering.getCatalogItemId();
			List<OffersProperties> offersProperties = offersPropertiesRepository.findPropertyValue(vProductOfferingID);

			for (OfferingTypeOfferType children : offering.getChildren()) {
			    productType = children.getProductType().get(0);
			    if (ProductTypeEnumType.BROADBAND.equals(productType)) {
				isInternet = true;
				if (!children.getPlanBoList().get(0).getPriceList().isEmpty()) {
				    downloadSpeed = children.getPlanBoList().get(0).getPriceList().get(0).getDownloadSpeed();
				    amount = children.getPlanBoList().get(0).getPriceList().get(0).getPrice().getAmount();
				}

			    }

			}

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
			offeringType.setIsBundle(offering.getIsBundle());

			for (OfferingTypeOfferType children : offering.getChildren()) {

			    if (!children.getPlanBoList().isEmpty()) {

				bundledProductOfferingList.add(fillBundledProductOffering(children));
			    }

			    productSpecification.setId(children.getCatalogItemId());
			    productSpecification.setHref(Constant.HREF_PRODUCTSPECIFICATION);
			    ProductTypeEnumType childreProductType = children.getProductType().get(0);
			    if (ProductTypeEnumType.BROADBAND.equals(childreProductType)) {
				productSpecification.setName(children.getName() + " " + downloadSpeed + " " + Constant.MBPS);
			    } else {
				productSpecification.setName(children.getName());
			    }

			    if (ProductTypeEnumType.SH_EQ.equals(childreProductType)) {
				productSpecification.setProductType(ProductTypeEnum.DEVICE);
			    } else {

				productSpecification.setProductType(ProductTypeEnum.fromValue(childreProductType.toString()));
			    }

			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.BUSINESS_TYPE,
				    ValueTypeEnum.STRINGWRAPPER, children.getBusinessType()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.DISPLAY_NAME,
				    ValueTypeEnum.STRINGWRAPPER, children.getDisplayName()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.RELATION_ID,
				    ValueTypeEnum.STRINGWRAPPER, children.getRelationId()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.CORRELATION_ID,
				    ValueTypeEnum.STRINGWRAPPER, children.getCorrelationId()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_CATALOG_ITEM_ID,
				    ValueTypeEnum.STRINGWRAPPER, children.getParentCatalogItemID()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_CATALOG_ITEM_NAME,
				    ValueTypeEnum.STRINGWRAPPER, children.getParentCatalogItemName()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_CURRENT_STATUS,
				    ValueTypeEnum.STRINGWRAPPER, children.getParentCurrentStatus()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PARENT_ASSIGNED_ID,
				    ValueTypeEnum.STRINGWRAPPER, children.getParentAssignedID()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.PLAN_TYPE, ValueTypeEnum.STRINGWRAPPER,
				    children.getPlanType()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.TOP_RECOMMENDED,
				    ValueTypeEnum.STRINGWRAPPER, Boolean.toString(children.getTopRecommended())));
			    productCharacteristicsList
				    .add(fillProductCharacteristics(null, Constant.COMPATIBLE_WITH_DEVICE, ValueTypeEnum.STRINGWRAPPER,
					    Optional.ofNullable(children.getCompatibleWithDevice()).map(x -> x).orElse(null)));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.MIN_NUM_SUBSCRIBERS,
				    ValueTypeEnum.STRINGWRAPPER, children.getMinNumOfSubscribers()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.NUM_SUBSCRIBERS,
				    ValueTypeEnum.STRINGWRAPPER, children.getNumOfSubscribers()));
			    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.SHARED_PLAN,
				    ValueTypeEnum.STRINGWRAPPER, children.getSharedPlan()));
			    productCharacteristicsList.add(
				    fillProductCharacteristics(null, Constant.IMAGE, ValueTypeEnum.STRINGWRAPPER, children.getImage()));
			    productCharacteristicsList.add(
				    fillProductCharacteristics(null, Constant.BANNER, ValueTypeEnum.STRINGWRAPPER, children.getBanner()));

			    children.getAdditionalData().forEach(additionalData -> {
				productCharacteristicsList.add(fillProductCharacteristics(null, additionalData.getKey(),
					ValueTypeEnum.STRINGWRAPPER, additionalData.getValue()));

			    });

			    if (!children.getPriceDetails().isEmpty()) {
				for (PriceDetailsType priceDetail : children.getPriceDetails()) {

				    ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();

				    if (PriceTypeProdAltType.RECURRING_ALLOWANCE.equals(priceDetail.getPriceType())) {
					productPrice.setPriceType(PriceTypeEnum.RECURRING);
				    } else if (PriceTypeProdAltType.ONE_TIME_ALLOWANCE.equals(priceDetail.getPriceType())) {
					productPrice.setPriceType(PriceTypeEnum.ONE_TIME);
				    }

				    productPrice
					    .setPrice(fillMoneyType(priceDetail.getPrice().getAmount(), priceDetail.getPrice().getUnits()));
				    productPrice.setMinPrice(
					    fillMoneyType(priceDetail.getMinPrice().getAmount(), priceDetail.getMinPrice().getUnits()));
				    productPrice.setMaxPrice(
					    fillMoneyType(priceDetail.getMaxPrice().getAmount(), priceDetail.getMaxPrice().getUnits()));
				    // TODO CAMPOS NO VIENEN EN AMDOCS, CONSULTAR
				    // productPrice.setTaxAmount(
				    // fillMoneyType(priceDetail.getTaxAmount().getAmount(),
				    // priceDetail.getTaxAmount().getUnits()));
				    // productPrice.setPriceWithTax(
				    // fillMoneyType(priceDetail.getPriceWithTax().getAmount(),
				    // priceDetail.getPriceWithTax().getUnits()));
				    productPrice.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
					    priceDetail.getOriginalAmount().getUnits()));
				    // productPrice.setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalTaxAmount().getAmount(),
				    // priceDetail.getOriginalTaxAmount().getUnits()));
				}
			    }

			    for (PlanBODetailsType planBo : children.getPlanBoList()) {

				ComponentProdOfferPriceType productPricePo = new ComponentProdOfferPriceType();
				List<KeyValueType> additionalDataPlanBoList = new ArrayList<>();

				if (ProductTypeEnumType.BROADBAND.equals(productType)) {

				    planBo.getPriceList().forEach(priceList -> {

					productPricePo.setName(Constant.PRECIO_VELOCIDAD + priceList.getDownloadSpeed() + Constant.MBPS);
					productPricePo.setPriceType(PriceTypeEnum.RECURRING);
					productPricePo.setRecurringChargePeriod(RecurringChargePeriodEnum.MONTHLY);
					productPricePo.setPriceWithTax(fillMoneyType(Util.igvCalculator(priceList.getPrice().getAmount()),
						priceList.getPrice().getUnits()));
					productPricePo
						.setPrice(fillMoneyType(priceList.getPrice().getAmount(), priceList.getPrice().getUnits()));

					additionalDataPlanBoList.add(fillAdittionalData(Constant.TECNOLOGY, priceList.getTechnology()));
					additionalDataPlanBoList
						.add(fillAdittionalData(Constant.DOWNLOAD_SPEED, priceList.getDownloadSpeed()));

					productPricePo.setAdditionalData(additionalDataPlanBoList);
					productPriceList.add(productPricePo);

				    });

				} else {

				    productPricePo.setId(planBo.getBillingOfferId());
				    productPricePo.setCode(planBo.getBillingOfferCode());
				    productPricePo.setName(planBo.getBillingOfferName());

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
						fillMoneyType(priceDetail.getPrice().getAmount(), priceDetail.getPrice().getUnits()));
					productPricePo.setMinPrice(
						fillMoneyType(priceDetail.getMinPrice().getAmount(), priceDetail.getMinPrice().getUnits()));
					productPricePo.setMaxPrice(
						fillMoneyType(priceDetail.getMaxPrice().getAmount(), priceDetail.getMaxPrice().getUnits()));
					// productPricePo.setTaxAmount(fillMoneyType(priceDetail.getTaxAmount().getAmount(),
					// priceDetail.getTaxAmount().getUnits()));
					// productPricePo.setPriceWithTax(fillMoneyType(priceDetail.getPriceWithTax().getAmount(),
					// priceDetail.getPriceWithTax().getUnits()));
					productPricePo.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
						priceDetail.getOriginalAmount().getUnits()));
					// productPricePo.setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalTaxAmount().getAmount(),
					// priceDetail.getOriginalTaxAmount().getUnits()));

				    }

				    planBo.getPlanInfo().forEach(planInfo -> {

					additionalDataPlanBoList.add(fillAdittionalData(planInfo.getKey(), planInfo.getValue()));
					productPricePo.setAdditionalData(additionalDataPlanBoList);
				    });

				    productPriceList.add(productPricePo);
				}

				productPricePo.setProductSpecContainmentID(planBo.getProductSpecContainmentID());
				productPricePo.setPricePlanSpecContainmentID(planBo.getPricePlanSpecContainmentID());

			    }

			    // TODO ANEXO 1 SVA INCLUIDOS

			    subProductsList.add(svsincluding(aditionalSvaResponse, children.getProductType().get(0)));

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

			    // if (ProductTypeEnumType.BROADBAND.equals(productType)) {
			    //
			    // BigDecimal igvPrice =
			    // Util.igvCalculator(priceDetail.getPrice().getAmount().add(amount));
			    //
			    // productOfferingPrice.setPrice(
			    // fillMoneyType(priceDetail.getPrice().getAmount().add(amount),
			    // priceDetail.getPrice().getUnits()));
			    // productOfferingPrice.setPriceWithTax(fillMoneyType(igvPrice,
			    // priceDetail.getPriceWithTax().getUnits()));
			    // productOfferingPrice
			    // .setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount().add(amount),
			    // priceDetail.getOriginalAmount().getUnits()));
			    // productOfferingPrice
			    // .setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalTaxAmount().getAmount().add(amount),
			    // priceDetail.getOriginalTaxAmount().getUnits()));
			    // } else {
			    // productOfferingPrice.setPrice(
			    // fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
			    // priceDetail.getPrice().getUnits()));
			    // productOfferingPrice.setPriceWithTax(
			    // fillMoneyType(priceDetail.getPriceWithTax().getAmount(),
			    // priceDetail.getPriceWithTax().getUnits()));
			    // productOfferingPrice.setOriginalAmount(fillMoneyType(priceDetail.getOriginalAmount().getAmount(),
			    // priceDetail.getOriginalAmount().getUnits()));
			    // productOfferingPrice.setOriginalTaxAmount(fillMoneyType(priceDetail.getOriginalTaxAmount().getAmount(),
			    // priceDetail.getOriginalTaxAmount().getUnits()));
			    // }
			    //
			    // productOfferingPrice.setMinPrice(
			    // fillMoneyType(priceDetail.getMinPrice().getAmount(),
			    // priceDetail.getMinPrice().getUnits()));
			    // productOfferingPrice.setMaxPrice(
			    // fillMoneyType(priceDetail.getMaxPrice().getAmount(),
			    // priceDetail.getMaxPrice().getUnits()));
			    // productOfferingPrice.setTaxAmount(
			    // fillMoneyType(priceDetail.getTaxAmount().getAmount(),
			    // priceDetail.getTaxAmount().getUnits()));
			    //
			    // productOfferingPriceList.add(productOfferingPrice);

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
			additionalDataList
				.add(fillAdittionalData(Constant.TOP_RECOMMENDED, Boolean.toString(offering.getTopRecommended())));
			additionalDataList.add(fillAdittionalData(Constant.PRODUCRT_TYPE,
				Optional.ofNullable(productType).map(x -> x.toString()).orElse(null)));
			additionalDataList.add(fillAdittionalData(Constant.COMPATIBLE_WITH_DEVICE, offering.getCompatibleWithDevice()));
			additionalDataList.add(fillAdittionalData(Constant.MIN_NUM_SUBSCRIBERS, offering.getMinNumOfSubscribers()));
			additionalDataList.add(fillAdittionalData(Constant.NUM_SUBSCRIBERS, offering.getNumOfSubscribers()));
			additionalDataList.add(fillAdittionalData(Constant.SHARED_PLAN, offering.getSharedPlan()));

			offering.getAdditionalData().forEach(additionalData -> additionalDataList
				.add(fillAdittionalData(additionalData.getKey(), additionalData.getValue())));

			// TODO ANEXO 2 UPFRONT

			UpfrontFijaResponse upfrontFijaResponse = upfrontFija.getUpfrontFija(offersBenefitsRequestDto,
				aditionalSvaResponse.getOfferData().getLob());

			UpFrontType upFront = new UpFrontType();
			MoneyType price = new MoneyType();

			price.setAmount(upfrontFijaResponse.getValueAbp());
			price.setUnits(Constant.PERUVIAN_COIN);

			additionalDataList.add(fillAdittionalData(Constant.INSTALLATION_FEE_BO, upfrontFijaResponse.getCidBo()));
			additionalDataList
				.add(fillAdittionalData(Constant.PRODUCT_FOR_INST_FEE, upfrontFijaResponse.getProductForInstFee()));
			upFront.setPrice(price);

			refinedProduct.setSubProducts(subProductsList);
			refinedProduct.setProductCharacteristics(productCharacteristicsList);
			productSpecification.setRefinedProduct(refinedProduct);
			productSpecification.setProductPrice(productPriceList);
			productSpecificationList.add(productSpecification);
			offeringType.setUpFront(upFront);

			// TODO BENEFICIOS
			offeringType.setBenefits(getBenefits(offersBenefitsRequestDto, vProductOfferingID, downloadSpeed));

		    }

		}

	    }

	    offeringType.setCurrentPlanRelationID(categories.getCurrentPlanRelationId());

	    if (categories.getCategory() != null) {

		categoryList.add(fillCategory(categories.getCategory()));
	    }

	    // TODO PAGINACION
	    responseType.setPaginationInfo(fillPaginationInfo(categories.getPaginationInfo(), isInternet, downloadSpeed,
		    offersBenefitsRequestDto.getPaginationInfo().getPage()));
	    offeringType.setCustomerId(offersBenefitsRequestDto.getCustomerId());

	    String productPublicId = offersBenefitsRequestDto.getProduct().getPublicId();
	    String productType = offersBenefitsRequestDto.getProduct().getType();

	    if (StringUtil.isNullOrEmpty(productPublicId) && StringUtil.isNullOrEmpty(productType)) {

		List<ProductInventoryResponseDto> productInventory = parqueUnificadoConnection.callRestService(productPublicId,
			productType);

		offeringType.setCompatibleProducts(fillCompatibleProducts(productInventory));
	    }

	    offeringType.setBundledProductOffering(bundledProductOfferingList);
	    offeringType.setProductSpecification(productSpecificationList);
	    offeringType.setAdditionalData(additionalDataList);
	    offeringType.setCategory(categoryList);
	    offeringTypeList.add(offeringType);
	    responseType.setOfferings(offeringTypeList);
	}

	return responseType;
    }

    /**
     * El metodo retorna los campos poblados con los SVAS incluidos, obtenidos con
     * en la clase AdditionalSva
     * 
     * @param aditionalSvaResponse:
     *           response del metodo de los SVA adicionales de la oferta
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
		BigDecimal valueIgv = Util.igvCalculator(value);
		priceBenefit.setPriceType(Constant.RECURRING);

		priceBenefit.setPrice(fillMoneyType(value, Constant.PERUVIAN_COIN));
		priceBenefit.setPriceWithTax(fillMoneyType(valueIgv, Constant.PERUVIAN_COIN));

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

	String propertyValue = offersPropertiesRepository.findPropertyValue(offersBenefitsRequestDto.getProductOfferingCatalogId()).stream()
		.filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.RETENTION)).map(p -> p.getPropertyValue())
		.collect(Collectors.joining());

	String flagRetention;

	if (Boolean.TRUE.equals(offersBenefitsRequestDto.getIsRetention())) {
	    flagRetention = "'" + Constant.YES + "'";
	} else {
	    flagRetention = "'" + Constant.NO + "'";
	}

	List<SvaResponse> svaResponseList;

	List<OfferingType> offeringTypeList = new ArrayList<>();

	if (Constant.YES.equalsIgnoreCase(propertyValue)) {
	    svaResponseList = sva.getSvaTypeRetention(offersBenefitsRequestDto, flagRetention);

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
		    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.NOMBRE_SPS, ValueTypeEnum.STRINGWRAPPER,
			    billingOffer.getSpsIdAndName().getParentName()));

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

	} else {
	    svaResponseList = sva.getSvaTypeSva(offersBenefitsRequestDto, flagRetention);

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
		    BenefitType benefitType = new BenefitType();
		    List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();

		    productSpecification.setId(billingOffer.getBillingOffer().getChildId());
		    productSpecification.setName(billingOffer.getBillingOffer().getNameChild());
		    productSpecification.setProductType(ComposingProductType.ProductTypeEnum.SVA);

		    if (Constant.STB.equals(svaResponse.getIdComponent())) {
			productSpecification.setMaxCardinality(billingOffer.getMaxSTBsallowed());
		    }

		    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.SPSID, ValueTypeEnum.STRINGWRAPPER,
			    billingOffer.getSpsIdAndName().getParentId()));
		    productCharacteristicsList.add(fillProductCharacteristics(null, Constant.NOMBRE_SPS, ValueTypeEnum.STRINGWRAPPER,
			    billingOffer.getSpsIdAndName().getParentName()));

		    refinedProductType.setProductCharacteristics(productCharacteristicsList);
		    productSpecification.setRefinedProduct(refinedProductType);

		    productPrice.setName(Constant.PRECIO_SVA);
		    productPrice.setPriceType(billingOffer.getPriceType());
		    productPrice.setPrice(fillMoneyType(billingOffer.getAmount(), Constant.PERUVIAN_COIN));
		    productPrice.setProductSpecContainmentID(billingOffer.getBillingOffer().getRelationId());
		    productPrice.setPricePlanSpecContainmentID(billingOffer.getRelationId());

		    BigDecimal amoutIgv = Util.igvCalculator(billingOffer.getAmount());
		    productPrice.setTaxAmount(fillMoneyType(amoutIgv, Constant.PERUVIAN_COIN));

		    productPriceList.add(productPrice);
		    productSpecification.setProductPrice(productPriceList);

		    benefitType.setId(billingOffer.getVasBenefits().getBenefitComponentCid());
		    benefitType.setName(billingOffer.getNameComp());
		    benefitType.setDownloadSpeed(billingOffer.getVasBenefits().getSpeed());

		    characteristicsList
			    .add(fillCharacteristics(Constant.SPS_ID, billingOffer.getVasBenefits().getBenefitThemePackSpsCid()));
		    characteristicsList.add(fillCharacteristics(Constant.SPS_NAME, billingOffer.getParentName()));
		    characteristicsList.add(fillCharacteristics(Constant.BO_NAME, billingOffer.getNameBo()));
		    characteristicsList.add(fillCharacteristics(Constant.DURATION, billingOffer.getVasBenefits().getDuration()));
		    benefitType.setCharacteristics(characteristicsList);

		    benefitTypeList.add(benefitType);

		    productSpecificationList.add(productSpecification);

		    offeringType.setName(billingOffer.getBillingOffer().getNameParent());

		});

		offeringType.setBenefits(benefitTypeList);
		offeringType.setId(svaResponse.getIdComponent());
		offeringType.setProductSpecification(productSpecificationList);
		offeringTypeList.add(offeringType);

	    });

	}

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
    private StringWrapper fillProductCharacteristics(String id, String name, ValueTypeEnum enumValue, String value) {

	StringWrapper productCharacteristics = new StringWrapper();
	List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
	ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

	if (id != null) {
	    productCharacteristics.setId(id);
	    productCharacteristics.setName(name);
	    productCharacteristics.setValueType(enumValue);
	    productSpecCharacteristicValue.setValue(value);
	} else {
	    productCharacteristics.setName(name);
	    productCharacteristics.setValueType(enumValue);
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

	KeyValueType adittionalData = new KeyValueType();

	adittionalData.setKey(key);
	adittionalData.setValue(value);

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
	characteristics.setKey(key);
	characteristics.setValue(value);

	return characteristics;
    }

    /**
     * Metodo para poblar el atributo MoneyType
     * 
     * @param amount:
     *            monto
     * @param units:
     *            unidad monetaria
     * @return MoneyType: atributos poblados
     */

    private MoneyType fillMoneyType(BigDecimal amount, String units) {

	MoneyType moneyType = new MoneyType();
	moneyType.setAmount(amount);
	moneyType.setUnits(units);

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

	subcategories.setId(Optional.ofNullable(categories.getSubcategories()).map(x -> x.getId()).orElse(null));
	subcategories.setHref(Optional.ofNullable(categories.getSubcategories()).map(x -> x.getHref()).orElse(null));
	subcategories.setName(Optional.ofNullable(categories.getSubcategories()).map(x -> x.getName()).orElse(null));
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
    private PaginationInfoType fillPaginationInfo(PagingInfoOutputType paginationInfo, Boolean isInternet, String downloadSpeed,
	    Integer page) {

	PaginationInfoType paginationInfoType = new PaginationInfoType();

	BigDecimal totalPages;
	BigDecimal totalResults;
	paginationInfoType.last(false);
	paginationInfoType.setFirst(false);

	if (Boolean.TRUE.equals(isInternet)) {

	    BigDecimal speed = Optional.ofNullable(downloadSpeed).map(x -> new BigDecimal(x)).orElse(BigDecimal.valueOf(0));
	    totalPages = paginationInfo.getTotalResultsInCategory().add(speed).divide(paginationInfo.getItemsPerCategory());
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
