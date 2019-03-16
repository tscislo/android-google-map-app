package eu.scislo.mobilenext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
    }

    public void navigateToMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}
