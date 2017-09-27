
package com.unionOfMiners.android.union.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDatum implements Serializable
{

    @SerializedName("StaticId")
    @Expose
    private long staticId;
    @SerializedName("Total")
    @Expose
    private long total;
    @SerializedName("Zec")
    @Expose
    private long zec;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("UserId")
    @Expose
    private long userId;
    @SerializedName("Kratnost")
    @Expose
    private long kratnost;
    private final static long serialVersionUID = 8012002647170205265L;

    public long getStaticId() {
        return staticId;
    }

    public void setStaticId(long staticId) {
        this.staticId = staticId;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getZec() {
        return zec;
    }

    public void setZec(long zec) {
        this.zec = zec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getKratnost() {
        return kratnost;
    }

    public void setKratnost(long kratnost) {
        this.kratnost = kratnost;
    }

}
