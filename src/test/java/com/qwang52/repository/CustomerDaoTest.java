package com.qwang52.repository;

import com.qwang52.model.Customer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerDaoTest {
    @Test
    public void getCustomersTect(){
        CustomerDao customerJDBCDao = new CustomerDao();
        List<Customer> customerList = customerJDBCDao.getCustomers();
        assertEquals(4,customerList.size());
    }
}
