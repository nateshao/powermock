package com.nateshao.constrution;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 13:55
 */
public class UserDao {
    private String username;
    private String password;

    public UserDao(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void insert(){
        throw new UnsupportedOperationException();
    }
}
