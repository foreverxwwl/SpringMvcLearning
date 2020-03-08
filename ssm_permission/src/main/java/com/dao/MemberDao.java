package com.dao;

import com.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @outhor li
 * @create 2020-03-04 23:47
 * 会员相关dao
 */
@Repository
public interface MemberDao {

    @Select("select * from members where id = #{id}")
    public Member findById(String id) throws Exception;
}
