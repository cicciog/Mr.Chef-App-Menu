package primi;

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

public class PrimiFragment extends Fragment {

    private ArrayList<PrimoPiatto> listaPrimi;
    private Context context;
    private PrimiAdapter primiAdapter;

    public PrimiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_primi, null);

        ListView listView = (ListView) rootView.findViewById(R.id.listaPrimi);
        listaPrimi = new ArrayList<PrimoPiatto>();
        primiAdapter = new PrimiAdapter(getActivity(),listaPrimi);
        listView.setAdapter(primiAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                           @Override
              public void onItemClick (AdapterView< ? > adapter, View view, int position, long arg){
              FragmentManager fm = getActivity().getFragmentManager();
              PrimoFragmentDialog dialog = new PrimoFragmentDialog(listaPrimi.get(position));
                                                dialog.show(fm, "example");
                                            }
                                       }
                                    );

        return rootView;
    }
}
