package com.example.medpay.utils.displayUtils;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.medpay.R;

public class Toaster {

    public static void showToast(Context context, String message, boolean isSuccess) {
        Toast toast = android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT);
        int backgroundColorId = R.color.toast_background_default;
        int textColorId = R.color.toast_text_default;
        if (isSuccess) {
            backgroundColorId = R.color.toast_background_Success;
            textColorId = R.color.toast_text_Success;
        }
        toast.getView().getBackground().setColorFilter(
                ContextCompat.getColor(context, backgroundColorId), PorterDuff.Mode.SRC_IN);

        TextView textView = toast.getView().findViewById(android.R.id.message);
        textView.setTextColor(ContextCompat.getColor(context, textColorId));
        toast.show();
    }

}
