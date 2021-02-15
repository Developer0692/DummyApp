package com.example.medpay.utils;

public interface AppConstants {

    int PHONE_NUMBER_LENGTH = 10;

    interface DateFormats {
        String DATE_FORMAT_DEFAULT = "MMM dd, yyyy";
        String DATE_TIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm";
    }

    interface BundleParamsKeys {
        String PAYMENT_MODE = "payment_mode";
        String USER_MOBILE = "user_mobile";
        String PAYMENT_AMOUNT = "payment_amount";
    }


    interface PaymentModes {
        int CASH = 0;
        int CARD = 1;
        int UPI = 2;
        int INSURANCE = 3;
    }

}
