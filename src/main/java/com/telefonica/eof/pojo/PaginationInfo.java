package com.telefonica.eof.pojo;

import lombok.Data;

@Data
public class PaginationInfo {
    
    private Integer size;
    private Integer pageCount;
    private Integer page;
    private Integer maxResultCount;

}
