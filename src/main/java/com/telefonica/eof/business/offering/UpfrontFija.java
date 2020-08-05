package com.telefonica.eof.business.offering;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.telefonica.eof.entity.InstallationFee;
import com.telefonica.eof.jdbc.InstalFeeNoRiskRepository;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.InstallationFeeRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.UpfrontRepository;

public class UpfrontFija {
    
    @Autowired
    private PricePropertiesRepository	      pricePropertiesRepository;
    @Autowired
    private UpfrontRepository upfrontRepository;
    @Autowired
    private InstallationFeeRepository installationFeeRepository;
    @Autowired
    private InstalFeeNoRiskRepository instalFeeNoRiskRepository;
    @Autowired
    private BillingOfferMasterRepository billingOfferMasterRepository;

    public UpfrontFijaResponse getUpfrontFija (Integer score, String action, String lob) {
	
	UpfrontFijaResponse upfrontFijaResponse = new UpfrontFijaResponse();
	
	String upfront = upfrontRepository.getUpfront().stream()
		.filter(x -> x.getUpfrontIndDesc().contains(score.toString()))
    		.map(p -> p.getUpfrontIndId()).collect(Collectors.joining());

	InstallationFee installationFee = installationFeeRepository.getBoUpfront(action, lob, upfront);

	BigDecimal upfrontPrice;
	
	if ("Y".equalsIgnoreCase(upfront)) {
	    
	    upfrontPrice = pricePropertiesRepository.getUpfrontPrice(installationFee.getInstallationFeeBo());
	  
	}else {
	    upfrontPrice = instalFeeNoRiskRepository.getUpfrontPrice(null, null);
	
	}
	
	String cidBo = billingOfferMasterRepository.getCidBo(installationFee.getInstallationFeeBo());
	
	upfrontFijaResponse.setCidBo(cidBo);
	upfrontFijaResponse.setProductForInstFee(installationFee.getProductForInstFee());
	upfrontFijaResponse.setValueAbp(upfrontPrice);
	
	return upfrontFijaResponse;
	
    }
}
