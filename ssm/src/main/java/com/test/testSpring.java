package com.test;

import com.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @outhor li
 * @create 2020-02-12 22:37
 */
public class testSpring {
    @Test
    public void testSpring(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:springConfig.xml");
        AccountService accountService = ac.getBean("accountService",AccountService.class);
        accountService.findAll();

    }

}
