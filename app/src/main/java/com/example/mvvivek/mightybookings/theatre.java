package com.example.mvvivek.mightybookings;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mahe on 2/22/2018.
 */

public class theatre implements Serializable
{
    public String hall;
    public String show_id;
    public List<categories> categories;
    public Movie movie;

    public String getHall() {
        return hall;
    }

    public String getId() {
        return show_id;
    }

    public List<categories> getCategory() {
        return categories;
    }

    public Movie getMovie() {
        return movie;
    }
}
