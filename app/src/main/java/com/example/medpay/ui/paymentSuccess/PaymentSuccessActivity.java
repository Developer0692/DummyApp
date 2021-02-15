package com.example.medpay.ui.paymentSuccess;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medpay.R;
import com.example.medpay.ui.base.BaseActivity;
import com.example.medpay.utils.AppConstants;
import com.example.medpay.utils.dateTimeUtils.DateUtils;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

public class PaymentSuccessActivity extends BaseActivity {

    ImageView ivBack;
    TextView tvAmount, tvPaymentMethod, tvDate, tvPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        initView();
    }


    private void initView() {
        tvAmount = findViewById(R.id.tvAmount);
        tvPaymentMethod = findViewById(R.id.tvPaymentMethod);
        tvDate = findViewById(R.id.tvDate);
        tvPhone = findViewById(R.id.tvPhone);
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(view -> {
            finish();
        });
        tvDate.setText(DateUtils.getDateString(Calendar.getInstance(), AppConstants.DateFormats.DATE_TIME_FORMAT_DEFAULT));
        getIntentData();
    }


    private void getIntentData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            double amount = bundle.getDouble(AppConstants.BundleParamsKeys.PAYMENT_AMOUNT, 0.00);
            String amountString = String.format(Locale.getDefault(),
                    "%s %s", getString(R.string.currency), getFormattedValues(amount));
            tvAmount.setText(amountString);

            tvPaymentMethod.setText(getPaymentMode(bundle.getInt(AppConstants.BundleParamsKeys.PAYMENT_MODE, -1)));

            String phone = bundle.getString(AppConstants.BundleParamsKeys.USER_MOBILE);
            if (phone.length() > 6) {
                phone = String.format("xxxxxx-%s", phone.substring(phone.length() - 5));
                tvPhone.setText(phone);
            }
        }
    }

    private String getFormattedValues(double value) {
        return new DecimalFormat("##.##").format(value);
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


}