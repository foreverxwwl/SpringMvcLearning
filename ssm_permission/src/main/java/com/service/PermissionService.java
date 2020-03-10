package com.service;

import com.domain.Permission;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-09 0:06
 */
public interface PermissionService {
    List<Permission> findAll();
    void add(Permission permission);
}
