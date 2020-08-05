package com.telefonica.eof.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.telefonica.eof.repository.StbSettingRepository;

@Repository
public class JdbcStbSettingRepository implements StbSettingRepository{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getStbSettingWithSpeed (String channelId, String vProductOfferingID, Integer velocidad ) {
	String query = "select STB_SETTINGS"
		+ " from STB_SETTING"
		+ " where SALES_CHANNEL in (?, 'All')"
		+ " and PO_CODE = ?"
		+ " and CAST(SPEED_FROM AS NUMBER) <= ?"
		+ " and CAST(SPEED_TO AS NUMBER) >= ?";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{channelId, vProductOfferingID, velocidad, velocidad },
		String.class);
    }
    
    @Override
    public String getStbSettingWithoutSpeed (String channelId, String vProductOfferingID) {
	String query = "select STB_SETTINGS"
		+ " from STB_SETTING"
		+ " where SALES_CHANNEL in (?, 'All')"
		+ " and PO_CODE = ?"
		+ " and SPEED_FROM = 'N/A'"
		+ " and SPEED_TO  = 'N/A'";
	
	return jdbcTemplate.queryForObject(query,
		new Object[]{channelId, vProductOfferingID },
		String.class);
    }
    

}
