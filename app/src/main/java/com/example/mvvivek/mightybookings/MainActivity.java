package com.example.mvvivek.mightybookings;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    TextView mighty;
    theatre t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView tv3 = (TextView)findViewById(R.id.tv3);
        TextView tv33 = (TextView)findViewById(R.id.tv33);
        Button denzongbutton = (Button) findViewById(R.id.denzongbutton);
        Button imperialbutton = (Button) findViewById(R.id.imperialbutton);
        mighty = (TextView) findViewById(R.id.mighty);
        t1=new theatre();
        t2=new theatre();

        Typeface custom = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        mighty.setTypeface(custom);

        if(BuildConfig.DEBUG) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        ApiClient.getAPIInterface().getEventsList().enqueue(new Callback<List<theatre>>() {
            @Override
            public void onResponse(Call<List<theatre>> call, Response<List<theatre>> response) {
                //Log.d("stag1",response.body().get(0).getHall());

                t1.hall = response.body().get(0).getHall();
                t1.show_id = response.body().get(0).getId();
                t1.categories = response.body().get(0).getCategory();
                t1.movie = response.body().get(0).movie;

                t2.hall = response.body().get(1).getHall();
                t2.show_id = response.body().get(1).getId();
                t2.categories = response.body().get(1).getCategory();
                t2.movie = response.body().get(1).movie;

            }

            @Override
            public void onFailure(Call<List<theatre>> call, Throwable t) {

                Log.d("stag2",t.getMessage());

            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = "https://www.youtube.com/watch?v=-K9ujx8vO_A&t=1s";
                String url = t1.movie.getTrailer();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        tv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = "https://www.youtube.com/watch?v=-K9ujx8vO_A&t=1s";
                String url = t2.movie.getTrailer();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        denzongbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, ticket_info.class);
                String theatre="Denzong Hall";
                String movie="Padman";
                //i.putExtra("theatre",theatre);
                //i.putExtra("movie",movie);
                i.putExtra("object",t1);
                startActivity(i);
            }
        });
        imperialbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, ticket_info.class);
                String theatre="Imperial Hall";
                String movie="Padman";
                i.putExtra("theatre",theatre);
                i.putExtra("movie",movie);
                startActivity(i);
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.dropdownmenu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.aboutUs)
        {
            String url = "https://rootnode.co.in";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        if(id == R.id.contactUs)
        {
            Intent i = new Intent(MainActivity.this,contact_us.class );
            startActivity(i);

        }

        if(id == R.id.home)
        {
            Intent i = new Intent(MainActivity.this,MainActivity.class );
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}

