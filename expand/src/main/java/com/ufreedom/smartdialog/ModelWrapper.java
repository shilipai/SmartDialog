package com.ufreedom.smartdialog;

/**
 * Author SunMeng
 * Date : 2017 二月 17
 */

public class ModelWrapper {

    private BaseModel mModel;

    private int type;

    public ModelWrapper(BaseModel model, int type) {
        this.mModel = model;
        this.type = type;
    }

    public BaseModel getModel() {
        return mModel;
    }

    public int getType() {
        return type;
    }
}
