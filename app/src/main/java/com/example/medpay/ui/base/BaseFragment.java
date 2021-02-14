package com.example.medpay.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.medpay.utils.displayUtils.LoaderDialog;
import com.example.medpay.utils.displayUtils.Toaster;

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    public void showLoader(boolean show, String message) {
        if (show) {
            LoaderDialog.getLoaderDialog().show(getChildFragmentManager(), message);
        } else {
            LoaderDialog.getLoaderDialog().dismiss();
        }
    }

    public void showLoader(boolean show) {
        showLoader(show, "");
    }

    public void showToast(String message, boolean isSuccess) {
        Toaster.showToast(requireActivity(), message, isSuccess);
    }

    public void showToast(String message) {
        showToast(message, false);
    }

}
