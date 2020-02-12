package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @outhor li
 * @create 2020-02-11 22:09
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException {
        try {
            int a = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            //抛出
            throw new SysException("查询所有用户出错");
        }

        return "success";
    }
}
