package com.telefonica.eof.repository;

import java.util.List;

import com.telefonica.eof.dto.DiscountParamsDto;
import com.telefonica.eof.entity.WirelineServiceBenefits;

public interface WirelineServiceBenefitsRepository {
    
    public  List<WirelineServiceBenefits>  findBenefits(DiscountParamsDto discountParamsDto );

}
