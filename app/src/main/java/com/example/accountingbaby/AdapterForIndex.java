package com.example.accountingbaby;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterForIndex extends ArrayAdapter {
    AppCompatActivity MainActivity;
    //首頁需要顯示的資料放置容器
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<Integer> cost_or_earn = new ArrayList<>();
    ArrayList<String> item_name = new ArrayList<>();
    ArrayList<String> tag = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> amount = new ArrayList<>();


    public AdapterForIndex(@NonNull Context context, int resource) {
        super(context, resource);
        //裝填內容的地方，需要連接資料庫取得

    }

    @Override
    public int getCount() {
        return item_name.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = MainActivity.getLayoutInflater();
        ConstraintLayout cLayout;

        //判斷是支出還收入配置各自樣式
        if (cost_or_earn.get(position)==0) {
            cLayout = (ConstraintLayout) inflater.inflate(R.layout.cost_row, null);
            //抓出各個row文字標籤id並設定內容上去
            /*TextView price_view = test.findViewById(R.id.price_view);
            price_view.setText("價格:" + product_price.get(position) + "");
            TextView name_view = test.findViewById(R.id.name_view);
            name_view.setText(product_name.get(position) + "");*/
        } else {
            cLayout = (ConstraintLayout) inflater.inflate(R.layout.earn_row, null);
            //抓出各個row文字標籤id並設定內容上去
            /* 收入少了Tag；
             * 另外我們要釐清這邊的set似乎跟之後修改返回輸入框的值沒有直接關係，
             * 我只要在該頁面取得id就足夠叫回所有資料 */

        }

        return cLayout;
    }
}

