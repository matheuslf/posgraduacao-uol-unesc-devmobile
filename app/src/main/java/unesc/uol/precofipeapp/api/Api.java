package unesc.uol.precofipeapp.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import unesc.uol.precofipeapp.api.endpoint.AnoEndpoint;
import unesc.uol.precofipeapp.api.endpoint.MarcasEndpoint;
import unesc.uol.precofipeapp.api.endpoint.ModelosEndpoint;
import unesc.uol.precofipeapp.api.endpoint.ValorEndpoint;
import unesc.uol.precofipeapp.api.model.Anos;
import unesc.uol.precofipeapp.api.model.Marcas;
import unesc.uol.precofipeapp.api.model.Modelos;
import unesc.uol.precofipeapp.api.model.Valor;

public class Api {

    public static final String URL_ROOT = "https://parallelum.com.br/fipe/api/v1/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL_ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void getMarcas(final Callback<List<Marcas>> callback) {
        MarcasEndpoint endpoint = retrofit.create(MarcasEndpoint.class);
        Call<List<Marcas>> call = endpoint.getMarcas();
        call.enqueue(callback);
    }

    public static void getModelos(int codigo, Callback<Modelos> callback) {
        ModelosEndpoint endpoint = retrofit.create(ModelosEndpoint.class);
        Call<Modelos> call = endpoint.getModelos(codigo);
        call.enqueue(callback);
    }

    public static void getAnos(int codigo, int codigo_modelo, Callback<List<Anos>> callback) {
        AnoEndpoint endpoint = retrofit.create(AnoEndpoint.class);
        Call<List<Anos>> call = endpoint.getAnos(codigo, codigo_modelo);
        call.enqueue(callback);
    }

    public static void getValor(int codigo, int codigo_modelo, String codigo_ano, Callback<Valor> callback) {
        ValorEndpoint endpoint = retrofit.create(ValorEndpoint.class);
        Call<Valor> call = endpoint.getValor(codigo, codigo_modelo, codigo_ano);
        call.enqueue(callback);
    }
}
