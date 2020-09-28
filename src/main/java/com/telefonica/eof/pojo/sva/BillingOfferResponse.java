package com.telefonica.eof.pojo.sva;

import java.math.BigDecimal;

import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.PriceTypeEnum;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: BillingOfferResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre el metodo
 *               getBillingOffer y el metodo principal de la clase
 *               AditionalSva.
 */
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
