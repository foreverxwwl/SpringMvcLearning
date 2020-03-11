package com.service.impl;

import com.dao.RolesDao;
import com.domain.Permission;
import com.domain.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-08 23:06
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RolesDao rolesDao;

    @Override
    public void saveRole(Role role) {
        rolesDao.saveRole(role);
    }

    @Override
    public List<Role> findAll() {

        return rolesDao.findAll();
    }
    @Override
    public Role findById(String id){
        return rolesDao.findRolesById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) {
        return rolesDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, List<String> permissionIds) {

        for (String permissionId: permissionIds) {
            rolesDao.addPermissionToRole(roleId, permissionId);
        }
    }


}
