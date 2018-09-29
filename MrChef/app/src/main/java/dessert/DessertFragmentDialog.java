package dessert;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.f.mrlic.R;


public class DessertFragmentDialog extends DialogFragment {

    private Dessert dessert;

    public DessertFragmentDialog(Dessert pDessert) {
        dessert = pDessert;
    }

    // create an AlertDialog and return it
    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        // create dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View dessertDialogView = getActivity().getLayoutInflater().inflate(R.layout.fragment_dessert_fragment_dialog, null);
        builder.setView(dessertDialogView); // add GUI to dialog

        TextView titleTextView = (TextView) dessertDialogView.findViewById(R.id.textTitle);
        titleTextView.setText(dessert.getNome());

        TextView ingredientiTextView = (TextView) dessertDialogView.findViewById(R.id.textIngredienti);
        ingredientiTextView.setText("Ingredienti: \n"+dessert.getIngrediednti());

        TextView priceTextView = (TextView) dessertDialogView.findViewById(R.id.textPrice);
        priceTextView.setText("€ "+dessert.getPrezzo());

        // set the AlertDialog's
        builder.setCancelable(true);

        // add Set Color Button
        builder.setNegativeButton("close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do something
                    }
                }
        );

        return builder.create(); // return dialog
    }
}
