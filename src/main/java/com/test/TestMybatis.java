package com.test;

import com.dao.AccountDao;
import com.domain.Account;
import com.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public  void run1() throws Exception {
       //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        // 查询所有数据
        List<Account> list = dao.findAll();
        for (Account a :
                list) {
            System.out.println(a);
        }
        // 关闭资源
        session.close();
        in.close();
    }
    @Test
    public  void run2() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        // 保存数据
        Account account = new Account();
        account.setMoney(100d);
        account.setUid(45);
        dao.saveAccount(account);
        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }
}
