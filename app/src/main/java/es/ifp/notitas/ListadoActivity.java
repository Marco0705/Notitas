package es.ifp.notitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {

    protected ListView lista;
    protected ArrayAdapter<String> adaptador;
    protected ArrayList<String> listadoNotas = new ArrayList<String>();
    protected DataBaseSQL db;
    protected String contenidoItem1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista = (ListView) findViewById(R.id.lista_listado);

        db = new DataBaseSQL(this);
        listadoNotas = db.getNotas();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listadoNotas);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                contenidoItem1 = adapterView.getItemAtPosition(i).toString();
                Intent pasarPantalla = new Intent(ListadoActivity.this, VerNotaActivity.class);
                finish();
                pasarPantalla.putExtra("VALOR", contenidoItem1);
                startActivity(pasarPantalla);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listado, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        switch (item.getItemId()) {
            case R.id.item_crear_listado:

                Intent pasarPantalla = new Intent(ListadoActivity.this, CrearNotasActivity.class);
                finish();
                startActivity(pasarPantalla);
                return true;

            case R.id.item_opciones_listado:

                pasarPantalla = new Intent(ListadoActivity.this, BorrarNotasActivity.class);
                finish();
                startActivity(pasarPantalla);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}