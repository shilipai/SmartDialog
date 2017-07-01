package com.ufreedom.smartdialog.transition;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Author SunMeng
 * Date : 2017 二月 09
 */

public interface DialogEnterTransition {
    
    public void applyEnterTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper);
    
}
