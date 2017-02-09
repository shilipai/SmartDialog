package com.ufreedom.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ufreedom.smartdialog.MaterialSmartDialog;
import com.ufreedom.smartdialog.transition.ScaleTransition;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void showDialog(View view){
        MaterialSmartDialog materialSmartDialog = new MaterialSmartDialog();
        materialSmartDialog.setDialogTransition(new ScaleTransition());
        materialSmartDialog.showDialog(this);
    }
}
