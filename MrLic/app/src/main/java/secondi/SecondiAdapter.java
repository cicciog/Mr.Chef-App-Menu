package secondi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.f.mrlic.R;

import java.util.ArrayList;

/**
 * Created by fgual on 06/09/2017.
 */

public class SecondiAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SecondoPiatto> listaSecondi;

    SecondiAdapter(Context pContext, ArrayList<SecondoPiatto> pListaSecondi) {
        context = pContext;
        listaSecondi = pListaSecondi;
        new SecondiTask(context,listaSecondi,this).execute();
    }

    @Override
    public int getCount() {
        return listaSecondi.size();
    }

    @Override
    public Object getItem(int i) {
        return listaSecondi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.secondi_row, viewGroup, false);

        TextView title = (TextView) row.findViewById(R.id.title);
        TextView price = (TextView) row.findViewById(R.id.prezzo);

        SecondoPiatto temp = listaSecondi.get(i);
        title.setText(temp.getNome());
        price.setText("€ "+temp.getPrezzo());

        return row;
    }
}
