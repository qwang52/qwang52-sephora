package com.qwang52.repository;

import com.qwang52.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class CustomerDao {
    static final String DBURL ="jdbc:postgresql://localhost:5432/sephora_dev";
    static final String USER = "admin";
    static final String PASS = "password";
    //private Logger logger = LoggerFactory.getLogger(getClass());
    //private Logger logger = LoggerFactory.getLogger(getClass());

    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            //logger.debug("open connection...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            //logger.info("creat statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM customers";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long customerid  = rs.getLong("customerid");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int postcode = rs.getInt("postcode");
                int phonenumber = rs.getInt("phonenumber");
                //Fill the object
                Customer customer = new Customer();
                customer.setCustomerid(customerid);
                customer.setFirstname(firstname);
                customer.setLastname(lastname);
                customer.setEmail(email);
                customer.setPostcode(postcode);
                customer.setPhonenumber(phonenumber);
                customers.add(customer);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            //logger.error("error",e);
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return customers;
    }

    public static void main(String[] args){
        CustomerDao customerJDBCDao = new CustomerDao();
        System.out.println(customerJDBCDao.getCustomers());

    }
}
