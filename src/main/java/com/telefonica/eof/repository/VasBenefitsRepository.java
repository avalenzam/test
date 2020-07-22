package com.telefonica.eof.repository;

import com.telefonica.eof.dto.SvaBenefitParamsDto;
import com.telefonica.eof.entity.VasBenefits;

public interface VasBenefitsRepository {
    public  VasBenefits getSvaBenefits(SvaBenefitParamsDto svaBenefitParamsDto, String dataRateFrom, String dataRateTo);

}
