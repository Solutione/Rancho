package org.solutione.rancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ImageView imgMenu = (ImageView) findViewById(R.id.imgMenu);
        final LinearLayout lytMenu = (LinearLayout) findViewById(R.id.lytMenu);
        LinearLayout lytMenuClose = (LinearLayout) findViewById(R.id.lytMenuClose);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytMenu.setVisibility(View.VISIBLE);
            }
        });

        lytMenuClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lytMenu.setVisibility(View.GONE);
            }
        });
    }
}
