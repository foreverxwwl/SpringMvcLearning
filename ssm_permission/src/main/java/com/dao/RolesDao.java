package com.dao;

import com.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-06 16:21
 */
@Repository
public interface RolesDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dao.PermissionsDao.findByRoleId"))
    })
    public List<Role> findRolesByUserId(String userId);

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void saveRole(Role role);

    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dao.PermissionsDao.findByRoleId"))
    })
    public Role findRolesById(String id);
}


