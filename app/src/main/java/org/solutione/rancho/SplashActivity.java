package org.solutione.rancho;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent (getApplicationContext(), InitActivity.class);
                startActivity(intent);
                finish();
            };
        }, 1500);
    }
}
