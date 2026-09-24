package com.example.formjakis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inImie, inNazwisko, inEmail, inHaslo;
    Button btnRejestruj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inImie = findViewById(R.id.imie);
        inNazwisko = findViewById(R.id.nazwisko);
        inEmail = findViewById(R.id.email);
        inHaslo = findViewById(R.id.haslo);
        btnRejestruj = findViewById(R.id.rejestruj);

        btnRejestruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie = inImie.getText().toString().trim();
                String nazwisko = inNazwisko.getText().toString().trim();
                String email = inEmail.getText().toString().trim();
                String haslo = inHaslo.getText().toString().trim();

                if (imie.isEmpty() || nazwisko.isEmpty() || email.isEmpty() || haslo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.contains("@") || !email.contains(".")) {
                    Toast.makeText(MainActivity.this, "Podaj poprawny adres email", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean maMala = false;
                boolean maDuza = false;
                boolean maSpecjalny = false;

                for (char c : haslo.toCharArray()) {
                    if (Character.isLowerCase(c)) maMala = true;
                    if (Character.isUpperCase(c)) maDuza = true;
                    if (!Character.isLetterOrDigit(c)) maSpecjalny = true;
                }

                if (haslo.length() < 8) {
                    Toast.makeText(MainActivity.this, "Hasło musi mieć co najmniej 8 znaków", Toast.LENGTH_SHORT).show();
                } else if (!maDuza) {
                    Toast.makeText(MainActivity.this, "Hasło musi zawierać dużą literę", Toast.LENGTH_SHORT).show();
                } else if (!maMala) {
                    Toast.makeText(MainActivity.this, "Hasło musi zawierać małą literę", Toast.LENGTH_SHORT).show();
                } else if (!maSpecjalny) {
                    Toast.makeText(MainActivity.this, "Hasło musi zawierać znak specjalny", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Dane są poprawne", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}