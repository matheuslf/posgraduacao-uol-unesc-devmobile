package unesc.uol.precofipeapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.adapter.AnosAdapter;
import unesc.uol.precofipeapp.adapter.ModelosAdapter;
import unesc.uol.precofipeapp.api.Api;
import unesc.uol.precofipeapp.api.model.Anos;
import unesc.uol.precofipeapp.api.model.Modelos;
import unesc.uol.precofipeapp.api.model.Valor;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class AnosActivity extends AppCompatActivity {

    private ListView listaAnos;
    private int codigo_marca, codigo_modelo;
    private String codigo_ano;
    private AnosAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anos);

        listaAnos = findViewById(R.id.listaAnos);
        listaAnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                codigo_ano = ((Anos)adapter.getItem(i)).getCodigo();

                Api.getValor(codigo_marca, codigo_modelo, codigo_ano, new Callback<Valor>() {
                    @Override
                    public void onResponse(Call<Valor> call, Response<Valor> response) {
                        if (response.isSuccessful()) {
                            DialogUtil.showError(AnosActivity.this, "Informação", "Valor FIPE: "+response.body().getValor());
                        }
                        else {
                            DialogUtil.showError(AnosActivity.this, "Erro", "Falha ao buscar o valor da FIPE!");
                        }
                    }

                    @Override
                    public void onFailure(Call<Valor> call, Throwable t) {
                        DialogUtil.showError(AnosActivity.this, "Erro", "Falha ao buscar o valor da FIPE [001]!");
                    }
                });

            }
        });

        Toast.makeText(AnosActivity.this ,"Buscando os anos dos veiculos", Toast.LENGTH_LONG).show();

        codigo_marca = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0);
        codigo_modelo = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MODELO, 0);

        Api.getAnos(codigo_marca, codigo_modelo, new Callback<List<Anos>>() {
            @Override
            public void onResponse(Call<List<Anos>> call, Response<List<Anos>> response) {
                if (response.isSuccessful()) {
                    adapter = new AnosAdapter(AnosActivity.this, response.body());
                    listaAnos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    DialogUtil.showError(AnosActivity.this, "Erro", "Falha ao buscar os anos de veículo!");
                }
            }

            @Override
            public void onFailure(Call<List<Anos>> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.showError(AnosActivity.this, "Erro", "Falha ao buscar os anos de veículo [001]!");
            }
        });
    }
}
