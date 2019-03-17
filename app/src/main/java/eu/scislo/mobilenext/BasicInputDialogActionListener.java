package eu.scislo.mobilenext;


public interface BasicInputDialogActionListener<T> {
    public void onDialogPositiveClick(String value, T externalData);

    public void onDialogNegativeClick();
}


