package com.example.mvvivek.mightybookings;

import java.io.Serializable;

/**
 * Created by mvvivek on 22/02/2018.
 */

public class Movie implements Serializable
{

    private String movieName;
    private String description;
    private String trailer;
    private String poster;
    private String date;
    private String time;



    public String getMovieName() {
        return movieName;
    }


    public String getDescription() {
        return description;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getPoster() {
        return poster;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}






