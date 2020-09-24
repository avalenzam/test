package com.telefonica.eof;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.telefonica.eof.business.sva.Sva;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.entity.InstallationFee;
import com.telefonica.eof.generated.model.OfferingType;
import com.telefonica.eof.generated.model.ResponseType;
import com.telefonica.eof.pojo.Broadband;
import com.telefonica.eof.pojo.PaginationInfo;
import com.telefonica.eof.pojo.Product;
import com.telefonica.eof.pojo.sva.SvaResponse;
import com.telefonica.eof.proxy.offering.Offerings;
import com.telefonica.eof.repository.InstallationFeeRepository;
import com.telefonica.eof.repository.UpfrontRepository;
import com.telefonica.eof.rest.OfferingsApiController;
import com.telefonica.eof.service.OffersBenefitsService;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

@SpringBootTest
class ServiceTest {

    private OffersBenefitsRequestDto offersBenefitsRequestDto;


    @Autowired
    private Offerings offerings;

    @Autowired
    private Sva sva;

    @Autowired
    private OffersBenefitsService offersBenefitsService;

    @Autowired
    private UpfrontRepository upfrontRepository;
    @Autowired
    private InstallationFeeRepository installationFeeRepository;
    
    @Autowired
    private OfferingsApiController offeringsApiController;

    
    @BeforeEach
    void Before() {

	offersBenefitsRequestDto = new OffersBenefitsRequestDto();
	Broadband broadband = new Broadband();
	PaginationInfo paginationInfo = new PaginationInfo();
	Product product = new Product();

	

	offersBenefitsRequestDto.setCategoryId("3195941");
	offersBenefitsRequestDto.setChannelId("CC");
	offersBenefitsRequestDto.setCustomerId("56843169");
	product.setType("landline,sva");//
	offersBenefitsRequestDto.setProduct(product);
	offersBenefitsRequestDto.setCreditLimit(BigDecimal.valueOf(500));//
	offersBenefitsRequestDto.setRegion("15");//
	offersBenefitsRequestDto.setCustomerSegment("R");//
	offersBenefitsRequestDto.setCustomerSubsegment("RNA");//
	offersBenefitsRequestDto.setDealerId("61200");//
	offersBenefitsRequestDto.setCreditScore(9999);
	broadband.setMinDlDataRate(60);//
	broadband.setConnection("TV_CATV;INT_GPON;VOIC_VOIP");
	offersBenefitsRequestDto.setBroadband(broadband);
	offersBenefitsRequestDto.setBroadband(broadband);
	offersBenefitsRequestDto.setIsRetention(false);//
	offersBenefitsRequestDto.setProductOfferingCatalogId("32952011");//
	offersBenefitsRequestDto.setAction("PR");
	offersBenefitsRequestDto.setCommercialAreaId("1");
	offersBenefitsRequestDto.setSiteId("61200001");//
	offersBenefitsRequestDto.setSourceType("OFFER");
	offersBenefitsRequestDto.setNetworkTechnology("FTTH;HFC;COPPER");
	offersBenefitsRequestDto.setServiceabilityMaxSpeed("999999");
	offersBenefitsRequestDto.setServiceabilityId("1234");
	paginationInfo.setSize(100);
	paginationInfo.setPageCount(1);
	paginationInfo.setPage(1);
	paginationInfo.setMaxResultCount(1);
	offersBenefitsRequestDto.setPaginationInfo(paginationInfo);
	offersBenefitsRequestDto.setSortCriteriaName("NAME");
	offersBenefitsRequestDto.setSortCriteriaAscending(true);
	offersBenefitsRequestDto.setServiceabilityMaxSpeed("500");//



    }

    @Test
    void Test() {
	
	String crediScore = String.valueOf(offersBenefitsRequestDto.getCreditScore() % 10);
	String upfront = upfrontRepository.findUpfront().stream()
		.filter(x -> x.getUpfrontIndDesc().contains(crediScore))
    		.map(p -> p.getUpfrontIndId()).collect(Collectors.joining());
	System.out.println(upfront);
	InstallationFee installationFee = installationFeeRepository.findBoUpfront(offersBenefitsRequestDto.getAction(), "Voice+Internet+TV", upfront);
	System.out.println(installationFee);
    }

    @Test
    void OferingsTest() {

	RetrieveOfferingsResponseType rort = offerings.consult(offersBenefitsRequestDto);
	System.out.println(rort.getCategories());
    }

    @Test
    void SvaTest() {

	String flagRetention;
	if (offersBenefitsRequestDto.getIsRetention()) {
	    flagRetention = "'" + Constant.YES + "'";
	    List<SvaResponse> svaListRetention = sva.getSvaTypeRetention(offersBenefitsRequestDto, flagRetention);
	    System.out.println(svaListRetention);

	} else {

	    System.out.println("entro no");
	    flagRetention = "'" + Constant.NO + "'";
	    List<SvaResponse> svaList = sva.getSvaTypeSva(offersBenefitsRequestDto, flagRetention);
	    System.out.println(svaList);
	}

    }

    @Test
    void OffersBenefitsServiceTest() {
	ResponseType offering = offersBenefitsService.getOfferBenefitsFi(offersBenefitsRequestDto);
	System.out.println(offering);
    }
    
    
    
