package org.solutione.rancho;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("loading..");
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent (getApplicationContext(), InitActivity.class);
                startActivity(intent);
                finish();
            };
        }, 1500);
    }
}
