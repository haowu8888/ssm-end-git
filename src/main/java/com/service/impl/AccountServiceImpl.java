package com.service.impl;

import com.dao.AccountDao;
import com.domain.Account;
import com.github.pagehelper.PageHelper;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll(int page, int size) {
       // System.out.println("业务层:查询所有账户");
        PageHelper.startPage(page,size);
        return accountDao.findAll();
    }
    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public Account findById(int accountId) throws Exception {
        return accountDao.findById(accountId);
    }
}
