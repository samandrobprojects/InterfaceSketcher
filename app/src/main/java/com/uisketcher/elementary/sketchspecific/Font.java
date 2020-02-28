package com.uisketcher.elementary.sketchspecific;

import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;

import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class Font {
    private final Typeface _androidTypeface;
    private final int _androidTypefaceStyle;
    private final DiscreteMetric _fontSize;

    private Font(Typeface androidTypeface, int androidTypefaceStyle, final DiscreteMetric fontSize) {
        _androidTypeface = androidTypeface;
        _androidTypefaceStyle = androidTypefaceStyle;
        _fontSize = fontSize;
    }

    public static Font italicMonospacedSystemFontOfSize(DiscreteMetric fontSize) {
        return new Font(Typeface.MONOSPACE, Typeface.ITALIC, fontSize);
    }

    public static Font normalMonospacedSystemFontOfSize(DiscreteMetric fontSize) {
        return new Font(Typeface.MONOSPACE, Typeface.NORMAL, fontSize);
    }

    public static Font boldMonospacedSystemFontOfSize(DiscreteMetric fontSize) {
        return new Font(Typeface.MONOSPACE, Typeface.BOLD, fontSize);
    }

    public void applyThisFontToAndroidTextViewWithSketchingContext(TextView givenTextView, UISketchingContext sketchingContext) {
        givenTextView.setTypeface(_androidTypeface, _androidTypefaceStyle);
        givenTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, _fontSize.getMetricInPixelsWithSketchingContext(sketchingContext));
    }
}
