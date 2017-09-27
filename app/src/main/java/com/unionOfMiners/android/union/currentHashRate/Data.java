
package com.unionOfMiners.android.union.currentHashRate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "time",
    "lastSeen",
    "reportedHashrate",
    "currentHashrate",
    "validShares",
    "invalidShares",
    "staleShares",
    "averageHashrate",
    "activeWorkers",
    "unpaid",
    "unconfirmed",
    "coinsPerMin",
    "usdPerMin",
    "btcPerMin"
})
public class Data implements Serializable
{

    @JsonProperty("time")
    private long time;
    @JsonProperty("lastSeen")
    private long lastSeen;
    @JsonProperty("reportedHashrate")
    private long reportedHashrate;
    @JsonProperty("currentHashrate")
    private double currentHashrate;
    @JsonProperty("validShares")
    private long validShares;
    @JsonProperty("invalidShares")
    private long invalidShares;
    @JsonProperty("staleShares")
    private long staleShares;
    @JsonProperty("averageHashrate")
    private double averageHashrate;
    @JsonProperty("activeWorkers")
    private long activeWorkers;
    @JsonProperty("unpaid")
    private long unpaid;
    @JsonProperty("unconfirmed")
    private long unconfirmed;
    @JsonProperty("coinsPerMin")
    private double coinsPerMin;
    @JsonProperty("usdPerMin")
    private double usdPerMin;
    @JsonProperty("btcPerMin")
    private double btcPerMin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7310459281627841225L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param lastSeen
     * @param usdPerMin
     * @param btcPerMin
     * @param averageHashrate
     * @param activeWorkers
     * @param validShares
     * @param reportedHashrate
     * @param unconfirmed
     * @param time
     * @param invalidShares
     * @param currentHashrate
     * @param coinsPerMin
     * @param unpaid
     * @param staleShares
     */
    public Data(long time, long lastSeen, long reportedHashrate, double currentHashrate, long validShares, long invalidShares, long staleShares, double averageHashrate, long activeWorkers, long unpaid, long unconfirmed, double coinsPerMin, double usdPerMin, double btcPerMin) {
        super();
        this.time = time;
        this.lastSeen = lastSeen;
        this.reportedHashrate = reportedHashrate;
        this.currentHashrate = currentHashrate;
        this.validShares = validShares;
        this.invalidShares = invalidShares;
        this.staleShares = staleShares;
        this.averageHashrate = averageHashrate;
        this.activeWorkers = activeWorkers;
        this.unpaid = unpaid;
        this.unconfirmed = unconfirmed;
        this.coinsPerMin = coinsPerMin;
        this.usdPerMin = usdPerMin;
        this.btcPerMin = btcPerMin;
    }

    @JsonProperty("time")
    public long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(long time) {
        this.time = time;
    }

    @JsonProperty("lastSeen")
    public long getLastSeen() {
        return lastSeen;
    }

    @JsonProperty("lastSeen")
    public void setLastSeen(long lastSeen) {
        this.lastSeen = lastSeen;
    }

    @JsonProperty("reportedHashrate")
    public long getReportedHashrate() {
        return reportedHashrate;
    }

    @JsonProperty("reportedHashrate")
    public void setReportedHashrate(long reportedHashrate) {
        this.reportedHashrate = reportedHashrate;
    }

    @JsonProperty("currentHashrate")
    public double getCurrentHashrate() {
        return currentHashrate;
    }

    @JsonProperty("currentHashrate")
    public void setCurrentHashrate(double currentHashrate) {
        this.currentHashrate = currentHashrate;
    }

    @JsonProperty("validShares")
    public long getValidShares() {
        return validShares;
    }

    @JsonProperty("validShares")
    public void setValidShares(long validShares) {
        this.validShares = validShares;
    }

    @JsonProperty("invalidShares")
    public long getInvalidShares() {
        return invalidShares;
    }

    @JsonProperty("invalidShares")
    public void setInvalidShares(long invalidShares) {
        this.invalidShares = invalidShares;
    }

    @JsonProperty("staleShares")
    public long getStaleShares() {
        return staleShares;
    }

    @JsonProperty("staleShares")
    public void setStaleShares(long staleShares) {
        this.staleShares = staleShares;
    }

    @JsonProperty("averageHashrate")
    public double getAverageHashrate() {
        return averageHashrate;
    }

    @JsonProperty("averageHashrate")
    public void setAverageHashrate(double averageHashrate) {
        this.averageHashrate = averageHashrate;
    }

    @JsonProperty("activeWorkers")
    public long getActiveWorkers() {
        return activeWorkers;
    }

    @JsonProperty("activeWorkers")
    public void setActiveWorkers(long activeWorkers) {
        this.activeWorkers = activeWorkers;
    }

    @JsonProperty("unpaid")
    public long getUnpaid() {
        return unpaid;
    }

    @JsonProperty("unpaid")
    public void setUnpaid(long unpaid) {
        this.unpaid = unpaid;
    }

    @JsonProperty("unconfirmed")
    public long getUnconfirmed() {
        return unconfirmed;
    }

    @JsonProperty("unconfirmed")
    public void setUnconfirmed(long unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    @JsonProperty("coinsPerMin")
    public double getCoinsPerMin() {
        return coinsPerMin;
    }

    @JsonProperty("coinsPerMin")
    public void setCoinsPerMin(double coinsPerMin) {
        this.coinsPerMin = coinsPerMin;
    }

    @JsonProperty("usdPerMin")
    public double getUsdPerMin() {
        return usdPerMin;
    }

    @JsonProperty("usdPerMin")
    public void setUsdPerMin(double usdPerMin) {
        this.usdPerMin = usdPerMin;
    }

    @JsonProperty("btcPerMin")
    public double getBtcPerMin() {
        return btcPerMin;
    }

    @JsonProperty("btcPerMin")
    public void setBtcPerMin(double btcPerMin) {
        this.btcPerMin = btcPerMin;
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
