package com.dao;

import com.domain.Hostel;
import org.apache.ibatis.annotations.*;
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
     * 查询单个
     * @param id
     * @return
     */
    @Select("select * from hostel where id=#{id}")
    public Hostel findById(int id);

    /**
     * 保存
     * @param hostel
     */
    @Insert("insert into hostel(hostelName,hostelImage,hostelPrice,hostelSketch,hostelStatus,cname) values(#{hostelName},#{hostelImage},#{hostelPrice},#{hostelSketch},#{hostelStatus},#{cname})")
    public void saveHostel(Hostel hostel);

    /**
     * 更新
     * @param hostel
     */
    @Update("update hostel set hostelName=#{hostelName},hostelImage=#{hostelImage},hostelPrice=#{hostelPrice},hostelSketch=#{hostelSketch},hostelStatus=#{hostelStatus},cname=#{cname} where id=#{id}")
    public void updateHostel(Hostel hostel);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from hostel where id=#{id}")
    public void deleteHostel(int id);
}
