package com.ufreedom.smartdialog.transition;

import com.facebook.rebound.SpringConfig;
import com.ufreedom.smartdialog.DialogDismiss;

/**
 *
 * Created by UFreedom on 2017/7/3.
 */

public class SpringDialogTransition implements DialogTransition {

    private TransitionModel[] transitionModelArray;

    public static SpringDialogTransition create(TransitionModel... transitionModel) {
        return new SpringDialogTransition(transitionModel);
    }

    public SpringDialogTransition(TransitionModel... transitionModel) {
        transitionModelArray = transitionModel;
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        applyTransition(transitionHelper);
    }

    private void applyTransition(final TransitionHelper transitionHelper) {
        for (final TransitionModel transitionModel : transitionModelArray) {
            if (transitionModel != null) {
                SpringHelper.create(transitionModel.startVal, transitionModel.endVal)
                        .configSpring(transitionModel.springConfig == null ? SpringConfig.fromBouncinessAndSpeed(12, 16) : transitionModel.springConfig)
                        .reboundListener(new SimpleReboundListener() {
                            @Override
                            public void onReboundUpdate(double currentValue) {
                                transitionHelper.transition(transitionModel.transitionCode, currentValue);
                            }
                        }).start();
            }
        }
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        applyTransition(transitionHelper);
    }


}
