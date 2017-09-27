package com.unionOfMiners.android.union.restInterface;

import com.unionOfMiners.android.union.auth.UserDatum;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by HP on 26.09.2017.
 */

public interface AuthInterface {

//    @POST("/api/inlog")
//    Call<AuthResponse> authUser(@Body AuthBody authBody);

    @FormUrlEncoded
    @POST("/api/inlog")
    Call<ResponseBody> auth(@Field("UserName") String username, @Field("Password") String password);

    @GET("/api/data/{id}")
    Call<List<UserDatum>> getUser(@Path("id") long id);
}
