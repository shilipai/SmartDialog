package com.ufreedom.smartdialog.transition;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by Sun Meng on 2017/7/3.
 */

public class ViewSizeTransition implements DialogTransition {

    private TransitionModel transitionModelWidth;
    private TransitionModel transitionModelHeight;

    private ViewSizeTransition() {

    }

    public ViewSizeTransition(TransitionModel transitionModelWidth, TransitionModel transitionModelHeight) {
        this.transitionModelWidth = transitionModelWidth;
        this.transitionModelHeight = transitionModelHeight;
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        doSizeChange(transitionHelper);
    }

    private void doSizeChange(final TransitionHelper transitionHelper) {

        if (transitionModelWidth != null && transitionModelHeight != null
                && transitionModelWidth.startVal == transitionModelHeight.startVal
                && transitionModelWidth.endVal == transitionModelHeight.endVal) {
            SpringHelper.create(transitionModelWidth.startVal, transitionModelWidth.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setDialogWidthAndHeight((int) currentValue,(int) currentValue);
                        }
                    }).start(transitionHelper);

            return;
        }

        if (transitionModelWidth != null) {
            SpringHelper.create(transitionModelWidth.startVal, transitionModelWidth.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setDialogWidth((int) currentValue);
                        }
                    }).start(transitionHelper);
        }

        if (transitionModelHeight != null) {
            SpringHelper.create(transitionModelHeight.startVal, transitionModelHeight.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setDialogHeight((int) currentValue);
                        }
                    }).start(transitionHelper);
        }
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper) {
        doSizeChange(transitionHelper);
    }




}
