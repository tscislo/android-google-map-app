package eu.scislo.mobilenext.activities;

import android.gesture.GestureOverlayView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import eu.scislo.mobilenext.PlaceRecyclerViewAdapter;
import eu.scislo.mobilenext.Places;
import eu.scislo.mobilenext.R;

public class PlacesList extends AppCompatActivity implements PlaceRecyclerViewAdapter.ItemClickListener {

    PlaceRecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        recyclerView = findViewById(R.id.placesList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        this.drawRecyclerAdapter();
    }

    public void drawRecyclerAdapter() {
        adapter = new PlaceRecyclerViewAdapter(this, Places.list);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Places.list.remove(position);
        this.drawRecyclerAdapter();
    }
}
