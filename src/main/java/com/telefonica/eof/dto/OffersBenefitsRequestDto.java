package com.telefonica.eof.dto;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.telefonica.eof.pojo.Broadband;
import com.telefonica.eof.pojo.PaginationInfo;
import com.telefonica.eof.pojo.Plan;
import com.telefonica.eof.pojo.Portability;
import com.telefonica.eof.pojo.Product;
import com.telefonica.eof.pojo.ProductOfferingPrice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: OffersBenefitsRequestDto.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Request enviado del front
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OffersBenefitsRequestDto {
    
    private String type;
    private String correlationId;
    private String name;
    private Boolean isBundle;
    private String lifeCycleStatus;
    private String categoryId;
    private String categoryName;
    private String subcategoryId;
    private String subcategoryName;
    private String channelId;
    private String channelName;
    private String productSpecificationId;
    private String productSpecificationName;
    private String frameworkAgreeementId;
    private String customerId;
    private String accountId;
    private Product product;
    private DateTime startDate;
    private DateTime endDate;
    private String limit;
    private String offset;
    private ProductOfferingPrice productOfferingPrice;
    private String fields;
    private Integer creditScore;
    private BigDecimal creditLimit;
    private String siteId;
    private String region;
    private String stateOrProvince;
    private String customerSegment;
    private String customerSubsegment;
    private Boolean isPortability;
    private Portability portability;
    private String dealerId;
    private Broadband broadband;
    private Boolean isRetention;
    private String productOfferingCatalogId;
    private String currentOffering;
    private Boolean isUpgrade;
    private String action;
    private String commercialAreaId;
    private String productOrderId;
    private Plan plan;
    // productPlanType: Hace referencia al campo Product del spect.Recibe Postpaid, Prepaid,...
    private String productPlanType;
    private String sourceType;
    private String networkTechnology;
    private String serviceabilityMaxSpeed;
    private String serviceabilityId;
    private String invoiceCompany;
    private String orderSubType;
    private String subscriberGroupValue;
    private String excludeOffersId;
    private String installationAddressDepartment;
    private String nationalId;
    private String nationalIdType;
    private PaginationInfo paginationInfo;
    private String sortCriteriaName;
    private Boolean sortCriteriaAscending;

}
