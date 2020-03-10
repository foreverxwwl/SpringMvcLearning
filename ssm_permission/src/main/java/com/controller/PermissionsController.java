package com.controller;

import com.domain.Permission;
import com.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-08 23:53
 * 权限
 */
@Controller
@RequestMapping("/permission")
public class PermissionsController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    private ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save")
    private String add(Permission permission){
        permissionService.add(permission);
        return "redirect:findAll";
    }
}
