package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @outhor li
 * @create 2020-02-09 9:52
 */

@Controller
@RequestMapping(path = "/user")
public class controller {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello springMVC");
        return "success";
    }
}
