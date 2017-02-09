package com.ufreedom.smartdialog.transition;

import android.view.View;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

public class TransitionHelper implements ITransition,Rebound{

    private SpringSystem mSpringSystem;
    private View mContentView;
    private View mRootView;


    public TransitionHelper(SpringSystem mSpringSystem, View dialogContentView,View rootView) {
        this.mSpringSystem = mSpringSystem;
        this.mContentView = dialogContentView;
        this.mRootView = rootView;
    }
    
    public void setBackgroundAlpha(float alpha){
        mRootView.setAlpha(alpha);
    }

    @Override
    public void setAlpha(float alpha) {
        mContentView.setAlpha(alpha);
    }

    @Override
    public void setRotation(float rotation) {
        mContentView.setRotation(rotation);
    }

    @Override
    public void setRotationX(float rotationX) {
        mContentView.setRotationX(rotationX);
    }

    @Override
    public void setRotationY(float rotationY) {
        mContentView.setRotationY(rotationY);
    }

    @Override
    public void setScaleX(float scaleX) {
        mContentView.setScaleX(scaleX);
    }

    @Override
    public void setScaleY(float scaleY) {
        mContentView.setScaleY(scaleY);
    }

    @Override
    public void setScrollX(int scrollX) {
        mContentView.setScrollX(scrollX);
    }

    @Override
    public void setScrollY(int scrollY) {
        mContentView.setScrollY(scrollY);
    }

    @Override
    public void setTranslationX(float translationX) {
        mContentView.setTranslationX(translationX);
    }

    @Override
    public void setTranslationY(float translationY) {
        mContentView.setTranslationY(translationY);
    }

    @Override
    public void setX(float x) {
        mContentView.setX(x);
    }

    @Override
    public void setY(float y) {
        mContentView.setY(y);
    }

    @Override
    public Spring createSpringByBouncinessAndSpeed(double bounciness, double speed) {
        return mSpringSystem.createSpring()
                .setSpringConfig(SpringConfig.fromBouncinessAndSpeed(bounciness, speed));
    }

    @Override
    public Spring createSpringByTensionAndFriction(double tension, double friction) {
        return mSpringSystem.createSpring()
                .setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(tension, friction));
    }

    @Override
    public float transition(double progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, 0, 1, startValue, endValue);
    }


}
