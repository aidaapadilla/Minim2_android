package dsa.ejercicios_practica.minim2_2019bo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import dsa.ejercicios_practica.minim2_2019bo.AdapterPerfil;
import dsa.ejercicios_practica.minim2_2019bo.models.Character;
import dsa.ejercicios_practica.minim2_2019bo.services.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Perfil extends AppCompatActivity {
    static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";
    private RecyclerView recyclerView;
    private AdapterPerfil mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    UserService API;
    ImageView avatarImg;
    TextView name;
    TextView nickname; //Aqui es on hauria d'estar el recycler view
    private Character user;
    View viewprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Intent intent = getIntent();
        name = findViewById(R.id.name);
        nickname = findViewById(R.id.nickname);
        avatarImg = findViewById(R.id.imageView7);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycle_view2);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterPerfil();
        recyclerView.setAdapter(mAdapter);

        createAPI();
        String nameUser ="pepa";
        doApiCall(nameUser);
    }
    public void createAPI(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UserService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API = retrofit.create(UserService.class);
    }

    public void doApiCall(String name) {
        Call<Character> call = API.getUser(name);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                if (response.code() == 200) {
                    user = response.body();
                    mAdapter.setData(user.getMedallasCharacter());
                    setData(user);
                } else {
                    Toast toast = Toast.makeText(Perfil.this, "Perfil no encontrado", Toast.LENGTH_SHORT);
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {

            }
        });
    }
    public void setData(Character c){
        name.setText(c.getName());
        nickname.setText(c.getNickname());
        avatarImg.setImageResource(R.drawable.jugon);
    }
}