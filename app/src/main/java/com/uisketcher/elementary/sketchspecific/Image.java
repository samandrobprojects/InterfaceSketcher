package com.uisketcher.elementary.sketchspecific;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class Image {
    private final int _drawableResourceID;

    private Image(int drawableResourceID) {
        _drawableResourceID = drawableResourceID;
    }

    public static Image imageWithAndroidDrawableResourceID(int drawableResourceID) {
        return new Image(drawableResourceID);
    }

    public Drawable getAndroidImageWithSketchingContext(UISketchingContext sketchingContext) {
        return ContextCompat.getDrawable(sketchingContext.getAndroidContext(), _drawableResourceID);
    }
}
