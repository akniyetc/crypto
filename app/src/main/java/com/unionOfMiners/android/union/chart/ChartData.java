
package com.unionOfMiners.android.union.chart;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "market_cap",
    "price",
    "volume"
})
public class ChartData implements Serializable
{

    @JsonProperty("market_cap")
    private List<List<Long>> marketCap = null;
    @JsonProperty("price")
    private List<List<Float>> price = null;
    @JsonProperty("volume")
    private List<List<Long>> volume = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6210169387230772894L;

    @JsonProperty("market_cap")
    public List<List<Long>> getMarketCap() {
        return marketCap;
    }

    @JsonProperty("market_cap")
    public void setMarketCap(List<List<Long>> marketCap) {
        this.marketCap = marketCap;
    }

    @JsonProperty("price")
    public List<List<Float>> getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(List<List<Float>> price) {
        this.price = price;
    }

    @JsonProperty("volume")
    public List<List<Long>> getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(List<List<Long>> volume) {
        this.volume = volume;
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
