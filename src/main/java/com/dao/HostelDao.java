package com.dao;

import com.domain.Account;
import com.domain.Hostel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 客房持久层
 */
@Repository
@Transactional
public interface HostelDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from hostel")
    public List<Hostel> findAll();
    /**
     * 保存
     * @param hostel
     */
    @Insert("insert into hostel(uid,money) values(#{uid},#{money})")
    public void saveAccount(Hostel hostel);

    /**
     * 查询单个
     * @param hid
     * @return
     */
    @Select("select * from hostel where id=#{id}")
    public Hostel findById(int hid);
}
