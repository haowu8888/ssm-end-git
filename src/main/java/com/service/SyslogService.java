package com.service;

import com.domain.Syslog;

import org.springframework.stereotype.Service;

import java.util.List;


public interface SyslogService {
    void saveLog(Syslog syslog) throws Exception;

    List<Syslog> findAll(int page, int size)throws Exception;
}
