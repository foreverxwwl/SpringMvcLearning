package com.dao;

import com.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-04 23:53
 * 游客相关
 */
public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
