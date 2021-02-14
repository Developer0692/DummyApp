package com.example.medpay.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medpay.pojo.PaymentData;

import java.util.List;

public class HomeViewModel extends ViewModel {

    public MutableLiveData<Boolean> userWantToSubmit = new MutableLiveData<>();
    public MutableLiveData<Boolean> mobileFragmentBackClicked = new MutableLiveData<>();
    public MutableLiveData<Integer> mPaymentMode = new MutableLiveData<>();
    public MutableLiveData<Boolean> paymentDataSubmitSuccess = new MutableLiveData<>();
    public MutableLiveData<List<PaymentData>> todayTransactions = new MutableLiveData<>();
    public MutableLiveData<List<PaymentData>> yesterdayTransactions = new MutableLiveData<>();
    public MutableLiveData<String> yesterdayTransactionsTotal = new MutableLiveData<>();
    public MutableLiveData<String> todayTransactionsTotal = new MutableLiveData<>();

    public String userMobileNumber;

    public void getTodayTransactions(Long timeInMilli) {

    }

    public void getYesterdayTransactions(Long timeInMilli) {

    }

    public void setUserWantToSubmit(String phoneNumber) {
        userMobileNumber = phoneNumber;
        userWantToSubmit.postValue(true);
    }

    public void setMobileFragmentBackClicked() {
        mobileFragmentBackClicked.postValue(true);
    }

    public void getYesterdayTotal() {

    }

    public void getTodayTotal() {

    }

    public void setPaymentMode(int value) {
        mPaymentMode.postValue(value);
    }

    public void submitData(PaymentData data) {

    }


    private void resetData() {
        mobileFragmentBackClicked.postValue(false);
        userWantToSubmit.postValue(false);
        mPaymentMode.postValue(-1);
    }

}