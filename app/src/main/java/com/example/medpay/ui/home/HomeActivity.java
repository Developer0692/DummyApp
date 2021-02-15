package com.example.medpay.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.medpay.R;
import com.example.medpay.ui.base.BaseActivity;
import com.example.medpay.ui.paymentSuccess.PaymentSuccessActivity;
import com.example.medpay.utils.AppConstants;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends BaseActivity {

    private HomeViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }


    //============================= PRIVATE METHODS =========================

    private void initView() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.viewCreated(this);
        setBottomNavMenu();
        setUserActionListeners();
    }

    private void setBottomNavMenu() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void setUserActionListeners() {
        viewModel.mPaymentMode.observe(this, integer -> canDoSomethingHere(integer));
        viewModel.paymentDataSubmitSuccess.observe(this, success -> {
            if (success) {
                showSuccessScreen();
            }
        });
    }

    private void showSuccessScreen() {
        Bundle bundle = new Bundle();
        bundle.putDouble(AppConstants.BundleParamsKeys.PAYMENT_AMOUNT, viewModel.paymentAmount);
        bundle.putString(AppConstants.BundleParamsKeys.USER_MOBILE, viewModel.userMobileNumber);
        bundle.putInt(AppConstants.BundleParamsKeys.PAYMENT_MODE, viewModel.getPaymentMode());

        Intent intent = new Intent(this, PaymentSuccessActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        viewModel.resetData();
    }

    private void canDoSomethingHere(int paymentMode) {

    }

    //============================= PRIVATE METHODS =========================


    //============================= OVERRIDE METHODS =========================



    //============================= OVERRIDE METHODS =========================

}