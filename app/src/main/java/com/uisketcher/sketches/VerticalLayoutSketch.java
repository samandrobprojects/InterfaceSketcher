package com.uisketcher.sketches;

import android.view.View;
import android.widget.LinearLayout;

import com.uisketcher.UISketch;
import com.uisketcher.UISketchingAction;
import com.uisketcher.UISketchingContext;
import com.uisketcher.elementary.sketchspecific.EdgePadding;

/**
 * Created by swhitton on 28/2/20.
 */

public class VerticalLayoutSketch extends UISketch {

    private VerticalLayoutSketch() {}

    public static VerticalLayoutSketch newVerticalLayoutSketch() {
        return new VerticalLayoutSketch();
    }

    public void addSketchToNextPositionInLayoutWithEdgePadding(final UISketch sketchToAdd, final EdgePadding givenEdgePadding) {
        this.performSketchingAction(new UISketchingAction() {
            @Override
            public void doActionOnAndroidViewRepresentationWithSketchingContext(View androidViewRepresentation, UISketchingContext sketchingContext) {
                View androidViewRepresentingSketchToAdd = sketchToAdd.drawTangibleAndroidViewRepresentationOfSketchWithSketchingContext(sketchingContext);
                LinearLayout.LayoutParams layoutParamsForListItem = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                givenEdgePadding.applyEdgePaddingAsMarginOfAndroidLayoutParamsWithSketchingContext(layoutParamsForListItem, sketchingContext);
                androidViewRepresentingSketchToAdd.setLayoutParams(layoutParamsForListItem);
                androidViewRepresentingSketchToAdd.requestLayout();
                ((LinearLayout)androidViewRepresentation).addView(androidViewRepresentingSketchToAdd);
            }
        });
    }

    @Override
    public View _createBaseAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext) {
        LinearLayout linearLayoutRepresentation = new LinearLayout(sketchingContext.getAndroidContext());
        linearLayoutRepresentation.setOrientation(LinearLayout.VERTICAL);
        return linearLayoutRepresentation;
    }
}
