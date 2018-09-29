package primi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.f.mrlic.R;


public class PrimoFragmentDialog extends DialogFragment {

    private PrimoPiatto primo;

    public PrimoFragmentDialog(PrimoPiatto pPrimo) {
        primo = pPrimo;
    }

    // create an AlertDialog and return it
    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        // create dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View primoDialogView = getActivity().getLayoutInflater().inflate(R.layout.fragment_primo_fragment_dialog, null);
        builder.setView(primoDialogView); // add GUI to dialog

        TextView titleTextView = (TextView) primoDialogView.findViewById(R.id.textTitle);
        titleTextView.setText(primo.getNome());

        TextView ingredientiTextView = (TextView) primoDialogView.findViewById(R.id.textIngredienti);
        ingredientiTextView.setText("Ingredienti: \n"+primo.getIngredienti());

        TextView priceTextView = (TextView) primoDialogView.findViewById(R.id.textPrice);
        priceTextView.setText("€ "+primo.getPrezzo());

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
