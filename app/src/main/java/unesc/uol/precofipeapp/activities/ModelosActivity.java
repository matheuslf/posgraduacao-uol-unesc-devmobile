package unesc.uol.precofipeapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.security.Key;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unesc.uol.precofipeapp.MainActivity;
import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.adapter.ModelosAdapter;
import unesc.uol.precofipeapp.api.Api;
import unesc.uol.precofipeapp.api.model.Anos;
import unesc.uol.precofipeapp.api.model.Marcas;
import unesc.uol.precofipeapp.api.model.Modelos;
import unesc.uol.precofipeapp.util.DialogUtil;
import unesc.uol.precofipeapp.util.KeyUtil;

public class ModelosActivity extends AppCompatActivity {

    private ListView listaModelos;
    private ModelosAdapter adapter;
    private int codigo_marca = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelos);

        listaModelos = findViewById(R.id.listaModelos);
        listaModelos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(ModelosActivity.this, AnosActivity.class);
                it.putExtra(KeyUtil.KEY_CODIGO_MODELO, ((Modelos.Items)adapter.getItem(i)).getCodigo());
                it.putExtra(KeyUtil.KEY_CODIGO_MARCA, codigo_marca);
                startActivity(it);
            }
        });

        Toast.makeText(ModelosActivity.this ,"Buscando modelos dos veiculos", Toast.LENGTH_LONG).show();

        codigo_marca = getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0);
        Api.getModelos(getIntent().getIntExtra(KeyUtil.KEY_CODIGO_MARCA, 0), new Callback<Modelos>() {
            @Override
            public void onResponse(Call<Modelos> call, Response<Modelos> response) {
                if (response.isSuccessful()) {
                    adapter = new ModelosAdapter(ModelosActivity.this, response.body().getModelos());
                    listaModelos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                else {
                    DialogUtil.showError(ModelosActivity.this, "Erro", "Falha ao buscar os modelos de veículo!");
                }
            }

            @Override
            public void onFailure(Call<Modelos> call, Throwable t) {
                t.printStackTrace();
                DialogUtil.showError(ModelosActivity.this, "Erro", "Falha ao buscar os modelos de veículo [001]!");
            }
        });
    }
}
