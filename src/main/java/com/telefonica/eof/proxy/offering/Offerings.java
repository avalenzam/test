package com.telefonica.eof.proxy.offering;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.enums.OfferingHeaderEnum;

import com.telefonica.globalintegration.header.HeaderInType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.ProductTypeEnumType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsRequestType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

/**
 * 
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: June 2020
 * @FileName: Offerings.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los métodos necesarios para consumir el servicio
 *               Amdocs.
 */
@Service
public class Offerings {

    @Autowired
    OfferingsConnection offeringsConnection;

    @Autowired
    OfferingsRequestParamsFill offeringsRequestParamsFill;

    public RetrieveOfferingsResponseType consult(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	RetrieveOfferingsRequestType rort = new RetrieveOfferingsRequestType();

	
	rort.setCategory(offeringsRequestParamsFill.getCategory(offersBenefitsRequestDto));
	rort.setChannelId(offersBenefitsRequestDto.getChannelId());
	rort.setCustomerId(new BigDecimal(offersBenefitsRequestDto.getCustomerId()));

	List<ProductTypeEnumType> productType = new ArrayList<>();
	productType.add(ProductTypeEnumType.fromValue(offersBenefitsRequestDto.getProduct().getType()));
	rort.setProductType(productType);

	rort.setProductId(offersBenefitsRequestDto.getProduct().getId());
	rort.setProductOfferingCatalogId(Arrays.asList(offersBenefitsRequestDto.getProductOfferingCatalogId()));
	rort.setProductOrderId(offersBenefitsRequestDto.getProductOrderId());
	rort.setCatalogID(offersBenefitsRequestDto.getPlan().getId());
	rort.setFilterInfo(offeringsRequestParamsFill.getFilterInfo(offersBenefitsRequestDto));

	HeaderInType headerInType = new HeaderInType();

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
	headerInType.setTimestamp(OfferingHeaderEnum.TIMESTAMP.getValue());
	headerInType.setMsgType(OfferingHeaderEnum.MSGTYPE.getValue());

	JAXBElement<RetrieveOfferingsResponseType> response = offeringsConnection.callWebService(Constant.URL_OFFERINGS_SERVICE, rort,
		Constant.METHOD_OFFERINGS_SERVICE, headerInType);

	return response.getValue();
    }

}
