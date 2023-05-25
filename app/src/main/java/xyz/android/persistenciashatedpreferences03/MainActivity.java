package xyz.android.persistenciashatedpreferences03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener una instancia de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("nombre_preferencias", Context.MODE_PRIVATE);

        // Comprobar si una clave existe en las preferencias
        boolean contieneClave = sharedPreferences.contains("clave");
        if (contieneClave) {
            // La clave existe en las preferencias
        } else {
            // La clave no existe en las preferencias
        }

        // Obtener un Editor para realizar modificaciones en las preferencias
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Guardar un valor booleano en las preferencias
        boolean valorBooleano = true;
        editor.putBoolean("clave_booleana", valorBooleano);

        // Guardar un valor float en las preferencias
        float valorFloat = 3.14f;
        editor.putFloat("clave_float", valorFloat);

        // Guardar un valor entero en las preferencias
        int valorEntero = 42;
        editor.putInt("clave_entera", valorEntero);

        // Guardar un valor long en las preferencias
        long valorLong = 123456789L;
        editor.putLong("clave_long", valorLong);

        // Guardar un valor String en las preferencias
        String valorString = "Hola, mundo!";
        editor.putString("clave_string", valorString);

        // Guardar un conjunto de valores String en las preferencias
        Set<String> valorStringSet = new HashSet<>();
        valorStringSet.add("valor1");
        valorStringSet.add("valor2");
        valorStringSet.add("valor3");
        editor.putStringSet("clave_string_set", valorStringSet);

        // Confirmar los cambios en las preferencias
        boolean guardadoExitoso = editor.commit();
        if (guardadoExitoso) {
            // Los cambios se guardaron correctamente
        } else {
            // Ocurrió un error al guardar los cambios
        }

        // Recuperar todos los valores de las preferencias
        Map<String, ?> todosLosValores = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : todosLosValores.entrySet()) {
            String clave = entry.getKey();
            Object valor = entry.getValue();
            System.out.println("-----------------------valores de las preferencias-----------------------------");
            System.out.println(clave + " : " + valor);
            System.out.println("-----------------------valores de las preferencias-----------------------------");

            // Realizar acciones con cada clave y valor
        }

        // Recuperar un valor booleano de las preferencias
        boolean valorBooleanoRecuperado = sharedPreferences.getBoolean("clave_booleana", false);

        // Recuperar un valor float de las preferencias
        float valorFloatRecuperado = sharedPreferences.getFloat("clave_float", 0.0f);

        // Recuperar un valor entero de las preferencias
        int valorEnteroRecuperado = sharedPreferences.getInt("clave_entera", 0);

        // Recuperar un valor long de las preferencias
        long valorLongRecuperado = sharedPreferences.getLong("clave_long", 0L);

        // Recuperar un valor String de las preferencias
        String valorStringRecuperado = sharedPreferences.getString("clave_string", "");

        // Recuperar un conjunto de valores String de las preferencias
        Set<String> valorStringSetRecuperado = sharedPreferences.getStringSet("clave_string_set", new HashSet<>());
        for (String item : valorStringSetRecuperado) {
            System.out.println("clave_string_set: " + item);
        }

    }
}