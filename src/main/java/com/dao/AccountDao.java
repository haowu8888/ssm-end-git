package com.dao;

import com.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户dao接口
 */
@Repository
@Transactional
public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();
    /**
     * 保存
     * @param account
     */
    @Insert("insert into account(uid,money) values(#{uid},#{money})")
    public void saveAccount(Account account);

    /**
     * 查询单个
     * @param accountId
     * @return
     */
    @Select("select * from account where id=#{id}")
    public Account findById(int accountId);
}
