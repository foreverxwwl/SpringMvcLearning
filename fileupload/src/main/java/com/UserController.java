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
    /**
     * spring文件上传
     */
    @RequestMapping("/fileupload")
    public String fileupload(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("跨服务器文件上传...");
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        //判断如果没有这个文件则创建
        File file = new File(path);
        if (!file.exists()){
            //创建文件
            file.mkdir();
        }

        //说明上传文件
        //获取名称
        String filname = upload.getOriginalFilename();
        //把文件设置成唯一名
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filname = uuid + "-"+filname;
        //文件上传
        upload.transferTo(new File(path, filname));
        return "success";
    }

}
