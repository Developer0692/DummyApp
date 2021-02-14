package com.example.medpay.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.medpay.pojo.PaymentData;

import java.util.List;

@Dao
public interface PaymentDao {

    @Query("Select * from payment_data")
    List<PaymentData> getAll();

    @Query("Select * from payment_data where timeInMilliSeconds = :timeInMilli")
    List<PaymentData> getDataForGivenDate(Long timeInMilli);

    @Insert
    void insertAll(PaymentData... paymentData);

    @Delete
    void delete(PaymentData paymentData);

}
