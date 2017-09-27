package com.unionOfMiners.android.union.restInterface;

import com.unionOfMiners.android.union.chart.ChartData;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by HP on 14.08.2017.
 */

public interface ChartInterface {
    @GET("history/{time}/{coin}")
    Call<ChartData> getChartData(@Path("time") String time, @Path("coin") String coin);

    @GET("history/{coin}")
    Call<ChartData> getChartDataAll(@Path("coin") String coin);
}
