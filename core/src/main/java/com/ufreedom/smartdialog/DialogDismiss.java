package com.ufreedom.smartdialog;

import java.lang.ref.WeakReference;

/**
 *
 * Created by UFreedom on 2017/7/1.
 */

public  class DialogDismiss {

    private WeakReference<BaseDialog> baseDialogWeakReference;

    public DialogDismiss(BaseDialog baseDialog) {
        this.baseDialogWeakReference = new WeakReference<BaseDialog>(baseDialog);
    }

    public  void dismiss() {
        if (baseDialogWeakReference.get() != null) {
            baseDialogWeakReference.get().dismiss();
        }
    }
}
