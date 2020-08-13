package com.telefonica.eof.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.business.offering.AditionalSva;
import com.telefonica.eof.business.offering.Benefit;
import com.telefonica.eof.business.offering.UpfrontFija;
import com.telefonica.eof.business.sva.Sva2;
import com.telefonica.eof.commons.Util;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
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
import com.telefonica.eof.pojo.benefits.BenefitsResponse;
import com.telefonica.eof.pojo.productInventory.ProductInventoryResponseDto;
import com.telefonica.eof.pojo.sva.SvaResponse;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;
import com.telefonica.eof.proxy.offering.Offerings;
import com.telefonica.eof.proxy.productInventory.ParqueUnificadoConnection;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.globalintegration.services.retrieveofferings.v1.OfferingTypeOfferType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PlanBODetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceDetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.ProductTypeEnumType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

public class OffersBenefitsService {

    @Autowired
    private AditionalSva	       aditionalSva;
    @Autowired
    private UpfrontFija		       upfrontFija;
    @Autowired
    private Offerings		       offerings;
    @Autowired
    private Benefit		       benefit;
    @Autowired
    private Sva2		       sva;
    @Autowired
    private ParqueUnificadoConnection  parqueUnificadoConnection;
    @Autowired
    private OffersPropertiesRepository offersPropertiesRepository;

    public List<OfferingType> getOfferBenefitsFi(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	ResponseType responseType = new ResponseType();

	List<OfferingType> offeringTypeList = new ArrayList<>();
	
	
	List<OfferingType> svaList = getSva(offersBenefitsRequestDto);
	svaList.forEach(offeringSva -> {
	    offeringTypeList.add(offeringSva);
	});

	List<OfferingType> offerBenefitsList = getOfferAndBenefit(offersBenefitsRequestDto).getOfferings();

	PaginationInfoType paginationInfo = getOfferAndBenefit(offersBenefitsRequestDto).getPaginationInfo();
	
	offerBenefitsList.forEach(offering -> {
	    offeringTypeList.add(offering);
	});
	
	responseType.setOfferings(offeringTypeList);
	responseType.setPaginationInfo(paginationInfo);

	return offeringTypeList;

    }

