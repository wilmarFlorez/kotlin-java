package com.wilmarflorez.javaykotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LlistadoActivity extends AppCompatActivity {

    RecyclerView rcListado;
    LinearLayoutManager linearLayoutManager;
    TextView txtListadoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llistado);

        rcListado = findViewById(R.id.rcListado);
        txtListadoUser = findViewById(R.id.txtListadoUser);

        if (getIntent() != null){
            Bundle bundle = getIntent().getExtras();
            String nombre = bundle.getString("usuario", "");
            txtListadoUser.setText("Bienvenido " + nombre);
        }

        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
       rcListado.setLayoutManager(linearLayoutManager);
       rcListado.setAdapter(new AdapterListado(getFakeData()));
    }

    private List<PojoBasico> getFakeData() {
        List<PojoBasico> pojoBasicos = new ArrayList<>();
        for (int i = 0; i <=10; i++){
            pojoBasicos.add(new PojoBasico("Titulo " + i,"Descripcion"));
        }

        return pojoBasicos;
    }
}
