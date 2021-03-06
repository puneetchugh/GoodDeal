package com.example.puneetchugh.gooddealapplication.adapters;
import android.support.annotation.Nullable;
import android.widget.BaseAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.puneetchugh.gooddealapplication.R;
import com.example.puneetchugh.gooddealapplication.data.ProductsDataSource;
import com.example.puneetchugh.gooddealapplication.models.History;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by puneet on 11/26/15.
 */

public class HistoryAdapter extends BaseAdapter implements View.OnClickListener {

    private ProductsDataSource productsDataSource;
    private Activity activity;
    private ArrayList<History> histories;
    private static LayoutInflater inflater = null;
    public Resources res;
    private History tempValues = null;

    public HistoryAdapter(Activity activity, ArrayList<History> histories, Resources res) {

        productsDataSource = new ProductsDataSource(activity);
        this.activity = activity;
        this.histories = histories;
        this.res = res;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public int getCount() {

        if (histories.size() <= 0)
            return 1;
        return histories.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {


        @Nullable @BindView(R.id.product_name) TextView productNameView;
        //public TextView productSequenceView;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            vi = inflater.inflate(R.layout.history_tab, null);

            holder = new ViewHolder(vi);
            //holder.productNameView = (TextView) vi.findViewById(R.id.product_name);
            //holder.productSequenceView = (TextView) vi.findViewById(R.id.sequence_number);

            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();

        if (histories.size() <= 0) {
            holder.productNameView.setText("No History");


        } else {

            tempValues = null;
            tempValues = (History) histories.get(position);

            holder.productNameView.setText(tempValues.getName());
            //holder.productSequenceView.setText(String.valueOf(tempValues.getId()));
        }

        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }


}

