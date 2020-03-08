package com.dao;

import com.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-02 18:37
 * 产品相关DAO
 */
@Repository
public interface ProductDao {

    //1.更具id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;

    //2.查询所有产品
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    //保存商品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product) throws Exception;
}
