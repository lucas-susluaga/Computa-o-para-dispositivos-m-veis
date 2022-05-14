package com.example.appcartao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CarteiraDAO {

    public static void inserir (Context context, Carteira carteira){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", carteira.getNome());
        valores.put("limite", carteira.getLimite());
        valores.put("banco", carteira.getBanco());
        valores.put("codBandeira", carteira.getBandeira().getId());

        db.insert("carteira", null, valores);

        db.close();
    }

    public static void editar (Context context, Carteira carteira){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", carteira.getNome());
        valores.put("limite", carteira.getLimite());
        valores.put("banco", carteira.getBanco());
        valores.put("codBandeira", carteira.getBandeira().getId());

        db.update("carteira", valores, "id = "+ carteira.getId(), null);

        db.close();
    }

    public static void excluir (Context context, int idCarteira){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.delete("carteira", "id"+idCarteira, null);

        db.close();
    }


    public static List<Carteira> getCarteira(Context context){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery( "SELECT c.id, c.nome, c.limite, c.banco, b.id, b.nome "+
                " FROM carteira c INNER JOIN bandeira b ON b.id = c.codBandeira ORDER BY c.nome", null);

        List<Carteira> lista = new ArrayList<>();

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                Bandeira b = new Bandeira();
                b.setId(cursor.getInt(4));
                b.setNome(cursor.getString(5));

                Carteira c = new Carteira();
                c.setId(cursor.getInt(0));
                c.setNome(cursor.getString(1));
                c.setLimite(cursor.getString(2));
                c.setBanco(cursor.getString(3));
                c.setBandeira(b);

                lista.add(c);
            }while (cursor.moveToNext());
        }
        return lista;
    }
}
