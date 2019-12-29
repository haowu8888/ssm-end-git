package com.service;

import com.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有
     *
     * @param page
     * @param size
     * @return
     */
    public List<Account> findAll(int page, int size) throws Exception;

    /**
     * 保存
     *
     * @param account
     */
    public void saveAccount(Account account) throws Exception;

    /**
     * 查询单个
     * @param accountId
     * @return
     */
    public Account findById(int accountId) throws Exception;
}
