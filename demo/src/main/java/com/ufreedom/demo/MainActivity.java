package com.ufreedom.demo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ufreedom.smartdialog.BaseDialog;
import com.ufreedom.smartdialog.DialogConfig;
import com.ufreedom.smartdialog.transition.AlphaTransition;
import com.ufreedom.smartdialog.transition.ScaleTransition;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void showDialog(View view){

        MyDialog myDialog = new MyDialog();
        myDialog.addDialogEnterTransition(new AlphaTransition());
        myDialog.addDialogEnterTransition(new ScaleTransition());

        myDialog.addDialogExitTransition(new AlphaTransition());
        myDialog.addDialogExitTransition(new ScaleTransition());
        myDialog.showDialog(this);

    }

    class MyDialog extends BaseDialog {


        @Override
        public void onInitialize(@Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onInitDialog(DialogConfig dialogConfig) {
            dialogConfig.setCanceledOnTouchOutside(true);
        }

        @Override
        public void onBindUi() {

            View view = findViewById(R.id.image_one);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismissWithAnim();
                }
            });
        }

        @Override
        public int getDialogContentLayoutResourceId() {
            return R.layout.dialog_one;
        }
    }
}
