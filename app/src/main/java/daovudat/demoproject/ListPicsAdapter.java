package daovudat.demoproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by Dao Vu Dat on 7/4/2016.
 */
public class ListPicsAdapter extends ArrayAdapter<Pics> {

    Context context;

    public ListPicsAdapter(Context context) {
        super(context, 0);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.grid_item_hcmus, null);
        }
        Pics trailer = getItem(position);
        if (trailer != null) {
            ((ImageView)view.findViewById(R.id.img_view)).setImageBitmap(trailer.getImage());
        }
        return view;
    }
}