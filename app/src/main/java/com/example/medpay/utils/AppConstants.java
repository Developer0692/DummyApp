package com.example.medpay.utils;

public interface AppConstants {

    int PHONE_NUMBER_LENGTH = 10;

    interface DateFormats {
        String DATE_FORMAT_DEFAULT = "MMM dd, yyyy";
    }

    interface BundleParamsKeys {
        String PAYMENT_MODE = "payment_mode";
    }


    interface PaymentModes {
        int CASH = 0;
        int CARD = 1;
        int UPI = 2;
        int INSURANCE = 3;
    }

}
