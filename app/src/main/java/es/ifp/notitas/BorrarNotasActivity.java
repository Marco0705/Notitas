package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BorrarNotasActivity extends AppCompatActivity {

    protected Button boton1;
    protected Button boton2;
    protected DataBaseSQL db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_notas);

        boton1 = (Button) findViewById(R.id.boton1_borrarNotas);
        boton2 = (Button) findViewById(R.id.boton2_borrarNotas);

        db = new DataBaseSQL(this);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pasarPantalla = new Intent(BorrarNotasActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.borrarTodasNotas();
                Toast.makeText(BorrarNotasActivity.this, R.string.toast_borradoTotal, Toast.LENGTH_SHORT).show();
                Intent pasarPantalla = new Intent(BorrarNotasActivity.this, ListadoActivity.class);
                startActivity(pasarPantalla);
            }
        });

    }
}

