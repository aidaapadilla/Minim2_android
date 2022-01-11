package dsa.ejercicios_practica.minim2_2019bo.services;

import dsa.ejercicios_practica.minim2_2019bo.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface UserService {
    final String BASE_URL = "http://10.0.2.2:8080";
    @GET("/dsaApp/endpoint/user/{userId}")
    Call<User> getUser(@Body String userName);
}
