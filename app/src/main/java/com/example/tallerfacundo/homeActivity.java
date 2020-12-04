package com.example.tallerfacundo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
    public void goToActivityTarea(View view){
        Intent activity4 = new Intent(this, tareaActivity.class);
        startActivity(activity4);
    }

    public void goToActivityDetalle(View view){
        Intent activity5 = new Intent(this, detalleActivity.class);
        startActivity(activity5);
    }

}
