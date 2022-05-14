package com.example.appcartao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final int VERSAO = 5;
    private static final String NOME = "DBCarteira";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }


    @Override //aqui eu crio as tabelas do SQLite
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE  IF NOT EXISTS bandeira (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "nome TEXT NOT NULL);"
        );

        db.execSQL( "CREATE TABLE  IF NOT EXISTS carteira (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                "nome TEXT NOT NULL," +
                "limite TEXT," +
                "banco TEXT," +
                "codBandeira INT);"

        );

    }

    @Override //1 param: referencia do banco, 2 param: o banco antigo, 3 param: o parametro novo
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int antiga, int atual) {
        if (atual == 5){
            sqLiteDatabase.execSQL("DELETE FROM bandeira");
        }
    }
}
