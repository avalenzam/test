package com.telefonica.eof.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum HttpsErrorMessage {
//   TODO VERIFICAR EL SVC0001 O SVC1001
    ERROR_400("SVC1001", "400 BAD REQUEST", "Se debe poblar estos campos: category.id, channel.id, customerId, product.type, product.id, creditScore, creditLimit, siteId, region, stateOrProvince, customer.segment, broadband.connection, isRetention, currentOffering, action, commercialAreaId, sourceType, networkTechnology, serviceability.maxSpeed, orderSubType"),
    ERROR_404("SVC1006", "404 NOT FOUND", "los parametros de busqueda separados por comas (,)"),
    ERROR_409("SVC1007", "409 CONFLICT", "Cliente con orden en vuelo en curso"),
    ERROR_500("SVC1000", "500 INTERNAL SERVER ERROR", "" );

    private String exceptionId;
    private String responseHttp;
    private String message;
    
   
}
