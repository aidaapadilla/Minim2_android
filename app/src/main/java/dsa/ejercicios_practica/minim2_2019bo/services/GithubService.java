package dsa.ejercicios_practica.minim2_2019bo.services;

import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.List;

import dsa.ejercicios_practica.minim2_2019bo.models.Repositorio;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {
    final String BASE_URL = "https://api.github.com/";

    @GET("users/{username}")
    Call<JsonObject> getUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<JsonObject>> getRepos(@Path("username") String username);
}
