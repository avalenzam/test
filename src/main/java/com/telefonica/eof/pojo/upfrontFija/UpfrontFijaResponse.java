package com.telefonica.eof.pojo.upfrontFija;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpfrontFijaResponse {

    private BigDecimal valueAbp;
    private String productForInstFee;
    private String cidBo;
}
