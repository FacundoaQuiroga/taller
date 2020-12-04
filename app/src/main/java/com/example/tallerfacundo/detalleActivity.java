package com.example.tallerfacundo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class detalleActivity extends AppCompatActivity {

    EditText edtDetalle_id;
    TextView txtDetalle_artista, txtDetalle_album, txtDetalle_fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        edtDetalle_id = findViewById(R.id.edtDetalle_id);
        txtDetalle_artista = findViewById(R.id.txtDetalle_artista);
        txtDetalle_album = findViewById(R.id.txtDetalle_album);
        txtDetalle_fecha = findViewById(R.id.txtDetalle_fecha);
    }

    public void buscarDisco(View view){
        gestorDeBaseDeDatos gestor = new gestorDeBaseDeDatos(this, "empleados", null, 1);
        SQLiteDatabase db = gestor.getWritableDatabase();

        String id = edtDetalle_id.getText().toString();

        Cursor datos = db.rawQuery("select tarea, descripcion, estado from tareas where id =" + id, null);
        if (datos.moveToFirst()){

            txtDetalle_artista.setText(datos.getString(0).toString());
            txtDetalle_album.setText(datos.getString(1).toString());
            txtDetalle_fecha.setText(datos.getString(2).toString());

            edtDetalle_id.setText("");
            db.close();
        }else{
            Toast.makeText(this, "No existen registros asociados a este id", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }
}
