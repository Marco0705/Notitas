package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VerNotaActivity extends AppCompatActivity {

    protected TextView caja1;
    protected TextView caja2;
    protected Button botonVolver;
    protected Button botonBorrar;
    protected DataBaseSQL db;
    protected String paquete1 = "";
    protected Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_nota);

        caja1 = (TextView) findViewById(R.id.caja1_ver_notas);
        caja2 = (TextView) findViewById(R.id.caja2_ver_nota);
        botonVolver = (Button) findViewById(R.id.boton_volver_ver);
        botonBorrar = (Button) findViewById(R.id.boton_borrar_ver);

        db = new DataBaseSQL(this);

        extras = getIntent().getExtras();
        if(extras != null){

            paquete1 = extras.getString("VALOR");
            String[] partes = paquete1.split("- ");
            caja2.setText(paquete1);
        }

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pasarPantalla = new Intent(VerNotaActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] partes = paquete1.split("- ");
                db.borrarNota(partes[0]);
                Toast.makeText(VerNotaActivity.this, R.string.toast_boton_borrar_ver, Toast.LENGTH_SHORT).show();
                Intent pasarPantalla = new Intent(VerNotaActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }
}