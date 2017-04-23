package daovudat.demoproject;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class GridView_hcmus extends AppCompatActivity {

    GridView listViewTrPics;
    ListPicsAdapter adapter;
    ArrayList<Pics> picsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_grid_view_hcmus);

        initControls();
        loadData();
    }

    private void loadData() {
        picsArrayList.add(new Pics(BitmapFactory.decodeResource(getResources(), R.raw.hcmus1)));
        picsArrayList.add(new Pics(BitmapFactory.decodeResource(getResources(), R.raw.hcmus2)));
        picsArrayList.add(new Pics(BitmapFactory.decodeResource(getResources(), R.raw.hcmus3)));
        adapter.addAll(picsArrayList);

    }

    private void initControls() {
        listViewTrPics = (GridView) findViewById(R.id.list_view_pics);
        adapter = new ListPicsAdapter(this);
        picsArrayList = new ArrayList<>();
        listViewTrPics.setAdapter(adapter);
    }
}
