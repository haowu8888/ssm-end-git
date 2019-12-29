package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户dao包接口
 */
@Repository
@Transactional
public interface UserDao {
    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from user")
    public  List<User> findUser();
}
