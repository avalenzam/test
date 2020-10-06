package com.telefonica.eof.business.sva;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.internal.util.StringUtil;
import com.telefonica.eof.commons.Constant;
import com.telefonica.eof.commons.Util;
import com.telefonica.eof.dto.OffersBenefitsRequestDto;
import com.telefonica.eof.dto.SvaBenefitParamsDto;
import com.telefonica.eof.entity.OffersProperties;
import com.telefonica.eof.entity.PriceProperties;
import com.telefonica.eof.entity.RelationMaster;
import com.telefonica.eof.entity.Sps;
import com.telefonica.eof.entity.Upfront;
import com.telefonica.eof.entity.VasBenefits;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType;
import com.telefonica.eof.generated.model.ComponentProdOfferPriceType.PriceTypeEnum;
import com.telefonica.eof.pojo.sva.BillingOfferResponse;
import com.telefonica.eof.pojo.sva.SvaResponse;
import com.telefonica.eof.repository.BillingOfferMasterRepository;
import com.telefonica.eof.repository.ComponentsMasterRepository;
import com.telefonica.eof.repository.MasterOfOffersRepository;
import com.telefonica.eof.repository.OffersPropertiesRepository;
import com.telefonica.eof.repository.PricePropertiesRepository;
import com.telefonica.eof.repository.PropertyInBillingOfferRepository;
import com.telefonica.eof.repository.RelationMasterRepository;
import com.telefonica.eof.repository.RelationOffersXPlanRepository;
import com.telefonica.eof.repository.SvaOfferingRepository;
import com.telefonica.eof.repository.TbconfigItemRepository;
import com.telefonica.eof.repository.UpfrontRepository;
import com.telefonica.eof.repository.VasBenefitsRepository;

/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: Sva.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que obtiene los "servicios de valor agregado"(sva)
 *               adicionales
 */
@Component
public class Sva {
    @Autowired
    private MasterOfOffersRepository	     masterOfOffersRepository;
    @Autowired
    private OffersPropertiesRepository	     offersPropertiesRepository;
    @Autowired
    private SvaOfferingRepository	     svaOfferingRepository;
    @Autowired
    private RelationMasterRepository	     relationMasterRepository;
    @Autowired
    private RelationOffersXPlanRepository    relationOffersXPlanRepository;
    @Autowired
    private PricePropertiesRepository	     pricePropertiesRepository;
    @Autowired
    private VasBenefitsRepository	     vasBenefitsRepository;
    @Autowired
    private ComponentsMasterRepository	     componentsMasterRepository;
    @Autowired
    private BillingOfferMasterRepository     billingOfferMasterRepository;
    @Autowired
    private UpfrontRepository		     upfrontRepository;
    @Autowired
    private PropertyInBillingOfferRepository propertyInBillingOfferRepository;
    @Autowired
    private TbconfigItemRepository	     tbconfigItemRepository;

    /**
     * El método obtiene los sva adicionales del cliente sin retencion (IsRetention
     * = N)
     * 
     * @param offersBenefitsRequestDto:
     *            request que viene del front
     * @param flagRetention:
     *            flag que indica si tiene o no retencion
     * @param propertyValueList:
     *            listado de propertyValues
     * @param productOfferingCatalogId:
     *            campo que viene del front
     * @return retorna los servicios de valor agregado
     */

