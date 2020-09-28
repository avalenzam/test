package com.telefonica.eof.pojo.aditionalSva;

import java.util.List;

import lombok.Data;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: AditionalSvaResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre la clase
 *               AditionalSva y el OffersBenefitsService
 */
@Data
public class AditionalSvaResponse {

    private OfferDataResponse	       offerData;
    private ModemResponse	       modem;
    private List<DecosResponse>	       decos;
    private List<ChannelBlockResponse> channelBlock;
    private List<OtherSvasResponse>    otherSvas;
}
