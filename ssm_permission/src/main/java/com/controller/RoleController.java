package com.controller;

import com.domain.Permission;
import com.domain.Role;
import com.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-08 23:07
 * 角色
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(Role role){
        roleService.saveRole(role);
        return "redirect:findAll";
    }

    //查看所有角色
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAll();
        modelAndView.setViewName("role-list");
        modelAndView.addObject("role", roles);
        return modelAndView;
    }

    //查看角色详情
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        modelAndView.setViewName("role-show");
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    //查看角色没有的权限
    @RequestMapping("/findOtherPermissions")
    public ModelAndView findOtherPermissions(@RequestParam("id") String roleId){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> otherPermissions = roleService.findOtherPermissions(roleId);
        modelAndView.addObject("permissionList", otherPermissions);
        modelAndView.addObject("role",role);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam("roleId") String roleId, @RequestParam("ids") List<String> ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:findAll";
    }
}
