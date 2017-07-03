package com.ufreedom.smartdialog.transition;

/**
 *
 * Created by UFreedom on 2017/7/3.
 */

public class TransitionModel {

    public int duration;
    public float startVal;
    public float endVal;

    public TransitionModel( float startVal, float endVal,int duration) {
        this.duration = duration;
        this.startVal = startVal;
        this.endVal = endVal;
    }

    public TransitionModel(float startVal, float endVal) {
        this.startVal = startVal;
        this.endVal = endVal;
    }
}
