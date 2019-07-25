package org.solutione.rancho;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText usuario, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);


        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();

            }
        });
        findViewById(R.id.textViewRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }


    private void userLogin() {
        final String username = usuario.getText().toString();
        final String password1 = password.getText().toString();

        if (TextUtils.isEmpty(username)) {
            usuario.setError("Ingresa tu correo");
            usuario.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password1)) {
            password.setError("Ingresa tu contrasenia");
            password.requestFocus();
            return;
        }
    }
}