package com.telefonica.eof.business.offering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.entity.BillingOfferMaster;
import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.pojo.aditionalSva.AditionalSvaResponse;
import com.telefonica.eof.pojo.aditionalSva.ChannelBlockResponse;
import com.telefonica.eof.pojo.aditionalSva.DecosResponse;
import com.telefonica.eof.pojo.aditionalSva.ModemResponse;
import com.telefonica.eof.pojo.aditionalSva.OfferDataResponse;
import com.telefonica.eof.pojo.aditionalSva.OtherSvasResponse;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.DomainWithValidValuesRepository;
import com.telefonica.eof.repository.EquipmentRepository;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.StbSettingRepository;

public class AditionalSva {

    @Autowired
    private OffersPropertiesRepository	    offersPropertiesRepository;
    @Autowired
    private RelationMasterRepository	    relationMasterRepository;
    @Autowired
    private PricePropertiesRepository	    pricePropertiesRepository;
    @Autowired
    private ComponentsMasterRepository	    componentsMasterRepository;
    @Autowired
    private BillingOfferMasterRepository    billingOfferMasterRepository;
    @Autowired
    private EquipmentRepository		    equipmentRepository;
    @Autowired
    private StbSettingRepository	    stbSettingRepository;
    @Autowired
    private DomainWithValidValuesRepository domainWithValidValuesRepository;

    public AditionalSvaResponse getAditionalSva(String vProductOfferingID, Integer velocidad, String networkTecnology,
	    String currentOffering, String channelId, String field) {

	AditionalSvaResponse aditionalSvaResponse = new AditionalSvaResponse();

	OfferDataResponse offerData = getOfferData(vProductOfferingID, velocidad);

	ModemResponse modem = getModem(networkTecnology, offerData.getLob());

	List<DecosResponse> decos = null;

	if (offerData.getLob().contains("TV")) {

	    decos = getDecos(velocidad, vProductOfferingID, currentOffering, channelId, field);
	}

	List<ChannelBlockResponse> channelBlock = null;

	if ("null".equalsIgnoreCase(offerData.getDefSpsBo()) || StringUtil.isNullOrEmpty(offerData.getDefSpsBo())) {

	    channelBlock = getChannelBlock(offerData.getDefSpsBo(), offerData.getDefSpsId(), vProductOfferingID);

	}

	List<OtherSvasResponse> otherSvas = getOtherSvas(vProductOfferingID);

	aditionalSvaResponse.setOfferData(offerData);
	aditionalSvaResponse.setModem(modem);
	aditionalSvaResponse.setDecos(decos);
	aditionalSvaResponse.setChannelBlock(channelBlock);
	aditionalSvaResponse.setOtherSvas(otherSvas);

	return aditionalSvaResponse;
    }

    private OfferDataResponse getOfferData(String vProductOfferingID, Integer velocidad) {

	OfferDataResponse offerDataResponse = new OfferDataResponse();
	Boolean flagModemPremium;
	Boolean flagUltraWifi;
	String lob;

	List<OffersProperties> offersProperties = offersPropertiesRepository.getPropertyValue(vProductOfferingID);

	lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("LOB")).map(p -> p.getPropertyValue())
		.collect(Collectors.joining());

	if ("null".equalsIgnoreCase(lob) || StringUtil.isNullOrEmpty(lob)) {

	    lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("Bundle LOBs"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	}

	if (lob.matches("Internet|BB")) {

	    String minSpeedPremium = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase("Minimum Download Speed for Premium"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());

	    if (Integer.parseInt(minSpeedPremium) <= velocidad) {
		flagModemPremium = true;
	    } else {
		flagModemPremium = false;
	    }

	    String minSpeedWifi = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase("Minimum Speed for Loaned Ultra WiFi"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());

	    if (Integer.parseInt(minSpeedWifi) <= velocidad) {
		flagUltraWifi = true;
	    } else {
		flagUltraWifi = false;
	    }

	} else {
	    flagModemPremium = false;
	    flagUltraWifi = false;
	}

	String defSpsId = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("DEF_SPS_ID"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	String defSpsBo = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("DEF_SPS_BO"))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	offerDataResponse.setLob(lob);
	offerDataResponse.setFlagModemPremium(flagModemPremium);
	offerDataResponse.setFlagUltraWifi(flagUltraWifi);
	offerDataResponse.setDefSpsId(defSpsId);
	offerDataResponse.setDefSpsBo(defSpsBo);

	return offerDataResponse;

    }

    private ModemResponse getModem(String networkTecnology, String lob) {

	ModemResponse modemResponse = new ModemResponse();

	String equipmentCid = equipmentRepository.getEquipmentCid(networkTecnology, lob);

	String nameComp = null;

	if (!"null".equalsIgnoreCase(equipmentCid) || !StringUtil.isNullOrEmpty(equipmentCid)) {

	    nameComp = componentsMasterRepository.getComponentName(equipmentCid);
	}

	modemResponse.setEquipmentCid(equipmentCid);
	modemResponse.setNameComp(nameComp);

	return modemResponse;

    }

