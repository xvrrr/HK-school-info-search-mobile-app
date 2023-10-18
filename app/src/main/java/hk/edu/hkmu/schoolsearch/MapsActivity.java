package hk.edu.hkmu.schoolsearch;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

import hk.edu.hkmu.schoolsearch.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Intent intent = getIntent();
        String position = intent.getStringExtra(InputActivity.Position);
        int position1 = Integer.parseInt(position);
        HashMap<String, String> school = SchoolInfo.schoolList.get(position1);
        double LONG = Double.parseDouble(school.get(SchoolInfo.LONGITUDE));
        double LAT = Double.parseDouble(school.get(SchoolInfo.LATITUDE));


        mMap = googleMap;

        // Add a marker
        LatLng schoolGEO = new LatLng(LAT, LONG);
        mMap.addMarker(new MarkerOptions().position(schoolGEO).title(school.get(SchoolInfo.NAME)));
        //animate camera towards the school
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(schoolGEO,18),5000, null);
    }
}