
package com.unionOfMiners.android.union.currentHashRate.currentHistory;

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
    "reportedHashrate",
    "currentHashrate",
    "validShares",
    "invalidShares",
    "staleShares",
    "averageHashrate",
    "activeWorkers"
})
public class Datum implements Serializable
{

    @JsonProperty("time")
    private long time;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6157368198638613806L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param time
     * @param activeWorkers
     * @param averageHashrate
     * @param invalidShares
     * @param validShares
     * @param currentHashrate
     * @param staleShares
     * @param reportedHashrate
     */
    public Datum(long time, long reportedHashrate, double currentHashrate, long validShares, long invalidShares, long staleShares, double averageHashrate, long activeWorkers) {
        super();
        this.time = time;
        this.reportedHashrate = reportedHashrate;
        this.currentHashrate = currentHashrate;
        this.validShares = validShares;
        this.invalidShares = invalidShares;
        this.staleShares = staleShares;
        this.averageHashrate = averageHashrate;
        this.activeWorkers = activeWorkers;
    }

    @JsonProperty("time")
    public long getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(long time) {
        this.time = time;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