    @Test
    void OfferingsApiControllerTest() {
//	offeringsApiController.getOfferings(null, null,null, null, offersBenefitsRequestDto.getCorrelationId(),
//		offersBenefitsRequestDto.getName(), offersBenefitsRequestDto.getIsBundle(),
//		offersBenefitsRequestDto.getLifeCycleStatus(),  
//		offersBenefitsRequestDto.getCategoryId(), offersBenefitsRequestDto.getCategoryId(),
//		offersBenefitsRequestDto.getSubcategoryId(), offersBenefitsRequestDto.getSubcategoryName(), 
//		offersBenefitsRequestDto.getChannelId(), offersBenefitsRequestDto.getChannelName(),
//		offersBenefitsRequestDto.getProductSpecificationId(), offersBenefitsRequestDto.getProductSpecificationName(),
//		offersBenefitsRequestDto.getFrameworkAgreeementId(), offersBenefitsRequestDto.getCustomerId(), 
//		offersBenefitsRequestDto.getAccountId(), offersBenefitsRequestDto.getProduct().getType(),
//		offersBenefitsRequestDto.getProduct().getId(), offersBenefitsRequestDto.getProduct().getPublicId(),
//		offersBenefitsRequestDto.getStartDate(), offersBenefitsRequestDto.getEndDate(),
//		offersBenefitsRequestDto.getLimit(), offersBenefitsRequestDto.getOffset(), 
//		offersBenefitsRequestDto.getProductOfferingPrice().getPriceUnits(),
//		offersBenefitsRequestDto.getProductOfferingPrice().getCurrencyChangeDate(),
//		offersBenefitsRequestDto.getProductOfferingPrice().getStartPriceDate(),
//		offersBenefitsRequestDto.getProductOfferingPrice().getEndPriceDate(), 
//		offersBenefitsRequestDto.getProductOfferingPrice().getPriceConsumerEntityType(),
//		offersBenefitsRequestDto.getProductOfferingPrice().getPriceConsumerId(), 
//		offersBenefitsRequestDto.getProductOfferingPrice().getPriceLocation(),
//		offersBenefitsRequestDto.getProductOfferingPrice().getStartPriceAmout(), 
//		offersBenefitsRequestDto.getProductOfferingPrice().getEndPriceAmout(), 
//		offersBenefitsRequestDto.getFields(), offersBenefitsRequestDto.getCreditScore(),
//		offersBenefitsRequestDto.getCreditLimit(), offersBenefitsRequestDto.getSiteId(), 
//		offersBenefitsRequestDto.getRegion(), offersBenefitsRequestDto.getStateOrProvince(), 
//		offersBenefitsRequestDto.getCustomerSegment(), offersBenefitsRequestDto.getCustomerSubsegment(),
//		offersBenefitsRequestDto.getIsPortability(), offersBenefitsRequestDto.getPortability().getCurrentPlanType(),
//		offersBenefitsRequestDto.getPortability().getCustomerSince(), offersBenefitsRequestDto.getPortability().getCurrentCompany(),
//		offersBenefitsRequestDto.getDealerId(), offersBenefitsRequestDto.getBroadband().getMinDlDataRate(),
//		offersBenefitsRequestDto.getBroadband().getMaxDlDataRate(), offersBenefitsRequestDto.getBroadband().getConnection(),
//		offersBenefitsRequestDto.getIsRetention(), offersBenefitsRequestDto.getProductOfferingCatalogId(),
//		offersBenefitsRequestDto.getCurrentOffering(), offersBenefitsRequestDto.getIsUpgrade(),
//		offersBenefitsRequestDto.getAction(), offersBenefitsRequestDto.getCommercialAreaId(),
//		offersBenefitsRequestDto.getProductOrderId(), offersBenefitsRequestDto.getPlan().getId(),
//		offersBenefitsRequestDto.getPlan().getType(), offersBenefitsRequestDto.getSourceType(),
//		offersBenefitsRequestDto.getNetworkTechnology(), offersBenefitsRequestDto.getServiceabilityMaxSpeed(),
//		offersBenefitsRequestDto.getServiceabilityId(), offersBenefitsRequestDto.getPlan().getGroup(),
//		offersBenefitsRequestDto.getPlan().getRankInitial(), offersBenefitsRequestDto.getPlan().getRank(), 
//		offersBenefitsRequestDto.getPlan().getCommitmentDuration(), offersBenefitsRequestDto.getInvoiceCompany(),
//		offersBenefitsRequestDto.getOrderSubType(), offersBenefitsRequestDto.getSubscriberGroupValue(), 
//		offersBenefitsRequestDto.getExcludeOffersId(), offersBenefitsRequestDto.getPaginationInfo().getSize(),
//		offersBenefitsRequestDto.getPaginationInfo().getPageCount(), offersBenefitsRequestDto.getPaginationInfo().getPage(),
//		offersBenefitsRequestDto.getPaginationInfo().getMaxResultCount(), offersBenefitsRequestDto.getSortCriteriaName(), 
//		offersBenefitsRequestDto.getSortCriteriaAscending());
    }

    


}
