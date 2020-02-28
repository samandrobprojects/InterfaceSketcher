package com.uisketcher.sketches;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.uisketcher.UISketch;
import com.uisketcher.UISketchingContext;
import com.uisketcher.UISketchingAction;
import com.uisketcher.elementary.sketchspecific.Colour;
import com.uisketcher.elementary.sketchspecific.Font;
import com.uisketcher.elementary.sketchspecific.String;

/**
 * Created by swhitton on 28/2/20.
 */

public class TextLabelSketch extends UISketch {

    private TextLabelSketch() {}

    public static TextLabelSketch newTextLabelSketch() {
        return new TextLabelSketch();
    }

    @Override
    public View _createBaseAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext) {
        TextView textViewRepresentation = new TextView(sketchingContext.getAndroidContext());
        textViewRepresentation.setTextColor(Color.BLACK);
        textViewRepresentation.setGravity(Gravity.CENTER);
        textViewRepresentation.setText("");
        textViewRepresentation.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
        return textViewRepresentation;
    }

    public enum TextAlignment {
        CENTER_HORIZONTAL_AND_VERTICAL, LEFT, RIGHT, TOP_AND_CENTER_HORIZONTALLY, LEFT_AND_CENTER_VERTICALLY
    }

    public void setTextFont(final Font givenFont) {
        this.performSketchingAction(new UISketchingAction() {
            @Override
            public void doActionOnAndroidViewRepresentationWithSketchingContext(View androidViewRepresentation, UISketchingContext sketchingContext) {
                givenFont.applyThisFontToAndroidTextViewWithSketchingContext(((TextView)androidViewRepresentation), sketchingContext);
            }
        });
    }

    public void setTextColour(final Colour givenColour) {
        this.performSketchingAction(new UISketchingAction() {
            @Override
            public void doActionOnAndroidViewRepresentationWithSketchingContext(View androidViewRepresentation, UISketchingContext sketchingContext) {
                ((TextView)androidViewRepresentation).setTextColor(givenColour.getAndroidColourIntegerWithSketchingContext(sketchingContext));
            }
        });
    }

    public void setTextAlignment(final TextAlignment givenAlignment) {
        this.performSketchingAction(new UISketchingAction() {
            @Override
            public void doActionOnAndroidViewRepresentationWithSketchingContext(View androidViewRepresentation, UISketchingContext sketchingContext) {
                ((TextView)androidViewRepresentation).setGravity(_gravityFromTextAlignment(givenAlignment));
            }
        });
    }

    public void setTextString(final String givenTextString) {
        this.performSketchingAction(new UISketchingAction() {
            @Override
            public void doActionOnAndroidViewRepresentationWithSketchingContext(View androidViewRepresentation, UISketchingContext sketchingContext) {
                ((TextView)androidViewRepresentation).setText(givenTextString.getAndroidStringWithSketchingContext(sketchingContext));
            }
        });
    }

    private int _gravityFromTextAlignment(TextAlignment textAlignment) {
        if (textAlignment == TextAlignment.LEFT) {
            return Gravity.LEFT;
        } else if (textAlignment == TextAlignment.RIGHT) {
            return Gravity.RIGHT;
        } else if (textAlignment == TextAlignment.TOP_AND_CENTER_HORIZONTALLY) {
            return Gravity.CENTER_HORIZONTAL;
        } else if (textAlignment == TextAlignment.LEFT_AND_CENTER_VERTICALLY) {
            return Gravity.CENTER_VERTICAL;
        }
        return Gravity.CENTER;
    }
}
