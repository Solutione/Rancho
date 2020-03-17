package org.solutione.rancho;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class InitActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        Objects.requireNonNull(getSupportActionBar()).hide();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("loading..");
        mAuth = FirebaseAuth.getInstance();

        TextView txtAcceder = (TextView) findViewById(R.id.txtAcceder);
        txtAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });


    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            Toast.makeText(InitActivity.this, "Conectando al servidor",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}

