package com.telefonica.eof.enums;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum HttpsErrorMessage {
//   TODO VERIFICAR EL SVC0001 O SVC1001
    ERROR_400("SVC0001", "400",  HttpStatus.BAD_REQUEST, "Se debe poblar estos campos: category.id, channel.id, customerId, product.type, product.id, creditScore, creditLimit, siteId, region, stateOrProvince, customer.segment, broadband.connection, isRetention, currentOffering, action, commercialAreaId, sourceType, networkTechnology, serviceability.maxSpeed"),
    ERROR_404("SVC1006", "404", HttpStatus.INTERNAL_SERVER_ERROR, "los parametros de busqueda separados por comas (,)"),
    ERROR_409("SVC1007", "409", HttpStatus.INTERNAL_SERVER_ERROR, "Cliente con orden en vuelo en curso"),
    ERROR_500("SVC1000", "500", HttpStatus.INTERNAL_SERVER_ERROR, "" );


    private String exceptionId;
    private String httpStatusCode;
    private HttpStatus httpStatus;
    private String message;
     
}
