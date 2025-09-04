package com.example.demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class QuizRedesActivity extends AppCompatActivity {

    private boolean flagHint = true;
    private int count = 0;
    private int puntaje = 0;
    private int pistaCount = 0;
    private ArrayList<String> llaves;
    private HashMap<String, String> preguntas;
    private HashMap<String, String> solucion;
    private ArrayList<String> respuestas1, respuestas2, respuestas3, respuestas4, respuestas5, respuestas6, respuestas7;
    private Button buttonView1, buttonView2, buttonView3, buttonView4, buttonView5, buttonView6 , buttonViewHint;
    private TextView textViewPregunta;
    private String userInput;
    private String tema;

    private int rachaPositiva=0,rachaNegativa=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_redes);

        Toolbar toolbar = findViewById(R.id.toolbar_quiz_selection);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("TeleQuiz"); //título
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Up navigation Muestra el botón de regreso (flecha)
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_back_24dp); //seteo ícono de flecha atrás
        }
        userInput = getIntent().getStringExtra("Nombre");
        tema = getIntent().getStringExtra("Tema");

        llaves = new ArrayList<String>();
        llaves.add("Pregunta 1");
        llaves.add("Pregunta 2");
        llaves.add("Pregunta 3");
        llaves.add("Pregunta 4");
        llaves.add("Pregunta 5");
        llaves.add("Pregunta 6");
        llaves.add("Pregunta 7");
        Collections.shuffle(llaves);
        preguntas = new HashMap<String, String>();
        solucion = new HashMap<String, String>();
        respuestas1 = new ArrayList<>();
        respuestas2 = new ArrayList<>();
        respuestas3 = new ArrayList<>();
        respuestas4 = new ArrayList<>();
        respuestas5 = new ArrayList<>();
        respuestas6 = new ArrayList<>();
        respuestas7 = new ArrayList<>();
        switch(tema){
            case "Redes":
                preguntas.put("Pregunta 1", "¿Qué capa del modelo OSI es responsable de la conversión de datos de un formato de red a un formato que la aplicación pueda entender?");
                preguntas.put("Pregunta 2", "¿Cuál de los siguientes dispositivos de red opera en la Capa 2 (Capa de Enlace de Datos) del modelo OSI y utiliza direcciones MAC?");
                preguntas.put("Pregunta 3", "¿Qué protocolo es conocido por ser orientado a la conexión y garantizar la entrega de datos de forma fiable?");
                preguntas.put("Pregunta 4", "¿Cuál es el propósito principal de una dirección MAC?");
                preguntas.put("Pregunta 5", "¿Qué tipo de red conecta dispositivos en un área geográfica extensa, como una ciudad, un país o incluso el mundo?");
                preguntas.put("Pregunta 6", "En el contexto de redes, ¿qué es un ping?");
                preguntas.put("Pregunta 7", "¿Qué capa del modelo de referencia TCP/IP combina las capas de Sesión, Presentación y Aplicación del modelo OSI?");
                solucion.put("Pregunta 1", "Capa de Presentación");
                solucion.put("Pregunta 2", "Switch");
                solucion.put("Pregunta 3", "TCP (Transmission Control Protocol)");
                solucion.put("Pregunta 4", "Identificar de forma única un dispositivo en una red local a nivel físico.");
                solucion.put("Pregunta 5", "WAN (Wide Area Network)");
                solucion.put("Pregunta 6", "Un comando utilizado para probar la conectividad y el tiempo de respuesta entre dos hosts.");
                solucion.put("Pregunta 7", "Capa de Aplicación");
                respuestas1.add("Capa de Presentación");
                respuestas1.add("Capa de Enlace de Datos");
                respuestas1.add("Capa de Transporte");
                respuestas1.add("Capa de Red");
                respuestas2.add("Firewall");
                respuestas2.add("Switch");
                respuestas2.add("Hub");
                respuestas2.add("Router");
                respuestas3.add("IP (Internet Protocol)");
                respuestas3.add("TCP (Transmission Control Protocol)");
                respuestas3.add("UDP (User Datagram Protocol)");
                respuestas3.add("ARP (Address Resolution Protocol)");
                respuestas4.add("Identificar una red en Internet.");
                respuestas4.add("Identificar de forma única un dispositivo en una red local a nivel físico.");
                respuestas4.add("Identificar de forma única un dispositivo en una red a nivel lógico.");
                respuestas4.add("Identificar de forma única una aplicación o servicio en un host.");
                respuestas5.add("PAN (Personal Area Network)");
                respuestas5.add("MAN (Metropolitan Area Network)");
                respuestas5.add("WAN (Wide Area Network)");
                respuestas5.add("LAN (Local Area Network)");
                respuestas6.add("Un tipo de cable de red utilizado para la conexión de larga distancia.");
                respuestas6.add("Un protocolo utilizado para la transferencia de archivos en una red.");
                respuestas6.add("Un comando utilizado para probar la conectividad y el tiempo de respuesta entre dos hosts.");
                respuestas6.add("Un dispositivo de red que amplifica una señal débil.");
                respuestas7.add("Capa de Internet");
                respuestas7.add("Capa de Transporte");
                respuestas7.add("Capa de Acceso a la Red");
                respuestas7.add("Capa de Aplicación");
                break;
            case "CiberSeguridad":
                preguntas.put("Pregunta 1", "¿Qué tipo de ataque de ingeniería social engaña a las personas para que revelen información confidencial, como contraseñas, a través de correos electrónicos o mensajes de texto fraudulentos?");
                preguntas.put("Pregunta 2", "¿Cuál es el propósito principal de un firewall en una red de computadoras?");
                preguntas.put("Pregunta 3", "¿Qué concepto de seguridad se refiere a la protección de datos para que solo las personas autorizadas puedan acceder a la información?");
                preguntas.put("Pregunta 4", "¿Cuál de los siguientes es un ejemplo de autenticación de dos factores (2FA)?");
                preguntas.put("Pregunta 5", "¿Qué ataque busca sobrecargar un servidor, servicio o red con una gran cantidad de tráfico para hacer que no esté disponible para los usuarios legítimos?");
                preguntas.put("Pregunta 6", "¿Qué es la encriptación?");
                preguntas.put("Pregunta 7", "¿Cuál es la diferencia principal entre una vulnerabilidad y una amenaza?");
                solucion.put("Pregunta 1", "Phishing");
                solucion.put("Pregunta 2", "Bloquear el acceso no autorizado a la red y filtrar el tráfico.");
                solucion.put("Pregunta 3", "Confidencialidad");
                solucion.put("Pregunta 4", "Ingresar una contraseña y luego un código enviado a tu teléfono móvil.");
                solucion.put("Pregunta 5", "Ataque de Denegación de Servicio Distribuido (DDoS)");
                solucion.put("Pregunta 6", "El proceso de convertir un texto en un formato no legible para proteger su privacidad.");
                solucion.put("Pregunta 7", "Una vulnerabilidad es la debilidad de un sistema, mientras que una amenaza es un evento que puede explotar esa debilidad.");
                respuestas1.add("Troyano");
                respuestas1.add("Phishing");
                respuestas1.add("Ataque de fuerza bruta");
                respuestas1.add("Ransomware");
                respuestas2.add("Acelerar la conexión a Internet.");
                respuestas2.add("Cifrar todo el tráfico de red.");
                respuestas2.add("Bloquear el acceso no autorizado a la red y filtrar el tráfico.");
                respuestas2.add("Limpiar virus del sistema.");
                respuestas3.add("Confidencialidad");
                respuestas3.add("Integridad");
                respuestas3.add("Disponibilidad");
                respuestas3.add("Autenticación");
                respuestas4.add("Crear una contraseña que incluya letras mayúsculas, minúsculas y números.");
                respuestas4.add("Usar la misma contraseña para múltiples cuentas.");
                respuestas4.add("Ingresar una contraseña y luego un código enviado a tu teléfono móvil.");
                respuestas4.add("Escribir la contraseña en un papel.");
                respuestas5.add("Exfiltración de datos");
                respuestas5.add("Ataque de Denegación de Servicio Distribuido (DDoS)");
                respuestas5.add("Spear phishing");
                respuestas5.add("Ataque de intermediario (Man-in-the-middle)");
                respuestas6.add("El proceso de convertir un texto en un formato no legible para proteger su privacidad.");
                respuestas6.add("Un método para ocultar la dirección IP de un dispositivo.");
                respuestas6.add("La restauración de datos desde una copia de seguridad.");
                respuestas6.add("La detección de virus en una computadora.");
                respuestas7.add("Una vulnerabilidad es causada por un virus y una amenaza es causada por un hacker.");
                respuestas7.add("Una vulnerabilidad es un evento que explota una debilidad, y una amenaza es un fallo del sistema.");
                respuestas7.add("Una vulnerabilidad es la debilidad de un sistema, mientras que una amenaza es un evento que puede explotar esa debilidad.");
                respuestas7.add("Ambos términos significan lo mismo y se usan indistintamente.");
                break;
            case "Microondas":
                preguntas.put("Pregunta 1", "¿En qué rango de frecuencia se sitúan las microondas dentro del espectro electromagnético?");
                preguntas.put("Pregunta 2", "¿Cuál es la principal limitación de la propagación de microondas que hace necesario el uso de antenas repetidoras en los enlaces de larga distancia?");
                preguntas.put("Pregunta 3", "¿Qué tipo de antena es comúnmente utilizada para los enlaces de comunicación por microondas de larga distancia?");
                preguntas.put("Pregunta 4", "¿Cuál de las siguientes aplicaciones de las microondas se relaciona con el uso de sistemas de posicionamiento global?");
                preguntas.put("Pregunta 5", "Además de su uso en telecomunicaciones, ¿en qué otra aplicación común se utilizan las microondas para calentar alimentos?");
                preguntas.put("Pregunta 6", "¿Cuál es una de las principales ventajas de las telecomunicaciones por microondas frente a la fibra óptica?");
                preguntas.put("Pregunta 7", "¿Qué fenómeno natural puede afectar significativamente la propagación de las microondas, especialmente en frecuencias más altas?");
                solucion.put("Pregunta 1", "300 MHz a 300 GHz");
                solucion.put("Pregunta 2", "La necesidad de una línea de vista directa entre el transmisor y el receptor.");
                solucion.put("Pregunta 3", "Antena parabólica (o de plato)");
                solucion.put("Pregunta 4", "Sistemas de navegación por satélite (GPS).");
                solucion.put("Pregunta 5", "Hornos de microondas");
                solucion.put("Pregunta 6", "Son más fáciles y rápidos de instalar en terrenos difíciles o a través de grandes distancias.");
                solucion.put("Pregunta 7", "La lluvia y la niebla.");
                respuestas1.add("30 MHz a 300 MHz");
                respuestas1.add("30 kHz a 300 kHz");
                respuestas1.add("300 MHz a 300 GHz");
                respuestas1.add("30 GHz a 300 THz");
                respuestas2.add("La necesidad de una línea de vista directa entre el transmisor y el receptor.");
                respuestas2.add("La alta susceptibilidad a las interferencias electromagnéticas.");
                respuestas2.add("La incapacidad para transmitir grandes volúmenes de datos.");
                respuestas2.add("La baja atenuación en la atmósfera.");
                respuestas3.add("Antena parabólica (o de plato)");
                respuestas3.add("Antena omnidireccional");
                respuestas3.add("Antena Yagi-Uda");
                respuestas3.add("Antena de dipolo");
                respuestas4.add("Sistemas de radar para control de tráfico aéreo.");
                respuestas4.add("Transmisiones de televisión satelital.");
                respuestas4.add("Sistemas de navegación por satélite (GPS).");
                respuestas4.add("Enlaces de radiofrecuencia para redes móviles.");
                respuestas5.add("Aparatos de aire acondicionado");
                respuestas5.add("Radios portátiles");
                respuestas5.add("Televisores de pantalla plana");
                respuestas5.add("Hornos de microondas");
                respuestas6.add("Ofrecen una mayor velocidad de transmisión de datos.");
                respuestas6.add("No requieren una línea de vista directa.");
                respuestas6.add("Son inmunes a las interferencias atmosféricas.");
                respuestas6.add("Son más fáciles y rápidos de instalar en terrenos difíciles o a través de grandes distancias.");
                respuestas7.add("La lluvia y la niebla.");
                respuestas7.add("Las tormentas solares.");
                respuestas7.add("El magnetismo terrestre.");
                respuestas7.add("La radiación ultravioleta.");
                break;
        }

        buttonView1 = findViewById(R.id.button6);
        buttonView2 = findViewById(R.id.button7);
        buttonView3 = findViewById(R.id.button8);
        buttonView4 = findViewById(R.id.button9);
        buttonView5 = findViewById(R.id.button10);
        buttonView6 = findViewById(R.id.button11);
        buttonViewHint = findViewById(R.id.button5);
        textViewPregunta = findViewById(R.id.textView6);

        TextView temaRCM = findViewById(R.id.textView5);
        temaRCM.setText(tema);

        cargarSiguientePregunta();

        /*switch (llaves.get(count)) {
            case "Pregunta 1":
                Collections.shuffle(respuestas1);
                buttonView1.setText(respuestas1.get(0));
                buttonView2.setText(respuestas1.get(1));
                buttonView3.setText(respuestas1.get(2));
                buttonView4.setText(respuestas1.get(3));
                textViewPregunta.setText(count+1+"."+preguntas.get("Pregunta 1"));
                break;
            case "Pregunta 2":
                Collections.shuffle(respuestas2);
                buttonView1.setText(respuestas2.get(0));
                buttonView2.setText(respuestas2.get(1));
                buttonView3.setText(respuestas2.get(2));
                buttonView4.setText(respuestas2.get(3));
                textViewPregunta.setText(preguntas.get("Pregunta 2"));
                break;
            case "Pregunta 3":
                Collections.shuffle(respuestas3);
                buttonView1.setText(respuestas3.get(0));
                buttonView2.setText(respuestas3.get(1));
                buttonView3.setText(respuestas3.get(2));
                buttonView4.setText(respuestas3.get(3));
                textViewPregunta.setText(preguntas.get("Pregunta 3"));
                break;
            case "Pregunta 4":
                Collections.shuffle(respuestas4);
                buttonView1.setText(respuestas4.get(0));
                buttonView2.setText(respuestas4.get(1));
                buttonView3.setText(respuestas4.get(2));
                buttonView4.setText(respuestas4.get(3));
                textViewPregunta.setText(preguntas.get("Pregunta 4"));
                break;
            case "Pregunta 5":
                Collections.shuffle(respuestas5);
                buttonView1.setText(respuestas5.get(0));
                buttonView2.setText(respuestas5.get(1));
                buttonView3.setText(respuestas5.get(2));
                buttonView4.setText(respuestas5.get(3));
                textViewPregunta.setText(preguntas.get("Pregunta 5"));
                break;
            case "Pregunta 6":
                Collections.shuffle(respuestas6);
                buttonView1.setText(respuestas6.get(0));
                buttonView2.setText(respuestas6.get(1));
                buttonView3.setText(respuestas6.get(2));
                buttonView4.setText(respuestas6.get(3));
                textViewPregunta.setText(preguntas.get("Pregunta 6"));
                break;
            case "Pregunta 7":
                Collections.shuffle(respuestas7);
                buttonView1.setText(respuestas7.get(0));
                buttonView2.setText(respuestas7.get(1));
                buttonView3.setText(respuestas7.get(2));
                buttonView4.setText(respuestas7.get(3));
                break;
        }*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void cargarSiguientePregunta() {
        if (count < llaves.size()) {
            String preguntaActualKey = llaves.get(count);
            textViewPregunta.setText((count + 1) + ". " + preguntas.get(preguntaActualKey));
            buttonView1.setEnabled(true);
            buttonView2.setEnabled(true);
            buttonView3.setEnabled(true);
            buttonView4.setEnabled(true);
            buttonView5.setEnabled(true);
            buttonView6.setEnabled(true);
            if(flagHint){
                buttonViewHint.setEnabled(true);
            }
            if(count == 0){
                buttonView5.setEnabled(false);
            }
            if(count == 6){
                buttonView6.setEnabled(false);
            }
            ArrayList<String> respuestasActuales = null;
            switch (preguntaActualKey) {
                case "Pregunta 1": respuestasActuales = respuestas1; break;
                case "Pregunta 2": respuestasActuales = respuestas2; break;
                case "Pregunta 3": respuestasActuales = respuestas3; break;
                case "Pregunta 4": respuestasActuales = respuestas4; break;
                case "Pregunta 5": respuestasActuales = respuestas5; break;
                case "Pregunta 6": respuestasActuales = respuestas6; break;
                case "Pregunta 7": respuestasActuales = respuestas7; break;
            }

            if (respuestasActuales != null) {
                Collections.shuffle(respuestasActuales);
                buttonView1.setText(respuestasActuales.get(0));
                buttonView2.setText(respuestasActuales.get(1));
                buttonView3.setText(respuestasActuales.get(2));
                buttonView4.setText(respuestasActuales.get(3));
            }
        } else {
            // Quiz terminado
            textViewPregunta.setText("Quiz Terminado! Puntaje: " + puntaje);
            if(puntaje<0){
                textViewPregunta.setBackgroundColor(Color.parseColor("#FF0000"));
            }
            else{
                textViewPregunta.setBackgroundColor(Color.parseColor("#BDECB6"));
            }
            buttonView1.setVisibility(View.GONE);
            buttonView2.setVisibility(View.GONE);
            buttonView3.setVisibility(View.GONE);
            buttonView4.setVisibility(View.GONE);
            buttonView5.setVisibility(View.GONE);
            buttonView6.setEnabled(true);
            buttonView6.setText("Volver a Inicio");
            buttonView6.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(QuizRedesActivity.this, QuizSelectionActivity.class);
                    intent.putExtra("Nombre", userInput);
                    /*intent.putExtra("Tema", tema);*/
                    startActivity(intent);
                }
            });
            buttonViewHint.setVisibility(View.GONE);
        }
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
            Intent intent = new Intent(this, QuizSelectionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Nombre", getIntent().getStringExtra("Nombre"));
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

    public void hint(View view){
        Log.d("QuizSelectionMenu", "Hint presionado");
        // Podrías implementar una lógica para dar una pista, por ejemplo, deshabilitar una opción incorrecta.
        // O mostrar un Toast con la pista.
        if (count < llaves.size()) {
            if (pistaCount < 3) {
                String pista = "Pista: " + (pistaCount+1);
                Toast.makeText(this, pista, Toast.LENGTH_LONG).show();
                ArrayList<Integer>  enteros =  new ArrayList<>();
                enteros.add(0);
                enteros.add(1);
                enteros.add(2);
                enteros.add(3);
                Collections.shuffle(enteros);
                int i;
                for(i=0;i<2;i++){
                    int indice = enteros.get(i);
                    switch (indice){
                        case 0:
                            if(buttonView1.getText()!=solucion.get(llaves.get(count))){
                                buttonView1.setEnabled(false);
                                i=2;
                            }
                            break;
                        case 1:
                            if(buttonView2.getText()!=solucion.get(llaves.get(count))){
                                buttonView2.setEnabled(false);
                                i=2;
                            }
                            break;
                        case 2:
                            if(buttonView3.getText()!=solucion.get(llaves.get(count))){
                                buttonView3.setEnabled(false);
                                i=2;
                            }
                            break;
                        case 3:
                            if(buttonView4.getText()!=solucion.get(llaves.get(count))){
                                buttonView4.setEnabled(false);
                                i=2;
                            }
                            break;
                    }
                }
                buttonViewHint.setEnabled(false);
            }
            pistaCount++;
            if(pistaCount == 3){
                flagHint = false;
            }
        }
    }

    public void validate(View view){
        if (count >= llaves.size()) { // Si el quiz ya terminó, no hacer nada más
            return;
        }

        Button botonPresionado = (Button) view; // Cast de View a Button
        String textoOpcionElegida = botonPresionado.getText().toString();

        String preguntaActualKey = llaves.get(count); // Obtiene la llave de la pregunta que se acaba de responder
        String respuestaCorrecta = solucion.get(preguntaActualKey);

        Log.d("QuizRedesActivity", "Opción elegida: " + textoOpcionElegida);
        Log.d("QuizRedesActivity", "Respuesta correcta: " + respuestaCorrecta);

        if(textoOpcionElegida.equals(respuestaCorrecta)){
            puntaje= (int) Math.pow(2,rachaPositiva+1)+puntaje;
            rachaPositiva++;
            rachaNegativa=0;
            Log.d("QuizRedesActivity", "¡Respuesta Correcta! Puntaje: " + puntaje);
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
        } else {
            puntaje=puntaje+(-3) * (int) Math.pow(2,rachaNegativa);
            rachaPositiva=0;
            rachaNegativa++;
            Log.d("QuizRedesActivity", "Respuesta Incorrecta.");
            Toast.makeText(this, "Incorrecto. La respuesta era: " + respuestaCorrecta, Toast.LENGTH_LONG).show();
        }
        TextView textViewPuntaje = findViewById(R.id.textView8);
        textViewPuntaje.setText(String.valueOf(puntaje));
        count++; // Incrementar para la siguiente pregunta
        cargarSiguientePregunta(); // Cargar la siguiente pregunta o finalizar

    }

}