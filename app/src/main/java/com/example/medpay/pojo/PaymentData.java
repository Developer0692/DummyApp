package com.example.medpay.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "payment_data")
public class PaymentData {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "amount")
    public double amount;

    //0-cash
    //1-card
    //2-upi
    //3-insurance
    @ColumnInfo(name = "transactionType")
    public int transactionType;


    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "timeInMilliSeconds")
    public Long timeInMilliSeconds;

}
