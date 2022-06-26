package unesc.uol.precofipeapp.api.endpoint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import unesc.uol.precofipeapp.api.model.Marcas;
import unesc.uol.precofipeapp.api.model.Modelos;

public interface ModelosEndpoint {

    @GET("carros/marcas/{codigo}/modelos")
    Call<Modelos> getModelos(@Path("codigo") int codigo);
}
