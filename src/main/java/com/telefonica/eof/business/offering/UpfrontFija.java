package com.telefonica.eof.business.offering;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.entity.InstallationFee;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.InstalFeeNoRiskRepository;
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

    public UpfrontFijaResponse getUpfrontFija (OffersBenefitsRequestDto offersBenefitsRequestDto, String lob) {
	
	UpfrontFijaResponse upfrontFijaResponse = new UpfrontFijaResponse();
	
	String upfront = upfrontRepository.findUpfront().stream()
		.filter(x -> x.getUpfrontIndDesc().contains(offersBenefitsRequestDto.getCreditScore().toString()))
    		.map(p -> p.getUpfrontIndId()).collect(Collectors.joining());

	InstallationFee installationFee = installationFeeRepository.findBoUpfront(offersBenefitsRequestDto.getAction(), lob, upfront);

	BigDecimal upfrontPrice;
	
	if (Constant.YES.equalsIgnoreCase(upfront)) {
	    
	    upfrontPrice = pricePropertiesRepository.findUpfrontPrice(installationFee.getInstallationFeeBo());
	  
	}else {
	    upfrontPrice = instalFeeNoRiskRepository.findRate(offersBenefitsRequestDto.getChannelId(), offersBenefitsRequestDto.getInstallationAddressDepartment());
	
	}
	
	String cidBo = billingOfferMasterRepository.findCidBoBycaptionBo(installationFee.getInstallationFeeBo());
	
	upfrontFijaResponse.setCidBo(cidBo);
	upfrontFijaResponse.setProductForInstFee(installationFee.getProductForInstFee());
	upfrontFijaResponse.setValueAbp(upfrontPrice);
	
	return upfrontFijaResponse;
	
    }
}
