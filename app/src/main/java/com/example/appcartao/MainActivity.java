package com.example.appcartao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spBandeira;
    private EditText etTitulo, etLimite, etBanco;
    private Button btnSalvar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spBandeira = findViewById(R.id.spBandeira);

        etTitulo = findViewById(R.id.etTitulo);
        etLimite = findViewById(R.id.etLimite);
        etBanco = findViewById(R.id.etBanco);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        carregarGeneros();
    }

    private void salvar(){
        Carteira carteira = new Carteira();

        String titulo = etTitulo.getText().toString();

        if(!titulo.isEmpty() && spBandeira.getSelectedItemPosition() > 0){
            carteira.setNome(titulo);
            carteira.setBandeira((Bandeira) spBandeira.getSelectedItem());
            carteira.setBanco(etBanco.getText().toString());
            carteira.setLimite(etLimite.getText().toString());

            CarteiraDAO.inserir(MainActivity.this, carteira);//ou só this
            finish();
        }


    }

    private void carregarGeneros(){
        Bandeira fake = new Bandeira(0, "Selecione a Bandeira");
        List<Bandeira> lista = BandeiraDAO.getGeneros(this);
        lista.add(0, fake);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        spBandeira.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // menu.add("Limpar formulário"); como criar menu pelo código
        // this.getMenuInflater().inflate(R.menu.menu_formulario, menu);
        menu.add("Cadastrar Bandeira");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.toString().equals("Cadastrar Bandeira")){
            // GeneroDAO.inserir(MainActivity.this, "Terror");
            cadastrarGenero();
        }
        return super.onOptionsItemSelected(item);
    }

    private void cadastrarGenero(){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Cadastrar Bandeira");
        alerta.setIcon(android.R.drawable.ic_input_add);

        EditText etNomeBandeira = new EditText(this);
        etNomeBandeira.setHint("Digite aqui o nome da Bandeira");

        alerta.setView(etNomeBandeira);

        alerta.setNeutralButton("Cancelar", null);

        alerta.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String nome = etNomeBandeira.getText().toString();
                if ( !nome.isEmpty()){
                    BandeiraDAO.inserir(MainActivity.this, nome);
                    carregarGeneros();
                }
            }
        });
        alerta.show();
    }
}
