package com.service;

import com.domain.Syslog;
import org.springframework.stereotype.Service;


public interface SyslogService {
    void saveLog(Syslog syslog) throws Exception;
}
