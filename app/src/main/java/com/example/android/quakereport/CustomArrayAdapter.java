package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bogda on 11/22/2017.
 */

public class CustomArrayAdapter extends ArrayAdapter<EarthquakeInfo> {
    /**
     * Here we create our own constructor. When we use it we return the same data,
     * but 0 for resource because we're going to use our own layout now
     */
    public CustomArrayAdapter(Context context, ArrayList<EarthquakeInfo> myArrayList) {
        // here we pass in the context as usual, 0 as resource because we're going to override the methods and use our own layout, and our array list(data)
        super(context, 0, myArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        EarthquakeInfo rowOfData = getItem(position);
        // Check if there is an existing list item view (convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, parent, false);
        }
        // Get the views that we want to populate with our data
        TextView magTextView = convertView.findViewById(R.id.mag_text_view);
        TextView placeTextView = convertView.findViewById(R.id.place_text_view);
        TextView dateTextView = convertView.findViewById(R.id.date_text_view);
        // Populate the views with our data using the getter methods from our class
        magTextView.setText(String.valueOf(rowOfData.getmMag()));
        placeTextView.setText(rowOfData.getmPlace());
        dateTextView.setText(rowOfData.getmDate());
        // return our custom layout
        return convertView;
    }
}