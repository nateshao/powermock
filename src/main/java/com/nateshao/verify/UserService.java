package com.nateshao.verify;

import com.nateshao.common.User;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 12:54
 */
public class UserService {

    public void saveOrUpdate(User user){
        UserDao userDao = new UserDao();
        if (userDao.getCount(user) > 0){
            userDao.updateUser(user);
        }else {
            userDao.insertUser(user);
        }
    }
}
