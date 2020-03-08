package com.dao;

import com.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-08 20:15
 */
public interface PermissionsDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findByRoleId(String roleId);
}