    public List<SvaResponse> getSvaTypeSva(OffersBenefitsRequestDto offersBenefitsRequestDto, String flagRetention,
	    List<OffersProperties> propertyValueList, String productOfferingCatalogId) {

	String query = Constant.ASTERISK_QUERY + Constant.COMMA + flagRetention;
	String flagType = Constant.SVA;

	String offerCaption = masterOfOffersRepository.findOfferCaption(productOfferingCatalogId);
	Integer planCid = relationOffersXPlanRepository.findPlanCid(productOfferingCatalogId);
	Integer maxSTBsallowed = null;

	if (planCid != null) {
	    maxSTBsallowed = propertyInBillingOfferRepository.findPropertyValueByCidBo(planCid);
	}

	Integer score = Optional.ofNullable(offersBenefitsRequestDto.getCreditScore()).map(x -> x % 10).orElse(null);
	String upfront = null;
	if (score != null) {
	    upfront = upfrontRepository.findUpfront().stream().filter(x -> x.getUpfrontIndDesc().contains(score.toString()))
		    .map( Upfront::getUpfrontIndId).collect(Collectors.joining());
	}

	if (Constant.YES.equalsIgnoreCase(upfront)) {
	    maxSTBsallowed = tbconfigItemRepository.findParameterValue();

	}

	List<String> idComponentList = getAditionalComponent(offersBenefitsRequestDto.getAction(), query, propertyValueList);

	List<SvaResponse> svaResponseList = new ArrayList<>();

	for (String idComponent : idComponentList) {

	    if (idComponent != null) {
		List<RelationMaster> billingOfferList = getBillingOffer(productOfferingCatalogId, idComponent, flagType);

		SvaResponse svaResponse = new SvaResponse();
		List<BillingOfferResponse> billingOfferResponseList = new ArrayList<>();

		if (billingOfferList != null) {
		    for (RelationMaster billingOffer : billingOfferList) {

			String modemPremium = upfrontRepository.findUpfront().stream()
				.filter(x -> x.getUpfrontIndDesc().contains(score.toString())).map(Upfront::getUpfrontIndId)
				.collect(Collectors.joining());

			if (!(Constant.YES.equalsIgnoreCase(modemPremium)
				&& billingOffer.getParentId().matches("3192682|3192742|3192652"))) {

			    PriceTypeEnum priceType;

			    BigDecimal amount;

			    Sps spsIdAndName = getSpsIdAndName(billingOffer.getChildId());

			    PriceProperties priceInfo = pricePropertiesRepository.findPriceInfo(billingOffer.getChildId());
			    BigDecimal valueAbp = new BigDecimal(priceInfo.getValueAbp());

			    String relationId;

			    relationId = relationMasterRepository.findRelationId(productOfferingCatalogId, billingOffer.getParentId());

			    if (StringUtil.isNullOrEmpty(relationId)) {
				relationId = relationMasterRepository.findRelationIdByrelationCidRoot(billingOffer.getParentId(),
					productOfferingCatalogId);
			    }

			    if (Constant.OC.equalsIgnoreCase(priceInfo.getRevenueType())) {
				priceType = ComponentProdOfferPriceType.PriceTypeEnum.ONE_TIME;
				amount = Util.igvCalculator(valueAbp);
			    } else {
				priceType = ComponentProdOfferPriceType.PriceTypeEnum.RECURRING;
				amount = Util.igvCalculator(valueAbp);
			    }

			    SvaBenefitParamsDto svaBenefitParamsDto = new SvaBenefitParamsDto();
			    svaBenefitParamsDto.setChannelId(offersBenefitsRequestDto.getChannelId());
			    svaBenefitParamsDto.setOfferCaption(offerCaption);
			    svaBenefitParamsDto.setAction(offersBenefitsRequestDto.getAction());
			    svaBenefitParamsDto.setIsPortability(offersBenefitsRequestDto.getIsPortability());
			    svaBenefitParamsDto.setOrderSubType(offersBenefitsRequestDto.getOrderSubType());
			    svaBenefitParamsDto.setBroadbandConnection(offersBenefitsRequestDto.getBroadband().getConnection());
			    svaBenefitParamsDto.setNetworkTechnology(offersBenefitsRequestDto.getNetworkTechnology());
			    svaBenefitParamsDto.setCommercialAreaId(offersBenefitsRequestDto.getCommercialAreaId());
			    svaBenefitParamsDto.setParentId(spsIdAndName.getParentId());
			    svaBenefitParamsDto.setIDcomponente(idComponent);

			    String dataRateFrom;

			    String dataRateTo;

			    if (offersBenefitsRequestDto.getBroadband().getMinDlDataRate() != null) {
				dataRateFrom = "= 'NA'";
				dataRateTo = "= 'NA'";
			    } else {
				dataRateFrom = Constant.LESS_THAN + offersBenefitsRequestDto.getBroadband().getMinDlDataRate();
				dataRateTo = Constant.GREATER_THAN + offersBenefitsRequestDto.getBroadband().getMinDlDataRate();

			    }
			    VasBenefits vasBenefits = vasBenefitsRepository.findSvaBenefits(svaBenefitParamsDto, dataRateFrom, dataRateTo);
			    String nameComp = componentsMasterRepository
				    .findNameComponentByCidComponent(vasBenefits.getBenefitComponentCid());
			    String parentName = relationMasterRepository.findSpsIdAndName(vasBenefits.getBenefitThemePackSpsCid())
				    .getParentName();
			    String nameBo = billingOfferMasterRepository.findBillingOfferBycidBo(idComponent).getNameBo();

			    BillingOfferResponse billingOfferResponse = new BillingOfferResponse();

			    billingOfferResponse.setBillingOffer(billingOffer);
			    billingOfferResponse.setMaxSTBsallowed(maxSTBsallowed);
			    billingOfferResponse.setSpsIdAndName(spsIdAndName);
			    billingOfferResponse.setPriceType(priceType);
			    billingOfferResponse.setAmount(amount);
			    billingOfferResponse.setVasBenefits(vasBenefits);
			    billingOfferResponse.setNameComp(nameComp);
			    billingOfferResponse.setParentName(parentName);
			    billingOfferResponse.setNameBo(nameBo);
			    billingOfferResponse.setRelationId(relationId);

			    billingOfferResponseList.add(billingOfferResponse);

			}
		    }

		    if (!(billingOfferResponseList == null || billingOfferResponseList.isEmpty())) {
			svaResponse.setIdComponent(idComponent);
			svaResponse.setBillingOffer(billingOfferResponseList);
			svaResponseList.add(svaResponse);

		    }

		}
	    }

	}
	return svaResponseList;
    }

