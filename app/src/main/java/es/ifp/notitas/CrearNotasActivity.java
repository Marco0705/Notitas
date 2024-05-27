package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class CrearNotasActivity extends AppCompatActivity {

    protected TextView label1;
    protected EditText caja1;
    protected Button botonVolver;
    protected Button botonCrear;
    protected String contenidoCaja;
    protected DataBaseSQL db;
    protected ArrayList<String> listadoNotas = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_notas);

        label1 = (TextView) findViewById(R.id.label1_crearNotas);
        caja1 = (EditText) findViewById(R.id.caja1_crearNotas);
        botonVolver = (Button) findViewById(R.id.botonVolver_crearNotas);
        botonCrear = (Button) findViewById(R.id.botonCrear_crearNotas);

        db = new DataBaseSQL(this);
        listadoNotas = db.getNotas();


        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pasarPantalla = new Intent(CrearNotasActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                contenidoCaja = caja1.getText().toString();
                if(contenidoCaja.equals("")){

                    SpannableString spannableString = new SpannableString(getString(R.string.toast_rojo));
                    spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Toast.makeText(CrearNotasActivity.this, spannableString, Toast.LENGTH_SHORT).show();
                }
                else{

                    db.crearNota(contenidoCaja);
                    Toast.makeText(CrearNotasActivity.this, R.string.toast_correcto, Toast.LENGTH_SHORT).show();


                            Intent pasarPantalla = new Intent(CrearNotasActivity.this, ListadoActivity.class);
                            finish();
                            startActivity(pasarPantalla);
                        }
                }
        });
    }
}