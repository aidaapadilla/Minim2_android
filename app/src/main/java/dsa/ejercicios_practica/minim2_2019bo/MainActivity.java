package dsa.ejercicios_practica.minim2_2019bo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void insigniasClick(View view){
        Intent intent = new Intent(view.getContext(), MedallasRecyclerView.class);
        view.getContext().startActivity(intent);

    }
    public void perfilClick(View view){
        Intent intent = new Intent(view.getContext(), Perfil.class);
        view.getContext().startActivity(intent);
    }
}