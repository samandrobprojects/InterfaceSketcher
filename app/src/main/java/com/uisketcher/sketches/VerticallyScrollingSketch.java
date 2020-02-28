package com.uisketcher.sketches;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.uisketcher.UISketch;
import com.uisketcher.UISketchingContext;

/**
 * Created by swhitton on 28/2/20.
 */

public class VerticallyScrollingSketch extends UISketch {

    private final UISketch _sketchToScroll;
    private VerticallyScrollingSketch(UISketch sketchToScroll) {
        _sketchToScroll = sketchToScroll;
    }

    public static VerticallyScrollingSketch newVerticallyScrollingSketchByScrollingGivenSketch(UISketch givenSketchToScroll) {
        return new VerticallyScrollingSketch(givenSketchToScroll);
    }


    @Override
    public View _createBaseAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext) {
        ScrollView scrollViewRepresentation = new ScrollView(sketchingContext.getAndroidContext());
        View viewToScroll = _sketchToScroll.drawTangibleAndroidViewRepresentationOfSketchWithSketchingContext(sketchingContext);
        scrollViewRepresentation.addView(viewToScroll, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        return scrollViewRepresentation;
    }
}
