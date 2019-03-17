package eu.scislo.mobilenext;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import eu.scislo.mobilenext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setUser(this.user);
    }

    public void navigateToMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void navigateMessageRead(View view) {
        Intent intent = new Intent(this, MessageRead.class);
        intent.putExtra(MyIntents.MESSAGE.toString(), this.user.toString());
        startActivity(intent);
    }


}
