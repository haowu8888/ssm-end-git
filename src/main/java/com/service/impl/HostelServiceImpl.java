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
    public List<Hostel> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return hostelDao.findAll();
    }
    @Override
    public void saveHostel(Hostel hostel) throws Exception {
        hostelDao.saveHostel(hostel);
    }

    @Override
    public Hostel findById(int id) throws Exception {
        return hostelDao.findById(id);
    }

    public void updateHostel(Hostel hostel) throws Exception {
        hostelDao.updateHostel(hostel);
    }

    @Override
    public void deleteHostel(int id) throws Exception {
        hostelDao.deleteHostel(id);
    }

}
