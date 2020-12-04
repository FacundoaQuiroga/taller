package com.example.tallerfacundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class cuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    public void goToLogPage(View view){
        Intent activity3 = new Intent(this, MainActivity.class);
        startActivity(activity3);
    }





}
