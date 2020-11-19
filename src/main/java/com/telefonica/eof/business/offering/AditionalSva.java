package com.telefonica.eof.business.offering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.commons.Util;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.ehcache.CacheEquipmentCharge;
import com.telefonica.eof.ehcache.Equipment;
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
 * @Description: Clase que obtiene los servicios de valor agregado como parte de
 *               la oferta
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
    private StbSettingRepository	    stbSettingRepository;
    @Autowired
    private DomainWithValidValuesRepository domainWithValidValuesRepository;
    @Autowired
    private CacheEquipmentCharge	    cacheEquipmentCharge;

    /**
     * Método principal de la clase. Obtiene los sva adicionales como parte de la
     * oferta que viene de AMDOCS
     * 
     * @param vProductOfferingID:
     *            se obtiene del response de AMDOCS
     * @param velocidad:
     *            se obtiene del response de AMDOCS, es el campo downloadSpeed
     * @param offersBenefitsRequestDto:
     *            viene del front
     * @return AditionalSvaResponse : servicios de valor agregado
     */
    public AditionalSvaResponse getAditionalSva(String vProductOfferingID, String downloadSpeed,
	    OffersBenefitsRequestDto offersBenefitsRequestDto, List<OffersProperties> offersProperties) {

	Integer velocidad = Optional.ofNullable(downloadSpeed).map(x -> Integer.parseInt(downloadSpeed)).orElse(0);

	AditionalSvaResponse aditionalSvaResponse = new AditionalSvaResponse();

	OfferDataResponse offerData = getOfferData(velocidad, offersProperties);

	ModemResponse modem = getModem(offersBenefitsRequestDto.getNetworkTechnology(), offerData.getLob());

	List<DecosResponse> decos = null;

	if (offerData.getLob().contains(Constant.TV)) {

	    decos = getDecos(velocidad, vProductOfferingID, offersBenefitsRequestDto);
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
     * El método obtiene datos de la Oferta, necesario para el getAditionalSva()
     * 
     * @param vProductOfferingID:
     *            se obtiene del response de AMDOCS
     * @param velocidad:
     *            se obtiene del response de AMDOCS, es el campo downloadSpeed
     * @return OfferDataResponse : Datos de la Oferta
     */

    private OfferDataResponse getOfferData(Integer velocidad, List<OffersProperties> offersProperties) {

	OfferDataResponse offerDataResponse = new OfferDataResponse();
	Boolean flagModemPremium;
	Boolean flagUltraWifi;
	String lob;

	lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.LOB))
		.map(OffersProperties::getPropertyValue).collect(Collectors.joining());

	if (Constant.NULL.equalsIgnoreCase(lob) || StringUtil.isNullOrEmpty(lob)) {

	    lob = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.BUNDLE_LOBS))
		    .map(OffersProperties::getPropertyValue).collect(Collectors.joining());
	}

	if (lob.matches("Internet|BB")) {

	    String minSpeedPremium = offersProperties.stream()
		    .filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.MIN_SPEED_PREMIUM)).map(OffersProperties::getPropertyValue)
		    .collect(Collectors.joining());

	    if (Integer.parseInt(minSpeedPremium) <= velocidad) {
		flagModemPremium = true;
	    } else {
		flagModemPremium = false;
	    }

	    String minSpeedWifi = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.MIN_SPEED_WIFI))
		    .map(OffersProperties::getPropertyValue).collect(Collectors.joining());

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
		.map(OffersProperties::getPropertyValue).collect(Collectors.joining());

	String defSpsBo = offersProperties.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.DEF_SPS_BO))
		.map(OffersProperties::getPropertyValue).collect(Collectors.joining());

	offerDataResponse.setLob(lob);
	offerDataResponse.setFlagModemPremium(flagModemPremium);
	offerDataResponse.setFlagUltraWifi(flagUltraWifi);
	offerDataResponse.setDefSpsId(defSpsId);
	offerDataResponse.setDefSpsBo(defSpsBo);

	return offerDataResponse;

    }

    /**
     * El metodo obtiene el tipo del modem de la oferta, necesario para el
     * getAditionalSva()
     * 
     * @param networkTecnology
     *            atributo del offersBenefitsRequestDto que viene del front
     * @param lob
     *            atributo parte del response del metodo getOfferData()
     * @return ModemResponse : id y nombre del quipamiento
     */
    private ModemResponse getModem(String networkTecnology, String lob) {

	ModemResponse modemResponse = new ModemResponse();

	Map<String, List<Equipment>> equipmentMap = cacheEquipmentCharge.getEquipment();
	String equipmentCid = equipmentMap.get(lob).stream().filter(x -> x.getNetworkTechnology().contains(networkTecnology))
		.map(Equipment::getCid).collect(Collectors.joining());

	String nameComp = null;

	if (!(Constant.NULL.equalsIgnoreCase(equipmentCid) || StringUtil.isNullOrEmpty(equipmentCid))) {

	    nameComp = componentsMasterRepository.findNameComponentByCidComponent(equipmentCid);
	}

	modemResponse.setEquipmentCid(equipmentCid);
	modemResponse.setNameComp(nameComp);

	return modemResponse;

    }

    /**
     * El metodo obtiene Decos como parte de la oferta (STB), necesario para el
     * getAditionalSva()
     * 
     * @param velocidad:
     *            se obtiene del response de AMDOCS, es el campo downloadSpeed
     * @param vProductOfferingID:
     *            se obtiene del response de AMDOCS
     * @param offersBenefitsRequestDto:
     *            viene del front
     * @return List<DecosResponse> : listado de decos
     */
    private List<DecosResponse> getDecos(Integer velocidad, String vProductOfferingID, OffersBenefitsRequestDto offersBenefitsRequestDto) {

	String stbNewOffer;
	List<DecosResponse> decosResponseList = new ArrayList<>();
	DecosResponse decosResponse = new DecosResponse();

	if (velocidad != 0) {
	    stbNewOffer = stbSettingRepository.findStbSettingWithSpeed(offersBenefitsRequestDto.getChannelId(), vProductOfferingID,
		    velocidad);
	} else {
	    stbNewOffer = stbSettingRepository.findStbSettingWithoutSpeed(offersBenefitsRequestDto.getChannelId(), vProductOfferingID);
	}

	List<String> stbNewOfferList = new ArrayList<>();
	if (stbNewOffer != null) {
	    stbNewOfferList = Arrays.asList(stbNewOffer.split(Constant.COMMA));
	}

	if (!(Constant.NULL.equalsIgnoreCase(offersBenefitsRequestDto.getCurrentOffering())
		|| StringUtil.isNullOrEmpty(offersBenefitsRequestDto.getCurrentOffering()))) {

	    List<OffersProperties> propertyValue = offersPropertiesRepository
		    .findPropertyValue(offersBenefitsRequestDto.getCurrentOffering());

	    String currentOfferLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.LOB))
		    .map(p -> p.getPropertyValue()).collect(Collectors.joining());

	    String currentOfferBundleLob = propertyValue.stream().filter(x -> x.getNameOfProperty().equalsIgnoreCase(Constant.BUNDLE_LOBS))
		    .map(OffersProperties::getPropertyValue).collect(Collectors.joining());

	    if (!(currentOfferBundleLob.contains(Constant.TV) && currentOfferLob.contains(Constant.TV))
		    && offersBenefitsRequestDto.getFields().contains(Constant.DOWNLOAD_SPEED)) {

		List<String> fielList = Arrays.asList(offersBenefitsRequestDto.getFields().split(Constant.COMMA));
		List<String> downloadSpeedList = new ArrayList<>();
		fielList.forEach(item -> downloadSpeedList.add(Arrays.asList(item.split(Constant.DOBLEPOINT)).get(1)));

		for (String downloadSpeed : downloadSpeedList) {
		    String stbCurrentOffer;
		    if (offersBenefitsRequestDto.getCurrentOffering() != null) {
			stbCurrentOffer = stbSettingRepository.findStbSettingWithSpeed(offersBenefitsRequestDto.getChannelId(),
				vProductOfferingID, Integer.parseInt(downloadSpeed.trim()));
		    } else {
			stbCurrentOffer = stbSettingRepository.findStbSettingWithoutSpeed(offersBenefitsRequestDto.getChannelId(),
				vProductOfferingID);
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
		}

	    }
	} else {

	    if (Boolean.FALSE.equals(Util.isEmptyOrNullList(stbNewOfferList))) {
		stbNewOfferList.forEach(stbSettings -> {

		    String caption = domainWithValidValuesRepository.findNameComponentByvalidValue(stbSettings);
		    decosResponse.setCaption(caption);
		    decosResponse.setStbSetting(stbSettings);
		    decosResponseList.add(decosResponse);

		});

	    }

	}

	return decosResponseList;
    }

    /**
     * El metodo obtiene los bloques de canales de la oferta, necesario para el
     * getAditionalSva()
     * 
     * @param defSpsBo:
     *            atributo del response del metodo getOfferData()
     * @param defSpsId:
     *            atributo del response del metodo getOfferData()
     * @param vProductOfferingID:
     *            se obtiene del response de AMDOCS
     * @return List<ChannelBlockResponse> : listado de bloque de canales
     */
    private List<ChannelBlockResponse> getChannelBlock(String defSpsBo, String defSpsId, String vProductOfferingID) {

	List<ChannelBlockResponse> channelBlocklist = new ArrayList<>();
	ChannelBlockResponse channelBlockResponse = new ChannelBlockResponse();

	List<String> defSpsBoList = Arrays.asList(defSpsBo.split(Constant.COMMA));
	List<String> defSpsIdList = Arrays.asList(defSpsId.split(Constant.COMMA));

	defSpsBoList.forEach(bo -> {
	    Sps sps = relationMasterRepository.findComponentIdAndName(defSpsBo, vProductOfferingID);
	    BillingOfferMaster billingOffer = billingOfferMasterRepository.findBillingOfferBycidBo(bo);

	    if (Objects.nonNull(sps) || Objects.nonNull(billingOffer)) {

		channelBlockResponse.setFdIdParent(sps.getParentId());
		channelBlockResponse.setFdNameParent(sps.getParentId());
		channelBlockResponse.setCidBo(Optional.ofNullable(billingOffer).map(x -> billingOffer.getCidBo()).orElse(null));
		channelBlockResponse
			.setDescriptionText(Optional.ofNullable(billingOffer).map(x -> billingOffer.getDescriptionText()).orElse(null));
		channelBlocklist.add(channelBlockResponse);
	    }

	});

	defSpsIdList.forEach(id -> {

	    String nameParent = relationMasterRepository.findSpsDiscountName(id);

	    if (Objects.nonNull(nameParent)) {
		channelBlockResponse.setCNameParent(nameParent);
		channelBlockResponse.setDefSpsId(id);
		channelBlocklist.add(channelBlockResponse);
	    }

	});

	return channelBlocklist;
    }

    /**
     * El metodo obtiene otros SVAs (Multidestino y MCafee), necesario para el
     * getAditionalSva()
     * 
     * @param vProductOfferingID:
     *            se obtiene del response de AMDOCS
     * @return List<OtherSvasResponse> : listado de otros SVAs
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
