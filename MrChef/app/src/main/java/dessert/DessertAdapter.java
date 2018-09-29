package dessert;


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

public class DessertAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<Dessert> listaDessert;

    DessertAdapter(Context pContext, ArrayList<Dessert> pListaDessert) {
        context = pContext;
        listaDessert = pListaDessert;
        new DessertTask(context,listaDessert,this).execute();
    }

    //Restituisce la grandezza della lista
    @Override
    public int getCount() {
        return listaDessert.size();
    }

    //Restituisce l'elemneto selezionato della lista
    @Override
    public Object getItem(int position) {
        return listaDessert.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //imposta la View di un elemento della lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //attivo l'inflater per caricare la view di un item della lista
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //creo la view per inserire una riga nella list view
        View row = inflater.inflate(R.layout.dessert_row, parent, false);
        //recupero la text view del file dessert_row.xml
        TextView title = (TextView) row.findViewById(R.id.title);
        TextView price = (TextView) row.findViewById(R.id.prezzo);
        //recupero l'elemento dell'array list prrsente nella posizione avnte indice position
        Dessert temp = listaDessert.get(position);
        //inserisco nella textView il nome del dessert dell'oggetto temp
        title.setText(temp.getNome());
        //inseerisco nella textView il prezzo del dessert dell'oggetto temp
        price.setText("€ "+temp.getPrezzo());
        //restituisco la riga da inserire nella list view presente nel fragment dessert_fragment
        return row;
    }
}
