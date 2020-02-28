package com.uisketcher;

import android.view.View;

/**
 * Created by swhitton on 28/2/20.
 */

public interface UISketchingAction {
    public void doActionOnAndroidViewRepresentationWithSketchingContext(View androidViewRepresentation, UISketchingContext sketchingContext);
}