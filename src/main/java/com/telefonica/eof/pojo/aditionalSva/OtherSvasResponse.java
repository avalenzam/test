package com.telefonica.eof.pojo.aditionalSva;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: OtherSvasResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre el metodo
 *               getOtherSvas y el metodo principal de la clase
 *               AditionalSva.
 */
@Data
public class OtherSvasResponse {

    private String parentId; 
    private String nameComp; 
    private String cidBo;
    private String nameBo;
    
}
