package com.example.accountingbaby;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddItem extends AppCompatActivity {
    //宣告小部件
    RadioGroup c_or_e;
    RadioButton radio_cost;
    RadioButton radio_earn;

    EditText input_item_name;
    EditText input_item_tag;
    EditText input_item_date;
    EditText input_item_amount;
    Button apply_button;
    Button reset_button;

    int c_or_e_boolean;
    String final_amount;



    //宣告資料庫建立實體所需零件
    private static final String DB_Name = "the_db_for_the_app";
    private static final int DB_version = 1;
    private static final String table_name = "Accounting";
    SQLiteDatabase sqlite_db;
    Database mydb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        //抓出部件
        c_or_e=findViewById(R.id.c_or_e);
        radio_cost=findViewById(R.id.radio_cost); //1000004
        radio_earn=findViewById(R.id.radio_earn); //1000003
        input_item_name=findViewById(R.id.input_item_name);
        input_item_tag=findViewById(R.id.input_item_tag);
        input_item_date=findViewById(R.id.input_item_date);
        input_item_amount=findViewById(R.id.input_item_amount);
        apply_button=findViewById(R.id.apply_button);
        reset_button=findViewById(R.id.reset_button);

        //建立資料庫實體
        mydb=new Database(this,DB_Name,null,DB_version,table_name);
    }


    //二按鈕之onClick事件處理函數
        //新增至DB
        @SuppressLint("ResourceType")
        public void setApply_button(View view) {
            //資料庫開
            sqlite_db=mydb.getWritableDatabase();
            //處理一下radio群組的選擇結果
            if(c_or_e.getCheckedRadioButtonId()==2131165490){ //即cost被選中
                c_or_e_boolean=0;
            }else if(c_or_e.getCheckedRadioButtonId()==2131165491){ //即earn被選中
                c_or_e_boolean=1;
            }

            //量在放進資料庫前要先處理正負號
            if(c_or_e_boolean==0){ //開銷
                final_amount="-"+input_item_amount.getText().toString();
            }else if(c_or_e_boolean==1){ //收入
                final_amount=input_item_amount.getText().toString();
            }

            ContentValues contentValues = new ContentValues();
            contentValues.put("cost_or_earn",c_or_e_boolean);
            contentValues.put("item_name", input_item_name.getText().toString());
            contentValues.put("tag", input_item_tag.getText().toString());
            contentValues.put("date", input_item_date.getText().toString());
            contentValues.put("amount",final_amount);
            sqlite_db.insert(table_name,null,contentValues);
            //完成後要提示吧 吐司方法；不跳轉了，個人使用可能要連續新增
        }
        //清空文字框
        public void setReset_button(View view) {
            c_or_e.clearCheck();
            input_item_name.setText("");
            input_item_tag.setText("");
            input_item_date.setText("");
            input_item_amount.setText("");
    }

}