package com.controller;

import com.dao.SysLogDao;
import com.domain.SysLog;
import com.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @outhor li
 * @create 2020-03-11 17:23
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = sysLogService.findAll();
        modelAndView.addObject("sysLogs", sysLogList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

}
