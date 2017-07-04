package com.ufreedom.smartdialog.transition;

import android.view.View;

/**
 *
 * Created by UFreedom on 2017/7/4.
 */

public class Transitions {

    public static DialogTransition crateAlpha(float start, int end, int duration) {
        return new AlphaTransition(TransitionModel.create(start, end).duration(duration));
    }

    public static DialogTransition crateBackgroundAlpha(float start, int end, int duration) {
        return new BackgroundAlphaTransition(TransitionModel.create(start, end).duration(duration));
    }

    public static DialogTransition crateColor(float start, int end, int duration) {
        return new ColorTransition(TransitionModel.create(start, end).duration(duration));
    }

    public static DialogTransition crateColor(View view, float start, int end, int duration) {
        return new ColorTransition(TransitionModel.create(start, end).duration(duration));
    }

}
