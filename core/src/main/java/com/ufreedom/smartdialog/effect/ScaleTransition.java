package com.ufreedom.smartdialog.effect;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import com.ufreedom.smartdialog.spring.SimpleReboundListener;
import com.ufreedom.smartdialog.spring.SpringHelper;
import com.ufreedom.smartdialog.transition.DialogTransition;
import com.ufreedom.smartdialog.transition.TransitionHelper;

/**
 * Author UFreedom
 * Date : 2017 二月 09
 */

public class ScaleTransition implements DialogTransition {

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        ValueAnimator alphaAnimation = ObjectAnimator.ofFloat(0.0f, 1.0f);
        alphaAnimation.setDuration(100);
        alphaAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                transitionHelper.setAlpha((Float) animation.getAnimatedValue());
            }
        });

        SpringHelper.create(0f, 1f)
                .configBouncinessAndSpeed(12, 16)
                .reboundListener(new SimpleReboundListener() {
                    @Override
                    public void onReboundUpdate(double currentValue) {
                        transitionHelper.setScaleX((float) currentValue);
                        transitionHelper.setScaleY((float) currentValue);
                    }
                }).start(transitionHelper);
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper) {

    }
}
