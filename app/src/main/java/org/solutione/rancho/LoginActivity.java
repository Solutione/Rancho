package org.solutione.rancho;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity  {
    EditText usuario, password1;
    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.editTextUsername);
        password1 = findViewById(R.id.editTextPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(usuario.getText().toString(), password1.getText().toString());

            }
        });
        findViewById(R.id.textViewRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                createAccount(usuario.getText().toString(), password1.getText().toString());

            }
        });

    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                        // [START_EXCLUDE]
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }
    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }


        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                          //  updateUI(null);
                        }


                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private void signOut() {
        mAuth.signOut();
       // updateUI(null);
    }


    private boolean validateForm() {
        boolean valid = true;

        String email = usuario.getText().toString();
        if (TextUtils.isEmpty(email)) {
            usuario.setError("Required.");
            valid = false;
        } else {
            usuario.setError(null);
        }

        String password = password1.getText().toString();
        if (TextUtils.isEmpty(password)) {
            password1.setError("Required.");
            valid = false;
        } else {
            password1.setError(null);
        }

        return valid;
    }




}