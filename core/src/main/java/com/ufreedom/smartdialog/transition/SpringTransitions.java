package com.ufreedom.smartdialog.transition;

import android.annotation.TargetApi;

import com.facebook.rebound.SpringConfig;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by UFreedom on 2017/7/4.
 */

public class SpringTransitions {

    private List<TransitionModel> transitionModels;

    private SpringTransitions() {
        transitionModels = new ArrayList<>();
    }

    public static SpringTransitions create() {
        return new SpringTransitions();
    }

    public SpringTransitions withScaleX(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.SCALE_X));
        return this;
    }

    public SpringTransitions withScaleX(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.SCALE_X).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withScaleY(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.SCALE_Y));
        return this;
    }

    public SpringTransitions withScaleY(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.SCALE_Y).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withRotate(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION));
        return this;
    }

    public SpringTransitions withRotate(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withRotateX(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_X));
        return this;
    }

    public SpringTransitions withRotateX(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_X).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withRotateY(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_Y));
        return this;
    }

    public SpringTransitions withRotateY(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_Y).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withTranslateX(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_X));
        return this;
    }

    public SpringTransitions withTranslateX(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_X).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withTranslateY(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_Y));
        return this;
    }

    public SpringTransitions withTranslateY(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_Y).springConfig(springConfig));
        return this;
    }

    @TargetApi(21)
    public SpringTransitions withTranslateZ(float start, float end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_Z));
        return this;
    }

    @TargetApi(21)
    public SpringTransitions withTranslateZ(float start, float end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_Z).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withSize(int start, int end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.WIDTH_AND_HEIGHT));
        return this;
    }

    public SpringTransitions withSize(int start, int end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.WIDTH_AND_HEIGHT).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withWidth(int startWidth, int endWidth) {
        transitionModels.add(TransitionModel.create(startWidth, endWidth).transitionCode(TransitionHelper.WIDTH));
        return this;
    }

    public SpringTransitions withWidth(int startWidth, int endWidth, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(startWidth, endWidth).transitionCode(TransitionHelper.WIDTH).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withHeight(int startHeight, int endHeight) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.HEIGHT));
        return this;
    }

    public SpringTransitions withHeight(int startHeight, int endHeight, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.HEIGHT).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withX(float startHeight, float endHeight) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.X));
        return this;
    }

    public SpringTransitions withX(float startHeight, float endHeight, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.X).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withY(float startHeight, float endHeight) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.Y));
        return this;
    }

    public SpringTransitions withY(float startHeight, float endHeight, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.Y).springConfig(springConfig));
        return this;
    }

    @TargetApi(21)
    public SpringTransitions withZ(float startHeight, float endHeight) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.Z));
        return this;
    }


    @TargetApi(21)
    public SpringTransitions withZ(float startHeight, float endHeight, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(startHeight, endHeight).transitionCode(TransitionHelper.Z).springConfig(springConfig));
        return this;
    }

    public SpringDialogTransition transitions() {
        TransitionModel[] transitionModelArray = transitionModels.toArray(new TransitionModel[transitionModels.size()]);
        return SpringDialogTransition.create(transitionModelArray);
    }

}
