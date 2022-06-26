package unesc.uol.precofipeapp.api.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import unesc.uol.precofipeapp.api.model.Marcas;

public interface MarcasEndpoint {

    @GET("carros/marcas")
    Call<List<Marcas>> getMarcas();
}
