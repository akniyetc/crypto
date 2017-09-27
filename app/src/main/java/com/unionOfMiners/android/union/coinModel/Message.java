
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
    "coin",
    "msg"
})
public class Message implements Serializable
{

    @JsonProperty("coin")
    private String coin;
    @JsonProperty("msg")
    private Msg msg;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 266091504586467185L;

    @JsonProperty("coin")
    public String getCoin() {
        return coin;
    }

    @JsonProperty("coin")
    public void setCoin(String coin) {
        this.coin = coin;
    }

    @JsonProperty("msg")
    public Msg getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(Msg msg) {
        this.msg = msg;
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
