package com.telefonica.eof.business.offering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.entity.BillingOfferMaster;
import com.telefonica.eof.entity.OffersProperties;
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
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.StbSettingRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: AditionalSva.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene los servicios adicionales y equipamiento como parte de la oferta
 */

@Component
public class AditionalSva {

    @Autowired
    private OffersPropertiesRepository	    offersPropertiesRepository;
    @Autowired
    private RelationMasterRepository	    relationMasterRepository;
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

	if (offerData.getLob().contains(Constant.TV)) {

	    decos = getDecos(velocidad, vProductOfferingID, currentOffering, channelId, field);
	}

	List<ChannelBlockResponse> channelBlock = null;

	if (!(Constant.NULL.equalsIgnoreCase(offerData.getDefSpsBo()) || StringUtil.isNullOrEmpty(offerData.getDefSpsBo()))) {

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
    
    /**
     * El metodo obtiene datos de la Oferta 
     */

    private OfferDataResponse getOfferData(String vProductOfferingID, Integer velocidad) {

	OfferDataResponse offerDataResponse = new OfferDataResponse();
	Boolean flagModemPremium;
	Boolean flagUltraWifi;
	String lob;

	List<OffersProperties> offersProperties = offersPropertiesRepository.findPropertyValue(vProductOfferingID);

	lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.LOB)).map(p -> p.getPropertyValue())
		.collect(Collectors.joining());

