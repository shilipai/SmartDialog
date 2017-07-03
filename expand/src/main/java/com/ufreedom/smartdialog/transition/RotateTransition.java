package com.ufreedom.smartdialog.transition;

import android.util.Log;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by UFreedom on 2017/7/3.
 */

public class RotateTransition implements DialogTransition {

    private TransitionModel transitionModel;
    private TransitionModel transitionModelX;
    private TransitionModel transitionModelY;


    public RotateTransition(TransitionModel transitionModel) {
        this.transitionModel = transitionModel;
    }

    public RotateTransition(TransitionModel transitionModelX, TransitionModel transitionModelY) {
        this.transitionModelX = transitionModelX;
        this.transitionModelY = transitionModelY;
    }

    public RotateTransition(TransitionModel transitionModel, TransitionModel transitionModelX, TransitionModel transitionModelY) {
        this.transitionModel = transitionModel;
        this.transitionModelX = transitionModelX;
        this.transitionModelY = transitionModelY;
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        doRotate(transitionHelper);
    }


    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        doRotate(transitionHelper);
    }

    private void doRotate(final TransitionHelper transitionHelper) {
        if (transitionModel != null) {
            SpringHelper.create(transitionModel.startVal, transitionModel.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setRotation((float) currentValue);
                        }
                    }).start(transitionHelper);
        }

        if (transitionModelX != null) {
            SpringHelper.create(transitionModelX.startVal, transitionModelX.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setRotationX((float) currentValue);
                        }
                    }).start(transitionHelper);
        }

        if (transitionModelY != null) {
            SpringHelper.create(transitionModelY.startVal, transitionModelY.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setRotationY((float) currentValue);
                        }
                    }).start(transitionHelper);
        }
    }

}
