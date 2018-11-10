package com.guimatec.calculadoradamorte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et_nome, et_idade;
    RadioButton rb_masculino, rb_feminino;
    RadioButton rb_fumante_sim,rb_fumante_nao;
    RadioButton rb_drogas_sim, rb_drogas_nao;
    Button btn_calcular;
    TextView tv_resultado;

    Random r;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome = findViewById(R.id.et_nome);
        et_idade = findViewById(R.id.et_idade);
        rb_masculino = findViewById(R.id.rb_masculino);
        rb_feminino = findViewById(R.id.rb_feminino);
        rb_fumante_sim = findViewById(R.id.rb_fumante_sim);
        rb_fumante_nao = findViewById(R.id.rb_fumante_nao);
        rb_drogas_sim = findViewById(R.id.rb_drogas_sim);
        rb_drogas_nao = findViewById(R.id.rb_drogas_nao);
        btn_calcular = findViewById(R.id.btn_calcular);
        tv_resultado = findViewById(R.id.tv_resultado);

        r = new Random();

        //inicialização as coisas

        et_nome.setText("Guima");
        et_idade.setText("39");

        rb_masculino.setChecked(true);
        rb_feminino.setChecked(false);

        rb_fumante_sim.setChecked(false);
        rb_fumante_nao.setChecked(true);

        rb_drogas_sim.setChecked(false);
        rb_drogas_nao.setChecked(true);

        tv_resultado.setText("");

        //radio button clicado
        rb_masculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_masculino.setChecked(true);
                rb_feminino.setChecked(false);

            }
        });
        rb_feminino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_masculino.setChecked(false);
                rb_feminino.setChecked(true);

            }
        });
        rb_fumante_sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_fumante_sim.setChecked(true);
                rb_fumante_nao.setChecked(false);

            }
        });
        rb_fumante_nao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_fumante_sim.setChecked(false);
                rb_fumante_nao.setChecked(true);


            }
        });
        rb_drogas_sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_drogas_sim.setChecked(true);
                rb_drogas_nao.setChecked(false);

            }
        });
        rb_drogas_nao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_drogas_sim.setChecked(false);
                rb_drogas_nao.setChecked(true);

            }
        });

        //Botão Calcular
        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_nome.getText().toString().equals("") && !et_idade.getText().toString().equals("")){

                    //obter idade e configurá-lo para 20 se menor
                    int idadeAtual = Integer.parseInt(et_idade.getText().toString());
                    if (idadeAtual < 20){
                        idadeAtual = 20;
                    }
                    //definir semente aleatória de acordo com o nome idade atual
                    int somente = et_nome.getText().toString().hashCode();
                    r.setSeed(somente);

                    //calcular a idade de morrer
                    int idadeDaMorte = r.nextInt(120 - idadeAtual) + idadeAtual;

                    //obter as estatísticas humanas
                    boolean eMasculino = rb_masculino.isChecked();
                    boolean eFumante = rb_fumante_sim.isChecked();
                    boolean eUsuarioDrogas = rb_drogas_sim.isChecked();

                    //remove anos para fumar, tomar drogas ou ser homem
                    if (eMasculino){
                        idadeDaMorte = idadeDaMorte - 5;
                    }
                    if (eFumante){
                        idadeDaMorte = idadeDaMorte - 5;
                    }
                    if (eUsuarioDrogas){
                        idadeDaMorte = idadeDaMorte - 10;
                    }
                    if (eMasculino){
                        idadeDaMorte = idadeDaMorte - 5;
                    }
                    //calcular a nova idade da morte
                    if (idadeDaMorte <= idadeAtual){
                        idadeDaMorte = idadeAtual + 10;
                    }

                    //exibir o resultado
                    tv_resultado.setText(""+ idadeDaMorte);
                }
            }
        });


    }
}
