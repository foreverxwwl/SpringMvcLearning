package com;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-01 0:41
 * 产品
 */

public interface ProductService {


    public List<Product> findAll() throws Exception;

}
