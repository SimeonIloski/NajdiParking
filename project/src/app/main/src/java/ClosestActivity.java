package com.example.simeon.najdiparking;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.security.Permission;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class ClosestActivity extends AppCompatActivity {
    double longt = 0;
    double lat = 0;
    ArrayAdapter<Parkings> adapter;
    FusedLocationProviderClient client;
    ArrayList<Parking> parkingArrayList;
    ArrayList<Parkings> closestList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView2 = (ListView) findViewById(R.id.listView2);
        parkingArrayList=getIntent().getParcelableArrayListExtra("ParkingArrayList");
        client = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    longt=location.getLongitude();
                    lat=location.getLatitude();
                }
            }
        });

        Location myLoc=new Location("");
        if(longt!=0 && lat!=0) {
            myLoc.setLatitude(lat);
            myLoc.setLongitude(longt);
        }
        else{
            myLoc.setLatitude(42.0041);
            myLoc.setLongitude(21.4095);
        }
        closestList=new ArrayList<>();
        for(Parking p:parkingArrayList){
            Location l1=new Location(myLoc);
            l1.setLongitude(p.getLongtidue());
            l1.setLatitude(p.getLatitude());
            double d= (double) myLoc.distanceTo(l1);
            closestList.add(new Parkings(p,d));
        }
        Collections.sort(closestList);
        adapter=new ArrayAdapter<Parkings>(getApplicationContext(),android.R.layout.simple_list_item_1,closestList);
        listView2.setAdapter(adapter);
    }

}







