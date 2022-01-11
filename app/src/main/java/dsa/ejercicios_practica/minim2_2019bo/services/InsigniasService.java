package dsa.ejercicios_practica.minim2_2019bo.services;

import java.util.LinkedList;

import dsa.ejercicios_practica.minim2_2019bo.models.Repositorio;
import retrofit2.Call;
import retrofit2.http.GET;

public interface InsigniasService {
    final String BASE_URL = "http://10.0.2.2:8080";
    @GET("/dsaApp/endpoint/insignias")
    Call<LinkedList<Repositorio>> getInsignias();
}
