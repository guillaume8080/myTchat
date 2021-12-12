package com.example.ynocchat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Important : récupère les champs et les boutons dans le onCreate!!
        Button buttonRegister = findViewById(R.id.buttonSignUp);
        editTextUsername = findViewById(R.id.editTextUsername);
    }

    public void onRegisterClick(View view){

        Toast.makeText(
                RegisterActivity.this,
                "Bonjour " + editTextUsername.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

    public void onLoginClick(View v){

        Intent intentToLogin = new Intent(this,LoginActivity.class);
        startActivity(intentToLogin);

    }

}