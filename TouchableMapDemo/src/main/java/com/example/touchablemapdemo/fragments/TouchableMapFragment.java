package com.example.touchablemapdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.touchablemapdemo.layouts.TouchableFrameLayout;
import com.google.android.gms.maps.SupportMapFragment;

public class TouchableMapFragment extends SupportMapFragment {

    private View mOriginalContentView;

    public TouchableMapFragment() {
        mOriginalContentView = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mOriginalContentView = super.onCreateView(inflater, container, savedInstanceState);
        TouchableFrameLayout frameLayout = new TouchableFrameLayout(getActivity());
        frameLayout.addView(mOriginalContentView);
        return frameLayout;
    }

    @Override
    public View getView() {
        return mOriginalContentView;
    }

}
