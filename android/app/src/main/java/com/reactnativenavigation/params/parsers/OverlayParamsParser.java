package com.reactnativenavigation.params.parsers;

import android.os.Bundle;

import com.reactnativenavigation.params.NavigationParams;
import com.reactnativenavigation.params.OverlayParams;

public class OverlayParamsParser extends Parser {
    private static final String KEY_SCREEN = "screenId";
    private static final String KEY_NAVIGATION_PARAMS = "navigationParams";

    public static OverlayParams parse(Bundle params) {
        OverlayParams result = new OverlayParams();

        assertKeyExists(params, KEY_SCREEN);
        result.screenId = params.getString(KEY_SCREEN);
        assertKeyExists(params, KEY_NAVIGATION_PARAMS);
        result.navigationParams = new NavigationParams(params.getBundle(KEY_NAVIGATION_PARAMS));

        return result;
    }
}
