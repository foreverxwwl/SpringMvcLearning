package com.impl;

import com.Product;
import com.ProductDao;
import com.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-01 0:41
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> products = productDao.findAll();
        return products;
    }
}
