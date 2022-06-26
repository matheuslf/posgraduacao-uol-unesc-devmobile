package unesc.uol.precofipeapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unesc.uol.precofipeapp.R;
import unesc.uol.precofipeapp.api.model.Anos;

public class AnosAdapter extends BaseAdapter {

    private Activity activity;
    private List<Anos> arlAnos;

    public AnosAdapter(final Activity activity, final List<Anos> arlVeiculos) {
        this.activity = activity;
        this.arlAnos = arlVeiculos;
    }

    @Override
    public int getCount() {
        return arlAnos.size();
    }

    @Override
    public Object getItem(int i) {
        return arlAnos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.item_lista, viewGroup, false);
        }

        TextView textNome = view.findViewById(R.id.textNome);
        textNome.setText(arlAnos.get(i).getNome());

        TextView textCodigo = view.findViewById(R.id.textCodigo);
        textCodigo.setText(""+ arlAnos.get(i).getCodigo());

        return view;
    }
}
