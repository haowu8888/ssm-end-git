package com.service;

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
    public void saveHostel(Hostel hostel) throws Exception;

    /**
     * 查询单个
     * @param hid
     * @return
     */
    public Hostel findById(int hid) throws Exception;

    /**
     * 更新
     * @param hostel
     * @throws Exception
     */
    public void updateHostel(Hostel hostel) throws Exception;

    /**
     * 删除
     * @param id
     */
    public void deleteHostel(int id) throws Exception;
}
