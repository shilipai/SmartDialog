package com.ufreedom.smartdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by UFreedom on 2017/7/1.
 */

public interface IDialog {

    public void onInitialize(@Nullable Bundle savedInstanceState);

    public void onInitDialog(DialogConfig dialogConfig);

    public void onBindUi();

    public int getDialogContentLayoutResourceId();

}
