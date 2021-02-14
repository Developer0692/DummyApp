package com.example.medpay.utils.validations;

import com.example.medpay.utils.AppConstants;

public class CommonInputValidator {


    public static boolean validatePhone(String phone) {
        if (phone == null || phone.length() < AppConstants.PHONE_NUMBER_LENGTH) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(phone).matches();
        }
    }



    public static boolean validateAmount(double amount){
        return amount>0;
    }

}


