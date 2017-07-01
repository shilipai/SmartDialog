package com.ufreedom.smartdialog.transition;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import com.ufreedom.smartdialog.transition.SimpleReboundListener;
import com.ufreedom.smartdialog.transition.SpringHelper;
import com.ufreedom.smartdialog.transition.DialogEnterTransition;
import com.ufreedom.smartdialog.transition.TransitionHelper;

/**
 * Author UFreedom
 * Date : 2017 二月 16
 */

public class HeightRiseEnterTransition implements DialogEnterTransition {

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0.0f, 1.0f);
        valueAnimator.setDuration(200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                transitionHelper.setAlpha((Float) animation.getAnimatedValue());
            }
        });

        SpringHelper.create(0f, dialogHeight)
                .configBouncinessAndSpeed(6, 8)
                .reboundListener(new SimpleReboundListener() {
                    @Override
                    public void onReboundUpdate(double currentValue) {
                        transitionHelper.setDialogHeight((int) currentValue);
                    }
                })
                .start(transitionHelper);

    }
}
