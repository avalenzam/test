package com.telefonica.eof.service;

import java.util.List;

import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.generated.model.OfferingType;

public interface OfferBenefitsServiceI {
    public List<OfferingType> getOfferBenefitsFi(OffersBenefitsRequestDto offersBenefitsRequestDto) throws Exception;

}
