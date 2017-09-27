
package com.unionOfMiners.android.union.USDRates;

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
    "AUD",
    "BGN",
    "BRL",
    "CAD",
    "CHF",
    "CNY",
    "CZK",
    "DKK",
    "GBP",
    "HKD",
    "HRK",
    "HUF",
    "IDR",
    "ILS",
    "INR",
    "JPY",
    "KRW",
    "MXN",
    "MYR",
    "NOK",
    "NZD",
    "PHP",
    "PLN",
    "RON",
    "RUB",
    "SEK",
    "SGD",
    "THB",
    "TRY",
    "ZAR",
    "EUR"
})
public class Rates implements Serializable
{

    @JsonProperty("AUD")
    private double aUD;
    @JsonProperty("BGN")
    private double bGN;
    @JsonProperty("BRL")
    private double bRL;
    @JsonProperty("CAD")
    private double cAD;
    @JsonProperty("CHF")
    private double cHF;
    @JsonProperty("CNY")
    private double cNY;
    @JsonProperty("CZK")
    private double cZK;
    @JsonProperty("DKK")
    private double dKK;
    @JsonProperty("GBP")
    private double gBP;
    @JsonProperty("HKD")
    private double hKD;
    @JsonProperty("HRK")
    private double hRK;
    @JsonProperty("HUF")
    private double hUF;
    @JsonProperty("IDR")
    private long iDR;
    @JsonProperty("ILS")
    private double iLS;
    @JsonProperty("INR")
    private double iNR;
    @JsonProperty("JPY")
    private double jPY;
    @JsonProperty("KRW")
    private double kRW;
    @JsonProperty("MXN")
    private double mXN;
    @JsonProperty("MYR")
    private double mYR;
    @JsonProperty("NOK")
    private double nOK;
    @JsonProperty("NZD")
    private double nZD;
    @JsonProperty("PHP")
    private double pHP;
    @JsonProperty("PLN")
    private double pLN;
    @JsonProperty("RON")
    private double rON;
    @JsonProperty("RUB")
    private double rUB;
    @JsonProperty("SEK")
    private double sEK;
    @JsonProperty("SGD")
    private double sGD;
    @JsonProperty("THB")
    private double tHB;
    @JsonProperty("TRY")
    private double tRY;
    @JsonProperty("ZAR")
    private double zAR;
    @JsonProperty("EUR")
    private double eUR;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -1513918199529157331L;

    @JsonProperty("AUD")
    public double getAUD() {
        return aUD;
    }

    @JsonProperty("AUD")
    public void setAUD(double aUD) {
        this.aUD = aUD;
    }

    @JsonProperty("BGN")
    public double getBGN() {
        return bGN;
    }

    @JsonProperty("BGN")
    public void setBGN(double bGN) {
        this.bGN = bGN;
    }

    @JsonProperty("BRL")
    public double getBRL() {
        return bRL;
    }

    @JsonProperty("BRL")
    public void setBRL(double bRL) {
        this.bRL = bRL;
    }

    @JsonProperty("CAD")
    public double getCAD() {
        return cAD;
    }

    @JsonProperty("CAD")
    public void setCAD(double cAD) {
        this.cAD = cAD;
    }

    @JsonProperty("CHF")
    public double getCHF() {
        return cHF;
    }

    @JsonProperty("CHF")
    public void setCHF(double cHF) {
        this.cHF = cHF;
    }

    @JsonProperty("CNY")
    public double getCNY() {
        return cNY;
    }

    @JsonProperty("CNY")
    public void setCNY(double cNY) {
        this.cNY = cNY;
    }

    @JsonProperty("CZK")
    public double getCZK() {
        return cZK;
    }

    @JsonProperty("CZK")
    public void setCZK(double cZK) {
        this.cZK = cZK;
    }

    @JsonProperty("DKK")
    public double getDKK() {
        return dKK;
    }

    @JsonProperty("DKK")
    public void setDKK(double dKK) {
        this.dKK = dKK;
    }

