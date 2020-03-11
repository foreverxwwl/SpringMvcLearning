package com.controller;

import com.domain.Role;
import com.domain.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-06 18:43
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfo = userService.findAll();
        modelAndView.setViewName("user-list");
        modelAndView.addObject("userList",userInfo);
        return modelAndView;
    }

    @RequestMapping("/saveUser")
    public String saveUser(UserInfo userInfo){
        userService.saveUser(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show1");
        return modelAndView;
    }
    //查看用户和该用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndRole(@RequestParam(name = "id", required = true) String userId){
        ModelAndView modelAndView = new ModelAndView();
        //更具id查询用户
        UserInfo userInfo = userService.findById(userId);
        //查询用户可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", otherRoles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(value = "ids", required = true) String[] roleIds){
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll";
    }
}