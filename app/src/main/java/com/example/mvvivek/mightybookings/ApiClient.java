package com.example.mvvivek.mightybookings;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Mahe on 2/22/2018.
 */

public class ApiClient
{
    private static Retrofit retrofit = null;
    private static Retrofit retrofitEgg = null;

    private static final String BASE_URL = "http://54.163.75.233:8000/";

    public static APIInterface getAPIInterface(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            //retrofitEgg = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit.create(APIInterface.class);
    }



    public interface APIInterface{
        @GET("getdata")
        Call<List<theatre>> getEventsList();



    }
}
