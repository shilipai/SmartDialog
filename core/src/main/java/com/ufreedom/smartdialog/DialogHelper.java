package com.ufreedom.smartdialog;

import com.ufreedom.smartdialog.transition.DialogEnterTransition;

/**
 * Created by UFreedom on 2017/7/1.
 */

public class DialogHelper {


    private DialogHelper () {

    }

    public static DialogHelper create() {

        DialogHelper dialogHelper = new DialogHelper();
        return dialogHelper;
    }


    public DialogHelper enterTransition(DialogEnterTransition dialogEnterTransition) {

        return this;
    }

    public DialogHelper exitTransition(DialogEnterTransition dialogExitTransition) {


        return this;
    }







}
