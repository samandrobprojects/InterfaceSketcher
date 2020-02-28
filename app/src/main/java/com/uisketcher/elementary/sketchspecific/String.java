package com.uisketcher.elementary.sketchspecific;

import android.support.v4.content.ContextCompat;

import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class String {
    private final int _stringResourceID;

    private String(int stringResourceID) {
        _stringResourceID = stringResourceID;
    }

    public static String stringWithAndroidStringResourceID(int stringResourceID) {
        return new String(stringResourceID);
    }

    public java.lang.String getAndroidStringWithSketchingContext(UISketchingContext sketchingContext) {
        return sketchingContext.getAndroidContext().getResources().getString(_stringResourceID);
    }
}
