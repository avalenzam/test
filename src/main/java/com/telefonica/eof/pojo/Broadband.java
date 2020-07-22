package com.telefonica.eof.pojo;

import lombok.Data;

@Data
public class Broadband {

    private Integer minDlDataRate;
    private Integer maxDlDataRate;
    private String connection;
}
