package com.unionOfMiners.android.union.restInterface;

import com.unionOfMiners.android.union.KZTRates.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 28.07.2017.
 */

public interface CurrencyInterface {
    @GET("rss/rates_all.xml")
    Call<Rss> getSimpleCurrency();
}
