package com.ufreedom.smartdialog.transition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by UFreedom on 2017/7/2.
 */

public class Transitions {

    private List<DialogTransition> dialogTransitions;

    private Transitions() {
        dialogTransitions = new ArrayList<>();
    }

    public static Transitions create() {
        return new Transitions();
    }

    public Transitions withAlpha(float start, float end, int duration) {
        dialogTransitions.add(new AlphaTransition(new TransitionModel(start, end, duration)));
        return this;
    }

    public Transitions withScaleX(float start, float end) {
        dialogTransitions.add(new ScaleTransition(new TransitionModel(start, end), null));
        return this;
    }

    public Transitions withScaleY(float start, float end) {
        dialogTransitions.add(new ScaleTransition(null, new TransitionModel(start, end)));
        return this;
    }

    public Transitions withRotate(int start, int end) {
        dialogTransitions.add(new RotateTransition(new TransitionModel(start, end)));
        return this;
    }

    public Transitions withRotateX(int start, int end) {
        dialogTransitions.add(new RotateTransition(null, new TransitionModel(start, end), null));
        return this;
    }

    public Transitions withRotateY(int start, int end) {
        dialogTransitions.add(new RotateTransition(null, null, new TransitionModel(start, end)));
        return this;
    }

    public Transitions withTranslateX(int start, int end) {
        dialogTransitions.add(new TranslateTransition(new TransitionModel(start, end), null));
        return this;
    }

    public Transitions withTranslateY(int start, int end) {
        dialogTransitions.add(new TranslateTransition(null, new TransitionModel(start, end)));
        return this;
    }

    public Transitions withSize(int startWidth, int endWidth, int startHeight, int endHeight) {
        dialogTransitions.add(new ViewSizeTransition(new TransitionModel(startWidth, endWidth), new TransitionModel(startHeight, endHeight)));
        return this;
    }

    public Transitions withWidth(int startWidth, int endWidth) {
        dialogTransitions.add(new ViewSizeTransition(new TransitionModel(startWidth, endWidth), null));
        return this;
    }

    public Transitions withHeight(int startHeight, int endHeight) {
        dialogTransitions.add(new ViewSizeTransition(null, new TransitionModel(startHeight, endHeight)));
        return this;
    }


    public List<DialogTransition> transitions() {
        return dialogTransitions;
    }

}
