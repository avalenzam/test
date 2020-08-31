package com.telefonica.eof.pojo.sva;

import java.math.BigDecimal;

import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.PriceTypeEnum;

import lombok.Data;

@Data
public class BillingOfferResponse {
    private RelationMaster billingOffer;
    private Integer maxSTBsallowed;
    private Sps spsIdAndName;
    private PriceTypeEnum priceType;
    private BigDecimal amount;
    private VasBenefits vasBenefits;
    private String nameComp;
    private String parentName;
    private String nameBo;
    private String relationId;

}
