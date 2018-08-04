package com.example.helloiitg;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.gt.helloiitg.R;

public class Menu extends Activity implements OnClickListener {

    Button CampusMap, BusTiming, Taxi, InternetSettings, Contact, Webmail, Places, TimeTable;
    DisplayMetrics dm;
    int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        switch (getResources().getConfiguration().orientation) {
            case 2:
                setContentView(R.layout.menu_land);
                width = dm.widthPixels / 3;
                initialize();
                break;
            default:
                setContentView(R.layout.menu);
                width = dm.widthPixels / 2;
                initialize();
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.menu);
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            width = dm.widthPixels / 2;
            initialize();
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.menu_land);
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            width = dm.widthPixels / 3;
            initialize();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.about) {
            Intent k = new Intent("com.helloiitg.about");
            startActivity(k);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initialize() {
        // TODO Auto-generated method stub
        CampusMap = (Button) findViewById(R.id.bMap);
        CampusMap.setWidth(width);
        CampusMap.setPadding(0, 5, 0, 5);
        CampusMap.setOnClickListener(this);

        BusTiming = (Button) findViewById(R.id.bBusTiming);
        BusTiming.setWidth(width);
        BusTiming.setPadding(0, 5, 0, 5);
        BusTiming.setOnClickListener(this);

        Taxi = (Button) findViewById(R.id.bTaxi);
        Taxi.setWidth(width);
        Taxi.setPadding(0, 5, 0, 5);
        Taxi.setOnClickListener(this);

        InternetSettings = (Button) findViewById(R.id.bInternetSettings);
        InternetSettings.setWidth(width);
        InternetSettings.setPadding(0, 5, 0, 5);
        InternetSettings.setOnClickListener(this);

        Contact = (Button) findViewById(R.id.bContact);
        Contact.setWidth(width);
        Contact.setPadding(0, 5, 0, 5);
        Contact.setOnClickListener(this);

        Webmail = (Button) findViewById(R.id.bWebmail);
        Webmail.setWidth(width);
        Webmail.setPadding(0, 5, 0, 5);
        Webmail.setOnClickListener(this);

        Places = (Button) findViewById(R.id.bPlaces);
        Places.setWidth(width);
        Places.setPadding(0, 5, 0, 5);
        Places.setOnClickListener(this);

        TimeTable = (Button) findViewById(R.id.bTimeTable);
        TimeTable.setWidth(width);
        TimeTable.setPadding(0, 5, 0, 5);
        TimeTable.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.bMap:
                openIntent("campusmap");
                break;

            case R.id.bBusTiming:
//                Intent intent = getPackageManager().getLaunchIntentForPackage(
//                        "com.kadtech.xlab.bustiming");
//                if (intent != null) {
//                    startActivity(intent);
//                } else {
//                    intent = new Intent(Intent.ACTION_VIEW);
//                    // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.setData(Uri.parse("market://details?id="
//                            + "com.kadtech.xlab.bustiming"));
//                    startActivity(intent);
//                }
                openIntent("bustimings");
                break;

            case R.id.bTaxi:
                openIntent("taxi");
                break;
            case R.id.bInternetSettings:
                openIntent("internetsettings");
                break;
            case R.id.bContact:
                openIntent("contactdetails");
                break;
            case R.id.bWebmail:
                openIntent("webmail");
                break;
            case R.id.bPlaces:
                openIntent("places");
                break;
            case R.id.bTimeTable:
                //Toast.makeText(getApplicationContext(), "Undergoing changes, will be available soon",Toast.LENGTH_LONG).show();
                openIntent("timetable");
                break;
        }
    }

    private void openIntent(String classname) {
        // TODO Auto-generated method stub
        Intent i = new Intent("com.helloiitg." + classname);
        startActivity(i);
    }
}
