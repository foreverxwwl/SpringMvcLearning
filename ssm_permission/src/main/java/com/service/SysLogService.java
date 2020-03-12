package com.service;

import com.domain.SysLog;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-11 17:16
 */
public interface SysLogService {
    public void save(SysLog sysLog);
    public List<SysLog> findAll() throws Exception;
}
