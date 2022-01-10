package dsa.ejercicios_practica.minim2_2019bo.services;

import dsa.ejercicios_practica.minim2_2019bo.models.Character;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface UserService {
    final String BASE_URL = "http://localhost:8080";
    @GET("/dsaApp/endpoint/user/{userId}")
    Call<Character> getUser(@Body String userName);
}
