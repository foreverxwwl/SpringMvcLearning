package com.dao;

import com.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-08 20:15
 */
@Repository
public interface PermissionsDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission> findByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName, url) values(#{permissionName}, #{url})")
    public void add(Permission permission);
}