    private ResponseType getOfferAndBenefit(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	RetrieveOfferingsResponseType rort = offerings.consult(offersBenefitsRequestDto);

	ResponseType responseType = new ResponseType();

	List<OfferingType> offeringTypeList = new ArrayList<>();

	OfferingType offeringType = new OfferingType();
	List<CategoryTreeType> categoryList = new ArrayList<>();
	List<ComposingOfferingType> bundledProductOfferingList = new ArrayList<>();
	List<ComposingProductType> productSpecificationList = new ArrayList<>();
	List<ComponentProdOfferPriceType> productOfferingPriceList = new ArrayList<>();
	List<KeyValueType> additionalDataList = new ArrayList<>();
	PaginationInfoType paginationInfo = new PaginationInfoType();

	rort.getCategories().forEach(categories -> {

	    CategoryTreeType category = new CategoryTreeType();
	    CategoryTreeType subcategories = new CategoryTreeType();

	    Boolean isInternet = null;
	    String downloadSpeed = null;

	    for (OfferingTypeOfferType offering : categories.getOfferings()) {

		ComposingProductType productSpecification = new ComposingProductType();
		RefinedProductType refinedProduct = new RefinedProductType();
		List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
		List<ComponentProdOfferPriceType> productPriceList = new ArrayList<>();
		List<ComposingProductType> subProductsList = new ArrayList<>();

		offeringType.setId(offering.getCatalogItemId());
		offeringType.setHref("/offerings/{categories[i].offerings[j].catalogItemId}");

		ProductTypeEnumType productType = null;
		BigDecimal amount = null;
		String vProductOfferingID = offering.getCatalogItemId();

		for (OfferingTypeOfferType children : offering.getChildren()) {
		    productType = children.getProductType().get(0);
		    if (ProductTypeEnumType.BROADBAND.equals(children.getProductType())) {
			isInternet = true;
			downloadSpeed = children.getPlanBoList().get(0).getPriceList().get(0).getDownloadSpeed();
			amount = children.getPlanBoList().get(0).getPriceList().get(0).getPrice().getAmount();
		    }

		}

		if (ProductTypeEnumType.BROADBAND.equals(productType)) {
		    String offeringName = offering.getName() + downloadSpeed + "Mbps";
		    offeringType.setName(offeringName);
		} else {
		    offeringType.setName(offering.getName());
		}

		offeringType.setDescription(offering.getDescription());
		BillingMethodEnum billingMethodEnum = BillingMethodEnum.fromValue(offering.getPlanType());
		offeringType.setBillingMethod(billingMethodEnum);
		offeringType.setIsBundle(offering.getIsBundle());

		offering.getBundledDetails().forEach(bundle -> {

		    ComposingOfferingType bundledProductOffering = new ComposingOfferingType();

		    bundledProductOffering.setName(bundle.getOfferingName());
		    bundledProductOffering.setPlanName(bundle.getPlanName());
		    bundledProductOffering.setDisplayName(bundle.getDisplayName());
		    bundledProductOffering.setImage(bundle.getImage());

		    bundledProductOfferingList.add(bundledProductOffering);
		});

		for (OfferingTypeOfferType children : offering.getChildren()) {

		    productSpecification.setId(children.getCatalogItemId());
		    productSpecification.setHref("/offerings/{categories[i].offerings[j].children[k].catalogItemId}");

		    if (ProductTypeEnumType.BROADBAND.equals(productType)) {
			productSpecification.setName(children.getName() + downloadSpeed + "Mbps");
		    } else {
			productSpecification.setName(children.getName());
		    }

		    // TODO el children trae una lista y el response solo soporta un tipo
		    // ProductTypeEnum
		    // ProductTypeEnum productType =
		    // ProductTypeEnum.fromValue(children.getProductType());
		    // productSpecification.setProductType();

		    productCharacteristicsList
			    .add(fillProductCharacteristics("businessType", ValueTypeEnum.STRING, children.getBusinessType()));
		    productCharacteristicsList
			    .add(fillProductCharacteristics("displayName", ValueTypeEnum.STRING, children.getDisplayName()));
		    // TODO TYPE NO EXISTE
		    // productCharacteristicsList.add(fillComposingProductTypeOPffering("type",
		    // ValueTypeEnum.STRING, children.get));
		    productCharacteristicsList
			    .add(fillProductCharacteristics("relationId", ValueTypeEnum.STRING, children.getRelationId()));
		    productCharacteristicsList
			    .add(fillProductCharacteristics("correlationId", ValueTypeEnum.STRING, children.getCorrelationId()));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("parentCatalogItemID", ValueTypeEnum.STRING, children.getParentCatalogItemID()));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("parentCatalogItemName", ValueTypeEnum.STRING, children.getParentCatalogItemName()));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("parentCurrentStatus", ValueTypeEnum.STRING, children.getParentCurrentStatus()));
		    productCharacteristicsList
			    .add(fillProductCharacteristics("parentAssignedID", ValueTypeEnum.STRING, children.getParentAssignedID()));
		    productCharacteristicsList.add(fillProductCharacteristics("planType", ValueTypeEnum.STRING, children.getPlanType()));
		    productCharacteristicsList.add(fillProductCharacteristics("topRecommended", ValueTypeEnum.STRING,
			    Boolean.toString(children.getTopRecommended())));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("compatibleWithDevice", ValueTypeEnum.STRING, children.getCompatibleWithDevice()));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("minNumOfSubscribers", ValueTypeEnum.STRING, children.getMinNumOfSubscribers()));
		    productCharacteristicsList
			    .add(fillProductCharacteristics("numOfSubscribers", ValueTypeEnum.STRING, children.getNumOfSubscribers()));
		    productCharacteristicsList
			    .add(fillProductCharacteristics("sharedPlan", ValueTypeEnum.STRING, children.getSharedPlan()));
		    productCharacteristicsList.add(fillProductCharacteristics("image", ValueTypeEnum.STRING, children.getImage()));
		    productCharacteristicsList.add(fillProductCharacteristics("banner", ValueTypeEnum.STRING, children.getBanner()));

		    children.getAdditionalData().forEach(additionalData -> {
			productCharacteristicsList
				.add(fillProductCharacteristics(additionalData.getKey(), ValueTypeEnum.STRING, additionalData.getValue()));

		    });

		    children.getPriceDetails().forEach(priceDetail -> {

			ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();
			MoneyType price = new MoneyType();
			MoneyType minPrice = new MoneyType();
			MoneyType maxPrice = new MoneyType();
			MoneyType taxAmount = new MoneyType();
			MoneyType priceWithTax = new MoneyType();
			MoneyType originalAmount = new MoneyType();
			MoneyType originalTaxAmount = new MoneyType();

			// TODO RETORNAN DIFERENTE TIPO DE ENUM
			// productPrice.setPriceType(ProductTypeEnum.valueOf(priceDetail.getPriceType()));

			price.setAmount(priceDetail.getPrice().getAmount());
			price.setUnits(priceDetail.getPrice().getUnits());
			minPrice.setAmount(priceDetail.getMinPrice().getAmount());
			minPrice.setUnits(priceDetail.getMinPrice().getUnits());
			maxPrice.setAmount(priceDetail.getMaxPrice().getAmount());
			maxPrice.setUnits(priceDetail.getMaxPrice().getUnits());
			taxAmount.setAmount(priceDetail.getTaxAmount().getAmount());
			taxAmount.setUnits(priceDetail.getTaxAmount().getUnits());
			priceWithTax.setAmount(priceDetail.getPriceWithTax().getAmount());
			priceWithTax.setUnits(priceDetail.getPriceWithTax().getUnits());
			originalAmount.setAmount(priceDetail.getOriginalAmount().getAmount());
			originalAmount.setUnits(priceDetail.getOriginalAmount().getUnits());
			originalTaxAmount.setAmount(priceDetail.getOriginalTaxAmount().getAmount());
			originalTaxAmount.setUnits(priceDetail.getOriginalTaxAmount().getUnits());

			productPrice.setPrice(price);
			productPrice.setMinPrice(minPrice);
			productPrice.setMaxPrice(maxPrice);
			productPrice.setTaxAmount(taxAmount);
			productPrice.setPriceWithTax(priceWithTax);
			productPrice.setOriginalAmount(originalAmount);
			productPrice.setOriginalTaxAmount(originalTaxAmount);
			productPriceList.add(productPrice);

		    });

