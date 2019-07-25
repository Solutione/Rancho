package org.solutione.rancho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.solutione.rancho.api.Usuario;

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
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        new Usuario().addUser("juan","lopez perez","masculino","hola@gmail.com","hjkl","link");
    }


}

