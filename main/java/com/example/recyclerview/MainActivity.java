package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {

    ArrayList<DetallePerros> detallePerros = new ArrayList<>();
    ArrayList<DetallePerrosCompleto> detallePerrosCompleto = new ArrayList<>();

    int[] perrosImages = {R.mipmap.hueso,
            R.mipmap.hueso,
            R.mipmap.hueso,
            R.mipmap.hueso,
            R.mipmap.hueso,
            R.mipmap.hueso};

    int[] perrosImagesHuesos = {
            R.mipmap.husky,
            R.mipmap.pastorbelga,
            R.mipmap.pitbull,
            R.mipmap.pomerania,
            R.mipmap.rottweiler,
            R.mipmap.sanbernardo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB1();

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        setUpDetallePerros();

        AdaptadorPerros adaptador = new AdaptadorPerros(this, detallePerros, this);

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpDetallePerros () {
        String [] perrosNombres = getResources().getStringArray(R.array.perros_nombres);
        String [] perrosDescripcion = getResources().getStringArray(R.array.perros_descripcion);

        for (int i = 0; i < perrosNombres.length; i++) {
            detallePerros.add(new DetallePerros(perrosNombres[i],
                                                perrosDescripcion[i],
                                                perrosImagesHuesos[i],
                                                perrosImages[i]));
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( MainActivity.this, MainActivity2.class );

        String [] perrosDescripcionCompleta = getResources().getStringArray(R.array.perros_descripcionCompleta);

        for (int i = 0; i < perrosDescripcionCompleta.length; i++) {
            detallePerrosCompleto.add(new DetallePerrosCompleto(perrosDescripcionCompleta[i]));
        }

        intent.putExtra("NAME", detallePerros.get(position).getPerroNombre());
        intent.putExtra("DESCRIPCION", detallePerrosCompleto.get(position).getPerroDescripcion());
        intent.putExtra("IMAGEN", detallePerros.get(position).getImagen());

        startActivity(intent);
    }

    public void agregarFAB1() {

        FloatingActionButton FAB = findViewById(R.id.FAB);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }
}