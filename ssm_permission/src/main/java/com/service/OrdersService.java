package com.service;

import com.domain.Orders;
import java.util.List;

/**
 * @outhor li
 * @create 2020-03-03 20:38
 */
public interface OrdersService {

    public List<Orders> findAll(int page, int size) throws Exception;

    public Orders findById(String id) throws Exception;
}
