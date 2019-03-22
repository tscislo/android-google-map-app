package eu.scislo.mobilenext;

import com.google.android.gms.maps.model.MarkerOptions;

public class Place {

    public MarkerOptions markerOptions;
    public PlaceTypes type;

    public Place(MarkerOptions markerOptions, PlaceTypes type) {
        this.markerOptions = markerOptions;
        this.type = type;
    }

    public String toString() {
        return this.markerOptions.getTitle();
    }

}
