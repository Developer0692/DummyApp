package com.example.medpay.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.medpay.database.dao.PaymentDao;
import com.example.medpay.pojo.PaymentData;

@Database(entities = {PaymentData.class}, version = 1)
public abstract class LocalDataBase extends RoomDatabase {

    public abstract PaymentDao getPaymentDao();

}
