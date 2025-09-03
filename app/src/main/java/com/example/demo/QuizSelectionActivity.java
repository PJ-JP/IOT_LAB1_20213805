package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
// import android.widget.EditText; // No parece usarse aquí directamente
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Puede interferir con la Toolbar, considera si es necesario
        setContentView(R.layout.activity_quiz_selection);

        Toolbar toolbar = findViewById(R.id.toolbar_quiz_selection);
        setSupportActionBar(toolbar);

        // Opcional: Poner título a la Toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Selección de Quiz");
        }

        // Obtener el TextView donde se mostrará el dato
        TextView textViewToShowInput = findViewById(R.id.textView3); // ID del TextView

        // Obtener el valor del intent
        //Forma vista
        //Intent intent = getIntent();
        //String userInput = intent.getStringExtra("Nombre");
        //Curso curso = (Curso) intent.getSerializableExtra("Curso");) Curso serializable

        // Obtener el valor del intent
        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String userInput = extras.getString("Nombre");
        }*/
        //con Bundle
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Asegúrate de que la clave aquí coincida con la usada en MainActivity
            String userInput = extras.getString("Nombre");
            if (userInput != null && !userInput.isEmpty()) {
                textViewToShowInput.setText("" + userInput);
            } else {
                textViewToShowInput.setText("Bienvenido, Anónimo"); // Mensaje por defecto si no hay input
            }
        } else {
            textViewToShowInput.setText("Error al cargar nombre"); // Mensaje por defecto si no hay extras
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.quiz_selection_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_back_to_main) {
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
            // Por ahora, solo un Log para indicar que funciona
            Log.d("QuizSelectionMenu", "Abrir otra actividad presionado");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void abrirQuiz(View view) {

    }
}
