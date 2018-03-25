package com.reactnativenavigation.utils;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;

import com.reactnativenavigation.params.StatusBarTextColorScheme;
import com.reactnativenavigation.params.StyleParams;


public class NavigationBar {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setColor(Window window, StyleParams.Color navigationBarColor) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP || window == null) return;
//        final Window window = ((NavigationActivity) activity).getScreenWindow();
        if (navigationBarColor.hasColor()) {
            window.setNavigationBarColor(navigationBarColor.getColor());
        } else {
            window.setNavigationBarColor(Color.BLACK);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    public static void setTextColorScheme(View view, StatusBarTextColorScheme textColorScheme) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return;
        if (StatusBarTextColorScheme.Dark.equals(textColorScheme)) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            view.setSystemUiVisibility(flags);
        } else {
            int flags = view.getSystemUiVisibility();
            flags &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            view.setSystemUiVisibility(flags);
        }
    }
}
