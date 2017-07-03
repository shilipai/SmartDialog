package com.ufreedom.smartdialog;

import com.ufreedom.smartdialog.transition.DialogEnterTransition;

/**
 * Created by UFreedom on 2017/7/1.
 */

public class SmartDialog {


    private SmartDialog() {

    }

    public static SmartDialog create() {
        SmartDialog smartDialog = new SmartDialog();
        return smartDialog;
    }


    public SmartDialog enterTransition(DialogEnterTransition dialogEnterTransition) {

        return this;
    }

    public SmartDialog exitTransition(DialogEnterTransition dialogExitTransition) {


        return this;
    }







}
