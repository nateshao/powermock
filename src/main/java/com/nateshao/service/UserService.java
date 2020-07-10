package com.nateshao.service;

import com.nateshao.common.User;
import com.nateshao.dao.UserDao;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/10 7:45
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveInsert(User user) {
        userDao.insertUser(user);
    }
}
