package com.ufreedom.smartdialog.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by UFreedom on 2017/7/2.
 */

public class AlphaTransition implements DialogTransition{

    private int mEnterDuration;
    private int mExitDuration;

    public AlphaTransition() {
        mEnterDuration = 400;
        mExitDuration = 400;
    }

    public AlphaTransition(int enterDuration, int exitDuration) {
        this.mEnterDuration = enterDuration;
        this.mExitDuration = exitDuration;
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, final DialogDismiss dialogDismiss) {
        ValueAnimator alphaAnimation = ObjectAnimator.ofFloat(1.0f, 0.0f);
        alphaAnimation.setDuration(mEnterDuration);
        alphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                transitionHelper.setAlpha((Float) animation.getAnimatedValue());
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

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        ValueAnimator alphaAnimation = ObjectAnimator.ofFloat(0.0f, 1.0f);
        alphaAnimation.setDuration(mEnterDuration);
        alphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                transitionHelper.setAlpha((Float) animation.getAnimatedValue());
            }
        });
        alphaAnimation.start();
    }




}
