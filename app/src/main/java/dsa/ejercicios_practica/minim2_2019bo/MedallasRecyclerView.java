package dsa.ejercicios_practica.minim2_2019bo;
import dsa.ejercicios_practica.minim2_2019bo.services.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import dsa.ejercicios_practica.minim2_2019bo.models.*;
import dsa.ejercicios_practica.minim2_2019bo.services.InsigniasService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MedallasRecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterMedallas mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    InsigniasService API;
    List<Medalla> medallas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Intent intent = getIntent();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterMedallas();
        recyclerView.setAdapter(mAdapter);

        createAPI();
        doApiCall();
    }
    public void createAPI(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InsigniasService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API = retrofit.create(InsigniasService.class);
    }
    public void doApiCall(){
        Call<List<Medalla>> call = API.getInsignias(medallas);
        call.enqueue(new Callback<List<Medalla>>() {
            @Override
            public void onResponse(Call<List<Medalla>> call, Response<List<Medalla>> response) {
                if(response.code()==200) {
                    medallas=response.body();
                    mAdapter.setData(medallas);
                }
                else {
                    Toast toast = Toast.makeText(MedallasRecyclerView.this,"Medallas no encontradas",Toast.LENGTH_SHORT);
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    toast.show();
                }}

            @Override
            public void onFailure(Call<List<Medalla>> call, Throwable t) {
                Toast toast = Toast.makeText(MedallasRecyclerView.this,"ERROR DE CONEXIÓN, no se ha podido realizar la petición.",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }


}