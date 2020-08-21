package com.qwang52.jdbc;

import com.qwang52.model.Transaction;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    static final String DBURL ="jdbc:postgresql://localhost:5432/sephora_dev";
    static final String USER = "admin";
    static final String PASS = "password";
    public List<Transaction> getTransactions(){
        List<Transaction> transactions = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM transactions";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long ordernumber  = rs.getLong("ordernumber");
                Long customerid = rs.getLong("customerid");
                Long itemnumber = rs.getLong("itemnumber");
                BigDecimal ordertotal = rs.getBigDecimal("ordertotal");
                //Fill the object
                Transaction transaction = new Transaction();
                //transaction.setId(id);
                //transaction.setCustomerid(customerid);
                //transaction.setItemnumber(itemnumber);
                transaction.setOrdertotal(ordertotal);
                transactions.add(transaction);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
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
        return transactions;
    }

    public static void main(String[] args){
        TransactionDao transactionJDBCDao = new TransactionDao();
        System.out.println(transactionJDBCDao.getTransactions());

    }
}
