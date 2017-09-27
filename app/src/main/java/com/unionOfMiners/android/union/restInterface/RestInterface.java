package com.unionOfMiners.android.union.restInterface;

import com.unionOfMiners.android.union.coinModel.CoinsFromApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 26.07.2017.
 */

public interface RestInterface {
    @GET("front/")
    Call<List<CoinsFromApi>> getCryptoCurrency();
}
