package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @outhor li
 * @create 2020-02-12 11:04
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("controller执行了");
        return "success";
    }
}
