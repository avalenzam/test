package com.telefonica.eof.ehcache;

import java.io.Serializable;

import lombok.Data;

@Data
public class PlanCid implements Serializable{

    private static final long serialVersionUID = -2846492526922836961L;
    private String offerCaption;
    private String offerCid;
    private String departamento;
    private String dealerCode;
    private String storeId;
}
