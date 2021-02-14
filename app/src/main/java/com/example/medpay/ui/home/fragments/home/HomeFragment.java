package com.example.medpay.ui.home.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.medpay.R;
import com.example.medpay.pojo.PaymentData;
import com.example.medpay.ui.base.BaseFragment;
import com.example.medpay.ui.home.HomeViewModel;
import com.example.medpay.ui.home.fragments.home.subFragments.MobileNumberFragment;
import com.example.medpay.ui.home.fragments.home.subFragments.SelectPaymentMethodFragment;
import com.example.medpay.utils.AppConstants;
import com.example.medpay.utils.dateTimeUtils.DateUtils;
import com.example.medpay.utils.validations.CommonInputValidator;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class HomeFragment extends BaseFragment {

    private HomeViewModel sharedHomeViewModel;
    private TextInputEditText tietBillAmount;
    private int mPaymentMode = -1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        return root;
    }


    //=================== Private Methods ===================
    private void initView(View fragmentView) {
        sharedHomeViewModel =
                new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        tietBillAmount = fragmentView.findViewById(R.id.tietBillAmount);
        showSelectPaymentMethodFragment();
        setUpObservers();
    }


    private void showFragment(BaseFragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.setCustomAnimations(R.anim.enter_left,
                R.anim.exit_right, R.anim.enter_right, R.anim.exit_left);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }


    private void setUpObservers() {
        sharedHomeViewModel.mobileFragmentBackClicked.observe(getViewLifecycleOwner(), isBackClicked -> {
            if (isBackClicked) {
                showSelectPaymentMethodFragment();
            }
        });
        sharedHomeViewModel.mPaymentMode.observe(getViewLifecycleOwner(), this::changeFragmentToMobileFragment);
        sharedHomeViewModel.userWantToSubmit.observe(getViewLifecycleOwner(), userWantToSubmit -> {
            if (userWantToSubmit) {
                initiateDataSubmission();
            }
        });
        sharedHomeViewModel.mPaymentMode.observe(getViewLifecycleOwner(), integer -> {
            mPaymentMode = integer;
        });
    }

    private void changeFragmentToMobileFragment(Integer integer) {
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstants.BundleParamsKeys.PAYMENT_MODE, integer);
        showFragment(MobileNumberFragment.newInstance(bundle));
    }

    private void showSelectPaymentMethodFragment() {
        showFragment(SelectPaymentMethodFragment.newInstance(null));
    }

    private void initiateDataSubmission() {
        String amountEntered = tietBillAmount.getText().toString().trim();
        if (!amountEntered.isEmpty()) {
            try {
                double amount = Double.parseDouble(amountEntered);
                if (CommonInputValidator.validateAmount(amount)) {
                    PaymentData data = new PaymentData();
                    data.amount = amount;
                    data.timeInMilliSeconds = DateUtils.
                            getTimeInMillisForStartOfDate(Calendar.getInstance());
                    data.transactionType = mPaymentMode;
                    data.date = DateUtils.getDateString(Calendar.getInstance(),
                            AppConstants.DateFormats.DATE_FORMAT_DEFAULT);
                    sharedHomeViewModel.submitData(data);
                }
            } catch (Exception e) {
                showLoader(false);
                showToast(getString(R.string.error_try_again));
            }
        }
    }


    //=================== Private Methods ===================


    //=================== Override Methods ===================


    //=================== Override Methods ===================


}