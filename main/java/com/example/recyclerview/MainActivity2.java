package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("NAME");
        String descripcion = getIntent().getStringExtra("DESCRIPCION");
        int imagen = getIntent().getIntExtra("IMAGEN", 0);

        TextView nameTextView = findViewById(R.id.AA_Title1);
        TextView descriptionTextView = findViewById(R.id.AA_Description);
        ImageView AA_Image = findViewById(R.id.AA_Image);

        nameTextView.setText(name);
        descriptionTextView.setText(descripcion);
        AA_Image.setImageResource(imagen);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

    }
}
