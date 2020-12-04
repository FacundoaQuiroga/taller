package com.example.tallerfacundo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class tareaActivity extends AppCompatActivity {

    EditText edtMain_id, edtMain_tarea, edtMain_desc, edtMain_estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        edtMain_id = findViewById(R.id.edtMain_id);
        edtMain_tarea = findViewById(R.id.edtMain_tarea);
        edtMain_desc = findViewById(R.id.edtMain_desc);
        edtMain_estado = findViewById(R.id.edtMain_estado);
    }


    public void goToActivityDetalle(View view){
        Intent activity5 = new Intent(this, detalleActivity.class);
        startActivity(activity5);
    }

    public void guardarDisco(View view){

        gestorDeBaseDeDatos gestor = new gestorDeBaseDeDatos(this, "empleados", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtMain_id.getText().toString();
        String tarea = edtMain_tarea.getText().toString();
        String descripcion = edtMain_desc.getText().toString();
        String estado = edtMain_estado.getText().toString();

        if (!id.isEmpty() && !tarea.isEmpty() && !descripcion.isEmpty() && !estado.isEmpty()){
            ContentValues fila = new ContentValues();

            fila.put("id", id);
            fila.put("tarea", tarea);
            fila.put("desc", descripcion);
            fila.put("estado", estado);

            db.insert("discos", null, fila);
            db.close();

            Toast.makeText(this, "tarea ingresada exitosamente", Toast.LENGTH_SHORT).show();

            edtMain_id.setText("");
            edtMain_tarea.setText("");
            edtMain_desc.setText("");
            edtMain_estado.setText("");
        }else {
            Toast.makeText(this, "Por favor, complete los campos", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

}
