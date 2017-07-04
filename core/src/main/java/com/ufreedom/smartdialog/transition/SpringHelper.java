/*
 * Copyright (C) 2015 UFreedom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.ufreedom.smartdialog.transition;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;

/**
 * A help class for using Facebook Rebound
 * <p>
 * Author UFreedom
 * Date : 2016 十月 20
 */

public class SpringHelper {

    private static SpringSystem springSystem;
    private float mStartValue;
    private float mEndValue;
    private SpringConfig mSpringConfig;
    private ReboundListener mReboundListener;
    private SpringListener mSpringListener;

    public static void init() {
        if (springSystem == null) {
            springSystem = SpringSystem.create();
        }
    }

    public static void destroy() {
        springSystem = null;
    }

    private SpringHelper(float startValue, float endValue) {
        init();

        this.mStartValue = startValue;
        this.mEndValue = endValue;
    }

    public static SpringHelper create(float startValue, float endValue) {
        return new SpringHelper(startValue, endValue);
    }

    public static SpringHelper createWithBouncinessAndSpeed(float startValue, float endValue, double bounciness, double speed) {
        SpringHelper springHelper = new SpringHelper(startValue, endValue);
        return springHelper.configBouncinessAndSpeed(bounciness, speed);
    }

    public static SpringHelper createWithTensionAndFriction(float startValue, float endValue, double tension, double friction) {
        SpringHelper springHelper = new SpringHelper(startValue, endValue);
        return springHelper.configTensionAndFriction(tension, friction);
    }


    public SpringHelper configBouncinessAndSpeed(double bounciness, double speed) {
        mSpringConfig = SpringConfig.fromBouncinessAndSpeed(bounciness, speed);
        return this;
    }

    public SpringHelper configTensionAndFriction(double tension, double friction) {
        mSpringConfig = SpringConfig.fromOrigamiTensionAndFriction(tension, friction);
        return this;
    }

    public SpringHelper configSpring(SpringConfig springConfig) {
        mSpringConfig = springConfig;
        return this;
    }

    public SpringHelper reboundListener(ReboundListener reboundListener) {
        this.mReboundListener = reboundListener;
        return this;
    }

    public SpringHelper springListener(SpringListener springListener) {
        this.mSpringListener = springListener;
        return this;
    }

    public void start() {

        if (mSpringConfig == null) {
            throw new NullPointerException("Hi , You must call one of the method configBouncinessAndSpeed and configTensionAndFriction to make mConfig");
        }

        Spring spring = springSystem.createSpring();
        spring.setSpringConfig(mSpringConfig);
        start(spring);
    }

    private void start(Spring spring) {
        if (spring != null) {

            if (mSpringListener != null) {
                spring.addListener(mSpringListener);
            }

            spring.setCurrentValue(mapFromLowValue(mStartValue, mEndValue));
            spring.addListener(new SimpleSpringListener() {
                @Override
                public void onSpringUpdate(Spring spring) {
                    if (spring.getCurrentValue() == spring.getEndValue()) {
                        if (mReboundListener != null) {
                            mReboundListener.onReboundEnd();
                        }
                    }
                    if (mReboundListener != null) {
                        mReboundListener.onReboundUpdate(transition(spring.getCurrentValue(), mStartValue, mEndValue));
                    }
                }
            }).setEndValue(mapFromHighValue(mStartValue, mEndValue));
        } else {
            throw new NullPointerException("Spring should not be null");
        }
    }

    public float transition(double progress, float startValue, float endValue) {
        return (float) SpringUtil.mapValueFromRangeToRange(progress, mapFromLowValue(startValue, endValue), mapFromHighValue(startValue, endValue), startValue, endValue);
    }

    public int mapFromLowValue(float startValue, float endValue) {
        return startValue < endValue ? 0 : 1;
    }

    public int mapFromHighValue(float startValue, float endValue) {
        return startValue < endValue ? 1 : 0;
    }
}
