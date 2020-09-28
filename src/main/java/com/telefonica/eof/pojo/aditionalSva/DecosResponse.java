package com.telefonica.eof.pojo.aditionalSva;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: DecosResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre el metodo
 *               getDecos y el metodo principal de la clase
 *               AditionalSva.
 */
@Data
public class DecosResponse {
    
    private String caption;
    private String stbSetting;

}
