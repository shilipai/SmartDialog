package com.ufreedom.smartdialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.facebook.rebound.SpringSystem;
import com.ufreedom.smartdialog.transition.TransitionHelper;
import com.ufreedom.smartdialog.transition.DialogTransition;

/**
 * Author UFreedom
 * Date : 2016 十一月 04
 */

public abstract  class BaseDialog extends DialogFragment {

    protected View dialogView;
    private boolean mCanceledOnTouchOutside = true;
    private Dialog mDialog;
    private TransitionHelper mTransitionHelper;
    private DialogTransition mDialogTransition;
    
    
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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_container_layout, container, false);
        view.setBackgroundColor(getBackgroundColor());
        View rootView = view.findViewById(R.id.rootView);
        dialogView = LayoutInflater.from(getActivity()).inflate(getDialogContentLayoutResId(), (ViewGroup) view, false);
        ((ViewGroup) view).addView(dialogView);

        mTransitionHelper = new TransitionHelper(SpringSystem.create(),dialogView,view);
        
        onInitView(dialogView);
        
        dialogView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                dialogView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                
             //   onShowDialogAnimation(dialogView.getMeasuredWidth(),dialogView.getMeasuredHeight(), mDialogHelper);
                if (mDialogTransition != null){
                    mDialogTransition.applyDialogTransition(dialogView.getMeasuredWidth(),dialogView.getMeasuredHeight(), mTransitionHelper);
                }
            }
        });

        if (mCanceledOnTouchOutside){
            rootView.setOnTouchListener(new RootViewTouchListener());
            dialogView.setOnTouchListener(new DialogTouchListener());
        }
        
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


    public void setDialogTransition(DialogTransition mDialogTransition) {
        this.mDialogTransition = mDialogTransition;
    }

    protected abstract void onInitView(View dialog);
    
  //  protected  abstract void onShowDialogAnimation(int dialogWidth,int dialogHeight,DialogHelper dialogHelper);

    protected abstract int getDialogContentLayoutResId();

    
    protected int getBackgroundColor() {
        return  Color.parseColor("#CC000000");
    }


    protected View findViewById(int id) {
        if (dialogView == null) return null;

        return dialogView.findViewById(id);
    }

    /**
     * 是否拦截onBackPressed事件
     * @return
     */
    protected boolean onInterceptBackPressedEvent(){
        return false;
    }

    

    class RootViewTouchListener implements View.OnTouchListener{
        
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


    class DialogTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }
    
}
