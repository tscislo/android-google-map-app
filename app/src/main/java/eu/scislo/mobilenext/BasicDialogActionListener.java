package eu.scislo.mobilenext;


public interface BasicDialogActionListener<T> {
    public void onDialogPositiveClick(String value, T externalData);

    public void onDialogNegativeClick();
}


