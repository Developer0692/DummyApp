package com.example.medpay.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medpay.MedPayApp;
import com.example.medpay.database.dao.PaymentDao;
import com.example.medpay.pojo.PaymentData;
import com.example.medpay.utils.dateTimeUtils.DateUtils;

import java.util.Calendar;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private PaymentDao paymentDao = MedPayApp.localDataBase.getPaymentDao();

    public MutableLiveData<Boolean> userWantToSubmit = new MutableLiveData<>();
    public MutableLiveData<Boolean> mobileFragmentBackClicked = new MutableLiveData<>();
    public MutableLiveData<Integer> mPaymentMode = new MutableLiveData<>();
    public MutableLiveData<Boolean> paymentDataSubmitSuccess = new MutableLiveData<>();
    public LiveData<List<PaymentData>> todayTransactions = new MutableLiveData<>();
    public LiveData<List<PaymentData>> allTransactions = new MutableLiveData<>();
    public LiveData<List<PaymentData>> yesterdayTransactions = new MutableLiveData<>();
    public MutableLiveData<String> yesterdayTransactionsTotal = new MutableLiveData<>();
    public MutableLiveData<String> todayTransactionsTotal = new MutableLiveData<>();

    public String userMobileNumber;

    public void getAllTransactions() {
        allTransactions = paymentDao.getAll();
    }

    public void getTodayTransactions() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
        todayTransactions = paymentDao.
                getDataForGivenDate(DateUtils.getTimeInMillisForStartOfDate(cal));
    }

    public void getYesterdayTransactions() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 2);
        todayTransactions = paymentDao.
                getDataForGivenDate(DateUtils.getTimeInMillisForStartOfDate(cal));
    }

    public void setUserWantToSubmit(String phoneNumber) {
        userMobileNumber = phoneNumber;
        userWantToSubmit.postValue(true);
    }

    public void setMobileFragmentBackClicked() {
        mobileFragmentBackClicked.postValue(true);
    }

    public void getYesterdayTotal() {
        double total = 0.00d;
        List<PaymentData> dataList = yesterdayTransactions.getValue();
        if (dataList != null && !dataList.isEmpty()) {
            for (PaymentData data : dataList) {
                total += data.amount;
            }
        }

        yesterdayTransactionsTotal.postValue(String.valueOf(total));
    }

    public void getTodayTotal() {
        double total = 0.00d;
        List<PaymentData> dataList = todayTransactions.getValue();
        if (dataList != null && !dataList.isEmpty()) {
            for (PaymentData data : dataList) {
                total += data.amount;
            }
        }

        todayTransactionsTotal.postValue(String.valueOf(total));
    }

    public void setPaymentMode(int value) {
        mPaymentMode.postValue(value);
    }

    public void submitData(PaymentData data) {
        Log.e("PAYMENT amount", data.amount + "");
        Log.e("PAYMENT date", data.date + "");
        Log.e("PAYMENT milis", data.timeInMilliSeconds + "");
        Log.e("PAYMENT mode", data.transactionType + "");
    }


    private void resetData() {
        mobileFragmentBackClicked.postValue(false);
        userWantToSubmit.postValue(false);
        mPaymentMode.postValue(-1);
    }

}