package dsa.ejercicios_practica.minim2_2019bo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText txtUser;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        txtUser = findViewById(R.id.txtUserName);
    }
    public void perfilClick(View view){
        String name = txtUser.getText().toString();
        if(name!=null){
            SharedPreferences sharedPreferences = getSharedPreferences("user", context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", name);
            editor.commit();

            Intent intent = new Intent(this, MedallasRecyclerView.class);
            this.startActivity(intent);

        }
        else{
            String notification = "Enter the user you want to search";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this.getBaseContext(), notification, duration);
            toast.show();
        }
    }
}