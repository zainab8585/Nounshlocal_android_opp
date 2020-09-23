package barmej.com.nourishlocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private EditText nameEditText;
    private Button makeButton;
    private Button cookButton;
    private Button shopButton;
    private Button eatButton;
    private Button growButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        makeButton = (Button) findViewById(R.id.makeButton);
        cookButton = (Button) findViewById(R.id.cookButton);
        shopButton = (Button) findViewById(R.id.shopButton);
        eatButton = (Button) findViewById(R.id.eatButton);
        growButton = (Button) findViewById(R.id.growButton);

        makeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(makeButton.getText().toString());
            }
        });

        cookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(cookButton.getText().toString());
            }
        });

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(shopButton.getText().toString());
            }
        });

        eatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(eatButton.getText().toString());
            }
        });

        growButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(growButton.getText().toString());
            }
        });
    }

    private void openDetails(String type){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(getString(R.string.friend_name_key), nameEditText.getText().toString());
        intent.putExtra(getString(R.string.type_key), type);
        startActivity(intent);
    }
}