    private List<DecosResponse> getDecos(Integer velocidad, String vProductOfferingID, String currentOffering, String channelId,
	    String field) {

	String stbNewOffer;
	List<DecosResponse> decosResponseList = new ArrayList<>();
	DecosResponse decosResponse = new DecosResponse();

	if (velocidad != null) {
	    stbNewOffer = stbSettingRepository.getStbSettingWithSpeed(null, vProductOfferingID, velocidad);
	    System.out.println(stbNewOffer);
	} else {
	    stbNewOffer = stbSettingRepository.getStbSettingWithoutSpeed(null, vProductOfferingID);
	    System.out.println(stbNewOffer);
	}

	List<String> stbNewOfferList = Arrays.asList(stbNewOffer.split(","));

	if (!"null".equalsIgnoreCase(currentOffering) || !StringUtil.isNullOrEmpty(currentOffering)) {

	    List<OffersProperties> propertyValue = offersPropertiesRepository.getPropertyValue(currentOffering);

	    String currentOfferLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("LOB"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(currentOfferLob);

	    String currentOfferBundleLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase("Bundle LOBs"))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(currentOfferBundleLob);

	    if (!currentOfferBundleLob.contains("TV") && !currentOfferLob.contains("TV")) {

		if (field.contains("DownloadSpeed")) {
		    List<String> fielList = Arrays.asList(field.split(","));
		    List<String> downloadSpeedList = new ArrayList<String>();
		    fielList.forEach(item -> {
			downloadSpeedList.add(Arrays.asList(item.split(":")).get(1));
		    });

		    downloadSpeedList.forEach(downloadSpeed -> {
			String stbCurrentOffer;
			if (currentOffering != null) {
			    stbCurrentOffer = stbSettingRepository.getStbSettingWithSpeed(channelId, vProductOfferingID,
				    Integer.parseInt(downloadSpeed.trim()));
			    System.out.println(stbNewOffer);
			} else {
			    stbCurrentOffer = stbSettingRepository.getStbSettingWithoutSpeed(channelId, vProductOfferingID);
			    System.out.println(stbNewOffer);
			}
			List<String> stbCurrentOfferList = Arrays.asList(stbCurrentOffer.split(","));

			Integer rankSTB = 0;
			Integer currentRankSTB = 0;

			for (String stbSettingNew : stbNewOfferList) {
			    Integer caption = domainWithValidValuesRepository.getCaption(stbSettingNew.trim());
			    if (caption > rankSTB) {
				rankSTB = caption;
			    }
			}

			for (String stbSettingCurrent : stbCurrentOfferList) {
			    Integer caption = domainWithValidValuesRepository.getCaption(stbSettingCurrent.trim());
			    if (caption > rankSTB) {
				currentRankSTB = caption;
			    }
			}

			String stbSettings;

			if (rankSTB > currentRankSTB) {

			    stbSettings = domainWithValidValuesRepository.getStbSetting(rankSTB);

			} else {
			    stbSettings = null;
			}

			String caption = domainWithValidValuesRepository.getNameComponent(stbSettings);
			decosResponse.setCaption(caption);
			decosResponse.setStbSetting(stbSettings);
			decosResponseList.add(decosResponse);
		    });
		}

	    }
	} else {

	    stbNewOfferList.forEach(stbSettings -> {

		String caption = domainWithValidValuesRepository.getNameComponent(stbSettings);
		decosResponse.setCaption(caption);
		decosResponse.setStbSetting(stbSettings);
		decosResponseList.add(decosResponse);

	    });

	}

	return decosResponseList;
    }

    private List<ChannelBlockResponse> getChannelBlock(String defSpsBo, String defSpsId, String vProductOfferingID) {

	List<ChannelBlockResponse> channelBlocklist = new ArrayList<>();
	ChannelBlockResponse channelBlockResponse = new ChannelBlockResponse();

	List<String> defSpsBoList = Arrays.asList(defSpsBo.split(","));
	List<String> defSpsIdList = Arrays.asList(defSpsId.split(","));

	defSpsBoList.forEach(bo -> {
	    Sps sps = relationMasterRepository.getIdAndNameComponent(defSpsBo, vProductOfferingID);
	    BillingOfferMaster billingOffer = billingOfferMasterRepository.getBillingOfferName(bo);
	    PriceProperties valueAbp = pricePropertiesRepository.getPriceInfo(billingOffer.getCidBo());
	    
	    channelBlockResponse.setFdIdParent(sps.getParentId());
	    channelBlockResponse.setFdNameParent(sps.getParentId());
	    channelBlockResponse.setCidBo(billingOffer.getCidBo());
	    channelBlockResponse.setDescriptionText(billingOffer.getDescriptionText());
	    channelBlocklist.add(channelBlockResponse);
	});

	defSpsIdList.forEach(id -> {
	    String nameParent = relationMasterRepository.getDiscountSpsName(id);
	    channelBlockResponse.setCNameParent(nameParent);
	    channelBlockResponse.setDefSpsId(id);
	    channelBlocklist.add(channelBlockResponse);
	});

	return channelBlocklist;
    }

    private List<OtherSvasResponse> getOtherSvas(String vProductOfferingID) {

	List<OtherSvasResponse> otherSvaList = new ArrayList<>();
	OtherSvasResponse otherSvasResponse = new OtherSvasResponse();

	List<RelationMaster> svas = relationMasterRepository.getSvas(vProductOfferingID);
	svas.forEach(sva -> {
	    String nameComp = componentsMasterRepository.getComponentName(sva.getParentId());
	    otherSvasResponse.setNameComp(nameComp);
	    otherSvasResponse.setCidBo(sva.getCidBo());
	    otherSvasResponse.setNameBo(sva.getNameBo());
	    otherSvasResponse.setParentId(sva.getParentId());
	});

	return otherSvaList;

    }
}
