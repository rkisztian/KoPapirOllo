package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgJatekosvalasztas,imgGepValasztas;
    private TextView textEredmeny;
    private Button buttonKo, buttonPapir, buttonOllo;

    int jatekosEredmeny = 0;
    int gepEredmeny = 0;

    int jatekos = 0;
    int gep = 0;
    Random random = new Random();
    AlertDialog.Builder jatekVegeBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jatekos = 0;
                gep = rnd();
                imgJatekosvalasztas.setImageResource(R.drawable.rock);
                switch(gep){
                    case 0:
                        imgGepValasztas.setImageResource(R.drawable.rock);
                        break;
                    case 1:
                        imgGepValasztas.setImageResource(R.drawable.paper);
                        break;
                    case 2:
                        imgGepValasztas.setImageResource(R.drawable.scissors);
                        break;
                    default:
                        imgGepValasztas.setImageResource(R.drawable.rock);
                }


                if (jatekos == gep){
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                } else if(gep == 1){
                    gepEredmeny++;
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();
                }
                else {
                    jatekosEredmeny++;
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Nyertél!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jatekos = 1;
                gep = rnd();
                imgJatekosvalasztas.setImageResource(R.drawable.paper);
                switch(gep){
                    case 0:
                        imgGepValasztas.setImageResource(R.drawable.rock);
                        break;
                    case 1:
                        imgGepValasztas.setImageResource(R.drawable.paper);
                        break;
                    case 2:
                        imgGepValasztas.setImageResource(R.drawable.scissors);
                        break;
                    default:
                        imgGepValasztas.setImageResource(R.drawable.rock);
                }


                if (jatekos == gep){
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                } else if(gep == 2){
                    gepEredmeny++;
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();
                }
                else {
                    jatekosEredmeny++;
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Nyertél!", Toast.LENGTH_SHORT).show();
                }
                ellenoriz();

            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                jatekos = 2;
                gep = rnd();
                imgJatekosvalasztas.setImageResource(R.drawable.scissors);
                switch(gep){
                    case 0:
                        imgGepValasztas.setImageResource(R.drawable.rock);
                        break;
                    case 1:
                        imgGepValasztas.setImageResource(R.drawable.paper);
                        break;
                    case 2:
                        imgGepValasztas.setImageResource(R.drawable.scissors);
                        break;
                    default:
                        imgGepValasztas.setImageResource(R.drawable.rock);
                }

                if (jatekos == gep){
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
                } else if(gep == 0){
                    gepEredmeny++;
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();
                }
                else {
                    jatekosEredmeny++;
                    textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                    Toast.makeText(MainActivity.this, "Nyertél!", Toast.LENGTH_SHORT).show();
                }
                ellenoriz();
            }
        });


    }

    private void init(){
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);

        imgJatekosvalasztas = findViewById(R.id.imgJatekosvalasztas);
        imgGepValasztas = findViewById(R.id.imgGepValasztas);
        textEredmeny = findViewById(R.id.textEredmeny);

    }

    private int rnd(){
        return random.nextInt(3);
    }

    private void ellenoriz(){
        if (jatekosEredmeny == 3){
            jatekVegeBuilder = new AlertDialog.Builder(MainActivity.this);
            jatekVegeBuilder.setCancelable(false)
                    .setTitle("Nyertél!")
                    .setMessage("Szeretnél új játékot kezdeni?")
                    .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gepEredmeny = 0;
                            jatekosEredmeny = 0;
                            textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                        }
                    })
                    .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .create()
                    .show();
        }
        else if(gepEredmeny == 3){
            jatekVegeBuilder = new AlertDialog.Builder(MainActivity.this);
            jatekVegeBuilder.setCancelable(false)
                    .setTitle("Vesztettél!")
                    .setMessage("Szeretnél új játékot kezdeni?")
                    .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            gepEredmeny = 0;
                            jatekosEredmeny = 0;
                            textEredmeny.setText(String.format("Eredmény: Ember: %d, Gép: %d", jatekosEredmeny, gepEredmeny));
                        }
                    })
                    .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .create()
                    .show();
        }
    }


}
