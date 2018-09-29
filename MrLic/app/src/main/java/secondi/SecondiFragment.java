package secondi;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondiFragment extends Fragment {

    private ArrayList<SecondoPiatto> listaSecondi;
    private Context context;
    private SecondiAdapter secondiAdapter;

    public SecondiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_secondi, null);

        ListView listView = (ListView) rootView.findViewById(R.id.listaSecondi);
        listaSecondi = new ArrayList<SecondoPiatto>();
        secondiAdapter = new SecondiAdapter(getActivity(),listaSecondi);
        listView.setAdapter(secondiAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick (AdapterView< ? > adapter, View view, int position, long arg){
                                                FragmentManager fm = getActivity().getFragmentManager();
                                                SecondoFragmentDialog dialog = new SecondoFragmentDialog(listaSecondi.get(position));
                                                dialog.show(fm, "example");
                                            }
                                        }
        );

        return rootView;
    }

}
