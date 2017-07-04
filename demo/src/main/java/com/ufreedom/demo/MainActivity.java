package com.ufreedom.demo;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ufreedom.smartdialog.BaseDialog;
import com.ufreedom.smartdialog.DialogConfig;
import com.ufreedom.smartdialog.transition.SpringTransitions;
import com.ufreedom.smartdialog.transition.Transitions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void showDialog(View view){

        MyDialog myDialog = new MyDialog();
        myDialog.addDialogEnterTransition(SpringTransitions.create().
                withTranslateY(0,500)
                .transitions());
        myDialog.addDialogEnterTransition(Transitions.crateColor(Color.RED,Color.BLUE,1000));
        myDialog.showDialog(this);

    }

    public static class MyDialog extends BaseDialog {


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
