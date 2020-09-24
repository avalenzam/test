package com.telefonica.eof.dto;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: Sva.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description:  DTO de parametros enviados a la base de datos, tabla VAS BENNEFITS.
 */
@Data
public class SvaBenefitParamsDto {
    
    private String channelId;
    private String offerCaption; 
    private String action;
    private Boolean isPortability;
    private String orderSubType ;
    private String broadbandConnection;
    private String networkTechnology;
    private String commercialAreaId;
    private String parentId;
    private String iDcomponente;

}
