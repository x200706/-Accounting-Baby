package com.example.accountingbaby;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DB_Name = "the_db_for_the_app";
    private static final int DB_version = 1;


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, String table_name) {
        super(context, DB_Name, null, DB_version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table = "CREATE TABLE IF NOT EXISTS Accounting (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cost_or_earn INTEGER not null," + //此處用0表示cost，1表示earn；只是為了適配器方便多開此欄位；順帶一提SQLite沒有布林型態
                "item_name TEXT not null," +
                "tag TEXT not null," +
                "date TEXT not null," + //SQLite沒有日期型態，對應為TEXT
                "amount TEXT not null" + //SQLite沒有貨幣型態，對應為TEXT，此欄要能存入負值
                ")";
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        final String drop_table = "DROP TABLE Accounting";
        sqLiteDatabase.execSQL(drop_table);
    }
}
