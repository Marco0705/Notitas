package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    protected TextView label1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label1 = (TextView) findViewById(R.id.label1_start);

        TimerTask myTimerTask = new TimerTask() {

            @Override
            public void run() {
                // Codigo de pasar pantalla
                //Codigo que se ejecuta tras la espera
                //Por ejemplo, Codigo para pasar a la siguiente actividad

                Intent pasarPantalla = new Intent(StartActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }

        };
        // new timer
        Timer timer = new Timer();
        // schedule timer
        timer.schedule(myTimerTask, 3000); // 3 segundos de espera

    }
}