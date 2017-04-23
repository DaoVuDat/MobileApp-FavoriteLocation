package daovudat.demoproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Dao Vu Dat on 7/2/2016.
 */
public class ListOptionAdapter extends ArrayAdapter<OptionView> {
    Context context;

    public ListOptionAdapter(Context context) {
        super(context, 0);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.option_view, null);
        }
        OptionView optionView = getItem(position);
        if (optionView != null) {
            ((TextView)view.findViewById(R.id.text_view_name)).setText(optionView.getName());
            ((TextView)view.findViewById(R.id.text_view_des)).setText(optionView.getDes());
        }
        return view;
    }
}
