package com.uisketcher.elementary.sketchspecific;

import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class EdgePadding {

    private final DiscreteMetric _topEdgeDistance;
    private final DiscreteMetric _rightEdgeDistance;
    private final DiscreteMetric _leftEdgeDistance;
    private final DiscreteMetric _bottomEdgeDistance;

    public static EdgePadding edgePaddingWithDistanceFromLeftTopRightBottom(DiscreteMetric leftEdgeDistance, DiscreteMetric topEdgeDistance, DiscreteMetric rightEdgeDistance, DiscreteMetric bottomEdgeDistance) {
        return new EdgePadding(leftEdgeDistance, topEdgeDistance, rightEdgeDistance, bottomEdgeDistance);
    }

    private EdgePadding(DiscreteMetric leftEdgeDistance, DiscreteMetric topEdgeDistance, DiscreteMetric rightEdgeDistance, DiscreteMetric bottomEdgeDistance) {
        _leftEdgeDistance = leftEdgeDistance;
        _topEdgeDistance = topEdgeDistance;
        _rightEdgeDistance = rightEdgeDistance;
        _bottomEdgeDistance = bottomEdgeDistance;
    }

    public void applyEdgePaddingAsMarginOfAndroidLayoutParamsWithSketchingContext(ViewGroup.MarginLayoutParams givenLayoutParams, UISketchingContext sketchingContext) {
        givenLayoutParams.setMargins(
                (int)_leftEdgeDistance.getMetricInPixelsWithSketchingContext(sketchingContext),
                (int)_topEdgeDistance.getMetricInPixelsWithSketchingContext(sketchingContext),
                (int)_rightEdgeDistance.getMetricInPixelsWithSketchingContext(sketchingContext),
                (int)_bottomEdgeDistance.getMetricInPixelsWithSketchingContext(sketchingContext)
                );
    }


}
