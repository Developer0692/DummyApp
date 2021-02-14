package com.example.medpay.ui.home.fragments.home.subFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.medpay.R;
import com.example.medpay.ui.base.BaseFragment;
import com.example.medpay.ui.home.HomeViewModel;
import com.example.medpay.utils.AppConstants;
import com.example.medpay.utils.validations.CommonInputValidator;
import com.google.android.material.textfield.TextInputEditText;

public class MobileNumberFragment extends BaseFragment implements View.OnClickListener {


    private HomeViewModel viewModel;
    private int paymentMode;
    private TextView tvPaymentMode;
    private Button btnBack, btnSubmit;
    private TextInputEditText tietPhoneNumber;


    public static MobileNumberFragment newInstance(Bundle args) {
        MobileNumberFragment fragment = new MobileNumberFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mobile_number, container, false);
        if (getArguments() != null && getArguments().containsKey(AppConstants.BundleParamsKeys.PAYMENT_MODE)) {
            paymentMode = getArguments().getInt(AppConstants.BundleParamsKeys.PAYMENT_MODE);
        }
        initView(root);
        return root;
    }


    private void initView(View fragmentView) {
        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        tvPaymentMode = fragmentView.findViewById(R.id.tvPaymentMode);
        btnBack = fragmentView.findViewById(R.id.btnBack);
        btnSubmit = fragmentView.findViewById(R.id.btnSubmit);
        tietPhoneNumber = fragmentView.findViewById(R.id.tietPhoneNumber);
        setPaymentMode(getPaymentMode(paymentMode));
        setEventListeners();
    }

    private void setPaymentMode(String paymentMode) {
        if (paymentMode != null && !paymentMode.isEmpty()) {
            tvPaymentMode.setText(paymentMode);
        }
    }


    private String getPaymentMode(int paymentMode) {
        switch (paymentMode) {
            case AppConstants.PaymentModes.CASH:
                return getString(R.string.txt_cash);
            case AppConstants.PaymentModes.CARD:
                return getString(R.string.txt_card);
            case AppConstants.PaymentModes.UPI:
                return getString(R.string.txt_upi);
            case AppConstants.PaymentModes.INSURANCE:
                return getString(R.string.txt_insurance);
            default:
                return "";
        }
    }

    private void setEventListeners() {
        btnSubmit.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                viewModel.setMobileFragmentBackClicked();
                break;
            case R.id.btnSubmit:
                String phoneNumber = tietPhoneNumber.getText().toString().trim();
                if (CommonInputValidator.validatePhone(phoneNumber)) {
                    viewModel.setUserWantToSubmit(phoneNumber);
                } else {
                    tietPhoneNumber.setError(getString(R.string.err_invalid_phone));
                }
                break;
            default:
                break;
        }
    }
}
