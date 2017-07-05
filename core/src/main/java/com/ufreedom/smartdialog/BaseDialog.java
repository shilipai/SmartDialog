package com.ufreedom.smartdialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.ufreedom.smartdialog.transition.DialogExitTransition;
import com.ufreedom.smartdialog.transition.DialogTransition;
import com.ufreedom.smartdialog.transition.SpringHelper;
import com.ufreedom.smartdialog.transition.TransitionHelper;
import com.ufreedom.smartdialog.transition.DialogEnterTransition;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author UFreedom
 * Date : 2016 十一月 04
 */

public abstract class BaseDialog extends DialogFragment implements IDialog {

    protected View dialogView;
    private Dialog mDialog;
    private TransitionHelper mTransitionHelper;
    private List<DialogEnterTransition> mDialogEnterTransitions = new ArrayList<>(6);
    private List<DialogExitTransition> mDialogExitTransitions = new ArrayList<>(6);
    private Unbinder mUnbinder;

    public void showDialog(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        String tag = getClass().getSimpleName();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        Fragment prev = fragmentManager.findFragmentByTag(tag);
        if (prev != null) {
            ft.remove(prev);
            ft.addToBackStack(null);
            ft.commit();
        }
        show(fragmentManager, tag);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(R.style.DialogTheme, android.support.v4.app.DialogFragment.STYLE_NO_TITLE);
        SpringHelper.init();
        onInitialize(savedInstanceState);

        initEnterTransition();
        initExitTransition();

    }

    private void initExitTransition() {
        for (DialogExitTransition mDialogExitTransition : mDialogExitTransitions) {
            if (mDialogExitTransition != null) {
                mDialogExitTransition.onInitialize();
            }
        }
    }

    private void initEnterTransition() {
        for (DialogEnterTransition mDialogEnterTransition : mDialogEnterTransitions) {
            if (mDialogEnterTransition != null) {
                mDialogEnterTransition.onInitialize();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_container_layout, container, false);
        view.setBackgroundResource(R.color.default_background);
     //   View rootView = view.findViewById(R.id.rootView);
        dialogView = LayoutInflater.from(getActivity()).inflate(getDialogContentLayoutResourceId(), (ViewGroup) view, false);
        ((ViewGroup) view).addView(dialogView);

        DialogConfig mDialogConfig = new DialogConfig(view,dialogView,mDialog);
        onInitDialog(mDialogConfig);

        mTransitionHelper = new TransitionHelper(dialogView, view);
        mUnbinder = ButterKnife.bind(dialogView);
        onBindUI();

        if (mDialogConfig.isCanceledOnTouchOutside()) {
            if (getTouchToDismissView() != null) {
                getTouchToDismissView().setOnTouchListener(new RootViewTouchListener());
            }else {
                view.setOnTouchListener(new RootViewTouchListener());
            }

            if (getInterceptTouchToDismissView() != null) {
                getInterceptTouchToDismissView().setOnTouchListener(new DialogTouchListener());
            }else {
                dialogView.setOnTouchListener(new DialogTouchListener());
            }
        }

        dialogView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                dialogView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (mDialogEnterTransitions != null) {
                    for (DialogEnterTransition enterTransition : mDialogEnterTransitions) {
                        enterTransition.applyEnterTransition(dialogView.getMeasuredWidth(), dialogView.getMeasuredHeight(), mTransitionHelper);
                    }
                }
            }
        });


        return view;

    }

    protected View getTouchToDismissView() {
        return null;
    }

    protected View getInterceptTouchToDismissView() {
        return null;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDialog = new Dialog(getActivity(), getTheme()) {
            @Override
            public void onBackPressed() {
                if (onInterceptBackPressedEvent()) return;

                super.onBackPressed();
            }
        };

        if (mDialog.getWindow() != null) {
            mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            mDialog.getWindow().setWindowAnimations(R.style.BaseDialogAnimation);
        }

        return mDialog;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (mDialogEnterTransitions != null) {
            for (DialogEnterTransition mDialogEnterTransition : mDialogEnterTransitions) {
                if (mDialogEnterTransition != null) {
                    mDialogEnterTransition.onDestroy();
                }
            }
            mDialogEnterTransitions.clear();
            mDialogEnterTransitions = null;
        }

        if (mDialogExitTransitions != null) {
            for (DialogExitTransition mDialogExitTransition : mDialogExitTransitions) {
                if (mDialogExitTransition != null) {
                    mDialogExitTransition.onDestroy();
                }
            }
            mDialogExitTransitions.clear();
            mDialogExitTransitions = null;
        }

        SpringHelper.destroy();
    }

    public void dismissWithAnim() {
        if (mDialogExitTransitions != null) {
            for (DialogExitTransition dialogExitTransition : mDialogExitTransitions) {
                if (mDialog.isShowing()) {
                    dialogExitTransition.applyExitTransition(dialogView.getWidth(), dialogView.getHeight(), mTransitionHelper, new DialogDismiss(this));
                }
            }
        }
    }
/*

    @Override
    public void dismiss() {

       else {
            super.dismiss();
        }
    }
*/

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }


    public void addDialogExitTransition(DialogExitTransition dialogExitTransition) {
        if (!mDialogExitTransitions.contains(dialogExitTransition)) {
            mDialogExitTransitions.add(dialogExitTransition);
        }
    }

    public void addDialogEnterTransition(DialogEnterTransition mDialogEnterTransition) {
        if (!mDialogEnterTransitions.contains(mDialogEnterTransition)) {
            mDialogEnterTransitions.add(mDialogEnterTransition);
        }
    }

    public void addDialogExitTransitions(List<DialogTransition> dialogExitTransitions) {
        if (dialogExitTransitions != null ) {
            for (DialogExitTransition dialogExitTransition : dialogExitTransitions) {
                addDialogExitTransition(dialogExitTransition);
            }
        }
    }

    public void addDialogEnterTransitions(List<DialogTransition> dialogEnterTransitions) {
        if (dialogEnterTransitions != null ) {
            for (DialogEnterTransition dialogEnterTransition : dialogEnterTransitions) {
                addDialogEnterTransition(dialogEnterTransition);
            }
        }
    }


    protected <V> V findViewById(int id) {
        if (dialogView == null) return null;
        return (V) dialogView.findViewById(id);
    }

    protected boolean onInterceptBackPressedEvent() {
        return false;
    }


    private class RootViewTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (mDialogExitTransitions != null && mDialogExitTransitions.size() > 0) {
                        dismissWithAnim();
                    }else {
                        dismiss();
                    }
                    break;
            }
            return false;
        }
    }


    private class DialogTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

}
