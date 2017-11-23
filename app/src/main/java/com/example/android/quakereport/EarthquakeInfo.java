package com.example.android.quakereport;

public class EarthquakeInfo {
    /** Earthquake states - it will have a magnitude, a date and a place */
    private double mMag;
    private String mDate;
    private String mPlace;
    /** The constructor that we're going to use the pass the data for each EarthquakeInfo object */
    public EarthquakeInfo(double mag, String place, String date){
        mMag = mag;
        mPlace = place;
        mDate = date;
    }
    /** Getters methods */
    public double getmMag() {
        return mMag;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmPlace() {
        return mPlace;
    }
}
