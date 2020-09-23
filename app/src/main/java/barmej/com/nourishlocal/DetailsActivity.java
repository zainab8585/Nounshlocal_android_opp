package barmej.com.nourishlocal;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private String friendName;
    private String type;

    private ImageView typeImageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        friendName = getIntent().getStringExtra(getString(R.string.friend_name_key));
        type = getIntent().getStringExtra(getString(R.string.type_key));

        typeImageView = (ImageView) findViewById(R.id.typeImageView);

        typeImageView.setImageResource(getTypeDrawable(type));

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setText(type);

        descriptionTextView = (TextView) findViewById(R.id.descTextView);
        descriptionTextView.setText(getDescription(type));

        shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setText(String.format("%s %s", getString(R.string.share_with), friendName));

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                String msg = String.format("%s: %s", friendName, getDescription(type));
                shareIntent.putExtra(Intent.EXTRA_TEXT, msg);

                startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name)));
            }
        });
    }

    private int getTypeDrawable(String type) {
        if (type.equals(getString(R.string.make))) {
            return R.drawable.make;

        } else if (type.equals(getString(R.string.cook))) {
            return R.drawable.cook;

        } else if (type.equals(getString(R.string.eat))) {
            return R.drawable.eat;

        } else if (type.equals(getString(R.string.grow))) {
            return R.drawable.grow;

        } else {
            return R.drawable.shop;

        }

    }

    private String getDescription(String type) {
        if (type.equals(getString(R.string.make))) {
            return getString(R.string.make_description);

        } else if (type.equals(getString(R.string.cook))) {
            return getString(R.string.cook_description);

        } else if (type.equals(getString(R.string.eat))) {
            return getString(R.string.eat_description);

        } else if (type.equals(getString(R.string.grow))) {
            return getString(R.string.grow_description);

        } else {
            return getString(R.string.shop_description);

        }
    }

}
