package daovudat.demoproject;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.vstechlab.easyfonts.EasyFonts;



// Code from http://blog.teamtreehouse.com/add-navigation-drawer-android



public class HoChiMinh extends AppCompatActivity {

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getActionBar();
        setContentView(R.layout.activity_ho_chi_minh);

        mDrawerList = (ListView)findViewById(R.id.navList);mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();

        textView1 = (TextView)findViewById(R.id.textViewHCM);
        textView1.setTypeface(EasyFonts.tangerineBold(this));
        textView2 = (TextView)findViewById(R.id.textView_HCM_Des);
        textView2.setText("\tHo Chi Minh City (HCMC) is located in the delta area of the Saigon and Dong Nai rivers. " +
                "It is Vietnam’s largest city and an important economic, trade, cultural and research centre, both within the country, " +
                "and in South-East Asia. HCMC has a diversified topography, ranging from mainly agricultural and rural areas in the north " +
                "to a widespread system of rivers, canals and dense mangrove forest to the south. " +
                "The urban areas are located approximately 50km (31.1 miles) inland from the Pacific Ocean.\n" +
                "\n\tHCMC has a tropical monsoonal climate with two distinct seasons: a rainy season lasting from May to" +
                " November and a dry season from December to April. The mean annual temperature is 27.4 degrees " +
                "with an average humidity of about 77%. Average annual rainfall is about 2100 mm (82,7 inches) " +
                "of which about 90% falls during the rainy season. ");
        textView2.setMovementMethod(new ScrollingMovementMethod());

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void addDrawerItems() {
        String[] osArray = { "HCMUS", "Dinh Doc Lap", "Cho Ben Thanh"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String textToPosition = String.valueOf(parent.getItemAtPosition(position));
                if(textToPosition == "HCMUS")
                {
                    Intent i = new Intent(HoChiMinh.this, HCMUS_tab.class);
                    final MediaPlayer sound = MediaPlayer.create(HoChiMinh.this,R.raw.click);
                    sound.start();
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(HoChiMinh.this,"Coming soon...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Areas");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hcm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
