package com.datacrawler;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.datacrawler.callbacks.LocationUpdate;
import com.google.android.gms.location.LocationRequest;

import java.util.Map;

import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import rx.Subscription;
import rx.functions.Action1;


/**
 * Created by soham on 23/7/16.
 */
public class LocationObserver {
    Context context;
    public LocationUpdate locationUpdate;
    Subscription subscription;
    public LocationObserver(Context context) {
        this.context = context;


    }


    public void tryToGetLocation() {
        LocationRequest request = LocationRequest.create() //standard GMS LocationRequest
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(1000);

        ReactiveLocationProvider locationProvider = new ReactiveLocationProvider(context);
        subscription = locationProvider.getUpdatedLocation(request)
                .subscribe(new Action1<Location>() {
                    @Override
                    public void call(Location location) {
                        Log.e("LOGGER", "LOCATION CHANGED");
                        locationUpdate.onLocationUpdate(location);
                    }
                });


    }
    public void stopUpdates() {
        if (subscription.isUnsubscribed()) {
            Log.e("LOGGER","ALREADY UNSUBSCRIBED");
        } else {
            subscription.unsubscribe();
        }
    }
}
