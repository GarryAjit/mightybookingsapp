package com.example.mvvivek.mightybookings;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class contact_us extends AppCompatActivity {
    TextView mighty3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mighty3 = (TextView) findViewById(R.id.mighty3);

        Typeface custom = Typeface.createFromAsset(getAssets(),"fonts/Lobster-Regular.ttf");
        mighty3.setTypeface(custom);
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

        if(id == R.id.home)
        {
            Intent i = new Intent(contact_us.this,MainActivity.class );
            startActivity(i);

        }

        if(id == R.id.contactUs)
        {
            Intent i = new Intent(contact_us.this,contact_us.class );
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


}
