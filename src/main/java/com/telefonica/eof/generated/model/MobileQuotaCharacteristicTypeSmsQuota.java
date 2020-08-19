package com.telefonica.eof.generated.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * MobileQuotaCharacteristicTypeSmsQuota
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-08-17T23:56:34.536Z")




public class MobileQuotaCharacteristicTypeSmsQuota   {
  @JsonProperty("smsAllowance")
  private Integer smsAllowance = null;

  /**
   * Gets or Sets timeBands
   */
  public enum TimeBandsEnum {
    DAY("day"),
    
    NIGHT("night"),
    
    MORNING("morning"),
    
    EVENING("evening"),
    
    WEEKENDS("weekends"),
    
    WORKDAYS("workdays"),
    
    ALL("all");

    private String value;

    TimeBandsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TimeBandsEnum fromValue(String text) {
      for (TimeBandsEnum b : TimeBandsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("timeBands")
  @Valid
  private List<TimeBandsEnum> timeBands = null;

  /**
   * Gets or Sets origins
   */
  public enum OriginsEnum {
    HOME("home"),
    
    ROAMING("roaming"),
    
    EU("EU"),
    
    ANY("any");

    private String value;

    OriginsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OriginsEnum fromValue(String text) {
      for (OriginsEnum b : OriginsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("origins")
  @Valid
  private List<OriginsEnum> origins = null;

  /**
   * Gets or Sets destinations
   */
  public enum DestinationsEnum {
    TELEFONICA("telefonica"),
    
    NONTELEFONICA("nontelefonica"),
    
    LOCAL("local"),
    
    REGIONAL("regional"),
    
    NATIONAL("national"),
    
    INTERNATIONAL("international"),
    
    MOBILE("mobile"),
    
    LANDLINE("landline"),
    
    RURAL("rural"),
    
    ANY("any");

    private String value;

    DestinationsEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DestinationsEnum fromValue(String text) {
      for (DestinationsEnum b : DestinationsEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("destinations")
  @Valid
  private List<DestinationsEnum> destinations = null;

  public MobileQuotaCharacteristicTypeSmsQuota smsAllowance(Integer smsAllowance) {
    this.smsAllowance = smsAllowance;
    return this;
  }

  /**
   * Voice quota max number of sms allowed to consume. -1 means unlimited
   * @return smsAllowance
  **/
  @ApiModelProperty(required = true, value = "Voice quota max number of sms allowed to consume. -1 means unlimited")
  @NotNull


  public Integer getSmsAllowance() {
    return smsAllowance;
  }

  public void setSmsAllowance(Integer smsAllowance) {
    this.smsAllowance = smsAllowance;
  }

  public MobileQuotaCharacteristicTypeSmsQuota timeBands(List<TimeBandsEnum> timeBands) {
    this.timeBands = timeBands;
    return this;
  }

  public MobileQuotaCharacteristicTypeSmsQuota addTimeBandsItem(TimeBandsEnum timeBandsItem) {
    if (this.timeBands == null) {
      this.timeBands = new ArrayList<TimeBandsEnum>();
    }
    this.timeBands.add(timeBandsItem);
    return this;
  }

  /**
   * Get timeBands
   * @return timeBands
  **/
  @ApiModelProperty(value = "")


  public List<TimeBandsEnum> getTimeBands() {
    return timeBands;
  }

  public void setTimeBands(List<TimeBandsEnum> timeBands) {
    this.timeBands = timeBands;
  }

  public MobileQuotaCharacteristicTypeSmsQuota origins(List<OriginsEnum> origins) {
    this.origins = origins;
    return this;
  }

  public MobileQuotaCharacteristicTypeSmsQuota addOriginsItem(OriginsEnum originsItem) {
    if (this.origins == null) {
      this.origins = new ArrayList<OriginsEnum>();
    }
    this.origins.add(originsItem);
    return this;
  }

  /**
   * Get origins
   * @return origins
  **/
  @ApiModelProperty(value = "")


  public List<OriginsEnum> getOrigins() {
    return origins;
  }

  public void setOrigins(List<OriginsEnum> origins) {
    this.origins = origins;
  }

  public MobileQuotaCharacteristicTypeSmsQuota destinations(List<DestinationsEnum> destinations) {
    this.destinations = destinations;
    return this;
  }

  public MobileQuotaCharacteristicTypeSmsQuota addDestinationsItem(DestinationsEnum destinationsItem) {
    if (this.destinations == null) {
      this.destinations = new ArrayList<DestinationsEnum>();
    }
    this.destinations.add(destinationsItem);
    return this;
  }

  /**
   * Get destinations
   * @return destinations
  **/
  @ApiModelProperty(value = "")


  public List<DestinationsEnum> getDestinations() {
    return destinations;
  }

  public void setDestinations(List<DestinationsEnum> destinations) {
    this.destinations = destinations;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MobileQuotaCharacteristicTypeSmsQuota mobileQuotaCharacteristicTypeSmsQuota = (MobileQuotaCharacteristicTypeSmsQuota) o;
    return Objects.equals(this.smsAllowance, mobileQuotaCharacteristicTypeSmsQuota.smsAllowance) &&
        Objects.equals(this.timeBands, mobileQuotaCharacteristicTypeSmsQuota.timeBands) &&
        Objects.equals(this.origins, mobileQuotaCharacteristicTypeSmsQuota.origins) &&
        Objects.equals(this.destinations, mobileQuotaCharacteristicTypeSmsQuota.destinations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(smsAllowance, timeBands, origins, destinations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MobileQuotaCharacteristicTypeSmsQuota {\n");
    
    sb.append("    smsAllowance: ").append(toIndentedString(smsAllowance)).append("\n");
    sb.append("    timeBands: ").append(toIndentedString(timeBands)).append("\n");
    sb.append("    origins: ").append(toIndentedString(origins)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
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

