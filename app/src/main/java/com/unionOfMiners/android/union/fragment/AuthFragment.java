package com.unionOfMiners.android.union.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unionOfMiners.android.union.R;
import com.unionOfMiners.android.union.auth.UserDatum;

/**
 * Created by HP on 20.09.2017.
 */

public class AuthFragment extends Fragment {
    public static final String KEY_ID = "authId";

    public static AuthFragment newInstance(UserDatum userData) {

        Bundle args = new Bundle();
        args.putSerializable(KEY_ID, userData);
        AuthFragment fragment = new AuthFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_auth, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
