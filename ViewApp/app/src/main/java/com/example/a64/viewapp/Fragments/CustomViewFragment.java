package com.example.a64.viewapp.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a64.viewapp.R;
import com.example.a64.viewapp.Views.CustomView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomViewFragment extends Fragment {
    CustomView customView;

    public CustomViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_view, container, false);
        customView = (CustomView) view.findViewById(R.id.customView);
        customView.setLabelColor(Color.BLUE);
        customView.setLabelText("Vista Personalizada");
        customView.setSquareColor(Color.YELLOW);
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.setLabelColor(Color.YELLOW);
                customView.setLabelText("Vista Personalizada");
                customView.setSquareColor(Color.BLUE);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
