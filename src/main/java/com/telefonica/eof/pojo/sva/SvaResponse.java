package com.telefonica.eof.pojo.sva;

import java.util.List;

import lombok.Data;

@Data
public class SvaResponse {

    private List<BillingOfferResponse> billingOffer;
    private String idComponent;
}
