package com.example.touchablemapdemo.debugging;

import com.example.touchablemapdemo.utils.BoundingBox;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;
import java.util.List;

public class GoogleMapsDebugger {

    protected GoogleMap mMap;
    private Polygon mBoundingBox;

    public GoogleMapsDebugger(final GoogleMap map) {
        mMap = map;
    }

    public void drawBoundingBox(int color) {
        if (mBoundingBox != null) {
            mBoundingBox.remove();
        }
        final PolygonOptions polygonOptions = new PolygonOptions()
                .addAll(getBoundingBoxPoints())
                .strokeColor(color);
        mBoundingBox = mMap.addPolygon(polygonOptions);
    }

    private List<LatLng> getBoundingBoxPoints() {
        final BoundingBox boundingBox = new BoundingBox(mMap);
        final List<LatLng> points = new ArrayList<LatLng>();
        points.add(boundingBox.getNorthWest());
        points.add(boundingBox.getSouthWest());
        points.add(boundingBox.getSouthEast());
        points.add(boundingBox.getNorthEast());
        return points;
    }

}
