package com.ufreedom.smartdialog.transition;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by Sun Meng on 2017/7/3.
 */

public class TranslateTransition implements DialogTransition {

    private TransitionModel transitionModelX;
    private TransitionModel transitionModelY;

    private TranslateTransition() {

    }

    public TranslateTransition(TransitionModel transitionModelX, TransitionModel transitionModelY) {
        this.transitionModelX = transitionModelX;
        this.transitionModelY = transitionModelY;
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper) {
        doTranslate(transitionHelper);
    }

    private void doTranslate(final TransitionHelper transitionHelper) {
        if (transitionModelX != null) {
            SpringHelper.create(transitionModelX.startVal, transitionModelX.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setRotation((float) currentValue);
                        }
                    }).start(transitionHelper);
        }

        if (transitionModelY != null) {
            SpringHelper.create(transitionModelY.startVal, transitionModelY.endVal)
                    .configBouncinessAndSpeed(12, 16)
                    .reboundListener(new SimpleReboundListener() {
                        @Override
                        public void onReboundUpdate(double currentValue) {
                            transitionHelper.setRotation((float) currentValue);
                        }
                    }).start(transitionHelper);
        }

    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        doTranslate(transitionHelper);
    }


}
