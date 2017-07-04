package com.ufreedom.smartdialog.transition;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.facebook.rebound.ChoreographerCompat;
import com.facebook.rebound.SpringConfig;
import com.ufreedom.smartdialog.DialogDismiss;

/**
 * Created by UFreedom on 2017/7/3.
 */

public class SpringDialogTransition implements DialogTransition {

    private TransitionModel[] transitionModelArray;
    private Handler mHandler;

    public static SpringDialogTransition create(TransitionModel... transitionModel) {
        return new SpringDialogTransition(transitionModel);
    }

    public SpringDialogTransition(TransitionModel... transitionModel) {
        transitionModelArray = transitionModel;
    }

    @Override
    public void applyExitTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper, DialogDismiss dialogDismiss) {
        applyTransition(transitionHelper);
    }

    private void applyTransition(final TransitionHelper transitionHelper) {
        for (final TransitionModel transitionModel : transitionModelArray) {
            if (transitionModel != null) {
                if (transitionModel.delay > 0) {
                    postDelayed(new DelayCallback() {
                        @Override
                        public void doSomething() {
                            doSpring(transitionHelper, transitionModel);
                        }
                    },transitionModel.delay);
                }else {
                    doSpring(transitionHelper, transitionModel);
                }
            }
        }
    }

    private void doSpring(final TransitionHelper transitionHelper, final TransitionModel transitionModel) {
        SpringHelper.create(transitionModel.startVal, transitionModel.endVal)
                .configSpring(transitionModel.springConfig == null ? SpringConfig.fromBouncinessAndSpeed(12, 16) : transitionModel.springConfig)
                .reboundListener(new SimpleReboundListener() {
                    @Override
                    public void onReboundUpdate(double currentValue) {
                        transitionHelper.transition(transitionModel.transitionCode, currentValue);
                    }
                }).start();
    }

    @Override
    public void applyEnterTransition(int dialogWidth, int dialogHeight, final TransitionHelper transitionHelper) {
        applyTransition(transitionHelper);
    }


    @Override
    public void onInitialize() {
        mHandler = new InnerHandler(Looper.getMainLooper());
    }

    @Override
    public void onDestroy() {
        if (mHandler != null) {
            mHandler.removeMessages(InnerHandler.DELAY_MESSAGE);
            mHandler = null;
        }

    }

    private void postDelayed(DelayCallback callback, long delayMillis) {
        if (mHandler != null) {
            Message message = mHandler.obtainMessage();
            message.what = InnerHandler.DELAY_MESSAGE;
            message.obj = callback;
            mHandler.sendMessageDelayed(message, delayMillis);
        }
    }

    private static class InnerHandler extends Handler {

        static final int DELAY_MESSAGE = 0x0000;

        private InnerHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DELAY_MESSAGE:
                    if (msg.obj instanceof DelayCallback) {
                        DelayCallback obj = (DelayCallback) msg.obj;
                        obj.doSomething();
                    }
                    break;
            }

        }
    }

    static abstract class DelayCallback {
        public abstract void doSomething();
    }
}
