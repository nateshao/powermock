package com.nateshao.mockstatic.service;

import com.nateshao.common.User;
import com.nateshao.mockstatic.dao.UserDao;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/10 7:45
 */
public class UserService {
    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveInsert(User user) {
        UserDao.insertUser(user);
    }
}
