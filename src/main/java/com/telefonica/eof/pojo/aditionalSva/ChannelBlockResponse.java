package com.telefonica.eof.pojo.aditionalSva;

import lombok.Data;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: ChannelBlockResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre el metodo
 *               ChannelBlockResponse y el metodo principal de la clase
 *               AditionalSva.
 */
@Data
public class ChannelBlockResponse {
    
    private String fdIdParent;
    private String fdNameParent;
    private String cidBo;
    private String descriptionText;
    private String cNameParent;    
    private String defSpsId;

}
