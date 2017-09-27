package com.unionOfMiners.android.union;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HP on 11.09.2017.
 */

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_anim);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // По истечении времени, запускаем главный активити, а Splash Screen закрываем
//                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
//                SplashActivity.this.startActivity(mainIntent);
//                SplashActivity.this.finish();
//            }
//        }, SPLASH_DISPLAY_LENGTH);
    }
}
