package com.example.touchablemapdemo.layouts;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchableFrameLayout extends FrameLayout {

    private long lastTouched = 0;
    private static final long SCROLL_TIME = 200L;
    private final OnChangeListener mOnChangeListener;

    public TouchableFrameLayout(Context context) {
        super(context);
        try {
            mOnChangeListener = (OnChangeListener) context;
        } catch (ClassCastException exception) {
            throw new ClassCastException(context.toString() + " must implement OnChangeListener");
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastTouched = SystemClock.uptimeMillis();
                break;
            case MotionEvent.ACTION_UP:
                final long now = SystemClock.uptimeMillis();
                if (now - lastTouched > SCROLL_TIME) {
                    if (mOnChangeListener != null) {
                        mOnChangeListener.onInteractionEnd();
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public interface OnChangeListener {
        public void onInteractionEnd();
    }

}
