package com.dao;

import com.domain.Hostel;
import com.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UsersDao {
    /**
     * 用户名查询
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    public Users findByName(String username);

    /**
     * 查找所有
     * @return
     */
    @Select("select * from users")
    List<Users> findAll();

    /**
     * 保存
     */
    @Insert("insert into users(username,password,status,role) values(#{username},#{password},#{status},#{role})")
    void saveUsers(Users users);
}
