package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnFej, btnIras;
    private TextView eredmeny;
    private ImageView kep;
    private int tipp, veletlenTipp, gyozelem, vereseg, dobasokSzama, maxDobas;
    private Random random;
    private Toast coinToast;
    private AlertDialog.Builder alertBuild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnFej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tipp = 0;
                    veletlenTipp = random.nextInt(2);
                    if (veletlenTipp == 0) {
                        kep.setImageResource(R.drawable.heads);
                        Toast.makeText(getApplicationContext(), "Fej", Toast.LENGTH_SHORT).show();
                    } else {
                        kep.setImageResource(R.drawable.tails);
                        Toast.makeText(getApplicationContext(), "Írás", Toast.LENGTH_SHORT).show();
                    }
                    dobasokSzama++;
                    maxDobas++;
                    eredmeny.setText("Dobások:" + dobasokSzama + "\nGyőzelem: 0\nVereség: 0");

                    if (veletlenTipp == tipp) {
                        gyozelem++;
                        eredmeny.setText("Dobások: " + dobasokSzama + "\nGyőzelem: " + gyozelem +
                                "\nVereség: " + vereseg);
                    } else {
                        vereseg++;
                        eredmeny.setText("Dobások: " + dobasokSzama + "\nGyőzelem: " + gyozelem +
                                "\nVereség: " + vereseg);
                    }

                if (maxDobas == 5) {
                    jatekVege();
                }



            }
        });

        btnIras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    tipp = 1;
                    veletlenTipp = random.nextInt(2);
                    if (veletlenTipp == 1) {
                        kep.setImageResource(R.drawable.tails);
                        Toast.makeText(getApplicationContext(), "Írás", Toast.LENGTH_SHORT).show();
                    } else {
                        kep.setImageResource(R.drawable.heads);
                        Toast.makeText(getApplicationContext(), "Fej", Toast.LENGTH_SHORT).show();
                    }
                    dobasokSzama++;
                    maxDobas++;
                    eredmeny.setText("Dobások:" + dobasokSzama + "\nGyőzelem: 0\nVereség: 0");
                    if (veletlenTipp == tipp) {
                        gyozelem++;
                        eredmeny.setText("Dobások: " + dobasokSzama + "\nGyőzelem: " + gyozelem +
                                "\nVereség: " + vereseg);
                    } else {
                        vereseg++;
                        eredmeny.setText("Dobások: " + dobasokSzama + "\nGyőzelem: " + gyozelem +
                                "\nVereség: " + vereseg);
                    }

                if (maxDobas == 5) {
                    jatekVege();
                }



            }
        });
    }
    private void init() {
        btnFej = findViewById(R.id.btn_fej);
        btnIras = findViewById(R.id.btn_iras);
        eredmeny = findViewById(R.id.text_eredmenyek);
        kep = findViewById(R.id.kep);
        random = new Random();
        coinToast = new Toast(getApplicationContext());
        gyozelem = 0;
        dobasokSzama = 0;
        vereseg = 0;
        maxDobas = 0;
        alertBuild = new AlertDialog.Builder(this);
        createAlertDialog();

    }

    private void jatekVege() {
        if (veletlenTipp == tipp) {
            alertBuild.setTitle("Győzelem");
            alertBuild.create();
            alertBuild.show();
        }
        else {
            alertBuild.setTitle("Vereség").create().show();
        }
    }

    private void createAlertDialog() {
        alertBuild.setMessage("Szeretne új játékot játszani?");
        alertBuild.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertBuild.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                eredmeny.setText("Dobások: 0\nGyőzelem: 0\nVereség: 0");
                kep.setImageResource(R.drawable.heads);
                gyozelem = 0;
                dobasokSzama = 0;
                vereseg = 0;
                maxDobas = 0;
                closeContextMenu();


            }
        });
        alertBuild.setCancelable(false);
    }
}