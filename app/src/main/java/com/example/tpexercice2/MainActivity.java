package com.example.tpexercice2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private EditText nom;
    private EditText adresse;
    private EditText surface;
    private EditText nbrPiece;
    private CheckBox piscine;
    private Button calcul;
    private TextView result1;
    private TextView result2;
    private TextView result3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.input1);
        adresse = findViewById(R.id.input2);
        surface = findViewById(R.id.input3);
        nbrPiece = findViewById(R.id.input4);
        piscine = findViewById(R.id.checkBox);
        calcul = findViewById(R.id.calculer);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (surface.getText().toString().isEmpty() || nbrPiece.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    int surfaceInt = Integer.parseInt(surface.getText().toString());
                    int nbrPieceInt = Integer.parseInt(nbrPiece.getText().toString());

                    int impBase = surfaceInt * 2;
                    int impSup = piscine.isChecked() ? (nbrPieceInt * 50 + 100) : (nbrPieceInt * 50);

                    result1.setText(String.valueOf(impBase));
                    result2.setText(String.valueOf(impSup));
                    result3.setText(String.valueOf(impBase + impSup));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Veuillez entrer des valeurs valides", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}