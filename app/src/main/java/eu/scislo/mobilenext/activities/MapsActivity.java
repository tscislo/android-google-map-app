package eu.scislo.mobilenext.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import eu.scislo.mobilenext.BasicInputDialog;
import eu.scislo.mobilenext.BasicInputDialogActionListener;
import eu.scislo.mobilenext.Place;
import eu.scislo.mobilenext.PlaceTypes;
import eu.scislo.mobilenext.Places;
import eu.scislo.mobilenext.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, BasicInputDialogActionListener<LatLng> {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        this.googleMap.setOnMapClickListener((latLng) -> {
            BasicInputDialog basicInputDialog = new BasicInputDialog();
            basicInputDialog.setExternalData(latLng);
            basicInputDialog.show(getFragmentManager(), "BasicInputDialog");
        });

//        this.googleMap.setOnMarkerClickListener((marker) -> {
//            System.out.println(marker.getTitle());
//            marker.remove();
//            return true;
//        });

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        Place place = new Place(new MarkerOptions()
                .position(sydney)
                .title("Sydney"), PlaceTypes.OWN);
        Places.list.add(place);
        googleMap.addMarker(place.markerOptions);


        for(int i =0; i< 100; i++){
            Places.list.add(this.getRandPlace());
        }

        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }


    private Place getRandPlace() {
        LatLng sydney = new LatLng(-34 + Math.random() * 100, 151 + Math.random() * 100);
        Place place = new Place(new MarkerOptions()
                .position(sydney)
                .title("Sydney Australia" + Math.random()), PlaceTypes.OWN);

        googleMap.addMarker(place.markerOptions);
        return place;
    }

    @Override
    public void onDialogPositiveClick(String markerName, LatLng latLng) {
        Place place = new Place(new MarkerOptions()
                .position(latLng)
                .title(markerName), PlaceTypes.OWN);
        Places.list.add(place);
        googleMap.addMarker(place.markerOptions);
    }

    @Override
    public void onDialogNegativeClick() {

    }
}
