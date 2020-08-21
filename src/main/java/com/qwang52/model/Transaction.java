package com.qwang52.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Order {
    public Order(){}

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
