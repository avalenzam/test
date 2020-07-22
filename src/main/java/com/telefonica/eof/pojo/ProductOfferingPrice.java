package com.telefonica.eof.pojo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class ProductOfferingPrice {

    private String priceUnits;
    private OffsetDateTime currencyChangeDate;
    private OffsetDateTime startPriceDate;
    private OffsetDateTime endPriceDate;
    private String priceConsumerEntityType;
    private String priceConsumerId;
    private String priceLocation;
    private BigDecimal startPriceAmout;
    private BigDecimal endPriceAmout;
}
