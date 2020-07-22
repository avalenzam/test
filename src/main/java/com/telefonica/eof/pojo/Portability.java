package com.telefonica.eof.pojo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Portability {

    private String currentPlanType;
    private LocalDate customerSince;
    private String currentCompany;
}
