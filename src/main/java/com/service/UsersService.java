package com.service;

import com.domain.Hostel;
import com.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户业务层
 */
public interface UsersService extends UserDetailsService {
    /**
     * 查找所有
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Users> findAll(int page, int size) throws Exception;
}