    /**
     * El método obtiene los sva adicionales del cliente en retencion (IsRetention =
     * N)
     * 
     * @param offersBenefitsRequestDto:
     *            request que viene del front
     * @param flagRetention:
     *            flag que indica si tiene o no retencion
     * @param propertyValueList:
     *            listado de propertyValues
     * @param productOfferingCatalogId:
     *            campo que viene del front
     * @return retorna los servicios de valor agregado
     */

    public List<SvaResponse> getSvaTypeRetention(OffersBenefitsRequestDto offersBenefitsRequestDto, String flagRetention,
	    List<OffersProperties> propertyValueList, String productOfferingCatalogId) {

	List<String> idComponentList = getAditionalComponent(offersBenefitsRequestDto.getAction(), flagRetention, propertyValueList);

	List<SvaResponse> svaResponseList = new ArrayList<>();

	idComponentList.forEach(idComponent -> {
	    List<RelationMaster> billingOfferList = getBillingOffer(productOfferingCatalogId, idComponent, flagRetention);

	    SvaResponse svaResponse = new SvaResponse();
	    List<BillingOfferResponse> billingOfferResponseList = new ArrayList<>();

	    billingOfferList.forEach(billingOffer -> {

		String relationId;

		relationId = relationMasterRepository.findRelationId(productOfferingCatalogId, billingOffer.getParentId());

		if (StringUtil.isNullOrEmpty(relationId)) {
		    relationId = relationMasterRepository.findRelationIdByrelationCidRoot(billingOffer.getParentId(),
			    productOfferingCatalogId);
		}

		BillingOfferResponse billingOfferResponse = new BillingOfferResponse();

		billingOfferResponse.setBillingOffer(billingOffer);
		billingOfferResponse.setRelationId(relationId);

		billingOfferResponseList.add(billingOfferResponse);

	    });

	    svaResponse.setIdComponent(idComponent);
	    svaResponse.setBillingOffer(billingOfferResponseList);

	    svaResponseList.add(svaResponse);
	});

	return svaResponseList;

    }

