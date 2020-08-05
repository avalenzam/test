package com.telefonica.eof.repository;

public interface DomainWithValidValuesRepository {

    public Integer getCaption (String spsSetting);
    public String getStbSetting (Integer rankSTB);
    public String getNameComponent (String stbSetting);
}
