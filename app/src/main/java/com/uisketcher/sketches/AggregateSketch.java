package com.uisketcher.sketches;

import android.view.View;
import android.widget.RelativeLayout;

import com.uisketcher.UISketch;
import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class AggregateSketch extends UISketch {

    public class PositioningRules {

    }

    private AggregateSketch() {
    }

    public static AggregateSketch newAggregateSketch() {
        return new AggregateSketch();
    }

    public void addSketchOnTopWithPositioningRules(UISketch sketchToAdd, PositioningRules positioningRulesInQuestion) {

    }

    @Override
    public View _createBaseAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext) {
        RelativeLayout relativeLayoutRepresentation = new RelativeLayout(sketchingContext.getAndroidContext());
        relativeLayoutRepresentation.setMinimumHeight(0);
        relativeLayoutRepresentation.setMinimumWidth(0);
        return relativeLayoutRepresentation;
    }
}
