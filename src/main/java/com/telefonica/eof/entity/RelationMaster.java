package com.telefonica.eof.entity;

import lombok.Data;

@Data
public class RelationMaster {
    
    private String cidBo;
    private String childId;
    private String captionBo;
    private String nameChild;
    private String parentId;
    private String nameParent;
    private String propertyValue;
    private String durationValue;
    
    

}
