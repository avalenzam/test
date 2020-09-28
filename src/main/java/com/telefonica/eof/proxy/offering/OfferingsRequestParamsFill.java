package com.telefonica.eof.proxy.offering;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.commons.Util;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryTreeTypeType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.FilterInfoType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PagingInfoType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.SortCriteriaType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.UNIKeyValueType;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: OfferingsRequestParamsFill.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los metodos necesarios para poblar el request de
 *               AMDOCS con el request que llega del front
 */
@Component
public class OfferingsRequestParamsFill {

    public CategoryTreeTypeType getCategory(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	CategoryTreeTypeType category = new CategoryTreeTypeType();
	CategoryTreeTypeType subcategory = new CategoryTreeTypeType();

	category.setId(offersBenefitsRequestDto.getCategoryId());
	category.setName(offersBenefitsRequestDto.getCategoryName());

	if (!(StringUtil.isNullOrEmpty(offersBenefitsRequestDto.getSubcategoryId())
		|| StringUtil.isNullOrEmpty(offersBenefitsRequestDto.getSubcategoryName()))) {

	    subcategory.setId(offersBenefitsRequestDto.getSubcategoryId());
	    subcategory.setName(offersBenefitsRequestDto.getSubcategoryName());
	    category.setSubcategories(subcategory);
	}

	return category;
    }

    public FilterInfoType getFilterInfo(OffersBenefitsRequestDto offersBenefitsRequestDto) {

	FilterInfoType fit = new FilterInfoType();

	fit.setName(offersBenefitsRequestDto.getName());

	if (offersBenefitsRequestDto.getFields() != null) {
	    fit.setFilterFacets(this.getFilterFacets(offersBenefitsRequestDto.getFields()));
	}

	fit.setCreditScore(String.valueOf(offersBenefitsRequestDto.getCreditScore()));
	fit.setDepartament(offersBenefitsRequestDto.getRegion());
	fit.setCustomerType(offersBenefitsRequestDto.getCustomerSegment());

	String isPortability = String.valueOf(offersBenefitsRequestDto.getIsPortability());

	if (StringUtil.isNullOrEmpty(isPortability)) {
	    fit.setPortInFlag(isPortability);

	}

	fit.setDealerCode(offersBenefitsRequestDto.getDealerId());

	String minDlDataRate = String.valueOf(offersBenefitsRequestDto.getBroadband().getMinDlDataRate());
	String maaxDlDataRate = String.valueOf(offersBenefitsRequestDto.getBroadband().getMaxDlDataRate());

	if (StringUtil.isNullOrEmpty(minDlDataRate)) {
	    fit.setOfferMaxInternetSpeed(minDlDataRate);
	}

	if (StringUtil.isNullOrEmpty(maaxDlDataRate)) {
	    fit.setOfferMinInternetSpeed(minDlDataRate);
	}

	fit.setServiceTechnology(Optional.ofNullable(offersBenefitsRequestDto.getBroadband()).map(x -> x.getConnection()).orElse(null));

	String portInFlag = String.valueOf(offersBenefitsRequestDto.getIsRetention());

	if (StringUtil.isNullOrEmpty(portInFlag)) {
	    fit.setRetentionFlag(portInFlag);
	}

	fit.setActionType(offersBenefitsRequestDto.getAction());
	fit.setCommercialZoneId(offersBenefitsRequestDto.getCommercialAreaId());
	fit.setStoreId(offersBenefitsRequestDto.getSiteId());
	fit.setSourceProductOfferingId(offersBenefitsRequestDto.getCurrentOffering());
	fit.setSourceType(Constant.OFFER);
	fit.setNetworkTechnology(offersBenefitsRequestDto.getNetworkTechnology());
	fit.setMaxSpeed(offersBenefitsRequestDto.getServiceabilityMaxSpeed());
	fit.setServiceabilityID(offersBenefitsRequestDto.getServiceabilityId());
	fit.setPlanGroup(Optional.ofNullable(offersBenefitsRequestDto.getPlan()).map(x -> x.getGroup()).orElse(null));
	fit.setPlanRank(Optional.ofNullable(offersBenefitsRequestDto.getPlan()).map(x -> x.getRank()).orElse(null));
	fit.setPlanCommitmentDuration(
		Optional.ofNullable(offersBenefitsRequestDto.getPlan()).map(x -> x.getCommitmentDuration()).orElse(null));
	fit.setInvoiceCompany(offersBenefitsRequestDto.getInvoiceCompany());
	if (offersBenefitsRequestDto.getPaginationInfo() != null) {
	    fit.setPaginationInfo(this.getPaginationInfo(offersBenefitsRequestDto.getPaginationInfo().getSize(),
		    offersBenefitsRequestDto.getPaginationInfo().getPageCount(), offersBenefitsRequestDto.getPaginationInfo().getPage(),
		    offersBenefitsRequestDto.getPaginationInfo().getMaxResultCount()));
	}

	fit.getSortCriteria().addAll(
		this.getSortCriteria(offersBenefitsRequestDto.getSortCriteriaName(), offersBenefitsRequestDto.getSortCriteriaAscending()));

	return fit;
    }

    private List<UNIKeyValueType> getFilterFacets(String fields) {

	return Util.getListSplit(fields, Constant.COMMA).stream().map(this::getFilterFacet).collect(Collectors.toList());
    }

    private UNIKeyValueType getFilterFacet(String element) {

	UNIKeyValueType ukvt = new UNIKeyValueType();

	List<String> subcategories = Util.getListSplit(element, Constant.DOBLEPOINT);

	ukvt.setKey(subcategories.get(0));
	ukvt.setValue(subcategories.get(1));

	return ukvt;
    }

    private PagingInfoType getPaginationInfo(Integer paginationInfoSize, Integer paginationInfoPageCount, Integer paginationInfoPage,
	    Integer paginationInfoMaxResultCount) {

	PagingInfoType pit = new PagingInfoType();

	pit.setPageSize(new BigDecimal(paginationInfoSize));
	pit.setPageCount(new BigDecimal(paginationInfoPageCount));
	pit.setPageNumber(new BigDecimal(paginationInfoPage));
	pit.setMaxResultCount(new BigDecimal(paginationInfoMaxResultCount));

	return pit;
    }

    private List<SortCriteriaType> getSortCriteria(String sortCriteriaName, Boolean sortCriteriaAscending) {

	SortCriteriaType sct = new SortCriteriaType();

	sct.setPropertyName(sortCriteriaName);
	sct.setIsAscending(sortCriteriaAscending);

	return Arrays.asList(sct);
    }

}
