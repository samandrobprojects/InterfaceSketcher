package com.example.swhitton.interfacesketcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.uisketcher.UISketch;
import com.uisketcher.UISketcher;
import com.uisketcher.elementary.sketchspecific.Colour;
import com.uisketcher.elementary.sketchspecific.DiscreteMetric;
import com.uisketcher.elementary.sketchspecific.EdgePadding;
import com.uisketcher.elementary.sketchspecific.Font;
import com.uisketcher.elementary.sketchspecific.String;
import com.uisketcher.sketches.VerticalLayoutSketch;
import com.uisketcher.sketches.VerticallyScrollingSketch;
import com.uisketcher.sketches.TextLabelSketch;

public class TestInterfaceSketcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_interface_sketcher);

        UISketcher sketcher = UISketcher.newSketcherWithAndroidContext(this);
        View viewFromSketch = sketcher.drawTangibleAndroidViewFromSketch(_testSketch());
        View viewToAddAsChild = viewFromSketch;

        viewToAddAsChild.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        viewToAddAsChild.requestLayout();
        RelativeLayout baseLayout = (RelativeLayout) this.findViewById(R.id.activity_test_interface_sketcher);
        baseLayout.addView(viewToAddAsChild);
    }

    private UISketch _testSketch() {
        VerticalLayoutSketch verticalLayoutSketch = VerticalLayoutSketch.newVerticalLayoutSketch();
        EdgePadding paddingForEachItem = EdgePadding.edgePaddingWithDistanceFromLeftTopRightBottom(DiscreteMetric.metricInPhysicalSize(20),DiscreteMetric.metricInPhysicalSize(20),DiscreteMetric.metricInPhysicalSize(20),DiscreteMetric.metricInPhysicalSize(20));
        for (int i = 0; i < 40; ++i) {
            EdgePadding paddingForEachSubItem = EdgePadding.edgePaddingWithDistanceFromLeftTopRightBottom(DiscreteMetric.metricInPhysicalSize(0),DiscreteMetric.metricInPhysicalSize(6),DiscreteMetric.metricInPhysicalSize(0),DiscreteMetric.metricInPhysicalSize(6));
            VerticalLayoutSketch verticalLayoutSketchItem = VerticalLayoutSketch.newVerticalLayoutSketch();
            verticalLayoutSketchItem.addSketchToNextPositionInLayoutWithEdgePadding(_textLabelSketchWithStringAndColour(String.stringWithAndroidStringResourceID(R.string.test_string), Colour.MAGENTA), paddingForEachSubItem);
            verticalLayoutSketchItem.addSketchToNextPositionInLayoutWithEdgePadding(_textLabelSketchWithStringAndColour(String.stringWithAndroidStringResourceID(R.string.test_string2), Colour.BLUE), paddingForEachSubItem);
            verticalLayoutSketchItem.addSketchToNextPositionInLayoutWithEdgePadding(_textLabelSketchWithStringAndColour(String.stringWithAndroidStringResourceID(R.string.test_string3), Colour.GREEN), paddingForEachSubItem);
            verticalLayoutSketch.addSketchToNextPositionInLayoutWithEdgePadding(verticalLayoutSketchItem, paddingForEachItem);
        }
        UISketch baseSketch = VerticallyScrollingSketch.newVerticallyScrollingSketchByScrollingGivenSketch(verticalLayoutSketch);
        return baseSketch;
    }

    private TextLabelSketch _textLabelSketchWithStringAndColour(String string, Colour colour) {
        TextLabelSketch textLabelSketch = TextLabelSketch.newTextLabelSketch();
        textLabelSketch.setTextAlignment(TextLabelSketch.TextAlignment.LEFT_AND_CENTER_VERTICALLY);
        textLabelSketch.setTextString(string);
        textLabelSketch.setTextColour(colour);
        textLabelSketch.setTextFont(Font.italicMonospacedSystemFontOfSize(DiscreteMetric.metricInPhysicalSize(15)));
        return textLabelSketch;
    }
}
