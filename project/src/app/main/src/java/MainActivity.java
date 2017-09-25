package com.example.simeon.najdiparking;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import  java.util.*;

import java.util.ArrayList;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public  ArrayList<Parking> parkingArrayList = new ArrayList<Parking>();
    public final ArrayList<String> zones=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle savedState=saveState();
        if(savedInstanceState != null && savedState==null){
            savedState=savedInstanceState.getBundle("parkingArrayList");
        }
        if(savedState!=null){
            parkingArrayList=savedState.getParcelableArrayList("parkingArrayList");
        }
        else{
            parkingArrayList=new ArrayList<>();
        }
        savedState=null;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        databaseReference.child("Parking").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Parking p = dataSnapshot1.getValue(Parking.class);
                    parkingArrayList.add(p);
                    zones.add(p.zone);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView) findViewById(R.id.listview);
       Collections.sort(parkingArrayList);
        Collections.reverse(parkingArrayList);
        ArrayAdapter<Parking> adapter = new ArrayAdapter<Parking>(this, android.R.layout.simple_list_item_1, parkingArrayList);
        listView.setAdapter(adapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

   @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
            else{
                finish();
                System.exit(0);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent=new Intent(this,ActivitySettings.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.closest) {
            Intent intent = new Intent(this, ClosestActivity.class);
            intent.putParcelableArrayListExtra("ParkingArrayList", parkingArrayList);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.map) {
            Intent intent = new Intent(this, MapActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_galery) {
            Intent intent=new Intent(this,GalleryActivity.class);
            startActivity(intent);
        } else if (id == R.id.pay) {
            Intent intent = new Intent(this, PayActivity.class);
            intent.putExtra("zones",zones);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "https://github.com/SimeonIloski/NajdiParking");
            startActivity(Intent.createChooser(intent, "Share"));
        } else if (id == R.id.nav_rate) {
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




   /* void filllist() only used metod for try the app before connecting with firebase/{
        parkingArrayList.add(new Parking("Агромеханика", "A1", "бул.ВМРО", 29, 41.9973, 21.4280));
        parkingArrayList.add(new Parking("Даме Груев 1", "A3", "ул. Даме Груев- пред полициска станица Беко", 53, 41.993550, 21.427606));
        parkingArrayList.add(new Parking("Даме Груев 2", "A4", "ул. Даме Груев- Позади собрание", 86, 41.992298, 21.432685));
        parkingArrayList.add(new Parking("Орце Николов", "A5", "ул. Даме Груев", 40, 41.998597, 21.427535));
        parkingArrayList.add(new Parking("Максим Гроки", "A6", "ул. Максим Горки, 27ми Март, 8-ма Ударна бригада и Скопска", 89, 41.996065, 21.428905));
        parkingArrayList.add(new Parking("Камен Мост", "A8", "Црвена Скопска Општина\" (Маршал Тито)", 151, 41.998059, 21.434672));
        parkingArrayList.add(new Parking("Бристол", "B2", "\"Мито ХаџиВасилев Јасмин\" по ново Св. \"Кирил и Методиј\"", 57, 41.991683, 21.428617));
        parkingArrayList.add(new Parking("Бристол 2", "B3", "\"Мито ХаџиВасилев Јасмин\" по ново Св. \"Кирил и Методиј\"", 46, 41.991089, 21.430167));
        parkingArrayList.add(new Parking("Јосип Броз", "B6", " ул. \"Димитрие Чуповски\"", 26, 41.995356, 21.426030));
        parkingArrayList.add(new Parking("Илинден", "B7", " ул. Стив Наумов", 77, 41.990041, 21.436823));
        parkingArrayList.add(new Parking("Дебар Маало", "C8", "ул. \"Коста Шахов\"", 7, 41.995991, 21.423019));
        parkingArrayList.add(new Parking("Дебар Маало2", "C9", " ул. \"Дебарска\" ул. \"Никола Тримпаре\"", 28, 41.996846, 21.423034));
        parkingArrayList.add(new Parking("Орце Николов", "C11", " ул. \"Орце Николов\" (на потегот од Св. Климент Охридски до ул. \"Франклин Рузвелт\" (Дебар Маало)", 112, 42.003325, 21.416986));
        parkingArrayList.add(new Parking("Универзална Сала", "C19", "ул. \"29 – ти Ноември\" по ново \"Костурски херои\"", 26, 41.998688, 21.417122));
        parkingArrayList.add(new Parking("Зоолошка", "C80", "Булевар \"Илинден\" ", 104, 42.006805, 21.417396));
        parkingArrayList.add(new Parking("Т.Ц.Бисер", "D3", " Населба Аеродром (Булевар \"Јане Сандански\")", 1358, 41.984996, 21.465679));
        parkingArrayList.add(new Parking("Веро", "D4", " Населба Аеродром (Булевар \"Јане Сандански\")", 727, 41.985137, 21.468004));
        parkingArrayList.add(new Parking("Владимир Комаров", "D5", "ул.\"Владимир Комаров\"", 116, 41.989850, 21.451758));
        parkingArrayList.add(new Parking("Палма Аеродром", "D6", " ул. \"Владимир Комаров\"", 113, 41.988766, 21.452241));
        parkingArrayList.add(new Parking("Хотел Русија", "D1", " Бул. \"АСНОМ\"", 31, 41.992894, 21.465418));

    }*/
   @Override
   public void onStop(){
            super.onStop();
       saveState();
   }
    @Override
    public  void onResume(){
            super.onResume();
        }
    @Override
    public  void onPause(){
            super.onPause();
        saveState();
    }

        public Bundle saveState(){
            Bundle state=new Bundle();
            state.putParcelableArrayList("parkingArrayList",parkingArrayList);
            return  state;
        }
        @Override
        public void onSaveInstanceState(Bundle savedInstancesState){
            super.onSaveInstanceState(savedInstancesState);
            savedInstancesState.putParcelableArrayList("parkingArrayList",parkingArrayList);
        }
        @Override
        public void onRestoreInstanceState(Bundle savedInstanceState){
            super.onRestoreInstanceState(savedInstanceState);
            parkingArrayList=savedInstanceState.getParcelableArrayList("parkingArrayList");
        }
}
