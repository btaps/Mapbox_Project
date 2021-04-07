package com.example.mapbox_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

// Traffic imports
import com.mapbox.mapboxsdk.plugins.traffic.TrafficPlugin;

// Building imports
import com.mapbox.mapboxsdk.plugins.building.BuildingPlugin;

// Places imports
//import com.mapbox.mapboxsdk.plugins.places.autocomplete.PlaceAutocomplete;
//import com.mapbox.mapboxsdk.plugins.places.autocomplete.model.PlaceOptions;
//import com.mapbox.api.geocoding.v5.models.CarmenFeature;


import java.util.ArrayList;
import java.util.List;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;


/**
 * Display {@link SymbolLayer} icons on the map.
 */
public class MainActivity extends AppCompatActivity implements
        OnMapReadyCallback {

    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    private static final String SOURCE_ID = "SOURCE_ID";
    private static final String ICON_ID = "ICON_ID";
    private static final String LAYER_ID = "LAYER_ID";
    private MapView mapView;
    private MapboxMap mapboxMap;
    private MapboxMap map;
    private TrafficPlugin trafficPlugin;
    private BuildingPlugin buildingPlugin;
//    private CarmenFeature home;
//    private CarmenFeature work;
    private String geojsonSourceLayerId = "geojsonSourceLayerId";
    private String symbolIconId = "symbolIconId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));

        // This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_main);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        /*
        * Uncomment lines 88-115 to initilize live Traffic and 3D Buildings
        */

//        mapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(final MapboxMap mapboxMap) {
//                map = mapboxMap;
//                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
//                    @Override
//                    public void onStyleLoaded(@NonNull Style style) {
//                        buildingPlugin = new BuildingPlugin(mapView, map, style);
//                        buildingPlugin.setMinZoomLevel(15f);
//                        buildingPlugin.setVisibility(true);
//
//                        trafficPlugin = new TrafficPlugin(mapView, mapboxMap, style);
//
//                        // Enable the traffic view by default
//                        trafficPlugin.setVisibility(true);
//
//                        findViewById(R.id.traffic_toggle_fab).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (map != null) {
//                                    trafficPlugin.setVisibility(!trafficPlugin.isVisible());
//                                }
//                            }
//                        });
//                    }
//                });
//            }
//        });


    }







    /*
     * Comment out lines 235 - 276. Uncomment lines 35-37, 64-65, 132 - 231 & line 50 in build.gradle (:app) to initilize Places Plugin,
     * NOTE: APP CRASHES.
     * App crashes upon moving from inital location. Seems to be a issue ONLY when places implementation is installed
     */

//    @Override
//    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
//        this.mapboxMap = mapboxMap;
//        mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
//            @Override
//            public void onStyleLoaded(@NonNull Style style) {
//                initSearchFab();
//
//                addUserLocations();
//
//                // Add the symbol layer icon to map for future use
//                style.addImage(symbolIconId, BitmapFactory.decodeResource(
//                        MainActivity.this.getResources(), R.drawable.mapbox_marker_icon_default));
//
//                // Create an empty GeoJSON source using the empty feature collection
//                setUpSource(style);
//
//                // Set up a new symbol layer for displaying the searched location's feature coordinates
//                setupLayer(style);
//
//            }
//        });
//    }
//
//    private void initSearchFab() {
//        findViewById(R.id.fab_location_search).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new PlaceAutocomplete.IntentBuilder()
//                        .accessToken(Mapbox.getAccessToken() != null ? Mapbox.getAccessToken() : getString(R.string.mapbox_access_token))
//                        .placeOptions(PlaceOptions.builder()
//                                .backgroundColor(Color.parseColor("#EEEEEE"))
//                                .limit(10)
//                                .addInjectedFeature(home)
//                                .addInjectedFeature(work)
//                                .build(PlaceOptions.MODE_CARDS))
//                        .build(MainActivity.this);
//                startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
//            }
//        });
//    }
//
//    private void addUserLocations() {
//        home = CarmenFeature.builder().text("Mapbox SF Office")
//                .geometry(Point.fromLngLat(-122.3964485, 37.7912561))
//                .placeName("50 Beale St, San Francisco, CA")
//                .id("mapbox-sf")
//                .properties(new JsonObject())
//                .build();
//
//        work = CarmenFeature.builder().text("Mapbox DC Office")
//                .placeName("740 15th Street NW, Washington DC")
//                .geometry(Point.fromLngLat(-77.0338348, 38.899750))
//                .id("mapbox-dc")
//                .properties(new JsonObject())
//                .build();
//    }
//
//    private void setUpSource(@NonNull Style loadedMapStyle) {
//        loadedMapStyle.addSource(new GeoJsonSource(geojsonSourceLayerId));
//    }
//
//    private void setupLayer(@NonNull Style loadedMapStyle) {
//        loadedMapStyle.addLayer(new SymbolLayer("SYMBOL_LAYER_ID", geojsonSourceLayerId).withProperties(
//                iconImage(symbolIconId),
//                iconOffset(new Float[] {0f, -8f})
//        ));
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_AUTOCOMPLETE) {
//
//            // Retrieve selected location's CarmenFeature
//            CarmenFeature selectedCarmenFeature = PlaceAutocomplete.getPlace(data);
//
//            // Create a new FeatureCollection and add a new Feature to it using selectedCarmenFeature above.
//            // Then retrieve and update the source designated for showing a selected location's symbol layer icon
//
//            if (mapboxMap != null) {
//                Style style = mapboxMap.getStyle();
//                if (style != null) {
//                    GeoJsonSource source = style.getSourceAs(geojsonSourceLayerId);
//                    if (source != null) {
//                        source.setGeoJson(FeatureCollection.fromFeatures(
//                                new Feature[] {Feature.fromJson(selectedCarmenFeature.toJson())}));
//                    }
//
//                    // Move map camera to the selected location
//                    mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(
//                            new CameraPosition.Builder()
//                                    .target(new LatLng(((Point) selectedCarmenFeature.geometry()).latitude(),
//                                            ((Point) selectedCarmenFeature.geometry()).longitude()))
//                                    .zoom(14)
//                                    .build()), 4000);
//                }
//            }
//        }
//    }


//    // Setting up 3 markers in starting location (Uruguay)
    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        List<Feature> symbolLayerIconFeatureList = new ArrayList<>();
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(-57.225365, -33.213144)));
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(-54.14164, -33.981818)));
        symbolLayerIconFeatureList.add(Feature.fromGeometry(

                Point.fromLngLat(-56.990533, -30.583266)));

        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/mapbox/dark-v9")

                // Add the SymbolLayer icon image to the map style
                .withImage(ICON_ID, BitmapFactory.decodeResource(
                        MainActivity.this.getResources(), R.drawable.mapbox_marker_icon_default))

                // Adding a GeoJson source for the SymbolLayer icons.
                .withSource(new GeoJsonSource(SOURCE_ID,
                        FeatureCollection.fromFeatures(symbolLayerIconFeatureList)))

                // Adding the actual SymbolLayer to the map style. An offset is added that the bottom of the red
                // marker icon gets fixed to the coordinate, rather than the middle of the icon being fixed to
                // the coordinate point. This is offset is not always needed and is dependent on the image
                // that you use for the SymbolLayer icon.
                .withLayer(new SymbolLayer(LAYER_ID, SOURCE_ID)
                        .withProperties(
                                iconImage(ICON_ID),
                                iconAllowOverlap(true),
                                iconIgnorePlacement(true)
                        )
                ), new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

                // Map is set up and the style has loaded. Now you can add additional data or make other map adjustments.


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
