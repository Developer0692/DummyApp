package com.example.medpay.ui.home.fragments.home.subFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.Observer;

import com.example.medpay.R;
import com.example.medpay.ui.base.BaseFragment;
import com.example.medpay.ui.home.HomeViewModel;
import com.example.medpay.utils.AppConstants;

public class SelectPaymentMethodFragment extends BaseFragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private LinearLayoutCompat llInsurance, llUpi, llCard, llCash;


    public static SelectPaymentMethodFragment newInstance(Bundle args) {
        SelectPaymentMethodFragment fragment = new SelectPaymentMethodFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_payment_method_selection,
                container, false);
        initView(root);
        return root;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llCash:
                homeViewModel.setPaymentMode(AppConstants.PaymentModes.CASH);
                break;
            case R.id.llCard:
                homeViewModel.setPaymentMode(AppConstants.PaymentModes.CARD);
                break;
            case R.id.llUpi:
                homeViewModel.setPaymentMode(AppConstants.PaymentModes.UPI);
                break;
            case R.id.llInsurance:
                homeViewModel.setPaymentMode(AppConstants.PaymentModes.INSURANCE);
                break;
            default:
                break;
        }
    }


    //========== override methods ===================


    //========== Private methods ===================

    private void initView(View fragmentView) {
        llInsurance = fragmentView.findViewById(R.id.llInsurance);
        llCard = fragmentView.findViewById(R.id.llCard);
        llCash = fragmentView.findViewById(R.id.llCash);
        llUpi = fragmentView.findViewById(R.id.llUpi);

        setEventListeners();
        setUpObservers();
    }

    private void setEventListeners() {
        llUpi.setOnClickListener(this);
        llCash.setOnClickListener(this);
        llCard.setOnClickListener(this);
        llInsurance.setOnClickListener(this);
    }


    private void changePaymentCardsBackGround(int paymentMode) {
        llCash.setSelected(false);
        llCard.setSelected(false);
        llUpi.setSelected(false);
        llInsurance.setSelected(false);
        switch (paymentMode) {
            case 0:
                llCash.setSelected(true);
                break;
            case 1:
                llCard.setSelected(true);
                break;
            case 2:
                llUpi.setSelected(true);
                break;
            case 3:
                llInsurance.setSelected(true);
                break;
            default:
                break;
        }
    }


    private void setUpObservers() {
        homeViewModel.mPaymentMode.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                changePaymentCardsBackGround(integer);
            }
        });
    }

    //========== Private methods ===================


}
