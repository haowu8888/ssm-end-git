package com.service.impl;

import com.dao.HostelDao;
import com.domain.Hostel;
import com.github.pagehelper.PageHelper;
import com.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("hostelService")
@Transactional
public class HostelServiceImpl implements HostelService {
    @Autowired
    private HostelDao hostelDao;
    @Override
    public List<Hostel> findAll(int page, int size) {
       // System.out.println("业务层:查询所有账户");
        PageHelper.startPage(page,size);
        return hostelDao.findAll();
    }
    @Override
    public void saveHostel(Hostel hostel) {
        hostelDao.saveAccount(hostel);
    }

    @Override
    public Hostel findById(int hid) throws Exception {
        return hostelDao.findById(hid);
    }
}
