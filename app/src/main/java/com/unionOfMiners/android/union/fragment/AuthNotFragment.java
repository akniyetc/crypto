package com.unionOfMiners.android.union.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.unionOfMiners.android.union.PrefsApplication;
import com.unionOfMiners.android.union.R;
import com.unionOfMiners.android.union.auth.AuthBody;
import com.unionOfMiners.android.union.auth.UserDatum;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HP on 19.09.2017.
 */

public class AuthNotFragment extends Fragment {

    private EditText etLogin;
    private EditText etPassword;
    private Button btnAuth;
    private ProgressBar mProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_not_auth, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mProgressBar = (ProgressBar) view.findViewById(R.id.pb_auth);
        mProgressBar.setVisibility(View.INVISIBLE);

        etLogin = (EditText) view.findViewById(R.id.login_input);
        etPassword = (EditText) view.findViewById(R.id.password_input);
        btnAuth = (Button) view.findViewById(R.id.btn_login);
        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postAuth();
                //getAuthId(30);
                mProgressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    public void postAuth(){
        AuthBody authBody = new AuthBody();
        authBody.setLogin(etLogin.getText().toString());
        authBody.setPassword(etPassword.getText().toString());


        PrefsApplication.get().getAuthInterface().auth(authBody.getLogin(), authBody.getPassword()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                long id = 0;
                try {
                    id = Long.parseLong(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Log.d("authId", String.valueOf(id));

                getAuthId(30);
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getAuthId(long id){
        PrefsApplication.get().getAuthInterface().getUser(id).enqueue(new Callback<List<UserDatum>>() {
            @Override
            public void onResponse(Call<List<UserDatum>> call, Response<List<UserDatum>> response) {
                Log.d("authLog", String.valueOf(response.body().size()));
                AuthFragment authFragment = new AuthFragment();
                //authFragment.newInstance(response.body());
                changeFragment(authFragment, R.id.fragmentContainer);
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<UserDatum>> call, Throwable t) {

            }
        });
    }

    public void changeFragment(Fragment fragment, @IdRes int containerId) {
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commitNow();
    }
}
