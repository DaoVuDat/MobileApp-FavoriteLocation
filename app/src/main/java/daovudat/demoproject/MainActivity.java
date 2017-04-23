package daovudat.demoproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        final MediaPlayer sound = MediaPlayer.create(this,R.raw.click);
        ImageView imageView ;
        ImageButton btnStart;
        TextView textView1;
        TextView textView2;

        imageView = (ImageView) findViewById(R.id.imageViewStart);

        btnStart = (ImageButton) findViewById(R.id.buttonStart);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);


        textView1.setTypeface(EasyFonts.tangerineRegular(this));
        textView2.setTypeface(EasyFonts.tangerineBold(this));


        imageView.setImageResource(R.drawable.search_1);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Option.class);
                sound.start();
                startActivity(i);
                finish();
            }
        });
    }
}