    /**
     * El metodo obtiene los componentes adicionales (idComponente) necesario para
     * el metodo getSvaTypeSva() y getSvaTypeRetention()
     * 
     * @param action:
     *            atributo del offersBenefitsRequestDto que viene del front
     * @param query:
     *            linea de query que varia dependiendo de si es retencion o no
     * @param propertyValueList:
     *            listado de propertyValue de acuerdo al ProductOfferingCatalogId()
     * @return retorna un listado de componentes
     */

    private List<String> getAditionalComponent(String action, String query, List<OffersProperties> propertyValueList) {

	String propertyValueLT = propertyValueList.stream().filter(x -> x.getNameOfProperty().equals(Constant.LOB_TYPE))
		.map(OffersProperties::getPropertyValue).collect(Collectors.joining());

	return svaOfferingRepository.findIdComponent(propertyValueLT, action, query).stream()
		.filter(x -> x.matches("3196671|3197701|3239962|34105211")).collect(Collectors.toList());
    }

    /**
     * El método obtiene un listado de billing offers filtradas por cada
     * idComponente, necesario para el metodo getSvaTypeSva() y
     * getSvaTypeRetention()
     * 
     * @param productOfferingCatalogId:
     *            atributo del offersBenefitsRequestDto que viene del front
     * @param idComponent:
     *            viene del listado del metodo getAditionalComponent()
     * @param flagType:
     *            atributo del offersBenefitsRequestDto que viene del front
     *            (offersBenefitsRequestDto.getProduct().getType())
     * @return List<RelationMaster>: lista de billing offers
     */
    private List<RelationMaster> getBillingOffer(String productOfferingCatalogId, String idComponent, String flagType) {

	List<RelationMaster> billingOfferList = null;

	if (Constant.SVA.equalsIgnoreCase(flagType)) {

	    List<RelationMaster> cidBoActive = relationMasterRepository.findBillingOfferActive(productOfferingCatalogId, idComponent);

	    String cidBoCurrentDateString = cidBoActive.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	    List<String> cidBoBoType = relationMasterRepository.findBillingOfferByBoType(cidBoCurrentDateString);

	    String cidBoBoTypeString = cidBoBoType.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	    if (Constant.BLOQUE_CANALES.equalsIgnoreCase(idComponent)) {
		String propertyValue = " in ('FULL','HD')";
		billingOfferList = relationMasterRepository.validateIdComponente(cidBoBoTypeString, propertyValue);
		String spsId = offersPropertiesRepository.findSpsIdByofferCid(productOfferingCatalogId);

		if (spsId != null ) {
		    String[] arr = spsId.split(";", 0);
		    String spsPropertyValue = arr[0];
		    List<String> parentIdList = relationMasterRepository.findParentIdByChildId(spsPropertyValue);

		    for (String parentId : parentIdList) {
			billingOfferList.removeIf(x -> x.getChildId().contains(parentId));
		    }
		}

	    } else if (idComponent.matches("3197701|3239962|34105211")) {
		String propertyValue = " is null";
		billingOfferList = relationMasterRepository.validateIdComponente(cidBoBoTypeString, propertyValue);
	    }

	} else if (Constant.TRUE.equalsIgnoreCase(flagType)) {
	    billingOfferList = relationMasterRepository.findBillingOfferActive(productOfferingCatalogId, idComponent);
	}

	return billingOfferList;

    }

    /**
     * El método obtiene el id y el nombre del sps, necesario para el metodo
     * getSvaTypeSva() y getSvaTypeRetention()
     * 
     * @param billingOfferChildId:
     *            atributo de RelationMaster que viene como response del metodo
     *            getBillingOffer()
     * @return Sps: contiene id y nombre del sps
     */

    private Sps getSpsIdAndName(String billingOfferChildId) {

	List<String> parentIdList = relationMasterRepository.findParentIdByChildId(billingOfferChildId);
	String parentId = parentIdList.stream().map(Object::toString).collect(Collectors.joining("', '", "'", "'"));

	return relationMasterRepository.findSpsIdAndName(parentId);

    }

}
