package com.qwang52.model;

import java.math.BigDecimal;

public class Product {
    public Product(){}

    private long itemnumber;

    private String productname;

    private String category;

    private String description;

    private BigDecimal size;

    private BigDecimal price;

    public void setItemnumber(long itemnumber){
        this.itemnumber = itemnumber;
    }
    public void setProductname(String productname){
        this.productname = productname;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setSize(BigDecimal size){
        this.size = size;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
}
