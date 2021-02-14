package com.example.medpay.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.medpay.utils.displayUtils.SuccessDialog;
import com.example.medpay.utils.displayUtils.Toaster;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    //==================== PUBLIC Methods =====================
    public void showSuccess() {
        showSuccess(null);
    }

    public void showSuccess(String message) {

    }

    public void showLoader(boolean isShow){
        if(isShow) {
            SuccessDialog.getLoaderDialog().show(getSupportFragmentManager(), "Loading dialog");
        }else{
            SuccessDialog.getLoaderDialog().dismiss();
        }
    }

    public void showToast(String message, boolean isSuccess) {
        Toaster.showToast(this, message, isSuccess);
    }

    public void showToast(String message) {
        showToast(message, false);
    }


}
