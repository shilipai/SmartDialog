package com.ufreedom.smartdialog.transition;

import android.annotation.TargetApi;
import android.view.View;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

import java.lang.ref.WeakReference;

public class TransitionHelper implements ITransition {

    public static final int NONE = 0x0000;
    public static final int TRANSLATION_X = 0x0001;
    public static final int TRANSLATION_Y = 0x0002;
    public static final int TRANSLATION_Z = 0x0004;
    public static final int SCALE_X = 0x0008;
    public static final int SCALE_Y = 0x0010;
    public static final int ROTATION = 0x0020;
    public static final int ROTATION_X = 0x0040;
    public static final int ROTATION_Y = 0x0080;
    public static final int X = 0x0100;
    public static final int Y = 0x0200;
    public static final int Z = 0x0400;
    public static final int ALPHA = 0x0800;
    public static final int WIDTH = 0x1000;
    public static final int HEIGHT = 0x2000;
    public static final int WIDTH_AND_HEIGHT = 0x4000;
    //  public static final int ALPHA          = 0x8000;


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

    @TargetApi(21)
    @Override
    public void setTranslationZ(float translationZ) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setTranslationZ(translationZ);
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

    @TargetApi(21)
    @Override
    public void setZ(float z) {
        View dialogView;
        if ((dialogView = getDialogView()) != null) {
            dialogView.setZ(z);
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

    public void transition(int transition, double value) {
        switch (transition) {
            case TRANSLATION_X:
                setTranslationX((float) value);
                break;
            case TRANSLATION_Y:
                setTranslationY((float) value);
                break;
            case TRANSLATION_Z:
                setTranslationZ((float) value);
                break;
            case ROTATION:
                setRotation((float) value);
                break;
            case ROTATION_X:
                setRotationX((float) value);
                break;
            case ROTATION_Y:
                setRotationY((float) value);
                break;
            case SCALE_X:
                setScaleX((float) value);
                break;
            case SCALE_Y:
                setScaleY((float) value);
                break;
            case X:
                setX((float) value);
                break;
            case Y:
                setY((float) value);
                break;
            case Z:
                setZ((float) value);
                break;
            case ALPHA:
                setAlpha((float) value);
                break;
            case WIDTH:
                setDialogWidth((int) value);
                break;
            case HEIGHT:
                setDialogHeight((int) value);
                break;
            case WIDTH_AND_HEIGHT:
                int val = (int) value;
                setDialogWidthAndHeight(val, val);
                break;
        }
    }

}
