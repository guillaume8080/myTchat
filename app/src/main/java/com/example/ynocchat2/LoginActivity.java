package com.example.ynocchat2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextIdentifier , editTextPassword;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ex : editTextUsername = findViewById(R.id.editTextUsername);
        editTextIdentifier = findViewById(R.id.editTextIdentifier);
        editTextPassword = findViewById(R.id.editTextPassword);
    }



    public void onRegisterClick(View v){

        Intent intentToLogin = new Intent(this,RegisterActivity.class);
        startActivity(intentToLogin);

    }

    public void onCoClick(View v){

        String identifiant = editTextIdentifier.getText().toString().trim();
        String password = editTextPassword.getText().toString();

        JSONObject json = new JSONObject();

        try {
            json.put("identifier",identifiant);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://Flutter-learning.mooo.com/auth/local/")
                .post(RequestBody.create(json.toString(), MediaType.get("application/json")))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                //génère le log
                Log.e(TAG, "onFailure : " + "connexion :" + e.getMessage());

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                String body = response.body().string();

                Log.i(TAG , "onResponse: "  + body);
                //Toast.makeText(RegisterActivity.this,response.code(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}