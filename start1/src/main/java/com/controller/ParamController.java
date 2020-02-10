package com.controller;

import com.domain.Account;
import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @outhor li
 * @create 2020-02-09 15:11
 * 测试数据封装
 */

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public void testParam(String username, String password){
        System.out.println(username+"..."+password);
    }
//
//    @RequestMapping("saveAccount")
//    public void testSaveAccount(Account account){
//        System.out.println(account);
//    }

    @RequestMapping("saveAccount")
    public void testSaveUser(Account account){
        System.out.println(account);
    }

    @RequestMapping("saveUser")
    public void testSaveUser(User user){
        System.out.println(user);
    }
}
