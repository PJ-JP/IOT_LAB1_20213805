package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

// import androidx.activity.EdgeToEdge; // Comentado por si interfiere con la Toolbar
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.util.ArrayList;

public class QuizSelectionActivity extends AppCompatActivity {

    private String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Considera si es necesario, puede afectar la Toolbar
        setContentView(R.layout.activity_quiz_selection);

        Toolbar toolbar = findViewById(R.id.toolbar_quiz_selection);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("TeleQuiz"); //título
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Up navigation Muestra el botón de regreso (flecha)
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_back_24dp); //seteo ícono de flecha atrás
        }

        TextView textViewToShowInput = findViewById(R.id.textView3);
        // Con bundle
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userInput = extras.getString("Nombre");
            if (userInput != null && !userInput.isEmpty()) {
                textViewToShowInput.setText(userInput);
            } else {
                textViewToShowInput.setText("Bienvenido, Anónimo");
            }
        } else {
            textViewToShowInput.setText("Error al cargar nombre");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.quiz_selection_menu, menu); // Infla el menú que ahora solo tiene action_open_other_activity
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) { // Maneja el clic en el botón de navegación (flecha atrás)
            // Regresar a MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Finaliza QuizSelectionActivity
            return true;
        } else if (itemId == R.id.action_open_other_activity) {
            // Abrir OtraActivity (reemplaza con el nombre de tu actividad)
            // Intent intent = new Intent(this, OtraActivity.class);
            // startActivity(intent);
            Log.d("QuizSelectionMenu", "Abrir otra actividad presionado");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void abrirQuizRedes(View view) {
        Intent intent = new Intent(this, QuizRedesActivity.class);
        intent.putExtra("Nombre", userInput);
        intent.putExtra("Tema", "Redes");
        /*intent.putExtra("Fecha", "01/01/2026");*/
        startActivity(intent);
    }

    public void abrirQuizCiberSeguridad(View view) {
        Intent intent = new Intent(this, QuizRedesActivity.class);
        intent.putExtra("Nombre", userInput);
        intent.putExtra("Tema", "CiberSeguridad");
        startActivity(intent);
    }
    public void abrirQuizMicroondas(View view) {
        Intent intent = new Intent(this, QuizRedesActivity.class);
        intent.putExtra("Nombre", userInput);
        intent.putExtra("Tema", "Microondas");
        startActivity(intent);
    }
}
