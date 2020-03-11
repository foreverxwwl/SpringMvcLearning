package com.service;

import com.domain.Role;
import com.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-06 16:00
 */
public interface UserService extends UserDetailsService {

    public List<UserInfo> findAll();

    //保存用户
    public void saveUser(UserInfo userInfo);
    //查询用户详情
    public UserInfo findById(String userId);
    //查询用户没有的角色
    public List<Role> findOtherRoles(String userId);

    public void addRoleToUser(String userId, String[] roleIds);

}
