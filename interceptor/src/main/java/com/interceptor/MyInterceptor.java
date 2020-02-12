package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @outhor li
 * @create 2020-02-12 11:04
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理方法 ，controller前执行
     * @param request
     * @param response
     * @param handler
     * @return true 放行 执行下一个拦截器或者controller。false 不放行 页面跳转
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了...前1111");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * 后处理方法  controller后 success.jsp页面前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了...后1111");
    }

    /**
     * success.jsp页面后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行了...最后1111");
    }
}
