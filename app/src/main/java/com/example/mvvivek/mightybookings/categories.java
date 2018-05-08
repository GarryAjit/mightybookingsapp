package com.example.mvvivek.mightybookings;

import java.io.Serializable;

/**
 * Created by Mahe on 2/22/2018.
 */

public class categories implements Serializable
{
    public String name;
    public int price;
    public int seats;

    public String getCategoryName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getSeats() {
        return seats;
    }
}
