package com.telefonica.eof.commons;

import java.math.BigDecimal;

public class Constant {

    public static final String ASTERISK_QUERY = "'*'";
    public static final String ASTERISK	      = "*";
    public static final String COMMA	      = ",";
    public static final String DOBLEPOINT     = ":";
    public static final String X	      = "x";
    public static final String SPACE	      = " ";
    public static final String UNDERSCORE     = "_";
    public static final String VOID_STRING    = "";
    public static final String GREATER_THAN   = ">=";
    public static final String LESS_THAN      = "<=";
    public static final String NULL	      = "null";

    public static final String YES   = "Y";
    public static final String NO    = "N";
    public static final String TRUE  = "true";
    public static final String FALSE = "false";

    public static final String MBPS = "Mbps";

    public static final String TECNOLOGY      = "technology";
    public static final String DOWNLOAD_SPEED = "DownloadSpeed";

    public static final String RESIDENTIAL = "R";
    public static final String CORPORATE   = "C";

    public static final String PLAN_GROUP = "Plan Group";
    public static final String PLAN_RANK  = "Plan Rank";
    public static final String RNU	  = "RNU";
    public static final String OFFER	  = "OFFER";

    public static final String HREF			 = "/offerings/";
    public static final String HREF_OFFERING		 = "/offerings/{categories[i].offerings[j].catalogItemId}";
    public static final String HREF_PRODUCTSPECIFICATION = "/offerings/{categories[i].offerings[j].children[k].catalogItemId}";

    public static final String OFFER_PRICE_DESCRIPTION = "PRECIO TOTAL FIJA";

    public static final String EASY_POST_PAYMENT = "postpagoFacil";
    public static final String EXEMPT_PENALTY	 = "exoneraPenalidad";

    public static final String COMPONENT_ID = "componentId";

    public static final String PREPAID = "prepaid";

    public static final String PROVIDE	     = "PR";
    public static final String CHANGE	     = "CH";
    public static final String PORTABILITY   = "PORT";
    public static final String ALTA	     = "ALTA";
    public static final String DEVICE_CHANGE = "CAEQ";
    public static final String REPLACE_OFFER = "RO";

    public static final String DURATION	= "duration";
    public static final String WIRELESS	= "WRLS";
    public static final String TV	= "TV";

    public static final String SVA	     = "sva";
    public static final String OC	     = "OC";
    public static final String PERUVIAN_COIN = "PEN";
    public static final String MONETARY	     = "Monetary";
    public static final String RECURRING     = "recurring";

    // PRICE PROPERTY
    public static final String DISCOUNT_VALUE = "Discount value";
    public static final String DISCOUNT_TYPE  = "Discount type";

    // idcomponente

    public static final String BLOQUE_CANALES		      = "3196671";
    public static final String SERVICIOS_ADICIONALES_VOZ_FIJA = "2724122";
    public static final String SPEED_BOOST		      = "3240852";
    public static final String ULTRA_WIFI		      = "34105211";
    public static final String STB			      = "3197701";
    public static final String MCAFEE			      = "3239962";
    public static final String MODEM_ONT		      = "3192682";
    public static final String MODEM_HFC		      = "3192742";
    public static final String MODE_MMTA		      = "3192652";
    public static final String MULTIDESTINO		      = "2723922";

    // property value
    public static final String RETENTION	 = "Retention";
    public static final String LOB_TYPE		 = "LOB Type";
    public static final String LOB		 = "LOB";
    public static final String BUNDLE_LOBS	 = "Bundle LOBs";
    public static final String MIN_SPEED_PREMIUM = "Minimum Download Speed for Premium";
    public static final String MIN_SPEED_WIFI	 = "Minimum Speed for Loaned Ultra WiFi";
    public static final String DEF_SPS_ID	 = "DEF_SPS_ID";
    public static final String DEF_SPS_BO	 = "DEF_SPS_BO";

    // additional data
    public static final String INSTALLATION_FEE_BO  = "INSTALLATION_FEE_BO";
    public static final String PRODUCT_FOR_INST_FEE = "PRODUCT_FOR_INST_FEE";

    // productCharasterictic id
    public static final String EQUIPMENT_SUB_TYPE = "Equipment_Sub_Type";
    public static final String STB_TYPE		  = "STB_Type";

