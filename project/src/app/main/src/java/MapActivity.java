package com.example.simeon.najdiparking;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Agromehanika = new LatLng(41.9973, 21.4280);
        mMap.addMarker(new MarkerOptions().position(Agromehanika).title("Agromehanika"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Agromehanika));
        LatLng DameGruev1 = new LatLng(41.993550, 21.427606);
        mMap.addMarker(new MarkerOptions().position(DameGruev1).title("DameGruev1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DameGruev1));
        LatLng DameGruev2 = new LatLng(41.992298, 21.432685);
        mMap.addMarker(new MarkerOptions().position(DameGruev2).title("DameGruev2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DameGruev2));
        LatLng OrceNikolov = new LatLng(41.998597, 21.427535);
        mMap.addMarker(new MarkerOptions().position(OrceNikolov).title("OrceNikolov"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(OrceNikolov));
        LatLng MaksimGorki = new LatLng(41.996065, 21.428905);
        mMap.addMarker(new MarkerOptions().position(MaksimGorki).title("MaksimGorki"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MaksimGorki));
        LatLng KamenMost = new LatLng(41.998059, 21.434672);
        mMap.addMarker(new MarkerOptions().position(KamenMost).title("KamenMost"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(KamenMost));
        LatLng Bristol = new LatLng(41.991683,21.428617 );
        mMap.addMarker(new MarkerOptions().position(Bristol).title("Bristol1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bristol));
        LatLng Bristol2 = new LatLng(41.991089, 21.430167);
        mMap.addMarker(new MarkerOptions().position(Bristol2).title("Bristol2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bristol2));
        LatLng JosipBroz = new LatLng(41.995356, 21.426030);
        mMap.addMarker(new MarkerOptions().position(JosipBroz).title("JosipBroz"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(JosipBroz));
        LatLng Ilinden = new LatLng(41.990041, 21.436823);
        mMap.addMarker(new MarkerOptions().position(Ilinden).title("Ilinden"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Ilinden));
        LatLng DebarMaalo1 = new LatLng(41.995991, 21.423019);
        mMap.addMarker(new MarkerOptions().position(DebarMaalo1).title("DebarMaalo1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DebarMaalo1));
        LatLng DebarMaalo2 = new LatLng(41.996846, 21.423034);
        mMap.addMarker(new MarkerOptions().position(DebarMaalo2).title("DebarMaalo2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(DebarMaalo2));
        LatLng OrceNikolov2 = new LatLng(42.003325, 21.416986);
        mMap.addMarker(new MarkerOptions().position(OrceNikolov2).title("OrceNikolov2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(OrceNikolov2));
        LatLng Univerzalna = new LatLng(41.998688, 21.417122);
        mMap.addMarker(new MarkerOptions().position(Univerzalna).title("Univerzalna"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Univerzalna));
        LatLng Zooloska = new LatLng(42.006805, 21.417396);
        mMap.addMarker(new MarkerOptions().position(Zooloska).title("Zooloska"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Zooloska));
        LatLng TCBISER = new LatLng(41.984996, 21.465679);
        mMap.addMarker(new MarkerOptions().position(TCBISER).title("TCBISER"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TCBISER));
        LatLng Vero = new LatLng(41.985137, 21.468004);
        mMap.addMarker(new MarkerOptions().position(Vero).title("Vero"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Vero));
        LatLng VladimirKomarov = new LatLng(41.989850, 21.451758);
        mMap.addMarker(new MarkerOptions().position(VladimirKomarov).title("VladimirKomarov"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(VladimirKomarov));
        LatLng PalmaAerodrom = new LatLng(41.988766, 21.452241);
        mMap.addMarker(new MarkerOptions().position(PalmaAerodrom).title("PalmaAerodrom"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(PalmaAerodrom));
        LatLng HotelRusija = new LatLng(41.992894, 21.465418);
        mMap.addMarker(new MarkerOptions().position(HotelRusija).title("HotelRusija"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(HotelRusija));
    }

}
