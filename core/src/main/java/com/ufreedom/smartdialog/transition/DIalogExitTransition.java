package com.ufreedom.smartdialog.transition;

import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by UFreedom on 2017/7/1.
 */

public interface DialogExitTransition {

    public void applyEnterTransition(int dialogWidth, int dialogHeight, TransitionHelper transitionHelper, DialogDismiss dialogDismiss);

}
