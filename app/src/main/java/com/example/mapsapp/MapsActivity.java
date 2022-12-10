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
        LatLng coep = new LatLng(18.528161758804586, 73.85266788568693);
        MarkerOptions option = new MarkerOptions().position(coep).title("COEP Ground");
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(option);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(coep));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coep, 16f));
        Button ground1Btn = findViewById(R.id.grd1);
        Button ground2Btn = findViewById(R.id.grd2);
        Button ground3Btn = findViewById(R.id.grd3);
        getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground1_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
        ground1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground1_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
        ground2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground2_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
        ground3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Flfrag, Ground3_frag.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
    }
}