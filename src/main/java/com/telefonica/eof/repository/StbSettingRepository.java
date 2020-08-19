package com.telefonica.eof.repository;

public interface StbSettingRepository {
    
    public String findStbSettingWithSpeed (String channelId, String vProductOfferingID, Integer velocidad );
    public String findStbSettingWithoutSpeed (String channelId, String vProductOfferingID);

}
