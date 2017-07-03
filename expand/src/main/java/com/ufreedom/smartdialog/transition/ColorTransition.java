package com.ufreedom.smartdialog.transition;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 *
 * Created by UFreedom on 2017/7/3.
 */

public class ColorTransition implements DialogTransition{

    private TransitionModel transitionModel;

    public ColorTransition(TransitionModel transitionModel) {
        this.transitionModel = transitionModel;
    }


    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        if (transitionModel != null) {
            doColorChange(transitionHelper);
        }
    }

    private void doColorChange(final TransitionHelper transitionHelper) {
        ValueAnimator colorAnimation = ObjectAnimator.ofFloat(transitionModel.startVal, transitionModel.endVal);
        colorAnimation.setDuration(transitionModel.duration);
        colorAnimation.setEvaluator(new ArgbEvaluator());
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                changeColor(transitionHelper, (Integer) animation.getAnimatedValue());
            }
        });
        colorAnimation.start();
    }

    protected void changeColor(TransitionHelper transitionHelper,int color) {
        transitionHelper.setColor(color);
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper) {
        if (transitionModel != null) {
            doColorChange(transitionHelper);
        }
    }


}
