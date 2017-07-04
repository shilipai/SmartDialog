package com.ufreedom.smartdialog.transition;

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

    public SpringTransitions withRotate(int start, int end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION));
        return this;
    }

    public SpringTransitions withRotate(int start, int end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withRotateX(int start, int end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_X));
        return this;
    }

    public SpringTransitions withRotateX(int start, int end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_X).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withRotateY(int start, int end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_Y));
        return this;
    }

    public SpringTransitions withRotateY(int start, int end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.ROTATION_Y).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withTranslateX(int start, int end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_X));
        return this;
    }

    public SpringTransitions withTranslateX(int start, int end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_X).springConfig(springConfig));
        return this;
    }

    public SpringTransitions withTranslateY(int start, int end) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_Y));
        return this;
    }

    public SpringTransitions withTranslateY(int start, int end, SpringConfig springConfig) {
        transitionModels.add(TransitionModel.create(start, end).transitionCode(TransitionHelper.TRANSLATION_Y).springConfig(springConfig));
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


    public SpringDialogTransition transitions() {
        TransitionModel[] transitionModelArray = transitionModels.toArray(new TransitionModel[transitionModels.size()]);
        return SpringDialogTransition.create(transitionModelArray);
    }

    public static SpringTransition create(final int transition) {
        return new SpringTransition() {
            @Override
            public void doTransition(TransitionHelper transitionHelper, double currentValue) {
                transitionHelper.transition(transition, currentValue);
            }
        };
    }

}
