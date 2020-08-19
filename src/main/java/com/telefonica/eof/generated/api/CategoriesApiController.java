package com.telefonica.eof.generated.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.eof.generated.model.CategoryRequestType;
import com.telefonica.eof.generated.model.CategoryTreeRefType;
import com.telefonica.eof.generated.model.CategoryType;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-17T17:23:53.051Z")

@Controller
public class CategoriesApiController implements CategoriesApi {

    private static final Logger log = LoggerFactory.getLogger(CategoriesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoriesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CategoryType> createCategory(@ApiParam(value = "New category in catalog" ,required=true )  @Valid @RequestBody CategoryRequestType category,@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment" ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,@ApiParam(value = "Identifier for the system originating the request" ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CategoryType>(objectMapper.readValue("\"\"", CategoryType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CategoryType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CategoryType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteCategory(@ApiParam(value = "ID of the category that needs to be fetched",required=true) @PathVariable("categoryId") String categoryId,@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment" ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,@ApiParam(value = "Identifier for the system originating the request" ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<CategoryType>> getCategories(@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment" ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,@ApiParam(value = "Identifier for the system originating the request" ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,@ApiParam(value = "To obtain the list of products matching to a given id in the other side mapping to the productId (to synchronize client and server identifiers) ") @Valid @RequestParam(value = "correlationId", required = false) String correlationId,@ApiParam(value = "to obtain the list of categories associated with a given name") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "To obtain the categories that can be offered after this value") @Valid @RequestParam(value = "startDate", required = false) OffsetDateTime startDate,@ApiParam(value = "To obtain categories that can be offered before this value") @Valid @RequestParam(value = "endDate", required = false) OffsetDateTime endDate,@ApiParam(value = "To limit the amount of results") @Valid @RequestParam(value = "limit", required = false) String limit,@ApiParam(value = "To get the results starting from an offset value. Use for pagination") @Valid @RequestParam(value = "offset", required = false) String offset,@ApiParam(value = "To define the information elements expected in the response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<CategoryType>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CategoryType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CategoryType>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CategoryType> retrieveCategory(@ApiParam(value = "ID of the category that needs to be fetched",required=true) @PathVariable("categoryId") String categoryId,@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment" ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,@ApiParam(value = "Identifier for the system originating the request" ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication,@ApiParam(value = "To define the information elements expected in the response") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CategoryType>(objectMapper.readValue("\"\"", CategoryType.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CategoryType>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CategoryType>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<CategoryTreeRefType>> retrieveCategoryTree(@ApiParam(value = "ID of the category we want the tree to begin from. If the user needs the whole tree starting from all roots a hyphen (/categories/-/tree) could be used. Otherwise, an id should be provided and the tree that will be returned will be the one from that node downwards.",required=true) @PathVariable("categoryId") String categoryId,@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment" ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,@ApiParam(value = "Identifier for the system originating the request" ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<CategoryTreeRefType>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<CategoryTreeRefType>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<CategoryTreeRefType>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateCategory(@ApiParam(value = "ID of the category that needs to be fetched",required=true) @PathVariable("categoryId") String categoryId,@ApiParam(value = "Data for the category update" ,required=true )  @Valid @RequestBody CategoryRequestType category,@ApiParam(value = "If this API is used via a platform acting as a common entry point to different OBs, this identifier is used to route the request to the corresponding OB environment" ) @RequestHeader(value="UNICA-ServiceId", required=false) String unICAServiceId,@ApiParam(value = "Identifier for the system originating the request" ) @RequestHeader(value="UNICA-Application", required=false) String unICAApplication) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
