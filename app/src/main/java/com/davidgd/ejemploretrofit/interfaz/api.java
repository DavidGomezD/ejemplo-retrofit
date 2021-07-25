package com.davidgd.ejemploretrofit.interfaz;

import com.davidgd.ejemploretrofit.modelo.modeloPost;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface api {

    @GET("rest.php") //Parte final de nuestra url
    Call<List<modeloPost>> getPosts(); //Recuerda importar modeloPost

}
