package com.example.tallerfacundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String correo = "admin@mail.com";
    String clave = "admin123";
    EditText editMain_Email;
    EditText editMain_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //oculta la actionbar
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        editMain_Email = (EditText) findViewById(R.id.editMain_Email);
        editMain_Pass = findViewById(R.id.editMain_Pass);
    }


    public void goToHomePage(View view){

        if (correo.equals(editMain_Email.getText().toString()) && clave.equals(editMain_Pass.getText().toString())){

            Intent activity = new Intent(this, homeActivity.class);
            startActivity(activity);
            Toast.makeText(this, "Bienvenido al Menu "+ editMain_Email.getText().toString(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "El correo o contraseña son incorrectos", Toast.LENGTH_SHORT).show();
        }
    }





    public void goToCrearCuenta(View view){
        Intent activity2 = new Intent(this, cuentaActivity.class);
        startActivity(activity2);
        Toast.makeText(this, "Aqui Puedes Crear tu Cuenta!", Toast.LENGTH_SHORT).show();
    }
}