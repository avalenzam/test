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
import com.telefonica.eof.enums.HttpsErrorMessage;
import com.telefonica.eof.exception.HttpException;
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

    private OffersBenefitsRequestDto request;
    private OffersBenefitsRequestDto request2;

    @Autowired
    private Offerings offerings;

    @Autowired
    private Sva sva;

    @Autowired
    private OffersBenefitsService offersBenefitsService;
   
    @BeforeEach
    void Before() {

	request = new OffersBenefitsRequestDto();
	Broadband broadband = new Broadband();
	PaginationInfo paginationInfo = new PaginationInfo();
	Product product = new Product();

	request.setCategoryId("3195941");
	request.setChannelId("CC");
//	request.setCustomerId("56843169");
	product.setType("landline,sva");//
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
	request.setProductOfferingCatalogId("32952011");//
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
	request.setServiceabilityMaxSpeed("500");//
	
	
	
	request2 = new OffersBenefitsRequestDto();
	Broadband broadband2 = new Broadband();
	Product product2 = new Product();

	request2.setCategoryId("3195941");
	request2.setChannelId("CC");
	request2.setCustomerId("56843169");
	product2.setType("broadband,landline,cableTv");//
	request2.setProduct(product2);
	request2.setCreditScore(9999);
	request2.setCreditLimit(BigDecimal.valueOf(999));//
	request2.setRegion("15");//
	request2.setCustomerSegment("R");
	request2.setIsPortability(false);
	request2.setDealerId("05650");//
	broadband2.setConnection("TV_CATV;INT_GPON;VOIC_VOIP");
	request2.setBroadband(broadband2);
	request2.setIsRetention(false);//
	request2.setAction("PR");
	request2.setCommercialAreaId("1");
	request2.setSiteId("05650001");//
	request2.setSourceType("OFFER");
	request2.setNetworkTechnology("HFC");
	request2.setServiceabilityMaxSpeed("999999");
	request2.setServiceabilityId("1234");
	request2.setInstallationAddressDepartment("15");
	
	request2.setSortCriteriaAscending(true);
	



    }

    @Test
    void Test() {
	
	String e = "SVC1001:Missing Mandatory Parameter";
	HttpException httpException = new HttpException();
	String soapErrorCode = e.substring(0, 7);

	for (HttpsErrorMessage http : HttpsErrorMessage.values()) {
	    if (http.getExceptionId().equalsIgnoreCase(soapErrorCode)) {
		
		httpException.setExceptionId(http.getExceptionId());
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

	String flagRetention;
	if (request.getIsRetention()) {
	    flagRetention = "'" + Constant.YES + "'";
	    List<SvaResponse> svaListRetention = sva.getSvaTypeRetention(request, flagRetention);
	    System.out.println(svaListRetention);

	} else {

	    System.out.println("entro no");
	    flagRetention = "'" + Constant.NO + "'";
	    List<SvaResponse> svaList = sva.getSvaTypeSva(request, flagRetention);
	    System.out.println(svaList);
	}

    }

    @Test
    void OffersBenefitsServiceTest() throws Exception {
	ResponseType offering = offersBenefitsService.getOfferBenefitsFi(request);
	System.out.println(offering);
    }
    
    
    
  
}
