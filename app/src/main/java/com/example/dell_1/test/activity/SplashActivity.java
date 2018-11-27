package com.example.dell_1.test.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.dell_1.test.R;
import com.example.dell_1.test.baseactivity.BaseActivity;

public class SplashActivity extends BaseActivity {

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(R.layout.splash_activity);
        handler();
    }

    private void handler() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(activity, MainActivity.class);

                startActivity(i);

                finish();

            }

        }, 2 * 1000);
    }
}
