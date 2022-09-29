package com.example.accountingbaby;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Entity implements Serializable {

    //宣告屬性
    private Integer id;
    private Integer cost_or_earn; //為了在更新頁面顯示收入或支出
    private String item_name;
    private String tag;
    private String date;
    private String amount; //看起來運算時要型態轉換；實際上也會存入負值

    //建構子
    public Entity(Integer id, Integer cost_or_earn,String item_name, String tag,  String date, String amount) {
        super();
        this.id = id;
        this.cost_or_earn = cost_or_earn;
        this.item_name = item_name;
        this.tag = tag;
        this.date = date;
        this.amount = amount ;
    }

    //空參數建構子
    public Entity() {
        super();
    }


    //set get
    public Integer getId() {
        return id;
    }
    public void setCost_or_earn(Integer cost_or_earn) {
        this.cost_or_earn = cost_or_earn;
    }
    public Integer getCost_or_earn() {
        return cost_or_earn;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getAmount () {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    //終端機檢查資料變更用ToString
    @Override
    public String toString() {
        return "Entity [id=" + id + ", cost_or_earn=" + cost_or_earn + ", item_name=" + item_name + ", tag=" + tag
                + ", date=" + date + ", amount =" + amount + "]";
    }

}
