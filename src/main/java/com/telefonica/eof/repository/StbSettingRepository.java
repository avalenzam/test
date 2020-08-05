package com.telefonica.eof.repository;

public interface StbSettingRepository {
    
    public String getStbSettingWithSpeed (String channelId, String vProductOfferingID, Integer velocidad );
    public String getStbSettingWithoutSpeed (String channelId, String vProductOfferingID);

}
