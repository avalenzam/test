package com.telefonica.eof.repository;

public interface DomainWithValidValuesRepository {

    public Integer findCaptionByvalidValue (String spsSetting);
    public String findValidValueByCaption (Integer rankSTB);
    public String findNameComponentByvalidValue (String stbSetting);
}
