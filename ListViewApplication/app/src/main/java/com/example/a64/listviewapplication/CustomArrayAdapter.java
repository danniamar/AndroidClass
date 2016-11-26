package com.example.a64.listviewapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64 on 26/11/2016.
 */

public class CustomArrayAdapter extends ArrayAdapter<String> {
    private Context mcontext;
    private ArrayList<String> dataset;

    public CustomArrayAdapter(Context context, ArrayList<String> dataset) {
        super(context, 0, dataset);
        mcontext= context;
        this.dataset=dataset;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(convertView == null){
          LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService();
            view=inflater.inflate(R.layout.layout_recycler,parent, false);
        }
        TextView txtView = (TextView) view.findViewById(R.id.txt_nombre);
        txtView.setText(dataset.get(position));

        TextView txtcargo = (TextView) view.findViewById(R.id.txt_Cargo);
        txtView.setText(dataset.get(position));

        return view;
    }
}
