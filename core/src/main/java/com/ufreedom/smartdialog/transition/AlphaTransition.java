package com.ufreedom.smartdialog.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 *
 * Created by UFreedom on 2017/7/2.
 */

public class AlphaTransition implements DialogTransition {


    private TransitionModel transitionModel;

    public AlphaTransition(TransitionModel transitionModel) {
        this.transitionModel = transitionModel;
    }

    private AlphaTransition() {

    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, final DialogDismiss dialogDismiss) {
        if (transitionModel != null) {
            final ValueAnimator alphaAnimation = ObjectAnimator.ofFloat(transitionModel.startVal, transitionModel.endVal);
            alphaAnimation.setDuration(transitionModel.duration);
            alphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    changeAlpha(transitionHelper, (Float) animation.getAnimatedValue());
                }
            });
            alphaAnimation.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    dialogDismiss.dismiss();
                }
            });
            alphaAnimation.start();
        }

    }

    protected void changeAlpha(final TransitionHelper transitionHelper, float alpha) {
        transitionHelper.setAlpha(alpha);
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        if (transitionModel != null) {
            ValueAnimator alphaAnimation = ObjectAnimator.ofFloat(transitionModel.startVal, transitionModel.endVal);
            alphaAnimation.setDuration(transitionModel.duration);
            alphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    changeAlpha(transitionHelper, (Float) animation.getAnimatedValue());
                }
            });
            alphaAnimation.start();
        }
    }


    @Override
    public void onInitialize() {

    }

    @Override
    public void onDestroy() {

    }
}
