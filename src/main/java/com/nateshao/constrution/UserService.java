package com.nateshao.constrution;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 13:53
 */
public class UserService {
    public void save(String username,String password){
        UserDao userDao = new UserDao(username,password);
        userDao.insert();
    }
}
