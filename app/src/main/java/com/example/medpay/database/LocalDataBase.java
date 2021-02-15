package com.example.medpay.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.airbnb.lottie.animation.content.Content;
import com.example.medpay.database.dao.PaymentDao;
import com.example.medpay.pojo.PaymentData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PaymentData.class}, version = 1)
public abstract class LocalDataBase extends RoomDatabase {

    public abstract PaymentDao getPaymentDao();


    private static volatile LocalDataBase LOCAL_DB_INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static LocalDataBase getDatabase(final Context context){
        if(LOCAL_DB_INSTANCE==null){
            synchronized (RoomDatabase.class) {
                    LOCAL_DB_INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LocalDataBase.class, "payment_database")
                            .build();
            }
        }
        return LOCAL_DB_INSTANCE;
    }

}
