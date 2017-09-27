package com.unionOfMiners.android.union;

import android.app.Application;
import android.content.ContextWrapper;
import android.util.Log;

import com.pixplicity.easyprefs.library.Prefs;
import com.unionOfMiners.android.union.restInterface.AuthInterface;
import com.unionOfMiners.android.union.restInterface.ChartInterface;
import com.unionOfMiners.android.union.restInterface.CurrencyInterface;
import com.unionOfMiners.android.union.restInterface.HashRateInterface;
import com.unionOfMiners.android.union.restInterface.RestInterface;
import com.unionOfMiners.android.union.restInterface.USDRatesInterface;
import com.unionOfMiners.android.union.websocket.BackgroundManager;
import com.unionOfMiners.android.union.websocket.SocketConnection;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by HP on 25.07.2017.
 */

public class PrefsApplication extends Application {

    private static RestInterface sRestInterface;
    private static ChartInterface sChartInterface;
    private static HashRateInterface sHashRateInterface;
    private static CurrencyInterface sCurrencyInterface;
    private static AuthInterface sAuthInterface;
    private static PrefsApplication sInstance;
    private SocketConnection exampleSocketConnection;
    private static USDRatesInterface sUSDRatesInterface;

    @Override
    public void onCreate() {

        super.onCreate();

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl url = request.url().newBuilder().build();
                        request = request.newBuilder().url(url).build();
                        Log.d("test", url.toString());
                        return chain.proceed(request);
                    }
                }).build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.HOST_COINCAP_API)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();

        sRestInterface = mRetrofit.create(RestInterface.class);

        Retrofit mRetrofit2 = new Retrofit.Builder()
                .baseUrl(Constants.HOST_KZT)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(client)
                .build();

        sCurrencyInterface = mRetrofit2.create(CurrencyInterface.class);


        Retrofit retrofitUSD = new Retrofit.Builder()
                .baseUrl(Constants.USD_HOST)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
        sUSDRatesInterface = retrofitUSD.create(USDRatesInterface.class);

        Retrofit retrofitChart = new Retrofit.Builder()
                .baseUrl(Constants.HOST_COINCAP_API)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
        sChartInterface = retrofitChart.create(ChartInterface.class);

        Retrofit retrofitHash = new Retrofit.Builder()
                .baseUrl(Constants.HASH_RATE_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
        sHashRateInterface = retrofitHash.create(HashRateInterface.class);

        Retrofit authRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.AUTH_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        sAuthInterface = authRetrofit.create(AuthInterface.class);



        exampleSocketConnection = new SocketConnection(this);
        BackgroundManager.get(this).registerListener(appActivityListener);
    }
    public boolean isSocketConnected() {
        return exampleSocketConnection.isConnected();
    }

    public void reconnect() {
        exampleSocketConnection.openConnection();
    }


    private BackgroundManager.Listener appActivityListener = new BackgroundManager.Listener() {
        public void onBecameForeground() {
            openSocketConnection();
            Log.i("Websocket", "Became Foreground");
        }

        public void onBecameBackground() {
            closeSocketConnection();
            Log.i("Websocket", "Became Background");
        }
    };

    public void closeSocketConnection() {
        exampleSocketConnection.closeConnection();
    }
    public void openSocketConnection() {
        exampleSocketConnection.openConnection();
    }


    public RestInterface getApi() {
        return sRestInterface;
    }

    public ChartInterface getChartInterface(){
        return sChartInterface;
    }
    public AuthInterface getAuthInterface(){
        return sAuthInterface;
    }
    public HashRateInterface getHashRateInterface(){
        return sHashRateInterface;
    }

    public USDRatesInterface getUSD() {
        return sUSDRatesInterface;
    }

    public CurrencyInterface getCurrencyApi() {
        return sCurrencyInterface;
    }

    public PrefsApplication() {
        sInstance = this;
    }

    public static PrefsApplication get() {
        return sInstance;
    }
}
