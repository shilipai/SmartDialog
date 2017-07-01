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

import com.facebook.rebound.SpringSystem;
import com.ufreedom.smartdialog.transition.DialogExitTransition;
import com.ufreedom.smartdialog.transition.TransitionHelper;
import com.ufreedom.smartdialog.transition.DialogEnterTransition;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author UFreedom
 * Date : 2016 十一月 04
 */

public abstract  class BaseDialog extends DialogFragment implements IDialog{

    protected View dialogView;
    private boolean mCanceledOnTouchOutside = true;
    private Dialog mDialog;
    private TransitionHelper mTransitionHelper;
    private DialogEnterTransition mDialogEnterTransition;
    private DialogExitTransition mDialogExitTransition;
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
        onInitialize(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_container_layout, container, false);
        view.setBackgroundResource(R.color.default_background);
        View rootView = view.findViewById(R.id.rootView);
        dialogView = LayoutInflater.from(getActivity()).inflate(getDialogContentLayoutResourceId(), (ViewGroup) view, false);
        ((ViewGroup) view).addView(dialogView);

        DialogConfig mDialogConfig = new DialogConfig(view);
        onInitDialog(mDialogConfig);

        mTransitionHelper = new TransitionHelper(SpringSystem.create(),dialogView,view);
        mUnbinder = ButterKnife.bind(dialogView);
        onBindUi();

        if (mCanceledOnTouchOutside){
            rootView.setOnTouchListener(new RootViewTouchListener());
            dialogView.setOnTouchListener(new DialogTouchListener());
        }

        dialogView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                dialogView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (mDialogEnterTransition != null){
                    mDialogEnterTransition.applyEnterTransition(dialogView.getMeasuredWidth(),dialogView.getMeasuredHeight(), mTransitionHelper);
                }
            }
        });


        
        return view;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDialog = new Dialog(getActivity(),getTheme()){
            @Override
            public void onBackPressed() {
                if (onInterceptBackPressedEvent()) return;

                super.onBackPressed();
            }
        };

        if (mDialog.getWindow() != null){
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
    }


    @Override
    public void dismiss() {

        if (mDialogExitTransition != null) {
            mDialogExitTransition.applyEnterTransition(dialogView.getWidth(), dialogView.getHeight(), mTransitionHelper,new DialogDismiss(this));
        }else {
            super.dismiss();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

    }

    /**
     *
     *
     * Sets whether this dialog is canceled when touched outside the window's
     * bounds. If setting to true, the dialog is set to be cancelable if not
     * already set.
     *
     * @param cancel Whether the dialog should be canceled when touched outside
     *            the window.
     */
    public void setCanceledOnTouchOutside(boolean cancel) {
        mCanceledOnTouchOutside = cancel;
        mDialog.setCanceledOnTouchOutside(cancel);
    }

    public void setDialogExitTransition(DialogExitTransition dialogExitTransition) {
        this.mDialogExitTransition = dialogExitTransition;
    }

    public void setDialogEnterTransition(DialogEnterTransition mDialogEnterTransition) {
        this.mDialogEnterTransition = mDialogEnterTransition;
    }


    protected <V> V findViewById(int id) {
        if (dialogView == null) return null;
        return (V) dialogView.findViewById(id);
    }

    protected boolean onInterceptBackPressedEvent(){
        return false;
    }


    private class RootViewTouchListener implements View.OnTouchListener{
        
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    dismiss();
                    break;
            }
            return false;
        }
    }


    private class DialogTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }
    
}
