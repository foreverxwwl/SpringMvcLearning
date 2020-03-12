package com.service.impl;

import com.dao.SysLogDao;
import com.domain.SysLog;
import com.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-11 17:17
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        List<SysLog> logs = sysLogDao.findAll();
        return logs;
    }
}
