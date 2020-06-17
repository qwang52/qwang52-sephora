package com.qwang52.repository;

import com.qwang52.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    static final String DBURL ="jdbc:postgresql://localhost:5432/sephora_dev";
    static final String USER = "admin";
    static final String PASS = "password";
    public List<Product> getProducts(){
        List<Product> products = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM products";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long itemnumber  = rs.getLong("itemnumber");
                String productname = rs.getString("productname");
                String category = rs.getString("category");
                String description = rs.getString("description");
                BigDecimal size = rs.getBigDecimal("size");
                BigDecimal price = rs.getBigDecimal("price");
                //Fill the object
                Product product = new Product();
                product.setItemnumber(itemnumber);
                product.setProductname(productname);
                product.setCategory(category);
                product.setDescription(description);
                product.setSize(size);
                product.setPrice(price);
                products.add(product);
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
        return products;
    }

    public static void main(String[] args){
        ProductDao productJDBCDao = new ProductDao();
        System.out.println(productJDBCDao.getProducts());

    }
}
