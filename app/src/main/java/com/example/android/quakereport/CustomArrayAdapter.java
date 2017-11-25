package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        TextView placeTextView2 = convertView.findViewById(R.id.place_text_view2);
        TextView dateTextView = convertView.findViewById(R.id.date_text_view);
        TextView timeTextView = convertView.findViewById(R.id.time_text_view);
        // Create GradientDrawable object and store the magTextView background in it
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        // Get the magnitude color using our method, we pass in the current item magnitude as argument
        // Our method will take the magnitude and, by using a switch statement, will return the appropriate color
        int magnitudeColor = getMagnitudeColor(rowOfData.getmMag());
        // Set the background color to the color we got above
        magnitudeCircle.setColor(getContext().getResources().getColor(magnitudeColor));
        // Passing the time in milliseconds into a new Date object
        Date dateObject = new Date(rowOfData.getmDate());
        // Creating date formatter objects specifying the pattern as argument
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat hourFormatter = new SimpleDateFormat("h:mm a");
        DecimalFormat magFormatter = new DecimalFormat("#.#");
        // Formatting the date objects using the patterns we specified
        String dateString = dateFormatter.format(dateObject);
        String hourString = hourFormatter.format(dateObject);
        String magString = magFormatter.format(rowOfData.getmMag());
        // Getting the place String from our data
        String stringToSplit = rowOfData.getmPlace();
        // Defining 2 String variables that will hold the split String
        String firstString;
        String secondString;
        // If the String data contains the charSequence "of ", then split the string there
        // As a result, "of " will be eliminated so we will have to add it manually again
        if(stringToSplit.contains("of ")) {
            // Splitting at "of "
            String[] splitString = stringToSplit.split("of ");
            // Getting first part of split string and adding "of" to it since it was eliminated
            firstString = splitString[0] + "of";
            // Getting the second part of the split string
            secondString = splitString[1];
        }
        // If it doesn't contain "of " then create the firstString manually as being "Near the"
        // The second part will just be the place
        else {
            firstString = "Near the";
            secondString = rowOfData.getmPlace();
        }

        // Populate the views with our data using the getter methods from our class and/or the variables created above
        magTextView.setText(magString);
        placeTextView.setText(firstString);
        placeTextView2.setText(secondString);
        dateTextView.setText(dateString);
        timeTextView.setText(hourString);
        // return our custom layout
        return convertView;
    }
    /**
     * @param magnitude - this is the magnitude for each earthquake
     * @return the desired color for different quake magnitudes
     * */
    public int getMagnitudeColor(double magnitude){
        // We need to cast the magnitude into an int, because getmMag() will return a double - we only need int
        int mag = (int) magnitude;
        //
        int magnitudeColor;
        switch (mag) {
            case 0 : magnitudeColor = R.color.magnitude1; break;
            case 2 : magnitudeColor = R.color.magnitude2; break;
            case 3 : magnitudeColor = R.color.magnitude3; break;
            case 4 : magnitudeColor = R.color.magnitude4; break;
            case 5 : magnitudeColor = R.color.magnitude5; break;
            case 6 : magnitudeColor = R.color.magnitude6; break;
            case 7 : magnitudeColor = R.color.magnitude7; break;
            case 8 : magnitudeColor = R.color.magnitude8; break;
            case 9 : magnitudeColor = R.color.magnitude9; break;
            default: magnitudeColor = R.color.magnitude10plus;
        }
        return magnitudeColor;
    }
}