package com.example.mapsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapsapp.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        LatLng coepGrd = new LatLng(18.528161758804586, 73.85266788568693);
        LatLng hostelGrd = new LatLng(18.52869724082493, 73.8512789054897);
        LatLng boatCLubGrd = new LatLng(18.53095384716651, 73.85630031454541);
        LatLng sppuGrd = new LatLng(18.558624856421375, 73.8225352766761);
        LatLng mainBuilding = new LatLng(18.52942970918503, 73.85651988785894);
        MarkerOptions optionCoepGrd = new MarkerOptions().position(coepGrd).title("COEP Ground");
        MarkerOptions optionHostelGrd = new MarkerOptions().position(hostelGrd).title("HostelGround");
        MarkerOptions optionBoatClubGrd = new MarkerOptions().position(boatCLubGrd).title("Boat Club");
        MarkerOptions optionSppuGrd = new MarkerOptions().position(sppuGrd).title("SPPU Ground");
        MarkerOptions optionMainBuilding = new MarkerOptions().position(mainBuilding).title("Main Building");
        mMap.addMarker(optionCoepGrd);
        mMap.addMarker(optionHostelGrd);
        mMap.addMarker(optionBoatClubGrd);
        mMap.addMarker(optionSppuGrd);
        mMap.addMarker(optionMainBuilding);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(boatCLubGrd));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(boatCLubGrd, 12f));
        Button ground1Btn = findViewById(R.id.grd1);
        Button ground2Btn = findViewById(R.id.grd2);
        Button ground3Btn = findViewById(R.id.grd3);
        Button ground4Btn = findViewById(R.id.grd4);
        Button ground5Btn = findViewById(R.id.grd5);
        getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground1_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
        ground1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground1_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                LatLng boatCLubGrd = new LatLng(18.53095384716651, 73.85630031454541);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(boatCLubGrd, 17f));
            }
        });
        ground2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground2_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                LatLng hostelGrd = new LatLng(18.52869724082493, 73.8512789054897);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(hostelGrd, 17f));

            }
        });
        ground3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground3_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                LatLng mainBuilding = new LatLng(18.52942970918503, 73.85651988785894);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mainBuilding, 17f));
            }
        });
        ground4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground4_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                LatLng coepGrd = new LatLng(18.528161758804586, 73.85266788568693);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coepGrd, 17f));
            }
        });
        ground5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground4_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                LatLng sppuGrd = new LatLng(18.558624856421375, 73.8225352766761);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sppuGrd, 17f));
            }
        });
    }
}