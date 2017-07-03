package com.ufreedom.smartdialog;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by UFreedom on 2017/7/1.
 */

public class DialogConfig {

    private WeakReference<View> mContainerView;
    private WeakReference<Dialog> mDialog;
    private WeakReference<View> mDialogContentView;
    private boolean mCanceledOnTouchOutside = true;

    public DialogConfig(View containerView,View dialogView,Dialog dialog) {
        mContainerView = new WeakReference<View>(containerView);
        mDialog = new WeakReference<Dialog>(dialog);
        mDialogContentView = new WeakReference<View>(dialogView);
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        mCanceledOnTouchOutside = cancel;
        if (mDialog.get() != null) {
            mDialog.get().setCanceledOnTouchOutside(cancel);
        }
    }

    public boolean isCanceledOnTouchOutside() {
        return mCanceledOnTouchOutside;
    }

    public void setBackgroundColor(int color) {
        if (mContainerView.get() != null) {
            mContainerView.get().setBackgroundColor(color);
        }
    }

    public void setBackgroundResource(@DrawableRes int resid) {
        if (mContainerView.get() != null) {
            mContainerView.get().setBackgroundResource(resid);
        }
    }

    public void setBackground(Drawable drawable) {
        if (mContainerView.get() != null) {
            mContainerView.get().setBackgroundDrawable(drawable);
        }
    }


}
