package com.telefonica.eof.service;

import java.util.ArrayList;
import java.util.List;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.business.offering.AditionalSva;
import com.telefonica.eof.business.offering.UpfrontFija;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.generated.model.ComposingProductType;
import com.telefonica.eof.generated.model.ComposingProductType.ProductTypeEnum;
import com.telefonica.eof.generated.model.KeyValueType;
import com.telefonica.eof.generated.model.MoneyType;
import com.telefonica.eof.generated.model.OfferingType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicType;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicType.ValueTypeEnum;
import com.telefonica.eof.generated.model.ProductSpecCharacteristicValueType;
import com.telefonica.eof.generated.model.RefinedProductType;
import com.telefonica.eof.generated.model.StringWrapper;
import com.telefonica.eof.generated.model.UpFrontType;
import com.telefonica.eof.pojo.aditionalSva.AditionalSvaResponse;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;

public class OffersBenefitsService {

    private AditionalSva aditionalSva;
    private UpfrontFija upfrontFija;

    // TODO PARAMTROS EN DURO, CAMBIAR POR LOS DE AMDOCS

    public List<OfferingType> getOfferBenefitsFi(OffersBenefitsRequestDto offersBenefitsRequestDto, String vProductOfferingID,
	    Integer velocidad) {
	
	
	
	// Sva adicionales -> anexo 1
	List<OfferingType> offeringTypeList = new ArrayList<>();
	OfferingType offeringType = new OfferingType();

	AditionalSvaResponse aditionalSvaResponse = aditionalSva.getAditionalSva(vProductOfferingID, velocidad,
		offersBenefitsRequestDto.getNetworkTechnology(), offersBenefitsRequestDto.getCurrentOffering(),
		offersBenefitsRequestDto.getChannelId(), offersBenefitsRequestDto.getFields());

	List<ComposingProductType> productSpecificationList = new ArrayList<>();
	ComposingProductType productSpecification = new ComposingProductType();
	RefinedProductType refinedProductType = new RefinedProductType();
	List<ComposingProductType> subProductsList = new ArrayList<>();
	// crear un objeto por cada vez que lo llamo
	ComposingProductType subProducts = new ComposingProductType();
	List<ProductSpecCharacteristicType> productCharacteristicsList = new ArrayList<>();
	UpFrontType upFront = new UpFrontType();
	MoneyType price = new MoneyType();
	List<KeyValueType> additionalDataList = new ArrayList<>();
	KeyValueType additionalData = new KeyValueType();
	KeyValueType additionalData1 = new KeyValueType();
	
	// TODO CAMBIAR EL IR DE ABAJO POR -> SI offerings.children.productType = "
	// ShEq"
	if (velocidad == 2) {
	    subProducts.setId(aditionalSvaResponse.getModem().getEquipmentCid());
	    subProducts.setName(aditionalSvaResponse.getModem().getNameComp());
	    subProducts.setProductType(ProductTypeEnum.DEVICE);
	    subProductsList.add(subProducts);
	    // TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN *
	    refinedProductType.setSubProducts(subProductsList);
	    productSpecification.setRefinedProduct(refinedProductType);
	    productSpecificationList.add(productSpecification);
	    offeringType.setProductSpecification(productSpecificationList);

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

		// TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN
		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProductType);
		productSpecificationList.add(productSpecification);
		offeringType.setProductSpecification(productSpecificationList);

	    } else {

		productCharacteristics.setId("Equipment_Sub_Type");
		productCharacteristics.setName("Sub Tipo de Equipo");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue("Básico");
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		// TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN
		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProductType);
		productSpecificationList.add(productSpecification);
		offeringType.setProductSpecification(productSpecificationList);
	    }

	}

	// TODO CAMBIAR EL IR DE ABAJO POR -> Sí offerings.children.productType = "
	// cableTv"
	if (velocidad == 2) {

	   
	    aditionalSvaResponse.getDecos().forEach(decos -> {
		
		 StringWrapper productCharacteristics = new StringWrapper();
		    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
		    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();
		    
		subProducts.setId("3197701");
		subProducts.setName(decos.getCaption());
		subProducts.setProductType(ProductTypeEnum.DEVICE);
		subProductsList.add(subProducts);

		refinedProductType.setSubProducts(subProductsList);
		productSpecification.setRefinedProduct(refinedProductType);
		productSpecificationList.add(productSpecification);
		offeringType.setProductSpecification(productSpecificationList);

		productCharacteristics.setId("STB_Type");
		productCharacteristics.setName("Tipo de Decodificador");
		productCharacteristics.setValueType(ValueTypeEnum.STRING);
		productSpecCharacteristicValue.setValue(decos.getStbSetting());
		productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		// TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN
		productCharacteristicsList.add(productCharacteristics);
		refinedProductType.setProductCharacteristics(productCharacteristicsList);
		productSpecification.setRefinedProduct(refinedProductType);
		productSpecificationList.add(productSpecification);
		offeringType.setProductSpecification(productSpecificationList);

	    });

	    if ("null".equalsIgnoreCase(aditionalSvaResponse.getOfferData().getDefSpsBo())
		    || StringUtil.isNullOrEmpty(aditionalSvaResponse.getOfferData().getDefSpsBo())) {

		aditionalSvaResponse.getChannelBlock().forEach(channelBlock -> {
		    
		    StringWrapper productCharacteristics = new StringWrapper();
		    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
		    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();
		    

		    subProducts.setId(channelBlock.getFdIdParent());
		    subProducts.setName(channelBlock.getFdNameParent());
		    subProducts.setProductType(ProductTypeEnum.SVA);
		    subProductsList.add(subProducts);

		    refinedProductType.setSubProducts(subProductsList);
		    productSpecification.setRefinedProduct(refinedProductType);
		    productSpecificationList.add(productSpecification);
		    offeringType.setProductSpecification(productSpecificationList);

//		    poblar billing offer
		    productCharacteristics.setId(channelBlock.getCidBo());
		    productCharacteristics.setName("Billing Offer");
		    productCharacteristics.setValueType(ValueTypeEnum.STRING);
		    productSpecCharacteristicValue.setValue(channelBlock.getDescriptionText());
		    productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		    productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

//		    poblar sps 
		    productCharacteristics.setId(channelBlock.getDefSpsId());
		    productCharacteristics.setName("SPSID");
		    productCharacteristics.setValueType(ValueTypeEnum.STRING);
		    productSpecCharacteristicValue.setValue(channelBlock.getCNameParent());
		    productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
		    productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

		    
		    // TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN
		    productCharacteristicsList.add(productCharacteristics);
		    refinedProductType.setProductCharacteristics(productCharacteristicsList);
		    productSpecification.setRefinedProduct(refinedProductType);
		    productSpecificationList.add(productSpecification);
		    offeringType.setProductSpecification(productSpecificationList);
		});

		aditionalSvaResponse.getOtherSvas().forEach(otherSvas -> {
		    StringWrapper productCharacteristics = new StringWrapper();
		    List<ProductSpecCharacteristicValueType> productSpecCharacteristicValueTypeList = new ArrayList<>();
		    ProductSpecCharacteristicValueType productSpecCharacteristicValue = new ProductSpecCharacteristicValueType();
		    
		    
//		    TODO FALTA AGREGAR EN EL IF -> Sí offerings.children.productType = " Broadband" 
		    if ("3239962".equals(otherSvas.getParentId())) {
			
			
			subProducts.setId(otherSvas.getParentId());
			subProducts.setName(otherSvas.getNameComp());
			subProducts.setProductType(ProductTypeEnum.SVA);
			subProductsList.add(subProducts);

			refinedProductType.setSubProducts(subProductsList);
			productSpecification.setRefinedProduct(refinedProductType);
			productSpecificationList.add(productSpecification);
			offeringType.setProductSpecification(productSpecificationList);

			productCharacteristics.setId(otherSvas.getCidBo());
			productCharacteristics.setName("Billing Offer");
			productCharacteristics.setValueType(ValueTypeEnum.STRING);
			productSpecCharacteristicValue.setValue(otherSvas.getNameBo());
			productSpecCharacteristicValueTypeList.add(productSpecCharacteristicValue);
			productCharacteristics.setProductSpecCharacteristicValue(productSpecCharacteristicValueTypeList);

			// TODO VERIFICAR ESTE RESPONSE CON TODOS LOS QUE SE REPITEN
			productCharacteristicsList.add(productCharacteristics);
			refinedProductType.setProductCharacteristics(productCharacteristicsList);
			productSpecification.setRefinedProduct(refinedProductType);
			productSpecificationList.add(productSpecification);
			offeringType.setProductSpecification(productSpecificationList);
			
//		TODO FALTA AGREGAR EN EL IF -> Sí offerings.children.productType = " landline" 
		    }else if ("2723922".equals(otherSvas.getParentId())) {
			
		    }
		});
	    }

	}
	
	// upfront fija -> anexo 2
	
	UpfrontFijaResponse upfrontFijaResponse = upfrontFija.getUpfrontFija(offersBenefitsRequestDto.getCreditScore(), offersBenefitsRequestDto.getAction(), aditionalSvaResponse.getOfferData().getLob());
	
	price.setAmount(upfrontFijaResponse.getValueAbp());
	price.setUnits("PEN");
	additionalData.setKey("INSTALLATION_FEE_BO");
	additionalData.setValue(upfrontFijaResponse.getCidBo());
	additionalData1.setKey("PRODUCT_FOR_INST_FEE");
	additionalData1.setValue(upfrontFijaResponse.getProductForInstFee());
	
	additionalDataList.add(additionalData1);
	additionalDataList.add(additionalData);
	upFront.setPrice(price);
	
	offeringType.setUpFront(upFront);
	offeringType.setAdditionalData(additionalDataList);
	
	
	
	return offeringTypeList;
    }

}
