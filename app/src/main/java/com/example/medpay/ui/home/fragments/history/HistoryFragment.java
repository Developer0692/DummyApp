package com.example.medpay.ui.home.fragments.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.medpay.R;

public class HistoryFragment extends Fragment {

    private HistoryViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView(root);
        return root;
    }


    //=================== Private Methods ===================
    private void initView(View fragmentView){

        setDataObservers();
    }

    private void setDataObservers(){

    }

    //=================== Private Methods ===================


    //=================== Override Methods ===================
    //=================== Override Methods ===================









    //=================== Public Methods ===================
    //=================== Public Methods ===================
}