package com.example.hospitaltracker;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
    private GoogleMap mMap;
    MarkerOptions marker;
    LatLng centerlocation;
    Vector<MarkerOptions> markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.0,101);

        markerOptions = new Vector<>();


        markerOptions.add(new MarkerOptions().title("Hospital Putrajaya")
                .position(new LatLng(2.92931,101.67418))
                .snippet("Open")
        );



        markerOptions.add(new MarkerOptions().title("Kedah Medical Centra")
                .position(new LatLng(6.14961,100.36916))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Raja Permaisuri Bainun Hospital")
                .position(new LatLng(4.60486,101.09051))
                .snippet("Open")
        );


        markerOptions.add(new MarkerOptions().title("Hospital Pulau Pinang")
                .position(new LatLng(5.41581,100.31208))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Raub Hospital")
                .position(new LatLng(4.02328,101.75915))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Pekan Hospital")
                .position(new LatLng(3.67251,103.36315))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Tunku Fauziah Hospital")
                .position(new LatLng(6.45957,100.19368))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Jitra")
                .position(new LatLng(6.27981,100.41919))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Sultan Abdul Halim")
                .position(new LatLng(5.668783816109874,100.51626195362032))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Sultanah Bahiyah")
                .position(new LatLng(6.15795,100.40601))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Tunku Azizah")
                .position(new LatLng(3.17071,101.70303))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Pantai Hospital Laguna Merbok")
                .position(new LatLng(5.684813052911848,100.49422913129347))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Gua Musang")
                .position(new LatLng(4.859711992118417,101.95460294012736))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Raja Perempuan Zainab II Hospital, Kota Bharu")
                .position(new LatLng(46.12555498511225,102.24576564197703))
                .snippet("Open")
        );

        markerOptions.add(new MarkerOptions().title("Hospital Alor Gajah")
                .position(new LatLng(2.3956585874533705,102.20207027081571))
                .snippet("Open")
        );



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



        for (MarkerOptions mark: markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,8));
    }
    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms,200);
        }
    }

}
