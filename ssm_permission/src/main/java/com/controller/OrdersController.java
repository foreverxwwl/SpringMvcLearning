package com.controller;

import com.domain.Orders;
import com.github.pagehelper.PageInfo;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-03 20:29
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    @RequestMapping("/findAll")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> orders = ordersService.findAll();
//        modelAndView.addObject("ordersList", orders);
//        modelAndView.setViewName("orders-list");
//        return modelAndView;
//    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true) int size ) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> orders = ordersService.findAll(page, size);
        //分页bean
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Orders order = ordersService.findById(id);
        modelAndView.setViewName("orders-show");
        modelAndView.addObject("orders", order);
        return modelAndView;
    }



}
