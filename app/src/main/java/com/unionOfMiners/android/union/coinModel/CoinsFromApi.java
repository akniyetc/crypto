
package com.unionOfMiners.android.union.coinModel;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.unionOfMiners.android.union.KZTRates.Rss;
import com.unionOfMiners.android.union.USDRates.RatesUSD;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "shapeshift",
        "position24",
        "position",
        "short",
        "long",
        "time",
        "price",
        "perc",
        "volume",
        "usdVolume",
        "cap24hrChange",
        "mktcap",
        "supply",
        "published",
        "vwapData",
        "delta",
        "cap24hrChangePercent",
        "capPercent",
        "vwapDataBTC"
})
public class CoinsFromApi implements Serializable {

    @JsonProperty("shapeshift")
    private boolean shapeshift;
    @JsonProperty("position24")
    private String position24;
    @JsonProperty("position")
    private String position;
    @JsonProperty("short")
    private String _short;
    @JsonProperty("long")
    private String _long;
    @JsonProperty("time")
    private long time;
    @JsonProperty("price")
    private double price;
    @JsonProperty("perc")
    private double perc;
    @JsonProperty("volume")
    private double volume;
    @JsonProperty("usdVolume")
    private String usdVolume;
    @JsonProperty("cap24hrChange")
    private String cap24hrChange;
    @JsonProperty("mktcap")
    private double mktcap;
    @JsonProperty("supply")
    private double supply;
    @JsonProperty("published")
    private boolean published;
    @JsonProperty("vwapData")
    private String vwapData;
    @JsonProperty("delta")
    private String delta;
    @JsonProperty("cap24hrChangePercent")
    private String cap24hrChangePercent;
    @JsonProperty("capPercent")
    private String capPercent;
    @JsonProperty("vwapDataBTC")
    private double vwapDataBTC;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 4003550095782983386L;



//    private CoinsFromApi(Parcel in) {
//        shapeshift = in.readByte() != 0;
//        position24 = in.readString();
//        position = in.readString();
//        _short = in.readString();
//        _long = in.readString();
//        time = in.readLong();
//        price = in.readDouble();
//        perc = in.readDouble();
//        volume = in.readDouble();
//        usdVolume = in.readString();
//        cap24hrChange = in.readString();
//        mktcap = in.readDouble();
//        supply = in.readDouble();
//        published = in.readByte() != 0;
//        vwapData = in.readString();
//        delta = in.readString();
//        cap24hrChangePercent = in.readString();
//        capPercent = in.readString();
//        vwapDataBTC = in.readDouble();
//    }
//
//    public static final Creator<CoinsFromApi> CREATOR = new Creator<CoinsFromApi>() {
//        @Override
//        public CoinsFromApi createFromParcel(Parcel in) {
//            return new CoinsFromApi(in);
//        }
//
//        @Override
//        public CoinsFromApi[] newArray(int size) {
//            return new CoinsFromApi[size];
//        }
//    };

    @JsonProperty("shapeshift")
    public boolean isShapeshift() {
        return shapeshift;
    }

    @JsonProperty("shapeshift")
    public void setShapeshift(boolean shapeshift) {
        this.shapeshift = shapeshift;
    }

    @JsonProperty("position24")
    public String getPosition24() {
        return position24;
    }

    @JsonProperty("position24")
    public void setPosition24(String position24) {
        this.position24 = position24;
    }

    @JsonProperty("position")
    public String getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(String position) {
        this.position = position;
    }

    @JsonProperty("short")
    public String getShort() {
        return _short;
    }

    @JsonProperty("short")
    public void setShort(String _short) {
        this._short = _short;
    }

    @JsonProperty("long")
    public String getLong() {
        return _long;
    }

    @JsonProperty("long")
    public void setLong(String _long) {
        this._long = _long;
    }

    @JsonProperty("time")
    public long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(long time) {
        this.time = time;
    }

    @JsonProperty("price")
    public double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(double price) {
        this.price = price;
    }

    @JsonProperty("perc")
    public double getPerc() {
        return perc;
    }

    @JsonProperty("perc")
    public void setPerc(double perc) {
        this.perc = perc;
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

    @JsonProperty("cap24hrChange")
    public String getCap24hrChange() {
        return cap24hrChange;
    }

    @JsonProperty("cap24hrChange")
    public void setCap24hrChange(String cap24hrChange) {
        this.cap24hrChange = cap24hrChange;
    }

    @JsonProperty("mktcap")
    public double getMktcap() {
        return mktcap;
    }

    @JsonProperty("mktcap")
    public void setMktcap(double mktcap) {
        this.mktcap = mktcap;
    }

    @JsonProperty("supply")
    public double getSupply() {
        return supply;
    }

    @JsonProperty("supply")
    public void setSupply(double supply) {
        this.supply = supply;
    }

    @JsonProperty("published")
    public boolean isPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(boolean published) {
        this.published = published;
    }

    @JsonProperty("vwapData")
    public String getVwapData() {
        return vwapData;
    }

    @JsonProperty("vwapData")
    public void setVwapData(String vwapData) {
        this.vwapData = vwapData;
    }

    @JsonProperty("delta")
    public String getDelta() {
        return delta;
    }

    @JsonProperty("delta")
    public void setDelta(String delta) {
        this.delta = delta;
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

    @JsonProperty("vwapDataBTC")
    public double getVwapDataBTC() {
        return vwapDataBTC;
    }

    @JsonProperty("vwapDataBTC")
    public void setVwapDataBTC(double vwapDataBTC) {
        this.vwapDataBTC = vwapDataBTC;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public double getEur() {
        return price * RatesUSD.rates.getEUR();
    }

    public double getGbp() {
        return price * RatesUSD.rates.getGBP();
    }

    public double getRub() {
        return price * RatesUSD.rates.getRUB();
    }

    public double getKzt() {
        return price * Rss.items.get(4).getDescription();
    }

    public double getEURCap() {
        return mktcap * RatesUSD.rates.getEUR();
    }

    public double getGBPCap() {
        return mktcap * RatesUSD.rates.getGBP();
    }

    public double getRUBCap() {
        return mktcap * RatesUSD.rates.getRUB();
    }

    public double getKZTCap() {
        return mktcap * Rss.items.get(4).getDescription();
    }


    public double getEURVolume() {
        return volume * RatesUSD.rates.getEUR();
    }

    public double getGBPVolume() {
        return volume * RatesUSD.rates.getGBP();
    }

    public double getRUBVolume() {
        return volume * RatesUSD.rates.getRUB();
    }

    public double getKZTVolume() {
        return volume * Rss.items.get(4).getDescription();
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeDouble(price);
//    }
}
