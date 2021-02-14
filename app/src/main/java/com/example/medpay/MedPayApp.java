package com.example.medpay;

import android.app.Application;

import androidx.room.Room;

import com.example.medpay.database.LocalDataBase;

public class MedPayApp extends Application {


    public LocalDataBase localDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        localDataBase = Room.databaseBuilder(getApplicationContext(),
                LocalDataBase.class, "payment_database").build();
    }
}
