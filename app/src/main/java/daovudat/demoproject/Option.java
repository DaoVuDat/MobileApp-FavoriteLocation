package daovudat.demoproject;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

public class Option extends AppCompatActivity {
    ListView listViewOption;
    ListOptionAdapter adapter;
    ArrayList<OptionView> trailerArrayList;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        textView1 = (TextView) findViewById(R.id.textView_Op);
        textView1.setTypeface(EasyFonts.tangerineBold(this));
        initControls();
        loadData();
    }

    private void loadData() {
        trailerArrayList.add(new OptionView("Default Location",
                "==> Suggested Areas, Schools, Hotels, Supermarkets,... in Regions in System"));
        trailerArrayList.add(new OptionView("Your Location",
                "==> Areas, Schools, Hotels, Supermarkets,... near your Location"));

        adapter.addAll(trailerArrayList);

    }

    private void initControls() {
        listViewOption = (ListView)findViewById(R.id.listViewOption);
        adapter = new ListOptionAdapter(this);
        trailerArrayList = new ArrayList<>();
        listViewOption.setAdapter(adapter);
        listViewOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent i = new Intent(Option.this, DefaultOp.class);
                    MediaPlayer sound = MediaPlayer.create(Option.this,R.raw.click);
                    sound.start();
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(Option.this, UserOption.class);
                    MediaPlayer sound1 = MediaPlayer.create(Option.this,R.raw.click);
                    sound1.start();
                    startActivity(i);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hcm, menu);
        return true;
    }

}
