package com.qwang52.model;

public class Customer {
    public Customer(){}


    private long customerid;

    private String firstname;

    private String lastname;

    private String email;

    private int postcode;

    private int phonenumber;

    public void setCustomerid(long customerid){
        this.customerid = customerid;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPostcode(int postcode){
        this.postcode = postcode;
    }
    public void setPhonenumber(int phonenumber){
        this.phonenumber = phonenumber;
    }







}
