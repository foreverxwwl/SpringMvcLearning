package com.dao;

import com.domain.Member;
import com.domain.Orders;
import com.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-03 20:31
 * 订单
 */
@Repository
public interface OrdersDao {


    //查询所有订单
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id" ,column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.dao.ProductDao.findById"))
    })
    public List<Orders> findAll() throws Exception;

    //查询订单详情
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true, property = "id" ,column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.dao.ProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "com.dao.MemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dao.TravellerDao.findByOrdersId")),
    })
    public Orders findById(String id) throws Exception;
}
