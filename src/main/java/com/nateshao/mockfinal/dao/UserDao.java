package com.nateshao.mockfinal.dao;

import com.nateshao.common.User;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/10 7:45
 */
final public class UserDao { // 不想被继承，不想改变逻辑
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    public void insertUser(User user) {
        throw new UnsupportedOperationException();
    }
}
