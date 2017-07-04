package com.ufreedom.smartdialog.transition;

import android.view.View;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

import java.lang.ref.WeakReference;

public class TransitionHelper implements ITransition {

    private WeakReference<View> mContentViewWeakReference;
    private WeakReference<View> mRootViewWeakReference;


    public TransitionHelper(View dialogContentView, View rootView) {
        mContentViewWeakReference = new WeakReference<View>(dialogContentView);
        mRootViewWeakReference = new WeakReference<View>(rootView);
    }

    public View getDialogView() {
        return mContentViewWeakReference.get();
    }

    private View getRootView() {
        return mRootViewWeakReference.get();
    }

    public void setBackgroundAlpha(float alpha) {
        View rootView;
        if ((rootView = getRootView()) != null) {
            rootView.setAlpha(alpha);
        }
    }

    @Override
    public void setAlpha(float alpha) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setAlpha(alpha);
        }
    }

    @Override
    public void setRotation(float rotation) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setRotation(rotation);
        }
    }

    @Override
    public void setRotationX(float rotationX) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setRotationX(rotationX);
        }
    }

    @Override
    public void setRotationY(float rotationY) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setRotationY(rotationY);
        }
    }

    @Override
    public void setScaleX(float scaleX) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setScaleX(scaleX);
        }
    }

    @Override
    public void setScaleY(float scaleY) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setScaleY(scaleY);
        }
    }

    @Override
    public void setScrollX(int scrollX) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setScrollX(scrollX);
        }
    }

    @Override
    public void setScrollY(int scrollY) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setScrollY(scrollY);
        }
    }

    @Override
    public void setTranslationX(float translationX) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setTranslationX(translationX);
        }
    }

    @Override
    public void setTranslationY(float translationY) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setTranslationY(translationY);
        }
    }

    @Override
    public void setX(float x) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setX(x);
        }
    }

    @Override
    public void setY(float y) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setY(y);
        }
    }

    @Override
    public void setDialogHeight(int height) {
        View dialogView;
        if ((dialogView = getDialogView()) != null && dialogView.getLayoutParams() != null) {
            dialogView.getLayoutParams().height = height;
            dialogView.requestLayout();
        }
    }

    @Override
    public void setDialogWidth(int width) {
        View dialogView;
        if ((dialogView = getDialogView()) != null && dialogView.getLayoutParams() != null) {
            dialogView.getLayoutParams().width = width;
            dialogView.requestLayout();
        }
    }

    @Override
    public void setDialogWidthAndHeight(int width, int height) {
        View dialogView;
        if ((dialogView = getDialogView()) != null && dialogView.getLayoutParams() != null) {
            dialogView.getLayoutParams().width = width;
            dialogView.getLayoutParams().height = height;
            dialogView.requestLayout();
        }
    }

    @Override
    public void setPivotX(float x) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setPivotX(x);
        }
    }

    @Override
    public void setPivotY(float y) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setPivotY(y);
        }
    }

    @Override
    public void setColor(int color) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setBackgroundColor(color);
        }
    }


}
