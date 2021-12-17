package com.example.ynocchat2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername , editTextEmail , editTextPassword;
    private static final String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Important : récupère les champs et les boutons dans le onCreate!!
        Button buttonRegister = findViewById(R.id.buttonSignUp);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
    }


    public void onRegisterClick(View view){

        //TODO récupérer les champs
        //trim = pas d espace
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString();
        String userName = editTextUsername.getText().toString().trim();

        /*
        * username : guillaume
        * mail : guillaume@mail.com
        * password : guillaume
        *
        * */

        //préparation d un objet json a l envoi serveur
        JSONObject json = new JSONObject();
        try {
            json.put("email",email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("username" , userName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //json.put("username" , userName);



        //TODO  envoyer requte d inscription au serveur
        //prépa requte
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://Flutter-learning.mooo.com/auth/local/register")
                .post(RequestBody.create(json.toString(), MediaType.get("application/json")))
                .build();

        //enqueue : met dans une queue toute les requetes detsibees au cleient hhtppOK

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {

                    //génère le log
                    Log.e(TAG, "onFailure : " + "inscription :" + e.getMessage());

                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                    String body = response.body().string();

                    Log.i(TAG , "onResponse: "  + body);
                    //Toast.makeText(RegisterActivity.this,response.code(), Toast.LENGTH_SHORT).show();
                }
            });




        Toast.makeText(
                RegisterActivity.this,
                "Bonjour " + userName,
                Toast.LENGTH_SHORT).show();

    }

    public void onLoginClick(View v){

        Intent intentToLogin = new Intent(this,LoginActivity.class);
        startActivity(intentToLogin);

    }

}