package com.service;

import com.domain.Product;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-02 18:37
 */
public interface ProductService {
    public List<Product> findAll() throws Exception;

    void saveProduct(Product product) throws Exception;
}
