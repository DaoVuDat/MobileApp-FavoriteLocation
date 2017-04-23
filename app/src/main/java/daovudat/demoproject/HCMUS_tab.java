package daovudat.demoproject;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;
import java.util.List;

import daovudat.demoproject.Modules.DirectionFinder;
import daovudat.demoproject.Modules.DirectionFinderListener;
import daovudat.demoproject.Modules.Route;

public class HCMUS_tab extends AppCompatActivity implements OnMapReadyCallback, DirectionFinderListener {

    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;
    TextView textView1;
    TextView textView2;
    ListView gridView;
    LocationManager locationManager;
    String provider;

    private GoogleMap mMap;
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_hcmus_tab);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        mapFragment.getMapAsync(this);


        mDrawerList = (ListView) findViewById(R.id.navListHCMUS);


        textView1 = (TextView) findViewById(R.id.textViewHCMUS);
        textView1.setTypeface(EasyFonts.tangerineBold(this));
        textView2 = (TextView) findViewById(R.id.textView_HCMUS_Des);
        textView2.setText("\t1942 Division of Indochina College of Science\n" +
                "\t1956 Faculty of Science, The University of Saigon\n" +
                "\t1977 Ho Chi Minh City University\n" +
                "\t1996 University of Natural Sciences, Vietnam National University – Ho Chi Minh City\n" +
                "\t2007 University of Science, Vietnam National University- Ho Chi Minh City\n" +
                "\tUniversity of Science served as a pioneer in science education in southern Vietnam by establishing the Division of Indochina College of Science in 1942.\n" +
                "\tIn 1977, after the country unified, the Faculty of Science was merged with the Faculty of Letters to create the Ho Chi Minh City University.\n" +
                "\tAfter some reforms, beginning in 1996, the Faculty of Science became the University of Natural Sciences, one of the five affiliated universities of the Vietnam National University-Ho Chi Minh City. " +
                "From the year 2007, the university was renamed as the University of Science.\n" +
                "\tThe University of Science is the public university which plays a particularly important role in education and scientific research in Vietnam National University-Ho Chi Minh City.\n" +
                "\tRecently, HCMUS featured the Laboratory of Stem Cell Research & Application in order to support academic research & new technology in related fields." +
                " Also, the Faculty of IT (FIT) has grown considerably in the last few years and is currently sponsored by the government to become one of the key faculties of IT in HCMC and Vietnam.");
        textView2.setMovementMethod(new ScrollingMovementMethod());

        findlocation();


        addDrawerItems();
        loadTabs();


    }

    private void findlocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria condition = new Criteria();
        provider = locationManager.getBestProvider(condition, false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(provider);

        try {
            new DirectionFinder(this,location.getLatitude()+ ","+location.getLongitude(), "10.763005, 106.682265").execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadTabs() {

        final TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec spec;

        spec = tabHost.newTabSpec("t1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Information");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("t2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Direction");
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }

    private void addDrawerItems() {
        String[] osArray = {"Pictures", "Address", "Contact", "Email"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String textToPosition = String.valueOf(parent.getItemAtPosition(position));
                if (textToPosition == "Pictures") {
                    Intent i = new Intent(HCMUS_tab.this, GridView_hcmus.class);
                    final MediaPlayer sound = MediaPlayer.create(HCMUS_tab.this, R.raw.click);
                    sound.start();
                    startActivity(i);
                }
                else if (textToPosition == "Address") {
                    Toast.makeText(HCMUS_tab.this, "I, 227 Nguyễn Văn Cừ, phường 4 Quận 5 Hồ Chí Minh, Vietnam", Toast.LENGTH_LONG).show();
                }
                else if (textToPosition == "Contact") {
                    Toast.makeText(HCMUS_tab.this, "+84 8 3835 3193", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(HCMUS_tab.this, "Coming soon...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    @Override
    public void onDirectionFinderStart() {

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline : polylinePaths) {
                polyline.remove();
            }
        }
    }

    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView)findViewById(R.id.text_view_distance)).setText(route.distance.text);
            ((TextView)findViewById(R.id.text_view_time)).setText(route.duration.text);

            originMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue))
                    .title(route.startAddress)
                    .position(route.startLocation)));

            destinationMarkers.add(mMap.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green))
                    .title(route.endAddress)
                    .position(route.endLocation)));

            PolylineOptions polylineOptions = new PolylineOptions()
                    .geodesic(true)
                    .color(Color.rgb(204, 102, 255))
                    .width(10);

            for (int i = 0; i < route.points.size(); i++) {
                polylineOptions.add(route.points.get(i));
            }

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }

}
