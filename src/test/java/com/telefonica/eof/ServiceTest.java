package com.telefonica.eof;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;

import com.telefonica.eof.business.sva.Sva;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.ehcache.CacheOffersPropertiesCharge;
import com.telefonica.eof.ehcache.CachePlanCidCharge;
import com.telefonica.eof.ehcache.Equipment;
import com.telefonica.eof.ehcache.PlanCid;
import com.telefonica.eof.ehcache.CacheEquipmentCharge;
import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.enums.HttpsErrorMessage;
import com.telefonica.eof.exception.HttpException;
import com.telefonica.eof.generated.model.ResponseType;
import com.telefonica.eof.pojo.Broadband;
import com.telefonica.eof.pojo.PaginationInfo;
import com.telefonica.eof.pojo.Product;
import com.telefonica.eof.pojo.sva.SvaResponse;
import com.telefonica.eof.proxy.offering.Offerings;
import com.telefonica.eof.repository.EquipmentRepository;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.service.OffersBenefitsService;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Results;
import net.sf.ehcache.search.expression.Criteria;

@SpringBootTest
class ServiceTest {

    private OffersBenefitsRequestDto request;

    @Autowired
    private Offerings offerings;

    @Autowired
    private Sva sva;

    @Autowired
    private OffersBenefitsService offersBenefitsService;

    @Autowired
    private OffersPropertiesRepository offersPropertiesRepository;

    @Autowired
    private CacheEquipmentCharge cacheEquipmentCharge;
    
    @Autowired
    private CacheOffersPropertiesCharge cacheOffersPropertiesCharge;
    
    @Autowired
    private CachePlanCidCharge cachePlanCidCharge;

    @BeforeEach
    void Before() {

	request = new OffersBenefitsRequestDto();
	Broadband broadband = new Broadband();
	PaginationInfo paginationInfo = new PaginationInfo();
	Product product = new Product();

	request.setCategoryId("3195941");
	request.setChannelId("CC");
	 request.setCustomerId("56843169");
	product.setType("landline");//
	request.setProduct(product);
	request.setCreditLimit(BigDecimal.valueOf(500));//
	request.setRegion("15");//
	request.setCustomerSegment("R");//
	request.setCustomerSubsegment("RNA");//
	request.setDealerId("61200");//
	request.setCreditScore(9999);
	broadband.setMinDlDataRate(60);//
	broadband.setConnection("TV_CATV;INT_GPON;VOIC_VOIP");
	request.setBroadband(broadband);
	request.setIsRetention(false);//
	request.setProductOfferingCatalogId("32952011");
	request.setAction("PR");
	request.setCommercialAreaId("1");
	request.setSiteId("61200001");//
	request.setSourceType("OFFER");
	request.setNetworkTechnology("FTTH;HFC;COPPER");
	request.setServiceabilityMaxSpeed("999999");
	request.setServiceabilityId("1234");
	paginationInfo.setSize(100);
	paginationInfo.setPageCount(1);
	paginationInfo.setPage(1);
	paginationInfo.setMaxResultCount(1);
	request.setPaginationInfo(paginationInfo);
	request.setSortCriteriaName("NAME");
	request.setSortCriteriaAscending(true);
//	request.setServiceabilityMaxSpeed("500");//


    }

    @Test
    void TestEhcacheEquipment() {

	String lobvalue = "Voice+TV";
	String networkvalue = "HFC";

	Map<String, List<Equipment>> equipmentMap = cacheEquipmentCharge.getEquipment();
	System.out.println(equipmentMap.get(lobvalue));
	String equipmentList = equipmentMap.get(lobvalue).stream().filter(x -> x.getNetworkTechnology().contains(networkvalue))
		.map(Equipment::getCid).collect(Collectors.joining());
	System.out.println(equipmentList);
    }
    
    @Test
    void TestEhcacheOffersProperties() {

	String offerCid = "34465865";
	 Map<String, List<OffersProperties>> offersPropertiesMap = cacheOffersPropertiesCharge.getOffersProperties();
	 List<OffersProperties> offersPropertiesList=offersPropertiesMap.get(offerCid);
	 List<OffersProperties> offersProperties = offersPropertiesRepository.findPropertyValue(offerCid);
	System.out.println(offersPropertiesList);
	System.err.println("offersProperties :"+ offersProperties);
    }
    
    @Test
    void TestEhcachePlanCid() {

	String offerCid = "34191511";
	String departamento = "15";
	String asterisk = "\\\\*|";
	
	Map<String, List<PlanCid>> planCidMap = cachePlanCidCharge.getPlanCid();
	List<PlanCid> planCidList=planCidMap.get(offerCid);
//	String planCid = planCidList.stream().filter(x -> x.getDepartamento().contains("*|15"))
//		.map(PlanCid::getOfferCaption).collect(Collectors.joining());
//	
	System.out.println(asterisk.concat(departamento));
	Boolean planCid = planCidList.stream().anyMatch(x -> x.getDepartamento().equalsIgnoreCase(Constant.ASTERISK) || x.getDepartamento().equalsIgnoreCase(departamento)
		&& x.getDealerCode().equalsIgnoreCase(Constant.ASTERISK) || x.getDealerCode().equalsIgnoreCase(departamento)
		&&  x.getStoreId().equalsIgnoreCase(Constant.ASTERISK) || x.getStoreId().equalsIgnoreCase(departamento));
	
	System.out.println("planCid :" + planCid);

    }

    @Test
    void Test() {

	Boolean flagType = Optional.ofNullable(request.getProduct()).map(x -> x.getType().contains("sva")).orElse(null);
	System.out.println(flagType);

	List<String> productOfferingCatalogIdList = Arrays.asList(request.getProduct().getType().split(","));

	System.err.println(productOfferingCatalogIdList);

	String e = "SVC1001:Missing Mandatory Parameter";
	HttpException httpException = new HttpException();
	String soapErrorCode = e.substring(0, 7);

	for (HttpsErrorMessage http : HttpsErrorMessage.values()) {
	    if (http.getExceptionId().equalsIgnoreCase(soapErrorCode)) {

		httpException.setMessage(http.getMessage());
	    }

	}

	System.out.println(httpException);

    }

    @Test
    void OferingsTest() {

	RetrieveOfferingsResponseType rort = offerings.consult(request);
	System.out.println(rort.getCategories());
    }

    @Test
    void SvaTest() {

	List<OffersProperties> propertyValueList = offersPropertiesRepository.findPropertyValue(request.getProductOfferingCatalogId());
	List<String> productOfferingCatalogIdList = Arrays.asList(request.getProductOfferingCatalogId().split(","));

	productOfferingCatalogIdList.forEach(productOfferingCatalogId -> {
	    String flagRetention;
	    if (request.getIsRetention()) {
		flagRetention = "'" + Constant.YES + "'";
		List<SvaResponse> svaListRetention = sva.getSvaTypeRetention(request, flagRetention, propertyValueList,
			productOfferingCatalogId);
		System.out.println(svaListRetention);

	    } else {

		System.out.println("entro no");
		flagRetention = "'" + Constant.NO + "'";
		List<SvaResponse> svaList = sva.getSvaTypeSva(request, flagRetention, propertyValueList, productOfferingCatalogId);
		if (svaList == null || svaList.isEmpty()) {
		    System.out.println("vacio");
		}
		System.out.println(svaList);
	    }
	});

    }

    @Test
    void OffersBenefitsServiceTest() throws Exception {
	ResponseType offering = offersBenefitsService.getOfferBenefitsFi(request);
	System.out.println(offering);
    }

}
