package com.service.impl;

import com.dao.PermissionsDao;
import com.domain.Permission;
import com.service.PermissionService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Permissions;
import java.util.List;

/**
 * @outhor li
 * @create 2020-03-09 0:07
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionsDao permissionsDao;

    @Override
    public List<Permission> findAll() {
        return permissionsDao.findAll();
    }

    @Override
    public void add(Permission permission) {
        permissionsDao.add(permission);
    }


}