	if (Constant.NULL.equalsIgnoreCase(lob) || StringUtil.isNullOrEmpty(lob)) {

	    lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.BUNDLE_LOBS))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	}

	if (lob.matches("Internet|BB")) {

	    String minSpeedPremium = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.MIN_SPEED_PREMIUM))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());

	    if (Integer.parseInt(minSpeedPremium) <= velocidad) {
		flagModemPremium = true;
	    } else {
		flagModemPremium = false;
	    }

	    String minSpeedWifi = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.MIN_SPEED_WIFI))
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

	String defSpsId = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.DEF_SPS_ID))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	String defSpsBo = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.DEF_SPS_BO))
		.map(p -> p.getPropertyValue()).collect(Collectors.joining());

	offerDataResponse.setLob(lob);
	offerDataResponse.setFlagModemPremium(flagModemPremium);
	offerDataResponse.setFlagUltraWifi(flagUltraWifi);
	offerDataResponse.setDefSpsId(defSpsId);
	offerDataResponse.setDefSpsBo(defSpsBo);

	return offerDataResponse;

    }

    /**
     * El metodo obtiene el tipo del modem
     */
    private ModemResponse getModem(String networkTecnology, String lob) {

	ModemResponse modemResponse = new ModemResponse();

	String equipmentCid = equipmentRepository.findEquipmentCid(networkTecnology, lob);

	String nameComp = null;

	if (!(Constant.NULL.equalsIgnoreCase(equipmentCid) || StringUtil.isNullOrEmpty(equipmentCid))) {

	    nameComp = componentsMasterRepository.findNameComponentByCidComponent(equipmentCid);
	}

	modemResponse.setEquipmentCid(equipmentCid);
	modemResponse.setNameComp(nameComp);

	return modemResponse;

    }

    /**
     *  El metodo obtiene el STB - decodificadores
     */
    private List<DecosResponse> getDecos(Integer velocidad, String vProductOfferingID, String currentOffering, String channelId,
	    String field) {

	String stbNewOffer;
	List<DecosResponse> decosResponseList = new ArrayList<>();
	DecosResponse decosResponse = new DecosResponse();

	if (velocidad != null) {
	    stbNewOffer = stbSettingRepository.findStbSettingWithSpeed(null, vProductOfferingID, velocidad);
	    System.out.println(stbNewOffer);
	} else {
	    stbNewOffer = stbSettingRepository.findStbSettingWithoutSpeed(null, vProductOfferingID);
	    System.out.println(stbNewOffer);
	}

	List<String> stbNewOfferList = Arrays.asList(stbNewOffer.split(Constant.COMMA));

	if (!(Constant.NULL.equalsIgnoreCase(currentOffering) || StringUtil.isNullOrEmpty(currentOffering))) {

	    List<OffersProperties> propertyValue = offersPropertiesRepository.findPropertyValue(currentOffering);

	    String currentOfferLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.LOB))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(currentOfferLob);

	    String currentOfferBundleLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.BUNDLE_LOBS))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());
	    System.out.println(currentOfferBundleLob);

	    if (!(currentOfferBundleLob.contains(Constant.TV) && currentOfferLob.contains(Constant.TV))) {

		if (field.contains(Constant.DOWNLOAD_SPEED)) {
		    List<String> fielList = Arrays.asList(field.split(Constant.COMMA));
		    List<String> downloadSpeedList = new ArrayList<String>();
		    fielList.forEach(item -> {
			downloadSpeedList.add(Arrays.asList(item.split(Constant.DOBLEPOINT)).get(1));
		    });

		    downloadSpeedList.forEach(downloadSpeed -> {
			String stbCurrentOffer;
			if (currentOffering != null) {
			    stbCurrentOffer = stbSettingRepository.findStbSettingWithSpeed(channelId, vProductOfferingID,
				    Integer.parseInt(downloadSpeed.trim()));
			    System.out.println(stbNewOffer);
			} else {
			    stbCurrentOffer = stbSettingRepository.findStbSettingWithoutSpeed(channelId, vProductOfferingID);
			    System.out.println(stbNewOffer);
			}
			List<String> stbCurrentOfferList = Arrays.asList(stbCurrentOffer.split(Constant.COMMA));

			Integer rankSTB = 0;
			Integer currentRankSTB = 0;

			for (String stbSettingNew : stbNewOfferList) {
			    Integer caption = domainWithValidValuesRepository.findCaptionByvalidValue(stbSettingNew.trim());
			    if (caption > rankSTB) {
				rankSTB = caption;
			    }
			}

			for (String stbSettingCurrent : stbCurrentOfferList) {
			    Integer caption = domainWithValidValuesRepository.findCaptionByvalidValue(stbSettingCurrent.trim());
			    if (caption > rankSTB) {
				currentRankSTB = caption;
			    }
			}

			String stbSettings;

			if (rankSTB > currentRankSTB) {

			    stbSettings = domainWithValidValuesRepository.findValidValueByCaption(rankSTB);

			} else {
			    stbSettings = null;
			}

			String caption = domainWithValidValuesRepository.findNameComponentByvalidValue(stbSettings);
			decosResponse.setCaption(caption);
			decosResponse.setStbSetting(stbSettings);
			decosResponseList.add(decosResponse);
		    });
		}

	    }
	} else {

	    stbNewOfferList.forEach(stbSettings -> {

		String caption = domainWithValidValuesRepository.findNameComponentByvalidValue(stbSettings);
		decosResponse.setCaption(caption);
		decosResponse.setStbSetting(stbSettings);
		decosResponseList.add(decosResponse);

	    });

	}

	return decosResponseList;
    }

    /**
     *  El metodo obtiene los bloques de canales de la oferta
     */
    private List<ChannelBlockResponse> getChannelBlock(String defSpsBo, String defSpsId, String vProductOfferingID) {

	List<ChannelBlockResponse> channelBlocklist = new ArrayList<>();
	ChannelBlockResponse channelBlockResponse = new ChannelBlockResponse();

	List<String> defSpsBoList = Arrays.asList(defSpsBo.split(Constant.COMMA));
	List<String> defSpsIdList = Arrays.asList(defSpsId.split(Constant.COMMA));

	defSpsBoList.forEach(bo -> {
	    Sps sps = relationMasterRepository.findComponentIdAndName(defSpsBo, vProductOfferingID);
	    BillingOfferMaster billingOffer = billingOfferMasterRepository.findBillingOfferBycidBo(bo);
	   
	    channelBlockResponse.setFdIdParent(sps.getParentId());
	    channelBlockResponse.setFdNameParent(sps.getParentId());
	    channelBlockResponse.setCidBo(billingOffer.getCidBo());
	    channelBlockResponse.setDescriptionText(billingOffer.getDescriptionText());
	    channelBlocklist.add(channelBlockResponse);
	});

	defSpsIdList.forEach(id -> {
	    String nameParent = relationMasterRepository.findSpsDiscountName(id);
	    channelBlockResponse.setCNameParent(nameParent);
	    channelBlockResponse.setDefSpsId(id);
	    channelBlocklist.add(channelBlockResponse);
	});

	return channelBlocklist;
    }
    
    /**
     *  El metodo obtiene  otros SVAs (Multidestino y MCafee)
     */

    private List<OtherSvasResponse> getOtherSvas(String vProductOfferingID) {

	List<OtherSvasResponse> otherSvaList = new ArrayList<>();
	OtherSvasResponse otherSvasResponse = new OtherSvasResponse();

	List<RelationMaster> svas = relationMasterRepository.findSvasByRootCid(vProductOfferingID);
	svas.forEach(sva -> {
	    String nameComp = componentsMasterRepository.findNameComponentByCidComponent(sva.getParentId());
	    otherSvasResponse.setNameComp(nameComp);
	    otherSvasResponse.setCidBo(sva.getCidBo());
	    otherSvasResponse.setNameBo(sva.getNameBo());
	    otherSvasResponse.setParentId(sva.getParentId());
	});

	return otherSvaList;

    }
}
