package com.service.impl;

import com.dao.OrdersDao;
import com.domain.Orders;
import com.github.pagehelper.PageHelper;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-03 20:41
 * 订单
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        List<Orders> orders = ordersDao.findAll();
        return orders;
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }


}
