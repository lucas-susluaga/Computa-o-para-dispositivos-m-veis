package com.example.appcartao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class LivrosActivity extends AppCompatActivity {


    private ListView lvLivros;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);

        lvLivros = findViewById(R.id.lvLivros);
        btnAdicionar = findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LivrosActivity.this, MainActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        carregarLivros();
    }

    private void carregarLivros(){
        List<Carteira> lista = CarteiraDAO.getCarteira(this);

        if (lista.size() == 0 ){
            Carteira fake = new Carteira("Nenhum cartão Cadastrado", "0", "Nenhum banco", null );
            lista.add(fake);
            lvLivros.setEnabled(false);
        } else {
            lvLivros.setEnabled(true);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        lvLivros.setAdapter(adapter);
    }
}
