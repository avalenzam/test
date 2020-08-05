package com.telefonica.eof.pojo.aditionalSva;

import java.util.List;

import lombok.Data;

@Data
public class AditionalSvaResponse {
    
    private OfferDataResponse offerData;
    private ModemResponse modem;
    private List<DecosResponse> decos;
    private List<ChannelBlockResponse> channelBlock;
    private List<OtherSvasResponse> otherSvas;
}
