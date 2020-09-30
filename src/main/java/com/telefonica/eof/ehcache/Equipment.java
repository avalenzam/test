package com.telefonica.eof.ehcache;

import java.io.Serializable;

import lombok.Data;

@Data
public class Equipment implements Serializable {
 
    private static final long serialVersionUID = -989090952892483159L;
    private String cid;
    private String lob;
    private String networkTechnology;

}
