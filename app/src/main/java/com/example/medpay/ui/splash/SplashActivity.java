package com.example.medpay.ui.splash;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.example.medpay.R;
import com.example.medpay.ui.base.BaseActivity;
import com.example.medpay.ui.home.HomeActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }


    private void initView() {
        LottieAnimationView animationView = findViewById(R.id.animationView);
        animationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((int) ((Float) valueAnimator.getAnimatedValue() * 100) >= 99) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
            }
        });
    }


}