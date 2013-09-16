package com.example.touchablemapdemo.utils;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class BoundingBox {

    private GoogleMap mMap;

    public BoundingBox(final GoogleMap map) {
        mMap = map;
    }

    public LatLng getNorthEast() {
        final LatLngBounds bounds = getLatLngBounds();
        return bounds.northeast;
    }

    public LatLng getNorthWest() {
        final LatLngBounds bounds = getLatLngBounds();
        return new LatLng(bounds.northeast.latitude, bounds.southwest.longitude);
    }

    public LatLng getSouthEast() {
        final LatLngBounds bounds = getLatLngBounds();
        return new LatLng(bounds.southwest.latitude, bounds.northeast.longitude);
    }

    public LatLng getSouthWest() {
        final LatLngBounds bounds = getLatLngBounds();
        return bounds.southwest;
    }

    private LatLngBounds getLatLngBounds() {
        return mMap.getProjection().getVisibleRegion().latLngBounds;
    }

}
