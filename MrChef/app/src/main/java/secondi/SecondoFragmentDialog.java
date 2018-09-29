package secondi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.f.mrlic.R;


public class SecondoFragmentDialog extends DialogFragment {

    private SecondoPiatto secondo;

    public SecondoFragmentDialog(SecondoPiatto pSecondo) {
        secondo = pSecondo;
    }

    // create an AlertDialog and return it
    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        // create dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View secondoDialogView = getActivity().getLayoutInflater().inflate(R.layout.fragment_secondo_fragment_dialog, null);
        builder.setView(secondoDialogView); // add GUI to dialog

        TextView titleTextView = (TextView) secondoDialogView.findViewById(R.id.textTitle);
        titleTextView.setText(secondo.getNome());

        TextView ingredientiTextView = (TextView) secondoDialogView.findViewById(R.id.textIngredienti);
        ingredientiTextView.setText("Ingredienti: \n"+secondo.getIngredienti());

        TextView priceTextView = (TextView) secondoDialogView.findViewById(R.id.textPrice);
        priceTextView.setText("€ "+secondo.getPrezzo());

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
