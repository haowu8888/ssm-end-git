package com.service.impl;

import com.dao.SyslogDao;
import com.domain.Syslog;
import com.github.pagehelper.PageHelper;
import com.service.SyslogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogDao syslogDao;

    @Override
    public void saveLog(Syslog syslog) throws Exception {
        syslogDao.save(syslog);
    }

    @Override
    public List<Syslog> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return syslogDao.findAll();
    }
}
