package daovudat.demoproject;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vstechlab.easyfonts.EasyFonts;

public class DefaultOp extends AppCompatActivity {
    TextView textView1;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_default_op);
        textView1 = (TextView)findViewById(R.id.textView_Country);
        textView1.setTypeface(EasyFonts.tangerineBold(this));

        listView = (ListView)findViewById(R.id.listView_Country);
        final String [] regions =new String[]{
                "Vietnam",
                "Japan",
                "Laos",
                "United State",
                "Singapore",
                "Thailand",
                "Russia",
                "England",
                "Korea",
                "India",
                "Canada"};
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, regions){

            @Override
            public View getView(int position, View convertView,
                                ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextSize(20);
                textView.setTextColor(Color.parseColor("#d1932e"));

                return view;
            }
        };

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String textToPosition = String.valueOf(parent.getItemAtPosition(position));
                if(textToPosition == "Vietnam")
                {
                    Intent i = new Intent(DefaultOp.this, Vietnam.class);
                    final MediaPlayer sound = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound.start();
                    startActivity(i);
                }
                else if (textToPosition == "Laos")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                }
                else if (textToPosition == "United State")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "Singapore")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "Thailand")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "Russia")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "England")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "Japan")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                }
                else if (textToPosition == "Korea")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "India")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
                }
                else if (textToPosition == "Canada")
                {
                    MediaPlayer sound1 = MediaPlayer.create(DefaultOp.this,R.raw.click);
                    sound1.start();
                    Toast.makeText(DefaultOp.this,"Updating...",Toast.LENGTH_SHORT).show();
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
