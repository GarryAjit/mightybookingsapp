package com.example.mvvivek.mightybookings;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmbooking extends AppCompatActivity {
TextView hallname;
    TextView moviename;
    TextView date;
    TextView time;
    TextView category;
    TextView seats;
    TextView username;
    TextView usernumber;
    Button cancel;
    TextView terms;
    TextView mighty4;
    TextView bill;
    theatre t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmbooking);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hallname=(TextView) findViewById(R.id.hallname);
        moviename=(TextView) findViewById(R.id.moviename);
        date=(TextView) findViewById(R.id.date);
        time=(TextView) findViewById(R.id.time);
        category=(TextView) findViewById(R.id.category);
        seats=(TextView) findViewById(R.id.seats);
        username=(TextView) findViewById(R.id.name);
        usernumber=(TextView) findViewById(R.id.number);
        cancel=(Button)findViewById(R.id.cancel);
        terms=(TextView)findViewById(R.id.textView32) ;
        mighty4 = (TextView) findViewById(R.id.mighty4);
        bill = (TextView) findViewById(R.id.bill);
        Typeface custom = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        mighty4.setTypeface(custom);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        //final String theatre = (String) b.get("theatre");
        //final String movie = (String) b.get("movie");
        t = (theatre) i.getSerializableExtra("object");
        final String seatclass = (String) b.get("seatclass");
        final String noOfSeats = (String) b.get("noOfSeats");
        final String timeSlot = (String) b.get("timeSlot");
        final String dt = (String) b.get("dt");
        final String name= (String) b.get("name");
        final String number= (String) b.get("number");
        final String email= (String) b.get("email");
        hallname.setText(t.getHall());
        moviename.setText(t.getMovie().getMovieName());
        date.setText(dt);
        time.setText(timeSlot);
        category.setText(seatclass);
        seats.setText(noOfSeats);
        username.setText(name);
        usernumber.setText(number);
        bill.setText("Rs "+180*5);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(confirmbooking.this, MainActivity.class);
                startActivity(i);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://mightybookings.com/TermsAndConditions.pdf";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
