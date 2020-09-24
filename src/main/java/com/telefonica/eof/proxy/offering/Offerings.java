package com.telefonica.eof.proxy.offering;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.enums.OfferingHeaderEnum;
import com.telefonica.globalintegration.header.HeaderInType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.ProductTypeEnumType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsRequestType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: Offerings.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los métodos necesarios para consumir el servicio
 *               Amdocs.
 */
@Component
public class Offerings {

    @Autowired
    private OfferingsConnection offeringsConnection;

    @Autowired
    private OfferingsRequestParamsFill offeringsRequestParamsFill;

    public RetrieveOfferingsResponseType consult(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	RetrieveOfferingsRequestType rort = new RetrieveOfferingsRequestType();

	rort.setCategory(offeringsRequestParamsFill.getCategory(offersBenefitsRequestDto));
	rort.setChannelId(offersBenefitsRequestDto.getChannelId());

	rort.setCustomerId(new BigDecimal(offersBenefitsRequestDto.getCustomerId()));

	String optionalProductType = Optional.ofNullable(offersBenefitsRequestDto.getProduct()).map(x -> x.getType()).orElse(null);
	List<String> productTypeList = Arrays.asList(optionalProductType.split(","));
	List<ProductTypeEnumType> productTypeEnumList = new ArrayList<>();

	productTypeList.forEach(productType -> {

	    productTypeEnumList.add(ProductTypeEnumType.fromValue(productType));

	});

	rort.getProductType().addAll(productTypeEnumList);
	rort.setProductId(Optional.ofNullable(offersBenefitsRequestDto.getProduct()).map(x -> x.getId()).orElse(null));
	rort.setProductOfferingCatalogId(Arrays.asList(offersBenefitsRequestDto.getProductOfferingCatalogId()));
	rort.setProductOrderId(offersBenefitsRequestDto.getProductOrderId());
	rort.setCatalogID(Optional.ofNullable(offersBenefitsRequestDto.getPlan()).map(x -> x.getId()).orElse(null));
	rort.setFilterInfo(offeringsRequestParamsFill.getFilterInfo(offersBenefitsRequestDto));

	HeaderInType headerInType = new HeaderInType();
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	headerInType.setCountry(OfferingHeaderEnum.COUNTRY.getValue());
	headerInType.setLang(OfferingHeaderEnum.LANG.getValue());
	headerInType.setEntity(OfferingHeaderEnum.ENTITY.getValue());
	headerInType.setSystem(OfferingHeaderEnum.SYSTEM.getValue());
	headerInType.setSubsystem(OfferingHeaderEnum.SUBSYSTEM.getValue());
	headerInType.setOriginator(OfferingHeaderEnum.ORIGINATOR.getValue());
	headerInType.setUserId(OfferingHeaderEnum.USERID.getValue());
	headerInType.setOperation(OfferingHeaderEnum.OPERATION.getValue());
	headerInType.setDestination(OfferingHeaderEnum.DESTINATION.getValue());
	headerInType.setExecId(OfferingHeaderEnum.EXECID.getValue());
	headerInType.setTimestamp(timestamp.toInstant().toString());

	JAXBElement<RetrieveOfferingsResponseType> response = offeringsConnection.callWebService(Constant.URL_OFFERINGS_SERVICE, rort,
		Constant.METHOD_OFFERINGS_SERVICE, headerInType);

	return response.getValue();

    }

}
