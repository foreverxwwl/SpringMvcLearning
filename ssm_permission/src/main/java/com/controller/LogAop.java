package com.controller;

import com.domain.SysLog;
import com.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @outhor li
 * @create 2020-03-11 16:41
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private LocalDateTime visitTime; //开始时间
    private Class LogClass; //访问的类
    private Method method;//访问的方法

    //前置通知，获取开始时间，获取执行类和方法
    @Before("execution(* com.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = LocalDateTime.now();//访问时间
        LogClass = joinPoint.getTarget().getClass();//获取访问类
        String methodName = joinPoint.getSignature().getName(); //方法名
        Object[] args = joinPoint.getArgs();//方法参数
        //获取方法的Method对象
        if (args.length == 0||args == null){//方法没有参数
            method = LogClass.getMethod(methodName);
        }else {//方法有参数
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++){
                classArgs[i] = args[i].getClass();
            }
            LogClass.getMethod(methodName,classArgs);
        }
    }

    //后置通知
    @After("execution(* com.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws NoSuchMethodException {
        LocalDateTime endTime = LocalDateTime.now();
        //获取访问时长
        Duration duration = Duration.between(visitTime,endTime);
        String url = "";
        //获取url
        if (LogClass != null && method != null && LogClass!= LogAop.class){
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) LogClass.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();
                    //获取当前用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String userName = user.getUsername();

                    //封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(duration.toMinutes());
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + LogClass.getName() + "[方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(userName);
                    sysLog.setVisitTime(visitTime);

                    sysLogService.save(sysLog);
                 }
            }
        }

    }
}
