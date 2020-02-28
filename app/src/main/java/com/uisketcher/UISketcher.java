package com.uisketcher;

import android.content.Context;
import android.view.View;

/**
 * Created by swhitton on 28/2/20.
 */

public class UISketcher {

    public static UISketcher newSketcherWithAndroidContext(Context androidContext) {
        return new UISketcher(androidContext);
    }

    private final Context _androidApplicationContext;

    private UISketcher(Context androidContext) {
        _androidApplicationContext = androidContext.getApplicationContext();
    }

    public View drawTangibleAndroidViewFromSketch(UISketch sketchInQuestion) {
        UISketchingContext sketchingContext = this._getSketchingContext();
        View tangibleAndroidViewDrawFromSketchInQuestion = sketchInQuestion.drawTangibleAndroidViewRepresentationOfSketchWithSketchingContext(sketchingContext);
        return tangibleAndroidViewDrawFromSketchInQuestion;
    }

    private UISketchingContext _getSketchingContext() {
        return new UISketchingContext() {
            @Override
            public Context getAndroidContext() {
                return _androidApplicationContext;
            }
        };
    }
}
