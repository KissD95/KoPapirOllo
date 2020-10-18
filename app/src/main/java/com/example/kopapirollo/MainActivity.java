package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView gepHp1,gepHp2,gepHp3,imageGepValasz,sajatHp1,sajatHp2,sajatHp3,imageSajatValasz;
    private Button btnRock,btnPaper,btnScissor;
    private TextView dontetlenek;
    private int sajatElet,gepElet,sajatValasz,gepValasz,dontetlenekSzama;
    private Random rand=new Random();
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujJatek();

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gepValasz = (int)(Math.random()*4)+1;
                sajatValasz=1;
                imageSajatValasz.setImageResource(R.drawable.rock);
                GepValaszVizsgal();
                KiNyert();
            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gepValasz = (int)(Math.random()*4)+1;
                sajatValasz=2;
                imageSajatValasz.setImageResource(R.drawable.paper);
                GepValaszVizsgal();
                KiNyert();
            }
        });
        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gepValasz = (int)(Math.random()*4)+1;
                sajatValasz=3;
                imageSajatValasz.setImageResource(R.drawable.scissors);
                GepValaszVizsgal();
                KiNyert();
            }
        });


    }
    private void KiNyert(){
        if (gepValasz == sajatValasz){
            Toast.makeText(MainActivity.this,"Döntetlen",Toast.LENGTH_SHORT).show();
            dontetlenekSzama+=1;
            dontetlenek.setText("Döntetlenek száma: "+dontetlenekSzama);
        }
        if(gepValasz==1 && sajatValasz==2){
            Toast.makeText(MainActivity.this,"Nyertél",Toast.LENGTH_SHORT).show();
            GepEletLevon();
        }
        if (gepValasz==1 && sajatValasz==3) {
            Toast.makeText(MainActivity.this,"A gép nyert",Toast.LENGTH_SHORT).show();
            SajatEletLevon();
        }if (gepValasz==2 && sajatValasz==1){
            Toast.makeText(MainActivity.this,"A gép nyert",Toast.LENGTH_SHORT).show();
            SajatEletLevon();
        }if (gepValasz==2 && sajatValasz==3) {
            Toast.makeText(MainActivity.this,"Te nyertél",Toast.LENGTH_SHORT).show();
            GepEletLevon();
        }if (gepValasz==3 && sajatValasz==1) {
            Toast.makeText(MainActivity.this,"Te nyertél",Toast.LENGTH_SHORT).show();
            GepEletLevon();
        }if (gepValasz==3 && sajatValasz==2) {
            Toast.makeText(MainActivity.this,"A gép nyert",Toast.LENGTH_SHORT).show();
            SajatEletLevon();
        }
    }





    private void GepValaszVizsgal() {
        if (gepValasz==1){
            imageGepValasz.setImageResource(R.drawable.rock);
        }else if (gepValasz==2) {
            imageGepValasz.setImageResource(R.drawable.paper);
        }else if(gepValasz==3){
            imageGepValasz.setImageResource(R.drawable.scissors);
        }
    }

    private void SajatEletLevon() {

        switch (sajatElet){

            case 3:
                sajatHp3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                sajatHp2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                sajatHp1.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
        sajatElet--;
        if (sajatElet < 1){
            builder.setTitle("Vereség").create().show();
            AlertDialog dialog = builder.create();

        }
    }

    private void GepEletLevon() {

        switch (gepElet){

            case 3:
                gepHp3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                gepHp2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                gepHp1.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
        gepElet--;
        if (gepElet < 1){
            builder.setTitle("Győzelem").create().show();
            AlertDialog dialog = builder.create();

        }
    }

    private void init() {

        sajatElet=3;
        gepElet=3;
        gepHp1=findViewById(R.id.gepHp1);
        gepHp2=findViewById(R.id.gepHp2);
        gepHp3=findViewById(R.id.gepHp3);
        imageGepValasz=findViewById(R.id.image_gepValasz);
        sajatHp1=findViewById(R.id.sajatHp1);
        sajatHp2=findViewById(R.id.sajatHp2);
        sajatHp3=findViewById(R.id.sajatHp3);
        imageSajatValasz=findViewById(R.id.image_sajatValasz);
        btnRock=findViewById(R.id.btnRock);
        btnPaper=findViewById(R.id.btnPaper);
        btnScissor=findViewById(R.id.btnScissor);
        dontetlenek=findViewById(R.id.dontetlenSzam);
        builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false).setMessage("Szeretne új játékot játszani?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ujJatek();
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
    }
    private void ujJatek() {
        dontetlenekSzama=0;
        sajatElet=3;
        gepElet=3;
        imageSajatValasz.setImageResource(0);
        imageGepValasz.setImageResource(0);
        gepHp1.setImageResource(R.drawable.heart2);
        gepHp2.setImageResource(R.drawable.heart2);
        gepHp3.setImageResource(R.drawable.heart2);
        sajatHp1.setImageResource(R.drawable.heart2);
        sajatHp2.setImageResource(R.drawable.heart2);
        sajatHp3.setImageResource(R.drawable.heart2);

    }
}