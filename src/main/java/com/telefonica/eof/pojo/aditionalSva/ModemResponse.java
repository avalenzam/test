package com.telefonica.eof.pojo.aditionalSva;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: ModemResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre el metodo
 *               getModem y el metodo principal de la clase
 *               AditionalSva.
 */
@Data
public class ModemResponse {

    private String equipmentCid;
    private String nameComp;
}
