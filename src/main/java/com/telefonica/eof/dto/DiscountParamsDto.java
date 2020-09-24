package com.telefonica.eof.dto;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: Sva.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description:  DTO de parametros enviados a la base de datos, tabla WIRELINES_SERVICE_BENEFITS.
 */
@Data
public class DiscountParamsDto {

    private String channelId;
    // id oferta amdocs
    private String catalogItemID; 
    private String action;
    private Boolean isPortability;
    private String currentOffering;
    private String broadbandConnection;
    private String networkTechnology;
    private String commercialAreaId;
    // viene de amdocs
    private String downloadSpeed;
}
