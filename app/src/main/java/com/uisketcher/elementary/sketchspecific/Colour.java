package com.uisketcher.elementary.sketchspecific;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class Colour {
    private enum ColourUnit {
        INTERNAL_ANDROID_COLOUR_INTEGER,
        ANDROID_COLOUR_RESOURCE_ID
    }

    private final int _baseColourValue;
    private final Colour.ColourUnit _baseColourUnit;

    private Colour(ColourUnit baseColourUnit, int baseColourValue) {
        _baseColourUnit = baseColourUnit;
        _baseColourValue = baseColourValue;
    }

    public static final Colour RED = new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.RED);
    public static final Colour GREEN = new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.GREEN);
    public static final Colour BLACK = new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.BLACK);
    public static final Colour WHITE = new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.WHITE);
    public static final Colour BLUE = new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.BLUE);
    public static final Colour MAGENTA = new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.MAGENTA);

    public static Colour colourWith0To255RedGreenBlueAlpha(int red, int green, int blue, int alpha) {
        return new Colour(ColourUnit.INTERNAL_ANDROID_COLOUR_INTEGER, Color.argb(alpha, red, green, blue));
    }

    public static Colour colourWithAndroidColourResourceID(int androidColourResourceID) {
        return new Colour(ColourUnit.ANDROID_COLOUR_RESOURCE_ID, androidColourResourceID);
    }

    public int getAndroidColourIntegerWithSketchingContext(UISketchingContext sketchingContext) {
        if (_baseColourUnit == ColourUnit.ANDROID_COLOUR_RESOURCE_ID) {
            return ContextCompat.getColor(sketchingContext.getAndroidContext(), _baseColourValue);
        } else {
            return _baseColourValue;
        }
    }
}
