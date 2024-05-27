package es.ifp.notitas;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {
    public DataBaseSQL(@Nullable Context context) {
        super(context, "notitas", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE notas(id integer PRIMARY KEY AUTOINCREMENT NOT NULL, nota TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean borrarTodasNotas(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE  FROM notas");

        return true;
    }

    public boolean borrarNota(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM notas WHERE id = " + id);

        return true;
    }

    public boolean crearNota(String nota){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO notas (id, nota) VALUES (null,'" + nota + "')");

        return true;
    }

    public ArrayList<String> getNotas(){

        ArrayList<String> notas = new ArrayList<String>();


        Cursor res = null;
        SQLiteDatabase db = this.getReadableDatabase();
        res = db.rawQuery("SELECT * FROM notas", null);

        res.moveToLast();
        if(res.getCount() > 0){

            res.moveToFirst();
            while(!res.isAfterLast()){
                notas.add(res.getString(0) + "- " + res.getString(1));
                res.moveToNext();
            }

        }
        return notas;
    }
}
