package com.ufreedom.smartdialog.transition;

/**
 *
 * Created by UFreedom on 2017/7/3.
 */

public class BackgroundAlphaTransition extends AlphaTransition {

    public BackgroundAlphaTransition(TransitionModel transitionModel) {
        super(transitionModel);
    }

    @Override
    protected void changeAlpha(TransitionHelper transitionHelper, float alpha) {
        transitionHelper.setBackgroundAlpha(alpha);
    }

}
