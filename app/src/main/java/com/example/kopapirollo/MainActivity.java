package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView gepHp1,gepHp2,gepHp3,gepValasz,sajatHp1,sajatHp2,sajatHp3,sajatValasz;
    private Button btnRock,btnPaper,btnScissor;
    private TextView dontetlenek;
    private int[] images={R.drawable.rock,R.drawable.paper,R.drawable.scissors};
    private Random rand=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        gombok();



    }

    private void gombok() {
        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gepValasz.setImageResource(images[rand.nextInt(images.length)]);
                sajatValasz.setImageResource(R.drawable.rock);
            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gepValasz.setImageResource(images[rand.nextInt(images.length)]);
                sajatValasz.setImageResource(R.drawable.paper);
            }
        });
        btnScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gepValasz.setImageResource(images[rand.nextInt(images.length)]);
                sajatValasz.setImageResource(R.drawable.scissors);
            }
        });

    }

    private void init() {
        gepHp1=findViewById(R.id.gepHp1);
        gepHp2=findViewById(R.id.gepHp2);
        gepHp3=findViewById(R.id.gepHp3);
        gepValasz=findViewById(R.id.image_gepValasz);
        sajatHp1=findViewById(R.id.sajatHp1);
        sajatHp2=findViewById(R.id.sajatHp2);
        sajatHp3=findViewById(R.id.sajatHp3);
        sajatValasz=findViewById(R.id.image_sajatValasz);
        btnRock=findViewById(R.id.btnRock);
        btnPaper=findViewById(R.id.btnPaper);
        btnScissor=findViewById(R.id.btnScissor);
        dontetlenek=findViewById(R.id.dontetlenSzam);
    }
}