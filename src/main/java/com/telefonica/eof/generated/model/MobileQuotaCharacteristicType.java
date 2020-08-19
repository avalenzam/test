package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Information for mobile type products, providing details on available data, voice and sms quota
 */
@ApiModel(description = "Information for mobile type products, providing details on available data, voice and sms quota")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-17T23:56:34.536Z")




public class MobileQuotaCharacteristicType   {
  @JsonProperty("voiceQuota")
  @Valid
  private List<MobileQuotaCharacteristicTypeVoiceQuota> voiceQuota = null;

  @JsonProperty("dataQuota")
  @Valid
  private List<MobileQuotaCharacteristicTypeDataQuota> dataQuota = null;

  @JsonProperty("smsQuota")
  @Valid
  private List<MobileQuotaCharacteristicTypeSmsQuota> smsQuota = null;

  public MobileQuotaCharacteristicType voiceQuota(List<MobileQuotaCharacteristicTypeVoiceQuota> voiceQuota) {
    this.voiceQuota = voiceQuota;
    return this;
  }

  public MobileQuotaCharacteristicType addVoiceQuotaItem(MobileQuotaCharacteristicTypeVoiceQuota voiceQuotaItem) {
    if (this.voiceQuota == null) {
      this.voiceQuota = new ArrayList<MobileQuotaCharacteristicTypeVoiceQuota>();
    }
    this.voiceQuota.add(voiceQuotaItem);
    return this;
  }

  /**
   * Get voiceQuota
   * @return voiceQuota
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<MobileQuotaCharacteristicTypeVoiceQuota> getVoiceQuota() {
    return voiceQuota;
  }

  public void setVoiceQuota(List<MobileQuotaCharacteristicTypeVoiceQuota> voiceQuota) {
    this.voiceQuota = voiceQuota;
  }

  public MobileQuotaCharacteristicType dataQuota(List<MobileQuotaCharacteristicTypeDataQuota> dataQuota) {
    this.dataQuota = dataQuota;
    return this;
  }

  public MobileQuotaCharacteristicType addDataQuotaItem(MobileQuotaCharacteristicTypeDataQuota dataQuotaItem) {
    if (this.dataQuota == null) {
      this.dataQuota = new ArrayList<MobileQuotaCharacteristicTypeDataQuota>();
    }
    this.dataQuota.add(dataQuotaItem);
    return this;
  }

  /**
   * Get dataQuota
   * @return dataQuota
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<MobileQuotaCharacteristicTypeDataQuota> getDataQuota() {
    return dataQuota;
  }

  public void setDataQuota(List<MobileQuotaCharacteristicTypeDataQuota> dataQuota) {
    this.dataQuota = dataQuota;
  }

  public MobileQuotaCharacteristicType smsQuota(List<MobileQuotaCharacteristicTypeSmsQuota> smsQuota) {
    this.smsQuota = smsQuota;
    return this;
  }

  public MobileQuotaCharacteristicType addSmsQuotaItem(MobileQuotaCharacteristicTypeSmsQuota smsQuotaItem) {
    if (this.smsQuota == null) {
      this.smsQuota = new ArrayList<MobileQuotaCharacteristicTypeSmsQuota>();
    }
    this.smsQuota.add(smsQuotaItem);
    return this;
  }

  /**
   * Get smsQuota
   * @return smsQuota
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<MobileQuotaCharacteristicTypeSmsQuota> getSmsQuota() {
    return smsQuota;
  }

  public void setSmsQuota(List<MobileQuotaCharacteristicTypeSmsQuota> smsQuota) {
    this.smsQuota = smsQuota;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MobileQuotaCharacteristicType mobileQuotaCharacteristicType = (MobileQuotaCharacteristicType) o;
    return Objects.equals(this.voiceQuota, mobileQuotaCharacteristicType.voiceQuota) &&
        Objects.equals(this.dataQuota, mobileQuotaCharacteristicType.dataQuota) &&
        Objects.equals(this.smsQuota, mobileQuotaCharacteristicType.smsQuota);
  }

  @Override
  public int hashCode() {
    return Objects.hash(voiceQuota, dataQuota, smsQuota);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MobileQuotaCharacteristicType {\n");
    
    sb.append("    voiceQuota: ").append(toIndentedString(voiceQuota)).append("\n");
    sb.append("    dataQuota: ").append(toIndentedString(dataQuota)).append("\n");
    sb.append("    smsQuota: ").append(toIndentedString(smsQuota)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