    // productCharastericticName
    public static final String BUSINESS_TYPE		= "businessType";
    public static final String DISPLAY_NAME		= "displayName";
    public static final String TYPE			= "type";
    public static final String RELATION_ID		= "relationId";
    public static final String CORRELATION_ID		= "correlationId";
    public static final String PARENT_CATALOG_ITEM_ID	= "parentCatalogItemID";
    public static final String PARENT_CATALOG_ITEM_NAME	= "parentCatalogItemName";
    public static final String PARENT_CURRENT_STATUS	= "parentCurrentStatus";
    public static final String PARENT_ASSIGNED_ID	= "parentAssignedID";
    public static final String PLAN_TYPE		= "planType";
    public static final String TOP_RECOMMENDED		= "topRecommended";
    public static final String COMPATIBLE_WITH_DEVICE	= "compatibleWithDevice";
    public static final String MIN_NUM_SUBSCRIBERS	= "minNumOfSubscribers";
    public static final String NUM_SUBSCRIBERS		= "numOfSubscribers";
    public static final String SHARED_PLAN		= "sharedPlan";
    public static final String IMAGE			= "image";
    public static final String BANNER			= "banner";
    public static final String ID_ASSIGNED_ITEM		= "idAssignedItem";
    public static final String PRODUCRT_TYPE		= "productType";
    public static final String SUB_TIPO_EQUIPO		= "Sub Tipo de Equipo";
    public static final String TIPO_DECODIFICADOR	= "Tipo de Decodificador";
    public static final String BILLING_OFFER		= "Billing Offer";
    public static final String SPSID			= "SPSID";
    public static final String NOMBRE_SPS		= "NombreSPS";

    // productPrice descripcion
    public static final String PLAN_INTERNET	  = "PRECIO DEL PLAN DE INTERNET";
    public static final String PLAN_TV		  = "PRECIO DEL PLAN DE TV";
    public static final String PLAN_VOZ		  = "PRECIO DEL PLAN DE VOZ";
    public static final String PLAN_EQ_COMPARTIDO = "PRECIO DEL PLAN EQUIPO COMPARTIDO";

    // propductCharacyeristic value
    public static final String PREMIUM = "premium";
    public static final String BASICA  = "Básico";

    // Product Catalog Management Service - retrieveOfferings operation
    public static final String URL_OFFERINGS_SERVICE	= "http://telefonica.com/globalIntegration/services/retrieveOfferings/v1";
    public static final String METHOD_OFFERINGS_SERVICE	= "retrieveOfferingsRequest";

    // productPrice
    public static final String PRECIO_SVA	= "Precio SVA";
    public static final String PRECIO_VELOCIDAD	= "PRECIO DE LA VELOCIDAD";

    // characteristics name
    public static final String SPS_ID	= "spsID";
    public static final String SPS_NAME	= "spsName";
    public static final String BO_NAME	= "BOName";
    public static final String BO_ID	= "BOID";
    public static final String NIGHT_ID	= "NightInd";

    // PARQUE UNIFICADO service
    public static final String PARQUE_UNIFICADO_URL = "http://10.4.43.93:8889/products-0.0.1/products";

    // HEADER
    public static final String UNICA_SERVICE_ID	= "UNICA-ServiceId";
    public static final String UNICA_TIMESTAMP	= "UNICA-Timestamp";

    /**
     * Gestión de Log y entornos.
     */
    public static final String NEW_LINE		      = System.getProperty("line.separator");
    public static final String CLASS_LOG_LABEL	      = "[Class]: ";
    public static final String METHOD_LOG_LABEL	      = "[Method]: ";
    public static final String PARAMETERS_LOG_LABEL   = "()";
    public static final String INPUT_PARAMETERS_LABEL = "[Input Params]: ";
    public static final String INPUT_PARAMETER_LABEL  = "[Input]: ";
    public static final String OUTPUT_LABEL	      = "[Output Object]: ";
    public static final String SEPARATOR	      = "===================================================================================================================================================================================";

    /**
     * Predefinidos
     */
    public static final BigDecimal IGV_MULTIPLIER = new BigDecimal(1.18);

    private Constant() {

    }

}
