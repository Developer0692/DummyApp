package com.example.medpay.ui.home;

import android.os.Bundle;

import com.example.medpay.R;
import com.example.medpay.ui.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }


    //============================= PRIVATE METHODS =========================

    private void initView(){
        setBottomNavMenu();
        setUserActionListeners();
    }

    private void setBottomNavMenu(){
        BottomNavigationView navView = findViewById(R.id.nav_view);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void setUserActionListeners(){

    }

    //============================= PRIVATE METHODS =========================



    //============================= OVERRIDE METHODS =========================
    //============================= OVERRIDE METHODS =========================

}