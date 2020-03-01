package com;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-01 0:36
 * 产品相关DAO
 */
public interface ProductDao {

    //1.更具id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //2.查询所有产品
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
}
