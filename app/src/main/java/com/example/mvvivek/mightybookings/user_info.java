package com.example.mvvivek.mightybookings;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class user_info extends AppCompatActivity {

    Button btn;
EditText username;
    TextView mighty2;
    EditText usernumber;
    EditText useremail;
    String defaultemail="contact@rootnode.co.in";
    int fname=1,fphone=1;
    theatre t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btn = (Button) findViewById(R.id.button3);
         username=(EditText)findViewById(R.id.editText);
         usernumber=(EditText)findViewById(R.id.editText2);
         useremail=(EditText)findViewById(R.id.editText3);

        mighty2 = (TextView) findViewById(R.id.mighty2);

        Typeface custom = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        mighty2.setTypeface(custom);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        //final String theatre = (String) b.get("theatre");
        //final String movie = (String) b.get("movie");
        t = (theatre) i.getSerializableExtra("object");
        final String seatclass = (String) b.get("seatclass");
        final String noOfSeats = (String) b.get("noOfSeats");
        final String timeSlot = (String) b.get("timeSlot");
        final String dt = (String) b.get("dt");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= username.getText().toString();
                String number=usernumber.getText().toString();
                String email=useremail.getText().toString();

                if(name.isEmpty())
                {
                    username.setError("Please enter your name");
                }
                if(number.length()!=10)
                {
                    usernumber.setError("Please enter a valid number");
                }
                if(email.length()>0 && !Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    useremail.setError("Please enter a valid email id");
                }

                else
                {
                    if(email.length()>0 && number.length()==10 && !name.isEmpty())
                    {
                        Intent i= new Intent(user_info.this, confirmbooking.class);
                        //i.putExtra("theatre",theatre);
                        //i.putExtra("movie",movie);
                        i.putExtra("object",t);
                        i.putExtra("seatclass",seatclass);
                        i.putExtra("noOfSeats",noOfSeats);
                        i.putExtra("timeSlot",timeSlot);
                        i.putExtra("dt",dt);
                        i.putExtra("name",name);
                        i.putExtra("number",number);
                        i.putExtra("email",email);
                        startActivity(i);
                    }
                    else if(email.length()==0 && number.length()==10 && !name.isEmpty())
                    {
                        Intent i= new Intent(user_info.this, confirmbooking.class);
                        //i.putExtra("theatre",theatre);
                        //i.putExtra("movie",movie);
                        i.putExtra("object", t);
                        i.putExtra("seatclass",seatclass);
                        i.putExtra("noOfSeats",noOfSeats);
                        i.putExtra("timeSlot",timeSlot);
                        i.putExtra("dt",dt);
                        i.putExtra("name",name);
                        i.putExtra("number",number);
                        i.putExtra("email",defaultemail);
                        startActivity(i);
                    }

                }
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
            Intent i = new Intent(user_info.this,contact_us.class );
            startActivity(i);

        }

        if(id == R.id.home)
        {
            Intent i = new Intent(user_info.this,MainActivity.class );
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
