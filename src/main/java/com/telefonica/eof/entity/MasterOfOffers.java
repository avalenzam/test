package com.telefonica.eof.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MasterOfOffers {

    private String id;
    
    private String offerCid;

    private String offerCaption;
    
    private String nameOffer;
    
    private String offerLastVersion;

    private LocalDateTime dateBegin;

    private LocalDateTime dateEnd;

    private String descriptionText;
}
