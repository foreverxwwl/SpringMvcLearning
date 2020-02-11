package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @outhor li
 * @create 2020-02-10 20:29
 * 一些常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})   // 把msg=美美存入到session域对中
public class AnnoController {

    /**
     * 获取请求中指定参数名称传给形参
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体参数
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /**
     * 占位符注解 PathVariable
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

    /**
     * 获取cookie的值
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    /**
     * ModelAttribute
     * 该方法在控制器方法之前执行
     */
    //方法上
    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showerUser执行了");
        //模拟数据库查询
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute (User user){
        System.out.println(user);
        return "success";
    }

    //参数上
    @ModelAttribute
    public void showUserMap(String uname, Map<String, User> map){
        System.out.println("showerUser执行了");
        //模拟数据库查询
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("user", user);
    }

    @RequestMapping("/testModelAttributeMap")
    public String testModelAttributeMap (@ModelAttribute("user") User user){
        System.out.println(user);
        return "success";
    }

    /**
     * SessionAttributes 注解
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        //存储到request域对象中 不用使用HttpServletRequest对象
        model.addAttribute("msg", "hh");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes...");
        status.setComplete();
        return "success";
    }
}
