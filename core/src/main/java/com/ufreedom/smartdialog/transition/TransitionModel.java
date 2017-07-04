package com.ufreedom.smartdialog.transition;

import com.facebook.rebound.SpringConfig;

/**
 *
 * Created by UFreedom on 2017/7/3.
 */

public class TransitionModel {

    public int duration;
    public float startVal;
    public float endVal;
    public SpringConfig springConfig;
    public int transitionCode;

    public TransitionModel( float startVal, float endVal,int duration) {
        this.duration = duration;
        this.startVal = startVal;
        this.endVal = endVal;
    }

    public TransitionModel(float startVal, float endVal) {
        this.startVal = startVal;
        this.endVal = endVal;
    }

    public static TransitionModel create(float startVal,float endVal) {
        return new TransitionModel(startVal,endVal);
    }

    public TransitionModel duration(int duration) {
        this.duration = duration;
        return this;
    }

    public TransitionModel springConfig(SpringConfig springConfig) {
        this.springConfig = springConfig;
        return this;
    }

    public TransitionModel transitionCode(int transitionCode) {
        this.transitionCode = transitionCode;
        return this;
    }
}
