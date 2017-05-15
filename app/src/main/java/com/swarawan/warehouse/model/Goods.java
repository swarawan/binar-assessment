package com.swarawan.warehouse.model;

/**
 * Created by rioswarawan on 5/15/17.
 */

public class Goods {

    public String name;
    public String total;
    public String supplier;
    public String date;

    public Goods(String name, String total, String supplier, String date) {
        this.name = name;
        this.total = total;
        this.supplier = supplier;
        this.date = date;
    }
}
