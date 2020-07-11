package com.nateshao.matcher;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 14:13
 */
public class UserService {
    public String find(String name){
        UserDao userDao = new UserDao();

        return userDao.query(name);
    }

}
