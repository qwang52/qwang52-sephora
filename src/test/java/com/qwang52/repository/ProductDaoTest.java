package com.qwang52.repository;

import com.qwang52.model.Product;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    @Test
    public void getProductsTest(){
        ProductDao productJDBCDao = new ProductDao();
        List<Product> productList = productJDBCDao.getProducts();
        assertEquals(5,productList.size());
    }
}

