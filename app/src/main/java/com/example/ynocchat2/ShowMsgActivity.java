package com.example.ynocchat2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.ynocchat2.databinding.ActivityShowMsgBinding;

public class ShowMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_show_msg);

        //Binding
        ActivityShowMsgBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_msg);
        User monUser = new User("oto","76");
        Message monMessage = new Message("le contenu" , "01/01/2022" , monUser );
        binding.setMessage(monMessage);
    }
}