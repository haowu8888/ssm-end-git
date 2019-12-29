package com.service;

import com.domain.User;

import java.util.List;

/**
 * Service层
 */
public interface  UserService {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findUser() throws Exception;
}
