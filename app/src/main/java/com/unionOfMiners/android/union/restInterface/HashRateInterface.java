package com.unionOfMiners.android.union.restInterface;

import com.unionOfMiners.android.union.currentHashRate.CurrentHashRate;
import com.unionOfMiners.android.union.currentHashRate.currentHistory.CurrentHistory;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 14.09.2017.
 */

public interface HashRateInterface {

    @GET("/miner/t1Un3Zr21XH9dicgPS2yWmHsv4gys9KvHLK/currentStats")
    Call<CurrentHashRate> getCurrentHashRate();

    @GET("/miner/t1Un3Zr21XH9dicgPS2yWmHsv4gys9KvHLK/history")
    Call<CurrentHistory> getCurrentHistory();
}
