package com.telefonica.eof.enums;

import lombok.Getter;

public enum NameEnum {
    
    BUSINESS_TYPE("businessType"),
    DISPLAY_NAME("displayName"),
    TYPE("type"),
    RELATION_ID("relationId"),
    CORRELATION_ID("correlationId"),
    PARENT_CATALOG_ITEM_ID("parentCatalogItemID"),
    PARENT_CATALOG_ITEM_NAME("parentCatalogItemName"),
    PARENT_CURRENT_STATUS("parentCurrentStatus"),
    PARENT_ASSIGNED_ID("parentAssignedID"),
    PLAN_TYPE("planType"),
    TOP_RECOMMENDED("topRecommended"),
    COMPATIBLE_WITH_DEVICE("compatibleWithDevice"),
    MIN_NUM_SUBSCRIBERS("minNumOfSubscribers"),
    NUM_SUBSCRIBERS("numOfSubscribers"),
    SHARED_PLAN("sharedPlan"),
    IMAGE("image"),
    BANNER("banner");
    
    @Getter
    String value;
    
    private NameEnum(String value) {
	this.value = value;
    }

}
