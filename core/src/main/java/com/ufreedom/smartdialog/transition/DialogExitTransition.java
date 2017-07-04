package com.ufreedom.smartdialog.transition;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by UFreedom on 2017/7/1.
 */

public interface DialogExitTransition extends TransitionLifecycle {

    public void applyExitTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper, DialogDismiss dialogDismiss);

}
