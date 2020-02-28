package com.uisketcher;

import android.os.Looper;
import android.os.Handler;
import android.view.View;

import com.uisketcher.elementary.Maybe;
import com.uisketcher.elementary.MultithreadingSafeObjectContainer;

import java.util.ArrayList;

/**
 * Created by swhitton on 28/2/20.
 */

public abstract class UISketch {

    private final MultithreadingSafeObjectContainer<ArrayList<UISketchingAction>> _sketchingActionQueueInThreadSafeContainer = MultithreadingSafeObjectContainer.containerSafelyContainingObject(new ArrayList<UISketchingAction>());
    private Maybe<UISketchingContext> _maybeLastAvaliableSketchingContext = Maybe.asNothing();

    public UISketch() {}

    abstract public View _createBaseAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext);

    public void performSketchingAction(UISketchingAction sketchingActionInQuestion) {
        _addSketchingActionToActionQueue(sketchingActionInQuestion);
        if (_maybeLastAvaliableSketchingContext.isNotNothing()) {
            _immidiatelyPerformAllSketchingActionsInQueueOnMainThreadWithSketchingContext(_maybeLastAvaliableSketchingContext.object());
        }
    }

    public View drawTangibleAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext) {
        _maybeLastAvaliableSketchingContext = Maybe.asObject(sketchingContext);
        _immidiatelyPerformAllSketchingActionsInQueueWithSketchingContext(sketchingContext);
        return _getCurrentAndroidViewRepresentationOfSketchWithSketchingContext(sketchingContext);
    }

    private void _addSketchingActionToActionQueue(final UISketchingAction sketchingActionInQuestion) {
        _sketchingActionQueueInThreadSafeContainer.accessObjectWithAccessor(new MultithreadingSafeObjectContainer.ObjectAccessor<ArrayList<UISketchingAction>>() {
            @Override
            public void accessObject(ArrayList<UISketchingAction> sketchingActionQueue) {
                sketchingActionQueue.add(sketchingActionInQuestion);
            }
        });
    }

    private void _immidiatelyPerformAllSketchingActionsInQueueOnMainThreadWithSketchingContext(final UISketchingContext sketchingContext) {
        if (_isCurrentlyOnMainThread()) {
            _immidiatelyPerformAllSketchingActionsInQueueWithSketchingContext(sketchingContext);
        } else {
            _schedualRunnableActionToBePerformedOnMainThread(new Runnable() {
                @Override
                public void run() {
                    _immidiatelyPerformAllSketchingActionsInQueueWithSketchingContext(sketchingContext);
                }
            });
        }
    }

    private void _schedualRunnableActionToBePerformedOnMainThread(Runnable runnableAction) {
        new Handler(Looper.getMainLooper()).post(runnableAction);
    }

    private boolean _isCurrentlyOnMainThread() {
        return (Looper.getMainLooper().getThread() == Thread.currentThread());
    }

    private void _immidiatelyPerformAllSketchingActionsInQueueWithSketchingContext(final UISketchingContext sketchingContext) {
        _sketchingActionQueueInThreadSafeContainer.accessObjectWithAccessor(new MultithreadingSafeObjectContainer.ObjectAccessor<ArrayList<UISketchingAction>>() {
            @Override
            public void accessObject(ArrayList<UISketchingAction> sketchingActionQueue) {
                View currentAndroidViewRepresentation = _getCurrentAndroidViewRepresentationOfSketchWithSketchingContext(sketchingContext);
                for (UISketchingAction sketchingActionInQueue : sketchingActionQueue) {
                    sketchingActionInQueue.doActionOnAndroidViewRepresentationWithSketchingContext(currentAndroidViewRepresentation, sketchingContext);
                }
                boolean someSketchingActionsWerePerformed = (sketchingActionQueue.size() > 0);
                sketchingActionQueue.clear();
                if (someSketchingActionsWerePerformed) {
                    currentAndroidViewRepresentation.invalidate();
                }
            }
        });
    }

    private Maybe<View> _maybeCurrentAndroidViewRepresentationIfItHasBeenCreated = Maybe.asNothing();
    private View _getCurrentAndroidViewRepresentationOfSketchWithSketchingContext(UISketchingContext sketchingContext) {
        if (_maybeCurrentAndroidViewRepresentationIfItHasBeenCreated.isNothing()) {
            View newAndroidViewRepresentation = this._createBaseAndroidViewRepresentationOfSketchWithSketchingContext(sketchingContext);
            _maybeCurrentAndroidViewRepresentationIfItHasBeenCreated = Maybe.asObject(newAndroidViewRepresentation);
        }
        return _maybeCurrentAndroidViewRepresentationIfItHasBeenCreated.object();
    }
}
