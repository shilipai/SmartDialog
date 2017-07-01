package com.ufreedom.smartdialog;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by UFreedom on 2017/7/1.
 */

public class DialogConfig {

    private WeakReference<View> mContainerView;

    public DialogConfig(View containerView) {
        this.mContainerView = new WeakReference<View>(containerView);
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