		    for (PlanBODetailsType planBo : children.getPlanBoList()) {

			ComponentProdOfferPriceType productPrice = new ComponentProdOfferPriceType();
			MoneyType price = new MoneyType();
			MoneyType minPrice = new MoneyType();
			MoneyType maxPrice = new MoneyType();
			MoneyType taxAmount = new MoneyType();
			MoneyType priceWithTax = new MoneyType();
			MoneyType originalAmount = new MoneyType();
			MoneyType originalTaxAmount = new MoneyType();
			List<KeyValueType> additionalDataPlanBoList = new ArrayList<>();

			productPrice.setId(planBo.getBillingOfferId());
			productPrice.setName(planBo.getBillingOfferName());

			if (ProductTypeEnumType.BROADBAND.equals(productType)) {
			    productPrice.setDescription("PRECIO DEL PLAN DE INTERNET");
			} else if (ProductTypeEnumType.CABLE_TV.equals(productType)) {
			    productPrice.setDescription("PRECIO DEL PLAN DE TV");
			} else if (ProductTypeEnumType.LANDLINE.equals(productType)) {
			    productPrice.setDescription("PRECIO DEL PLAN DE VOZ");
			} else if (ProductTypeEnumType.SH_EQ.equals(productType)) {
			    productPrice.setDescription("PRECIO DEL PLAN EQUIPO COMPARTIDO");
			}

			planBo.getPriceDetails().forEach(priceDetail -> {

			    price.setAmount(priceDetail.getPrice().getAmount());
			    price.setUnits(priceDetail.getPrice().getUnits());
			    minPrice.setAmount(priceDetail.getMinPrice().getAmount());
			    minPrice.setUnits(priceDetail.getMinPrice().getUnits());
			    maxPrice.setAmount(priceDetail.getMaxPrice().getAmount());
			    maxPrice.setUnits(priceDetail.getMaxPrice().getUnits());
			    taxAmount.setAmount(priceDetail.getTaxAmount().getAmount());
			    taxAmount.setUnits(priceDetail.getTaxAmount().getUnits());
			    priceWithTax.setAmount(priceDetail.getPriceWithTax().getAmount());
			    priceWithTax.setUnits(priceDetail.getPriceWithTax().getUnits());
			    originalAmount.setAmount(priceDetail.getOriginalAmount().getAmount());
			    originalAmount.setUnits(priceDetail.getOriginalAmount().getUnits());
			    originalTaxAmount.setAmount(priceDetail.getOriginalTaxAmount().getAmount());
			    originalTaxAmount.setUnits(priceDetail.getOriginalTaxAmount().getUnits());

			    productPrice.setPrice(price);
			    productPrice.setMinPrice(minPrice);
			    productPrice.setMaxPrice(maxPrice);
			    productPrice.setTaxAmount(taxAmount);
			    productPrice.setPriceWithTax(priceWithTax);
			    productPrice.setOriginalAmount(originalAmount);
			    productPrice.setOriginalTaxAmount(originalTaxAmount);

			});

			planBo.getPlanInfo().forEach(planInfo -> {

			    KeyValueType additionalData = new KeyValueType();
			    additionalData.setKey(planInfo.getKey());
			    additionalData.setValue(planInfo.getValue());
			    additionalDataPlanBoList.add(additionalData);
			    productPrice.setAdditionalData(additionalDataPlanBoList);
			});

			productPriceList.add(productPrice);

			if (ProductTypeEnumType.BROADBAND.equals(productType)) {

			    planBo.getPriceList().forEach(priceList -> {

				ComponentProdOfferPriceType productPrice1 = new ComponentProdOfferPriceType();
				MoneyType price1 = new MoneyType();
				MoneyType priceWithTax1 = new MoneyType();
				List<KeyValueType> additionalDataPriceList = new ArrayList<>();

				productPrice1.setName("PRECIO DE LA VELOCIDAD" + priceList.getDownloadSpeed() + "MbpS");
				productPrice1.setPriceType(PriceTypeEnum.RECURRING);
				productPrice1.setRecurringChargePeriod(RecurringChargePeriodEnum.MONTHLY);

				price1.setAmount(priceList.getPrice().getAmount());
				price1.setUnits(priceList.getPrice().getUnits());
				priceWithTax1.setAmount(Util.igvCalculator(priceList.getPrice().getAmount()));
				priceWithTax1.setUnits(priceList.getPrice().getUnits());

				KeyValueType additionalData = new KeyValueType();
				additionalData.setKey("technology");
				additionalData.setValue(priceList.getTechnology());

				additionalDataPriceList.add(additionalData);
				productPrice1.setAdditionalData(additionalDataPriceList);
				productPrice1.setPrice(price);
				productPrice1.setMinPrice(minPrice);
				productPrice1.setMaxPrice(maxPrice);
				productPrice1.setTaxAmount(taxAmount);
				productPrice1.setPriceWithTax(priceWithTax);
				productPrice1.setOriginalAmount(originalAmount);
				productPrice1.setOriginalTaxAmount(originalTaxAmount);

				productPriceList.add(productPrice1);

			    });
			}

		    }
		    ;

		}
		;

		for (PriceDetailsType priceDetail : offering.getPriceDetails()) {

		    ComponentProdOfferPriceType productOfferingPrice = new ComponentProdOfferPriceType();
		    MoneyType price = new MoneyType();
		    MoneyType minPrice = new MoneyType();
		    MoneyType maxPrice = new MoneyType();
		    MoneyType taxAmount = new MoneyType();
		    MoneyType priceWithTax = new MoneyType();
		    MoneyType originalAmount = new MoneyType();
		    MoneyType originalTaxAmount = new MoneyType();

		    productOfferingPrice.setName(priceDetail.getDescription());
		    productOfferingPrice.setDescription("");

		    // TODO NECESITO UN TIPO PriceTypeEnum Y EL RESPONSE ME DEVUELVE UN
		    // PriceTypeProdAltType
		    // productOfferingPrice.setPriceType(PriceTypeEnum.fromValue(priceDetail.getPriceType()));

		    if (ProductTypeEnumType.BROADBAND.equals(productType)) {

			price.setAmount(priceDetail.getPrice().getAmount().add(amount));
			priceWithTax.setAmount(priceDetail.getPriceWithTax().getAmount().add(amount));
			originalAmount.setAmount(priceDetail.getOriginalAmount().getAmount().add(amount));
			originalTaxAmount.setAmount(priceDetail.getOriginalTaxAmount().getAmount().add(amount));
		    } else {
			price.setAmount(priceDetail.getPrice().getAmount());
			priceWithTax.setAmount(priceDetail.getPriceWithTax().getAmount());
			originalAmount.setAmount(priceDetail.getOriginalAmount().getAmount());
			originalTaxAmount.setAmount(priceDetail.getOriginalTaxAmount().getAmount());
		    }

		    price.setUnits(priceDetail.getPrice().getUnits());
		    minPrice.setAmount(priceDetail.getMinPrice().getAmount());
		    minPrice.setUnits(priceDetail.getMinPrice().getUnits());
		    maxPrice.setAmount(priceDetail.getMaxPrice().getAmount());
		    maxPrice.setUnits(priceDetail.getMaxPrice().getUnits());
		    taxAmount.setAmount(priceDetail.getTaxAmount().getAmount());
		    taxAmount.setUnits(priceDetail.getTaxAmount().getUnits());
		    priceWithTax.setUnits(priceDetail.getPriceWithTax().getUnits());
		    originalAmount.setUnits(priceDetail.getOriginalAmount().getUnits());
		    originalTaxAmount.setUnits(priceDetail.getOriginalTaxAmount().getUnits());

		    productOfferingPrice.setPrice(price);
		    productOfferingPrice.setMinPrice(minPrice);
		    productOfferingPrice.setMaxPrice(maxPrice);
		    productOfferingPrice.setTaxAmount(taxAmount);
		    productOfferingPrice.setPriceWithTax(priceWithTax);
		    productOfferingPrice.setOriginalAmount(originalAmount);
		    productOfferingPrice.setOriginalTaxAmount(originalTaxAmount);

		    productOfferingPriceList.add(productOfferingPrice);

		}
		;

		additionalDataList.add(fillAdittionalData("image", offering.getImage()));
		additionalDataList.add(fillAdittionalData("banner", offering.getBanner()));
		additionalDataList.add(fillAdittionalData("displayName", offering.getDisplayName()));
		additionalDataList.add(fillAdittionalData("relationId", offering.getRelationId()));
		additionalDataList.add(fillAdittionalData("idAssignedItem", offering.getCorrelationId()));
		additionalDataList.add(fillAdittionalData("parentCatalogItemID", offering.getParentCatalogItemID()));
		additionalDataList.add(fillAdittionalData("parentCatalogItemName", offering.getParentCatalogItemName()));
		additionalDataList.add(fillAdittionalData("parentCurrentStatus", offering.getParentCurrentStatus()));
		additionalDataList.add(fillAdittionalData("parentAssignedID", offering.getParentAssignedID()));
		additionalDataList.add(fillAdittionalData("topRecommended", Boolean.toString(offering.getTopRecommended())));
		additionalDataList.add(fillAdittionalData("productType", productType.toString()));
		additionalDataList.add(fillAdittionalData("compatibleWithDevice", offering.getCompatibleWithDevice()));
		additionalDataList.add(fillAdittionalData("minNumOfSubscribers", offering.getMinNumOfSubscribers()));
		additionalDataList.add(fillAdittionalData("numOfSubscribers", offering.getNumOfSubscribers()));
		additionalDataList.add(fillAdittionalData("sharedPlan", offering.getSharedPlan()));

		offering.getAdditionalData().forEach(additionalData -> {
		    additionalDataList.add(fillAdittionalData(additionalData.getKey(), additionalData.getValue()));
		});

		// TODO ANEXO 1 SVA INCLUIDOS

		subProductsList.add(svsincluding(offersBenefitsRequestDto, vProductOfferingID, downloadSpeed, productType));

		// TODO ANEXO 2 UPFRONT

		Integer velocidad = Integer.parseInt(downloadSpeed);
		AditionalSvaResponse aditionalSvaResponse = aditionalSva.getAditionalSva(vProductOfferingID, velocidad,
			offersBenefitsRequestDto.getNetworkTechnology(), offersBenefitsRequestDto.getCurrentOffering(),
			offersBenefitsRequestDto.getChannelId(), offersBenefitsRequestDto.getFields());

		UpfrontFijaResponse upfrontFijaResponse = upfrontFija.getUpfrontFija(offersBenefitsRequestDto.getCreditScore(),
			offersBenefitsRequestDto.getAction(), aditionalSvaResponse.getOfferData().getLob());

		UpFrontType upFront = new UpFrontType();
		MoneyType price = new MoneyType();

		price.setAmount(upfrontFijaResponse.getValueAbp());
		price.setUnits("PEN");

		additionalDataList.add(fillAdittionalData("INSTALLATION_FEE_BO", upfrontFijaResponse.getCidBo()));
		additionalDataList.add(fillAdittionalData("PRODUCT_FOR_INST_FEE", upfrontFijaResponse.getProductForInstFee()));
		upFront.setPrice(price);

		refinedProduct.setSubProducts(subProductsList);
		refinedProduct.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProduct);
		productSpecification.setProductPrice(productPriceList);
		productSpecificationList.add(productSpecification);
		offeringType.setUpFront(upFront);

		// TODO BENEFICIOS
		offeringType.setBenefits(fillBenefits(offersBenefitsRequestDto, vProductOfferingID, downloadSpeed));

	    }
	    ;

	    offeringType.setCurrentPlanRelationID(categories.getCurrentPlanRelationId());
	    category.setId(categories.getCategory().getId());
	    category.setHref(categories.getCategory().getHref());
	    category.setName(categories.getCategory().getName());
	    subcategories.setId(categories.getCategory().getSubcategories().getId());
	    subcategories.setHref(categories.getCategory().getSubcategories().getHref());
	    subcategories.setName(categories.getCategory().getSubcategories().getName());
	    category.setSubcategories(subcategories);

	    // TODO PAGINACION
	    BigDecimal totalPages;
	    BigDecimal totalResults;
	    if (isInternet == true) {
		BigDecimal speed = new BigDecimal(downloadSpeed);
		totalPages = categories.getPaginationInfo().getTotalResultsInCategory().add(speed)
			.divide(categories.getPaginationInfo().getItemsPerCategory());
		totalResults = categories.getPaginationInfo().getTotalResultsInCategory().add(speed);
		paginationInfo.setTotalPages(totalPages.intValue());
		paginationInfo.setTotalResults(totalResults.intValue());
	    } else {
		totalPages = categories.getPaginationInfo().getTotalResultsInCategory()
			.divide(categories.getPaginationInfo().getItemsPerCategory());
		totalResults = categories.getPaginationInfo().getTotalResultsInCategory();
		paginationInfo.setTotalPages(totalPages.intValue());
		paginationInfo.setTotalResults(totalResults.intValue());
	    }

	    if (categories.getPaginationInfo().isHasMore() != true) {
		paginationInfo.last(true);
	    } else {
		paginationInfo.last(false);
	    }

	    paginationInfo.setItemsPerPage(categories.getPaginationInfo().getItemsPerPage().intValue());
	    categoryList.add(category);

	    // TODO FAlta PAGINATION FIRST

	});

	offeringType.setCustomerId(offersBenefitsRequestDto.getCustomerId());

	String productPublicId = offersBenefitsRequestDto.getProduct().getPublicId();
	String productType = offersBenefitsRequestDto.getProduct().getType();

	if (StringUtil.isNullOrEmpty(productPublicId) && StringUtil.isNullOrEmpty(productType)) {

	    List<ProductInventoryResponseDto> productInventory = parqueUnificadoConnection.callRestService(productPublicId, productType);

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
	    offeringType.setCompatibleProducts(compatibleProductsList);
	}

	offeringType.setBundledProductOffering(bundledProductOfferingList);
	offeringType.setProductSpecification(productSpecificationList);
	offeringType.setAdditionalData(additionalDataList);
	offeringType.setCategory(categoryList);
	offeringTypeList.add(offeringType);
	responseType.setOfferings(offeringTypeList);
	responseType.setPaginationInfo(paginationInfo);

	return responseType;
    }

    private ComposingProductType svsincluding(OffersBenefitsRequestDto offersBenefitsRequestDto, String vProductOfferingID,
	    String downloadSpeed, ProductTypeEnumType productType) {

	Integer velocidad = Integer.parseInt(downloadSpeed);

	AditionalSvaResponse aditionalSvaResponse = aditionalSva.getAditionalSva(vProductOfferingID, velocidad,
		offersBenefitsRequestDto.getNetworkTechnology(), offersBenefitsRequestDto.getCurrentOffering(),
		offersBenefitsRequestDto.getChannelId(), offersBenefitsRequestDto.getFields());

	ComposingProductType offeringSubProducts = new ComposingProductType();
	RefinedProductType refinedProductType = new RefinedProductType();
	List<ComposingProductType> subProductsList = new ArrayList<>();
	ComposingProductType subProducts = new ComposingProductType();

	List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();

	if (ProductTypeEnumType.SH_EQ.equals(productType)) {
	    subProducts.setId(aditionalSvaResponse.getModem().getEquipmentCid());
	    subProducts.setName(aditionalSvaResponse.getModem().getNameComp());
	    subProducts.setProductType(ProductTypeEnum.DEVICE);
	    subProductsList.add(subProducts);

	    refinedProductType.setSubProducts(subProductsList);

	    StringWrapper productCharacteristics = new StringWrapper();
	    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
	    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

	    if (aditionalSvaResponse.getOfferData().getFlagModemPremium() == true) {

		productCharacteristics.setId("Equipment_Sub_Type");
		productCharacteristics.setName("Sub Tipo de Equipo");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue("Premium");
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);

	    } else {

		productCharacteristics.setId("Equipment_Sub_Type");
		productCharacteristics.setName("Sub Tipo de Equipo");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue("Básico");
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);

	    }

	    offeringSubProducts.setRefinedProduct(refinedProductType);

	}

	if (ProductTypeEnumType.CABLE_TV.equals(productType)) {

	    aditionalSvaResponse.getDecos().forEach(decos -> {

		StringWrapper productCharacteristics = new StringWrapper();
		List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
		ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

		subProducts.setId("3197701");
		subProducts.setName(decos.getCaption());
		subProducts.setProductType(ProductTypeEnum.DEVICE);
		subProductsList.add(subProducts);

		refinedProductType.setSubProducts(subProductsList);

		productCharacteristics.setId("STB_Type");
		productCharacteristics.setName("Tipo de Decodificador");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue(decos.getStbSetting());
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		// TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN
		productCharacteristicsList.add(productCharacteristics);

	    });

	    refinedProductType.setProductCharacteristics(productCharacteristicsList);
	}

	if ("null".equalsIgnoreCase(aditionalSvaResponse.getOfferData().getDefSpsBo())
		|| StringUtil.isNullOrEmpty(aditionalSvaResponse.getOfferData().getDefSpsBo())) {

	    if (ProductTypeEnumType.CABLE_TV.equals(productType)) {

		aditionalSvaResponse.getChannelBlock().forEach(channelBlock -> {

		    StringWrapper productCharacteristics = new StringWrapper();
		    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
		    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

		    subProducts.setId(channelBlock.getFdIdParent());
		    subProducts.setName(channelBlock.getFdNameParent());
		    subProducts.setProductType(ProductTypeEnum.SVA);
		    subProductsList.add(subProducts);

		    // poblar billing offer
		    productCharacteristics.setId(channelBlock.getCidBo());
		    productCharacteristics.setName("Billing Offer");
		    productCharacteristics.setValueType(ValueTypeEnum.STRING);
		    productSpecCharacteristicValue.setValue(channelBlock.getDescriptionText());
		    productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		    productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		    // poblar sps
		    productCharacteristics.setId(channelBlock.getDefSpsId());
		    productCharacteristics.setName("SPSID");
		    productCharacteristics.setValueType(ValueTypeEnum.STRING);
		    productSpecCharacteristicValue.setValue(channelBlock.getCNameParent());
		    productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		    productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		    productCharacteristicsList.add(productCharacteristics);

		});
		refinedProductType.setSubProducts(subProductsList);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
	    }
	}

	aditionalSvaResponse.getOtherSvas().forEach(otherSvas -> {

	    StringWrapper productCharacteristics = new StringWrapper();
	    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
	    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

	    if (ProductTypeEnumType.BROADBAND.equals(productType) && "3239962".equals(otherSvas.getParentId())) {

		subProducts.setId(otherSvas.getParentId());
		subProducts.setName(otherSvas.getNameComp());
		subProducts.setProductType(ProductTypeEnum.SVA);
		subProductsList.add(subProducts);

		productCharacteristics.setId(otherSvas.getCidBo());
		productCharacteristics.setName("Billing Offer");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue(otherSvas.getNameBo());
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		refinedProductType.setSubProducts(subProductsList);

	    } else if (ProductTypeEnumType.LANDLINE.equals(productType) && "2723922".equals(otherSvas.getParentId())) {

		subProducts.setId(otherSvas.getParentId());
		subProducts.setName(otherSvas.getNameComp());
		subProducts.setProductType(ProductTypeEnum.SVA);
		subProductsList.add(subProducts);

		productCharacteristics.setId(otherSvas.getCidBo());
		productCharacteristics.setName("Billing Offer");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue(otherSvas.getNameBo());
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		refinedProductType.setSubProducts(subProductsList);

	    }
	});

	offeringSubProducts.setRefinedProduct(refinedProductType);

	return offeringSubProducts;
    }

    private List<BenefitType> fillBenefits(OffersBenefitsRequestDto offersBenefitsRequestDto, String vProductOfferingID,
	    String downloadSpeed) {

	List<BenefitsResponse> benefitList = benefit.getBenefitDiscount(offersBenefitsRequestDto, vProductOfferingID, downloadSpeed);

	List<BenefitType> benefitTypeList = new ArrayList<>();
	List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();
	List<PriceBenefitType> priceBenefitsList = new ArrayList<>();

	benefitList.forEach(benefits -> {

	    BenefitType benefitType = new BenefitType();
	    PriceBenefitType priceBenefit = new PriceBenefitType();

	    benefitType.setId(benefits.getBenefits().getBenefitsComponentCid());
	    benefitType.setName(benefits.getNameComp());
	    benefitType.setDownloadSpeed(benefits.getBenefits().getSpeed());
	    benefitType.setType(benefits.getBenefits().getLob());

	    characteristicsList.add(fillCharacteristics("spsId", benefits.getBenefits().getBenefitThemePackSpsCid()));
	    characteristicsList.add(fillCharacteristics("spsName", benefits.getSpsName()));
	    characteristicsList.add(fillCharacteristics("BOID", benefits.getBenefits().getBenefitBillingOfferCid()));
	    characteristicsList.add(fillCharacteristics("BOName", benefits.getNameBo()));
	    characteristicsList.add(fillCharacteristics("duration", benefits.getBenefits().getDuration()));
	    characteristicsList.add(fillCharacteristics("NightInd", benefits.getBenefits().getNightInd()));

	    if ("Monetary".equalsIgnoreCase(benefits.getValueAbpType())) {

		BigDecimal value = new BigDecimal(benefits.getValueAbp());
		BigDecimal valueIgv = Util.igvCalculator(value);
		priceBenefit.setPriceType("recurring");

		priceBenefit.setPrice(fillMoneyType(value, "PEN"));
		priceBenefit.setPriceWithTax(fillMoneyType(valueIgv, "PEN"));

		priceBenefitsList.add(priceBenefit);
		benefitType.setPriceBenefits(priceBenefitsList);
	    }

	    benefitType.setCharacteristics(characteristicsList);
	    benefitTypeList.add(benefitType);
	});

	return benefitTypeList;

    }

    private List<OfferingType> getSva(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	String propertyValue = offersPropertiesRepository.getPropertyValue(offersBenefitsRequestDto.getProductOfferingCatalogId()).stream()
		.filter(x -> x.getNameOfProperty().equalsIgnoreCase("Retention")).map(p -> p.getPropertyValue())
		.collect(Collectors.joining());

	List<SvaResponse> svaResponse;

	List<OfferingType> offeringTypeList = new ArrayList<>();

	if ("Y".equalsIgnoreCase(propertyValue)) {
	    svaResponse = sva.getSvaTypeRetention(offersBenefitsRequestDto);

	    svaResponse.forEach(sva -> {

		OfferingType offeringType = new OfferingType();
		List<ComposingProductType> productSpecificationList = new ArrayList<>();

		sva.getBillingOffer().forEach(billingOffer -> {

		    ComposingProductType productSpecification = new ComposingProductType();
		    RefinedProductType refinedProductType = new RefinedProductType();
		    List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();

		    productSpecification.setId(billingOffer.getBillingOffer().getChildId());
		    productSpecification.setName(billingOffer.getBillingOffer().getNameChild());

		    // TODO FALTA CORREGIR el enum debe ser SVA RETENCION
		    productSpecification.setProductType(ProductTypeEnum.SVA);
		    productSpecification.setPeriodDuration(billingOffer.getBillingOffer().getDurationValue());

		    productCharacteristicsList
			    .add(fillProductCharacteristics("SPSID", ValueTypeEnum.STRING, billingOffer.getSpsIdAndName().getParentId()));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("NombreSPS", ValueTypeEnum.STRING, billingOffer.getSpsIdAndName().getParentName()));

		    refinedProductType.setProductCharacteristics(productCharacteristicsList);
		    productSpecification.setRefinedProduct(refinedProductType);

		    productSpecificationList.add(productSpecification);
		    offeringType.setName(billingOffer.getBillingOffer().getNameParent());

		});

		offeringType.setId(sva.getIdComponent());
		offeringType.setProductSpecification(productSpecificationList);
		offeringTypeList.add(offeringType);

	    });

	} else {
	    svaResponse = sva.getSvaTypeSva(offersBenefitsRequestDto);

	    svaResponse.forEach(sva -> {

		OfferingType offeringType = new OfferingType();
		List<ComposingProductType> productSpecificationList = new ArrayList<>();
		List<BenefitType> benefitTypeList = new ArrayList<>();

		sva.getBillingOffer().forEach(billingOffer -> {

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

		    if ("3197701".equals(sva.getIdComponent())) {
			productSpecification.setMaxCardinality(billingOffer.getMaxSTBsallowed());
		    }

		    productCharacteristicsList
			    .add(fillProductCharacteristics("SPSID", ValueTypeEnum.STRING, billingOffer.getSpsIdAndName().getParentId()));
		    productCharacteristicsList.add(
			    fillProductCharacteristics("NombreSPS", ValueTypeEnum.STRING, billingOffer.getSpsIdAndName().getParentName()));

		    refinedProductType.setProductCharacteristics(productCharacteristicsList);
		    productSpecification.setRefinedProduct(refinedProductType);

		    productPrice.setName("Precio SVA");
		    productPrice.setPriceType(billingOffer.getPriceType());
		    productPrice.setPrice(fillMoneyType(billingOffer.getAmount(), "PEN"));
		    BigDecimal amoutIgv = Util.igvCalculator(billingOffer.getAmount());
		    productPrice.setTaxAmount(fillMoneyType(amoutIgv, "PEN"));

		    productPriceList.add(productPrice);
		    productSpecification.setProductPrice(productPriceList);

		    benefitType.setId(billingOffer.getVasBenefits().getBenefitComponentCid());
		    benefitType.setName(billingOffer.getNameComp());
		    benefitType.setDownloadSpeed(billingOffer.getVasBenefits().getSpeed());

		    characteristicsList.add(fillCharacteristics("spsID", billingOffer.getVasBenefits().getBenefitThemePackSpsCid()));
		    characteristicsList.add(fillCharacteristics("spsName", billingOffer.getParentName()));
		    characteristicsList.add(fillCharacteristics("BOName", billingOffer.getNameBo()));
		    characteristicsList.add(fillCharacteristics("duration", billingOffer.getVasBenefits().getDuration()));
		    benefitType.setCharacteristics(characteristicsList);

		    benefitTypeList.add(benefitType);


		    productSpecificationList.add(productSpecification);
		    
		    offeringType.setName(billingOffer.getBillingOffer().getNameParent());

		});
		
		offeringType.setBenefits(benefitTypeList);
		offeringType.setId(sva.getIdComponent());
		offeringType.setProductSpecification(productSpecificationList);
		offeringTypeList.add(offeringType);

	    });

	}
	
	return offeringTypeList;

    }

    private StringWrapper fillProductCharacteristics(String name, ValueTypeEnum enumValue, String value) {

	StringWrapper productCharacteristics = new StringWrapper();
	List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
	ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();

	productCharacteristics.setName(name);
	productCharacteristics.setValueType(enumValue);
	productSpecCharacteristicValue.setValue(value);
	productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
	productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

	return productCharacteristics;
    }

    private KeyValueType fillAdittionalData(String key, String value) {

	KeyValueType adittionalData = new KeyValueType();

	adittionalData.setKey(key);
	adittionalData.setValue(value);

	return adittionalData;
    }

    private CharacteristicBenefitType fillCharacteristics(String key, String value) {

	CharacteristicBenefitType characteristics = new CharacteristicBenefitType();
	characteristics.setKey(key);
	characteristics.setValue(value);

	return characteristics;
    }

    private MoneyType fillMoneyType(BigDecimal amount, String units) {

	MoneyType moneyType = new MoneyType();
	moneyType.setAmount(amount);
	moneyType.setUnits(units);

	return moneyType;
    }

}
