package com.example.a21752434.appwsretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a21752434.appwsretrofit.retrofitUtils.APIRestService;
import com.example.a21752434.appwsretrofit.retrofitUtils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private ProgressBar pbWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);
        pbWS = findViewById(R.id.pbWS);

        pbWS.setVisibility(View.INVISIBLE);
    }

    public void consumirWS(View v) {

        Retrofit r = RetrofitClient.getClient(APIRestService.BASE_URL);
        APIRestService ars = r.create(APIRestService.class);
        Call<String> call = ars.obtenerPokemons();

        // Hacemos visible el progress bar que habremos inicializado en
        // el onCreate poniéndolo como oculto
        pbWS.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                pbWS.setVisibility(View.GONE);
                if(response.isSuccessful()) {
                    tvResultado.setText(response.body().toString());

                } else {
                    Toast.makeText(MainActivity.this,
                            "El resultado no ha sido exitoso",
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                pbWS.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,
                        "No se ha podido establecer conexión con el Web Service",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
