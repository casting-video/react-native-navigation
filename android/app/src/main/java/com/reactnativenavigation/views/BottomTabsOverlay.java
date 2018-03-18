package com.reactnativenavigation.views;

import android.content.Context;
import android.os.Build;

import com.reactnativenavigation.animation.VisibilityAnimator;
import com.reactnativenavigation.params.NavigationParams;
import com.reactnativenavigation.views.utils.Constants;

public class BottomTabsOverlay extends ContentView {

    private VisibilityAnimator visibilityAnimator;

    public BottomTabsOverlay(Context context, String screenId, NavigationParams navigationParams) {
        super(context, screenId, navigationParams);
        createVisibilityAnimator();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(100);
        }
    }

    public void setVisibility(boolean hidden, boolean animated) {
        if (visibilityAnimator != null) {
            visibilityAnimator.setVisible(!hidden, animated, null);
        } else {
            setVisibility(hidden);
        }
    }

    private void setVisibility(boolean bottomTabsHidden) {
        setVisibility(bottomTabsHidden ? GONE : VISIBLE);
    }

    private void createVisibilityAnimator() {
        visibilityAnimator = new VisibilityAnimator(this,
            VisibilityAnimator.HideDirection.Down,
            Constants.BOTTOM_TABS_HEIGHT);
    }
}
