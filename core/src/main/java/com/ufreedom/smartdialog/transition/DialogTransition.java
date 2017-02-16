package com.ufreedom.smartdialog.transition;

/**
 * Author SunMeng
 * Date : 2017 二月 09
 */

public interface DialogTransition {
    
    public void applyEnterTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper);

    public void applyExitTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper);

}
