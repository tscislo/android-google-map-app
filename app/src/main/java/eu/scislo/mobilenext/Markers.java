package eu.scislo.mobilenext;

import com.google.android.gms.maps.model.Marker;

import java.util.HashMap;

public class Markers {

    private HashMap<String, Marker> myMarkers = new HashMap();

    public void addMyMarker(String name, Marker marker) {
        myMarkers.put(name, marker);
    }

}
