package com.service;

import com.domain.Account;
import java.util.List;

public interface AccountService {
        /**
         * 查询所有
         * @return
         */
        public List<Account> findAll();

        /**
         * 保存
         * @param account
         */
        public void saveAccount(Account account);
}
