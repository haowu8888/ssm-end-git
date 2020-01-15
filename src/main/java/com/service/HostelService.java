package com.service;

import com.domain.Account;
import com.domain.Hostel;

import java.util.List;

/**
 * 客房业务层
 */
public interface HostelService {
    /**
     * 查询所有
     *
     * @param page
     * @param size
     * @return
     */
    public List<Hostel> findAll(int page, int size) throws Exception;

    /**
     * 保存
     *
     * @param hostel
     */
    public void saveAccount(Hostel hostel) throws Exception;

    /**
     * 查询单个
     * @param hid
     * @return
     */
    public Hostel findById(int hid) throws Exception;
}
