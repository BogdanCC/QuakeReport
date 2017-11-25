package com.example.android.quakereport;

public class EarthquakeInfo {
    /** Earthquake states - it will have a magnitude, a date and a place */
    private double mMag;
    private long mDate;
    private String mPlace;
    private String quakeUrl;
    /** The constructor that we're going to use the pass the data for each EarthquakeInfo object */
    public EarthquakeInfo(double mag, String place, long date, String url){
        mMag = mag;
        mPlace = place;
        mDate = date;
        quakeUrl = url;
    }
    /** Getter methods */
    public double getmMag() {
        return mMag;
    }

    public long getmDate() {
        return mDate;
    }

    public String getmPlace() {
        return mPlace;
    }
    public String getQuakeUrl(){
        return quakeUrl;
    }
}
