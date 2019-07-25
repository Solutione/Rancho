package org.solutione.rancho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.solutione.rancho.API.ConnectSQL;

import java.util.Objects;

public class InitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        Objects.requireNonNull(getSupportActionBar()).hide();

        TextView txtAcceder = (TextView) findViewById(R.id.txtAcceder);
        txtAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.txtRegistrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //open register screen
                finish();
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
        new ConnectSQL();
    }


}

