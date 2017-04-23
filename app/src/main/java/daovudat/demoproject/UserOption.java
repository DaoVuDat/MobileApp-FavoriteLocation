package daovudat.demoproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class UserOption extends AppCompatActivity {

    private PlacePicker.IntentBuilder builder;
    private static final int PLACE_PICKER_FLAG = 1;

    ImageButton pickerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_user_option);
        builder = new PlacePicker.IntentBuilder();
        pickerBtn = (ImageButton) findViewById(R.id.pickerBtn);
        pickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer sound = MediaPlayer.create(UserOption.this,R.raw.click);
                sound.start();
                try {
                    builder = new PlacePicker.IntentBuilder();
                    Intent intent = builder.build(UserOption.this);
                    // Start the Intent by requesting a result, identified by a request code.
                    startActivityForResult(intent, PLACE_PICKER_FLAG);

                } catch (GooglePlayServicesRepairableException e) {
                    GooglePlayServicesUtil
                            .getErrorDialog(e.getConnectionStatusCode(), UserOption.this, 0);
                } catch (GooglePlayServicesNotAvailableException e) {
                    Toast.makeText(UserOption.this, "Google Play Services is not available.",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PLACE_PICKER_FLAG:
                    Place place = PlacePicker.getPlace(data, this);
                    break;
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hcm, menu);
        return true;
    }
}