    @JsonProperty("GBP")
    public double getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(double gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("HKD")
    public double getHKD() {
        return hKD;
    }

    @JsonProperty("HKD")
    public void setHKD(double hKD) {
        this.hKD = hKD;
    }

    @JsonProperty("HRK")
    public double getHRK() {
        return hRK;
    }

    @JsonProperty("HRK")
    public void setHRK(double hRK) {
        this.hRK = hRK;
    }

    @JsonProperty("HUF")
    public double getHUF() {
        return hUF;
    }

    @JsonProperty("HUF")
    public void setHUF(double hUF) {
        this.hUF = hUF;
    }

    @JsonProperty("IDR")
    public long getIDR() {
        return iDR;
    }

    @JsonProperty("IDR")
    public void setIDR(long iDR) {
        this.iDR = iDR;
    }

    @JsonProperty("ILS")
    public double getILS() {
        return iLS;
    }

    @JsonProperty("ILS")
    public void setILS(double iLS) {
        this.iLS = iLS;
    }

    @JsonProperty("INR")
    public double getINR() {
        return iNR;
    }

    @JsonProperty("INR")
    public void setINR(double iNR) {
        this.iNR = iNR;
    }

    @JsonProperty("JPY")
    public double getJPY() {
        return jPY;
    }

    @JsonProperty("JPY")
    public void setJPY(double jPY) {
        this.jPY = jPY;
    }

    @JsonProperty("KRW")
    public double getKRW() {
        return kRW;
    }

    @JsonProperty("KRW")
    public void setKRW(double kRW) {
        this.kRW = kRW;
    }

    @JsonProperty("MXN")
    public double getMXN() {
        return mXN;
    }

    @JsonProperty("MXN")
    public void setMXN(double mXN) {
        this.mXN = mXN;
    }

    @JsonProperty("MYR")
    public double getMYR() {
        return mYR;
    }

    @JsonProperty("MYR")
    public void setMYR(double mYR) {
        this.mYR = mYR;
    }

    @JsonProperty("NOK")
    public double getNOK() {
        return nOK;
    }

    @JsonProperty("NOK")
    public void setNOK(double nOK) {
        this.nOK = nOK;
    }

    @JsonProperty("NZD")
    public double getNZD() {
        return nZD;
    }

    @JsonProperty("NZD")
    public void setNZD(double nZD) {
        this.nZD = nZD;
    }

    @JsonProperty("PHP")
    public double getPHP() {
        return pHP;
    }

    @JsonProperty("PHP")
    public void setPHP(double pHP) {
        this.pHP = pHP;
    }

    @JsonProperty("PLN")
    public double getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(double pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("RON")
    public double getRON() {
        return rON;
    }

    @JsonProperty("RON")
    public void setRON(double rON) {
        this.rON = rON;
    }

    @JsonProperty("RUB")
    public double getRUB() {
        return rUB;
    }

    @JsonProperty("RUB")
    public void setRUB(double rUB) {
        this.rUB = rUB;
    }

    @JsonProperty("SEK")
    public double getSEK() {
        return sEK;
    }

    @JsonProperty("SEK")
    public void setSEK(double sEK) {
        this.sEK = sEK;
    }

    @JsonProperty("SGD")
    public double getSGD() {
        return sGD;
    }

    @JsonProperty("SGD")
    public void setSGD(double sGD) {
        this.sGD = sGD;
    }

    @JsonProperty("THB")
    public double getTHB() {
        return tHB;
    }

    @JsonProperty("THB")
    public void setTHB(double tHB) {
        this.tHB = tHB;
    }

    @JsonProperty("TRY")
    public double getTRY() {
        return tRY;
    }

    @JsonProperty("TRY")
    public void setTRY(double tRY) {
        this.tRY = tRY;
    }

    @JsonProperty("ZAR")
    public double getZAR() {
        return zAR;
    }

    @JsonProperty("ZAR")
    public void setZAR(double zAR) {
        this.zAR = zAR;
    }

    @JsonProperty("EUR")
    public double getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(double eUR) {
        this.eUR = eUR;
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
