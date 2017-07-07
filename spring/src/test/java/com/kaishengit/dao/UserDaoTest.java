package com.kaishengit.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yq on 2017/7/7.
 */
public class UserDaoTest {

    @Test
    public void save() {
        //1.创建spring容器
        //从classpath中读取spring配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从容器中获取
        UserDao userDao = (UserDao) applicationContext.getBean("111");
        userDao.save();

        applicationContext.close();

//        UserDao userDao2 = (UserDao) applicationContext.getBean("userDao");
//        //userDao.save();
//        System.out.println(userDao == userDao2);
    }
}
