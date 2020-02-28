package com.uisketcher.elementary.sketchspecific;

import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class DiscreteMetric {

    private enum MetricUnit {
        PIXELS,
        PHYSICAL_SIZE
    }

    private final float _baseMetricValue;
    private final MetricUnit _baseMetricUnit;

    private DiscreteMetric(float baseMetricValue, MetricUnit baseMetricUnit) {
        _baseMetricUnit = baseMetricUnit;
        _baseMetricValue = baseMetricValue;
    }

    public static DiscreteMetric metricInPixels(float pixels) {
        return new DiscreteMetric(pixels, MetricUnit.PIXELS);
    }

    public static DiscreteMetric metricInPhysicalSize(float physicalSize) {
        return new DiscreteMetric(physicalSize, MetricUnit.PHYSICAL_SIZE);
    }

    public float getMetricInPixelsWithSketchingContext(UISketchingContext sketchingContext) {
        if (_baseMetricUnit == MetricUnit.PHYSICAL_SIZE) {
            DisplayMetrics displayMetrics = sketchingContext.getAndroidContext().getResources().getDisplayMetrics();
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float)_baseMetricValue, displayMetrics);
        } else {
            return _baseMetricValue;
        }
    }
}
