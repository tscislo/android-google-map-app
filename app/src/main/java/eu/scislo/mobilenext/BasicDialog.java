package eu.scislo.mobilenext;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class BasicDialog<T> extends DialogFragment {
    private LayoutInflater inflater;
    private View dialogView;
    BasicDialogActionListener basicDialogActionListener;

    private T externalData;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialogView = inflater.inflate(R.layout.dialog_marker_name, null);

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialogView)
                .setMessage("Message")
                .setPositiveButton("OK", (dialog, id) -> {
                    EditText editText = dialogView.findViewById(R.id.name);
                    System.out.println(editText.getText());
                    this.basicDialogActionListener.onDialogPositiveClick(editText.getText().toString(), this.externalData);
                })
                .setNegativeButton("Cancel", (dialog, id) -> {
                    this.basicDialogActionListener.onDialogNegativeClick();
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            basicDialogActionListener = (BasicDialogActionListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException("Activity must implement BasicDialogActionListener");
        }

    }


    public LayoutInflater getInflater() {
        return inflater;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public T getExternalData() {
        return externalData;
    }

    public void setExternalData(T externalData) {
        this.externalData = externalData;
    }
}
