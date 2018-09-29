package dessert;


import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.f.mrlic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DessertFragment extends Fragment {

    private ArrayList<Dessert> listaDessert;
    private Context context;
    private DessertAdapter dessertAdapter;

    public DessertFragment() {
        // Required empty public constructor
    }

    //premette di creare la view del fragment, in questo caso viene creata la list view dei dessert
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //richiamo come view padre il layout del fragment dessert definito del file fragment_dessert.xml
        View rootView = inflater.inflate(R.layout.fragment_dessert, null);
        //richiamo la list view presente nel file fragment_dessert.xml
        ListView listView = (ListView) rootView.findViewById(R.id.listaDessert);

        //creao un'array list di dessert
        listaDessert = new ArrayList<Dessert>();

        //creo un dessertAdapter per riempire la list view con la listDessert (arraylist) in poche parole associo
        //un singolo oggetto della listDessert ad ogni dessert_row (oggetto --> view)
        dessertAdapter = new DessertAdapter(getActivity(),listaDessert);
        listView.setAdapter(dessertAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick (AdapterView< ? > adapter, View view, int position, long arg){
                                                FragmentManager fm = getActivity().getFragmentManager();
                                                DessertFragmentDialog dialog = new DessertFragmentDialog(listaDessert.get(position));
                                                dialog.show(fm, "example");
                                            }
                                        }
        );
        //dopo aver riempito la rootView con l'aiuto dell'adapter la passo al fragment per la visualizzazione
        return rootView;
    }

}
