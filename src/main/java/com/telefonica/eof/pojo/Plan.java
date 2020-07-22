package com.telefonica.eof.pojo;

import lombok.Data;

@Data
public class Plan {
    
    private String id;
    private String type;
    private String group;
    private String rankInitial;
    private String rank;
    private String commitmentDuration;

}
