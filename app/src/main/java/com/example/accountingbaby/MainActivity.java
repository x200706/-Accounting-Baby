package com.example.accountingbaby;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    //宣告資料庫建立實體所需零件
    private static final String DB_Name = "the_db_for_the_app";
    private static final int DB_version = 1;
    private static final String table_name = "Accounting";
    SQLiteDatabase sqlite_db;
    Database mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new Database(this,DB_Name,null,DB_version,table_name);
        sqlite_db=mydb.getWritableDatabase(); //資料庫開
    }
}