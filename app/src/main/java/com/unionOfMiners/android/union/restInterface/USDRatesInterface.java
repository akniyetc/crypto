package com.unionOfMiners.android.union.restInterface;

import com.unionOfMiners.android.union.USDRates.RatesUSD;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HP on 10.08.2017.
 */

public interface USDRatesInterface {
    @GET("latest")
    Call<RatesUSD> getUSDRates(@Query("base") String base);
}
