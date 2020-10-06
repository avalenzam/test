package com.telefonica.eof.business.offering;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.entity.InstallationFee;
import com.telefonica.eof.entity.Upfront;
import com.telefonica.eof.pojo.upfrontFija.UpfrontFijaResponse;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.InstalFeeNoRiskRepository;
import com.telefonica.eof.repository.InstallationFeeRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.UpfrontRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: UpfrontFija.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: El servicio obtiene el indicador Upfront de la oferta fija
 */
@Component
public class UpfrontFija {

    @Autowired
    private PricePropertiesRepository	 pricePropertiesRepository;
    @Autowired
    private UpfrontRepository		 upfrontRepository;
    @Autowired
    private InstallationFeeRepository	 installationFeeRepository;
    @Autowired
    private InstalFeeNoRiskRepository	 instalFeeNoRiskRepository;
    @Autowired
    private BillingOfferMasterRepository billingOfferMasterRepository;

    /**
     * Método principal de la clase. Obtiene los sva adicionales como parte de la
     * oferta que viene de AMDOCS
     * 
     * @param offersBenefitsRequestDto:
     *            viene del front
     * @return UpfrontFijaResponse: id,producto y precio de instalacion
     */
    public UpfrontFijaResponse getUpfrontFija(OffersBenefitsRequestDto offersBenefitsRequestDto, String lob) {

	UpfrontFijaResponse upfrontFijaResponse = new UpfrontFijaResponse();
	String crediScore = String.valueOf(offersBenefitsRequestDto.getCreditScore() % 10);
	String upfront = upfrontRepository.findUpfront().stream().filter(x -> x.getUpfrontIndDesc().contains(crediScore))
		.map(Upfront::getUpfrontIndId).collect(Collectors.joining());

	InstallationFee installationFee = installationFeeRepository.findBoUpfront(offersBenefitsRequestDto.getAction(), lob, upfront);

	if (installationFee != null) {
	    BigDecimal upfrontPrice;
	    if (Constant.YES.equalsIgnoreCase(upfront)) {

		upfrontPrice = pricePropertiesRepository.findUpfrontPrice(installationFee.getInstallationFeeBo());

	    } else {
		upfrontPrice = instalFeeNoRiskRepository.findRate(offersBenefitsRequestDto.getChannelId(),
			offersBenefitsRequestDto.getInstallationAddressDepartment());
	    }
	    String cidBo = billingOfferMasterRepository.findCidBoBycaptionBo(installationFee.getInstallationFeeBo());

	    upfrontFijaResponse.setCidBo(cidBo);
	    upfrontFijaResponse.setProductForInstFee(installationFee.getProductForInstFee());
	    upfrontFijaResponse.setValueAbp(upfrontPrice);
	}

	return upfrontFijaResponse;

    }
}
