
package com.unionOfMiners.android.union.coinModel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "published",
    "time",
    "vwapDataBTC",
    "vwapData",
    "cap24hrChange",
    "short",
    "position24",
    "long",
    "perc",
    "supply",
    "price",
    "volume",
    "usdVolume",
    "mktcap",
    "cap24hrChangePercent",
    "capPercent",
    "isBuy"
})
public class Msg implements Serializable
{

    @JsonProperty("published")
    private boolean published;
    @JsonProperty("time")
    private long time;
    @JsonProperty("vwapDataBTC")
    private String vwapDataBTC;
    @JsonProperty("vwapData")
    private String vwapData;
    @JsonProperty("cap24hrChange")
    private String cap24hrChange;
    @JsonProperty("short")
    private String _short;
    @JsonProperty("position24")
    private String position24;
    @JsonProperty("long")
    private String _long;
    @JsonProperty("perc")
    private String perc;
    @JsonProperty("supply")
    private String supply;
    @JsonProperty("price")
    private double price;
    @JsonProperty("volume")
    private double volume;
    @JsonProperty("usdVolume")
    private String usdVolume;
    @JsonProperty("mktcap")
    private long mktcap;
    @JsonProperty("cap24hrChangePercent")
    private String cap24hrChangePercent;
    @JsonProperty("capPercent")
    private String capPercent;
    @JsonProperty("isBuy")
    private boolean isBuy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5158825375298044641L;

    @JsonProperty("published")
    public boolean isPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(boolean published) {
        this.published = published;
    }

    @JsonProperty("time")
    public long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(long time) {
        this.time = time;
    }

    @JsonProperty("vwapDataBTC")
    public String getVwapDataBTC() {
        return vwapDataBTC;
    }

    @JsonProperty("vwapDataBTC")
    public void setVwapDataBTC(String vwapDataBTC) {
        this.vwapDataBTC = vwapDataBTC;
    }

    @JsonProperty("vwapData")
    public String getVwapData() {
        return vwapData;
    }

    @JsonProperty("vwapData")
    public void setVwapData(String vwapData) {
        this.vwapData = vwapData;
    }

    @JsonProperty("cap24hrChange")
    public String getCap24hrChange() {
        return cap24hrChange;
    }

    @JsonProperty("cap24hrChange")
    public void setCap24hrChange(String cap24hrChange) {
        this.cap24hrChange = cap24hrChange;
    }

    @JsonProperty("short")
    public String getShort() {
        return _short;
    }

    @JsonProperty("short")
    public void setShort(String _short) {
        this._short = _short;
    }

    @JsonProperty("position24")
    public String getPosition24() {
        return position24;
    }

    @JsonProperty("position24")
    public void setPosition24(String position24) {
        this.position24 = position24;
    }

    @JsonProperty("long")
    public String getLong() {
        return _long;
    }

    @JsonProperty("long")
    public void setLong(String _long) {
        this._long = _long;
    }

    @JsonProperty("perc")
    public double getPerc() {
        double doublePerc = Double.parseDouble(perc);
        return doublePerc;
    }

    @JsonProperty("perc")
    public void setPerc(String perc) {
        this.perc = perc;
    }

    @JsonProperty("supply")
    public String getSupply() {
        return supply;
    }

    @JsonProperty("supply")
    public void setSupply(String supply) {
        this.supply = supply;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("volume")
    public double getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @JsonProperty("usdVolume")
    public String getUsdVolume() {
        return usdVolume;
    }

    @JsonProperty("usdVolume")
    public void setUsdVolume(String usdVolume) {
        this.usdVolume = usdVolume;
    }

    @JsonProperty("mktcap")
    public long getMktcap() {
        return mktcap;
    }

    @JsonProperty("mktcap")
    public void setMktcap(long mktcap) {
        this.mktcap = mktcap;
    }

    @JsonProperty("cap24hrChangePercent")
    public String getCap24hrChangePercent() {
        return cap24hrChangePercent;
    }

    @JsonProperty("cap24hrChangePercent")
    public void setCap24hrChangePercent(String cap24hrChangePercent) {
        this.cap24hrChangePercent = cap24hrChangePercent;
    }

    @JsonProperty("capPercent")
    public String getCapPercent() {
        return capPercent;
    }

    @JsonProperty("capPercent")
    public void setCapPercent(String capPercent) {
        this.capPercent = capPercent;
    }

    @JsonProperty("isBuy")
    public boolean isIsBuy() {
        return isBuy;
    }

    @JsonProperty("isBuy")
    public void setIsBuy(boolean isBuy) {
        this.isBuy = isBuy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
