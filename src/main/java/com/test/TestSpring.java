package com.test;

import com.domain.Account;
import com.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestSpring {
    @Autowired
    private AccountService accountService;
    @Test
    public void run1() throws  Exception {
       // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       // AccountService as = ac.getBean("accountService", AccountService.class);
        List<Account> accounts = accountService.findAll(1, 5);
        for (Account a :
                accounts) {
            System.out.println(a);
        }
    }
}
