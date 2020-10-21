package com.telefonica.eof.pojo;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import lombok.Data;

@Data
public class ProductOfferingPrice {

    private String priceUnits;
    private DateTime currencyChangeDate;
    private DateTime startPriceDate;
    private DateTime endPriceDate;
    private String priceConsumerEntityType;
    private String priceConsumerId;
    private String priceLocation;
    private BigDecimal startPriceAmout;
    private BigDecimal endPriceAmout;
}
