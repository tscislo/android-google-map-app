package eu.scislo.mobilenext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateToMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void navigateMessageRead(View view) {
        Intent intent = new Intent(this, MessageRead.class);
        TextView editText = findViewById(R.id.name);
        String message = editText.getText().toString();
        intent.putExtra(MyIntents.MESSAGE.toString(), message);
        startActivity(intent);
    }


}
