package com.ufreedom.smartdialog.transition;

import android.util.Log;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 *
 * Created by UFreedom on 2017/7/2.
 */

public class ScaleTransition implements DialogTransition {


    private TransitionModel transitionModelX;
    private TransitionModel transitionModelY;


    private ScaleTransition() {

    }

    public ScaleTransition(TransitionModel transitionModelX, TransitionModel transitionModelY) {
        this.transitionModelX = transitionModelX;
        this.transitionModelY = transitionModelY;
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        doScale(transitionHelper);
    }

    private void doScale(final TransitionHelper transitionHelper) {
        if (transitionModelX != null) {
            SpringHelper.create(transitionModelX.startVal, transitionModelX.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setScaleX((float) currentValue);
                        }
                    }).start(transitionHelper);
        }

        if (transitionModelY != null) {
            SpringHelper.create(transitionModelY.startVal, transitionModelY.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setScaleY((float) currentValue);
                        }
                    }).start(transitionHelper);
        }

    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        doScale(transitionHelper);
    }
}
