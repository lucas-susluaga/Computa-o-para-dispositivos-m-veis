package com.example.appcartao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BandeiraDAO {

    public static void inserir (Context context, String nome){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.execSQL("INSERT INTO bandeira (nome) VALUES ('"+nome+"') ");
        db.close();
    }


    public static List<Bandeira> getGeneros(Context context){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery( "SELECT id, nome FROM bandeira ORDER BY nome", null);

        List<Bandeira> lista = new ArrayList<>();

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Bandeira g = new Bandeira();
                g.setId(cursor.getInt(0));
                g.setNome(cursor.getString(1));
                lista.add(g);
            }while (cursor.moveToNext());
        }
        return lista;
    }
}
