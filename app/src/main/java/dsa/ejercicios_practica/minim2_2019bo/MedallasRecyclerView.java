package dsa.ejercicios_practica.minim2_2019bo;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import dsa.ejercicios_practica.minim2_2019bo.models.*;
import dsa.ejercicios_practica.minim2_2019bo.services.GithubService;
import dsa.ejercicios_practica.minim2_2019bo.services.InsigniasService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MedallasRecyclerView extends AppCompatActivity {
    AlertDialog.Builder alertBuilder = null;
    private RecyclerView recyclerView;
    private AdapterGitHub mAdapter;

    private RecyclerView.LayoutManager layoutManager;
    GithubService API;
    static List<Repositorio> repositorioList = new LinkedList<Repositorio>();
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        alertBuilder = new AlertDialog.Builder(this);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new AdapterGitHub();
        recyclerView.setAdapter(mAdapter);
        createAPI();

        //Progress bar
        progressBar.setVisibility(View.VISIBLE);
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("name",null);
        doApiCallRepositories(username);
        doApiCall(username);
        progressBar.setVisibility(View.INVISIBLE);

    }
    public void createAPI(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InsigniasService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API = retrofit.create(GithubService.class);
    }

    public void doApiCall(String name){
        Call<JsonObject> call = API.getUser(name);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.isSuccessful()){
                    try{
                        User user = new User();
                        JSONObject jsonObject = null;
                        jsonObject = new JSONObject(new Gson().toJson(response.body()));
                        user.setFollowers(Integer.parseInt(jsonObject.getString("followers")));
                        user.setName(jsonObject.getString("login"));
                        user.setFollowing(Integer.parseInt(jsonObject.getString("following")));
                        user.setLink(jsonObject.getString("avatar_url"));
                        mAdapter.setUser(user);

                    }
                    catch (JSONException t){
                        t.printStackTrace();
                    }
                }
                else{
                    showAlertDialog("This user doesn't exist");
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                t.printStackTrace();
                showAlertDialog("No connection");
            }
        });
    }
    public void doApiCallRepositories(String name){
        Call<List<JsonObject>> call = API.getRepos(name);
        call.enqueue(new Callback<List<JsonObject>>() {
            @Override
            public void onResponse(Call<List<JsonObject>> call, Response<List<JsonObject>> response) {
                if(response.isSuccessful()){
                    try{
                        LinkedList<Repositorio> repositorios = new LinkedList<Repositorio>();
                        for (int i = 0; i < response.body().size(); i++){
                            JSONObject jsonObject = null;
                            jsonObject = new JSONObject(new Gson().toJson(response.body().get(i)));

                            Repositorio repo = new Repositorio();
                            repo.setRepositoryName(jsonObject.getString("name"));
                            repo.setLanguage(jsonObject.getString("language"));
                            repositorioList.add(repo);
                        }
                        mAdapter.setData(repositorioList);
                    }
                    catch (JSONException t){
                        t.printStackTrace();
                        showAlertDialog("Error creating the recyclerview");
                    }
                }
                else{
                    showAlertDialog("This user doesn't exist");
                }
            }

            @Override
            public void onFailure(Call<List<JsonObject>> call, Throwable t) {
                t.printStackTrace();
                showAlertDialog("No connection");

            }
        });
    }
    public void showAlertDialog(String message){

        alertBuilder.setTitle("Error");
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton("Aceptar",null);
        AlertDialog dialog = alertBuilder.create();
        dialog.show();

    }



}