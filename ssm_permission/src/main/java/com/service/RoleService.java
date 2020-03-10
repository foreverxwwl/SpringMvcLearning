package com.service;

import com.domain.Role;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-08 23:05
 */
public interface RoleService {

    public void saveRole(Role role);

    List<Role> findAll();

    public Role findById(String id);
}
