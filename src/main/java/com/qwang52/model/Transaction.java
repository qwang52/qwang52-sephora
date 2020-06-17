package com.qwang52.model;

import java.math.BigDecimal;

public class Transaction {
    public Transaction(){}

    private long ordernumber;

    private long customerid;

    private long itemnumber;

    private BigDecimal ordertotal;

    public void setOrdernumber(long ordernumber){
        this.ordernumber = ordernumber;
    }
    public void setCustomerid(long customerid){
        this.customerid = customerid;
    }
    public void setItemnumber(long itemnumber){
        this.itemnumber = itemnumber;
    }
    public void setOrdertotal(BigDecimal ordertotal){
        this.ordertotal = ordertotal;
    }

}
