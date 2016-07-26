package com.utils;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.datacrawler.AppsUtils;
import com.datacrawler.GeneralProperties;
import com.datacrawler.LocationObserver;
import com.datacrawler.NetworkStats;
import com.datacrawler.PhoneContactsUtils;
import com.datacrawler.callbacks.LocationUpdate;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<AppsUtils.AppInfo> phoneApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* AppsUtils phoneAppUtils = new AppsUtils();
        phoneAppUtils.getPackages(this);*/

       /* PhoneContactsUtils phoneContactsUtils = new PhoneContactsUtils();
        phoneContactsUtils.getContacts(this);*/

        /*GeneralProperties generalProperties = new GeneralProperties();
        Log.e("LOGGER", generalProperties.getGeneralProperties().toString());*/


        /*LocationObserver locationObserver = new LocationObserver(MainActivity.this);
        locationObserver.tryToGetLocation();
        locationObserver.locationUpdate = new LocationUpdate() {
            @Override
            public void onLocationUpdate(Location location) {
                Log.e("LOGGER","Location changed "+location.getLatitude()+","+location.getLongitude());
            }
        };*/

        NetworkStats networkStats = new NetworkStats();
        networkStats.getPakagesInfoUsingHashMap(this);

    }
}
