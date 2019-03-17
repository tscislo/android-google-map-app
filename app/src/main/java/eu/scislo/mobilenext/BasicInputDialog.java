package eu.scislo.mobilenext;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class BasicInputDialog<T> extends DialogFragment {
    private View dialogView;
    BasicInputDialogActionListener basicInputDialogActionListener;

    private T externalData;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_marker_name, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(dialogView)
                .setMessage("Message")
                .setPositiveButton("OK", (dialog, id) -> {
                    EditText editText = dialogView.findViewById(R.id.name);
                    this.basicInputDialogActionListener.onDialogPositiveClick(editText.getText().toString(), this.externalData);
                })
                .setNegativeButton("Cancel", (dialog, id) -> {
                    this.basicInputDialogActionListener.onDialogNegativeClick();
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            basicInputDialogActionListener = (BasicInputDialogActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement BasicInputDialogActionListener");
        }

    }


    public T getExternalData() {
        return externalData;
    }

    public void setExternalData(T externalData) {
        this.externalData = externalData;
    }
}
