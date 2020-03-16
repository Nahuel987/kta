package com.example.kta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kta.api.Api;
import com.example.kta.api.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private FrameLayout frameLayout;
    private RecyclerView recyclerView;
    private ArrayList<String> dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //HACER LA REFERENCIA AL RECYCLER VIEW DE DONDE SE MOSTRARA LA LISTA EN ESTE CASO EL RECYCLER ESTA EN ACTIVITY MAIN XML
        recyclerView= (RecyclerView) findViewById(R.id.recicladorEnMain);

        //SE INDICA EL TIPO DE LAYOUT QUE TENDRA EL RECYCLER recicla PARA ESTE CASO SERA CON VISTA VERTICAL
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //RETROFIT
        Api service= RetrofitClient.getRetrofitInstance().create(Api.class);
        Call<BreedListResponse> call = service.getBreedList();
        call.enqueue(new Callback<BreedListResponse>() {
            @Override
            public void onResponse(Call<BreedListResponse> call, Response<BreedListResponse> response) {

                // AQUI RECIBO LA LISTA DE RETROFIT
                List<String> doggis = response.body().getBreedList();

                //INSTANCIAR EL ADAPTADOR Y DARLE COMO PARAMETROS LA LISTA A MOSTRAR
                ListAdapter adaptadorListaDeRazas = new ListAdapter(doggis);

                //DAR COMO PARAMETRO AL RECYCLER VIEW LA LISTA
                recyclerView.setAdapter(adaptadorListaDeRazas);
                 Log.e("DATOS",String.valueOf(doggis));

            }
            @Override
            public void onFailure(Call<BreedListResponse> call, Throwable t) {
                Log.e("ERROR", String.valueOf(t));
            }
        });
    }
}
