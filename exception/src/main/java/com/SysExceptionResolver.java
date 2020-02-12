package com;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @outhor li
 * @create 2020-02-12 9:46
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获取到异常对象
        SysException e = null;
        if (ex instanceof SysException){
            e = (SysException)ex;
        }else {
            e = new SysException("系统正在维护");
        }

        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //存储错误信息
        mv.addObject("errorMsg", e.getMessage());
        //跳转到错误页面
        mv.setViewName("error");
        return mv;
    }
}
