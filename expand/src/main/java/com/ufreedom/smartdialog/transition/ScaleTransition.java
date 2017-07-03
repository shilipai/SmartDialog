package com.ufreedom.smartdialog.transition;

import android.util.Log;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 *
 * Created by UFreedom on 2017/7/2.
 */

public class ScaleTransition implements DialogTransition {

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        SpringHelper.create(1f, 0f)
                .configBouncinessAndSpeed(12, 16)
                .reboundListener(new SimpleReboundListener() {
                    @Override
                    public void onReboundUpdate(double currentValue) {
                        Log.e("UFreedom"," value: " +currentValue );
                        transitionHelper.setScaleX((float) currentValue);
                        transitionHelper.setScaleY((float) currentValue);
                    }
                }).start(transitionHelper);
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
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
}
