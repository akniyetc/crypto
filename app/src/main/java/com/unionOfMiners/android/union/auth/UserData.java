
package com.unionOfMiners.android.union.auth;

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
    "StaticId",
    "Total",
    "Zec",
    "Date",
    "UserId",
    "Kratnost"
})
public class UserData implements Serializable
{

    @JsonProperty("StaticId")
    private long staticId;
    @JsonProperty("Total")
    private long total;
    @JsonProperty("Zec")
    private long zec;
    @JsonProperty("Date")
    private String date;
    @JsonProperty("UserId")
    private long userId;
    @JsonProperty("Kratnost")
    private long kratnost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5436906867079065546L;

    @JsonProperty("StaticId")
    public long getStaticId() {
        return staticId;
    }

    @JsonProperty("StaticId")
    public void setStaticId(long staticId) {
        this.staticId = staticId;
    }

    @JsonProperty("Total")
    public long getTotal() {
        return total;
    }

    @JsonProperty("Total")
    public void setTotal(long total) {
        this.total = total;
    }

    @JsonProperty("Zec")
    public long getZec() {
        return zec;
    }

    @JsonProperty("Zec")
    public void setZec(long zec) {
        this.zec = zec;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("UserId")
    public long getUserId() {
        return userId;
    }

    @JsonProperty("UserId")
    public void setUserId(long userId) {
        this.userId = userId;
    }

    @JsonProperty("Kratnost")
    public long getKratnost() {
        return kratnost;
    }

    @JsonProperty("Kratnost")
    public void setKratnost(long kratnost) {
        this.kratnost = kratnost;
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
