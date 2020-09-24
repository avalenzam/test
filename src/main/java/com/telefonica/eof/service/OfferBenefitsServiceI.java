package com.telefonica.eof.service;

import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.generated.model.ResponseType;

public interface OfferBenefitsServiceI {
    public ResponseType getOfferBenefitsFi(OffersBenefitsRequestDto offersBenefitsRequestDto) throws Exception;

}
