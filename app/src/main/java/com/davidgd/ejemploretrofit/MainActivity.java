package com.davidgd.ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

import com.davidgd.ejemploretrofit.interfaz.api;
import com.davidgd.ejemploretrofit.modelo.modeloPost;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview1 = findViewById(R.id.tv1);

        //Llamamos a la funcion o invocamos el metodo iniciarRetrofit
        inciarRetrofit();
    }

    private void inciarRetrofit(){

        //Instanciar el nuevo objeto retrofit
        Retrofit objetoRetrofit = new Retrofit.Builder()
                .baseUrl("https://login.gomezdelgado.com/api/") //Base de nuestra URL
                .addConverterFactory(GsonConverterFactory.create()) //Covertidor Gson
                .build();

        //Instanciar el nuevo objeto api
        api objetoApi = objetoRetrofit.create(api.class);

        //Objeto call lista del api.java
        Call<List<modeloPost>> call = objetoApi.getPosts();

        call.enqueue(new Callback<List<modeloPost>>() {

            //Correcto
            @Override
            public void onResponse(Call<List<modeloPost>> call, Response<List<modeloPost>> response) {

                //Respuesta no exitosa
                if(!response.isSuccessful()){
                    //Muestra el codigo
                    textview1.setText("Codigo: " + response.code());
                }

                //Guarda la respuesta (El json)
                List<modeloPost> listaPost = response.body();

                //Recorremos la lista con un ciclo foreach
                for(modeloPost dato: listaPost){

                    String  contenido = ""; //Donde se guardaran los datos

                    //A contenido sumale lo siguiente
                    contenido += "id: " + dato.getId() + "\n";
                    contenido += "concepto: " + dato.getConcepto() + "\n";
                    contenido += "codigo: " + dato.getCodigo() + "\n";
                    contenido += "precio: " + dato.getPrecio() + "\n";
                    contenido += "control: " + dato.getControl() + "\n";
                    contenido += "fecha: " + dato.getFecha() + "\n";
                    contenido += "estado: " + dato.getEstado() + "\n";
                    contenido += "linea: " + dato.getLinea() + "\n";

                    //guarda los datos de contenido al final del textview
                    textview1.append(contenido);
                }

            }

            //Error
            @Override
            public void onFailure(Call<List<modeloPost>> call, Throwable t) {
                textview1.setText(t.getMessage());
            }

        }); //Fin del enqueue (Poner en cola)

    } //Fin de la funcion iniciarRetrofit

}