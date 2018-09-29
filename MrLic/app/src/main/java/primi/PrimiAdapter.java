package primi;

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

public class PrimiAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<PrimoPiatto> listaPrimi;

    PrimiAdapter(Context pContext, ArrayList<PrimoPiatto> pListaPrimi) {
        context = pContext;
        listaPrimi = pListaPrimi;
        new PrimiTask(context,listaPrimi,this).execute();
    }

    @Override
    public int getCount() {
        return listaPrimi.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPrimi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.primi_row, viewGroup, false);

        TextView title = (TextView) row.findViewById(R.id.title);
        TextView price = (TextView) row.findViewById(R.id.prezzo);

        PrimoPiatto temp = listaPrimi.get(i);
        title.setText(temp.getNome());
        price.setText("€ "+temp.getPrezzo());

        return row;
    }
}
