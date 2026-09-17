package com.example.formjakis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inImie, inNaz, inMail, inPass;
    Button btnRejest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inImie = findViewById(R.id.imie);
        inNaz = findViewById(R.id.nazwisko);
        inMail = findViewById(R.id.email);
        inPass = findViewById(R.id.haslo);
        btnRejest = findViewById(R.id.rejestruj);

        btnRejest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie = inImie.getText().toString();
                String nazwisko = inNaz.getText().toString();
                String email = inMail.getText().toString();
                String haslo = inPass.getText().toString();

                if (imie.isEmpty() || nazwisko.isEmpty() || email.isEmpty() || haslo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wszystkie pola muszą być wypełnione", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.contains("@") || !email.contains(".")) {
                    Toast.makeText(MainActivity.this, "Email musi zawierać @ i .", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean maMala = false;
                boolean maWielka = false;
                boolean maCyfre = false;
                boolean maSpecjalny = false;
                String specjalne = "!@#$%";

                for (char c : haslo.toCharArray()) {
                    if (Character.isLowerCase(c)) maMala = true;
                    if (Character.isUpperCase(c)) maWielka = true;
                    if (Character.isDigit(c)) maCyfre = true;
                    if (specjalne.indexOf(c) != -1) maSpecjalny = true;
                }

                if (haslo.length() < 16) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć minimum 16 znaków", Toast.LENGTH_SHORT).show();
                } else if (!maMala) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć małą literę", Toast.LENGTH_SHORT).show();
                } else if (!maWielka) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć wielką literę", Toast.LENGTH_SHORT).show();
                } else if (!maCyfre) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć cyfrę", Toast.LENGTH_SHORT).show();
                } else if (!maSpecjalny) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć znak specjalny (!, @, #, $, %)", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Zarejestrowano pomyślnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}