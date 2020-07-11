package com.nateshao.spy;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/10 10:13
 */
public class UserServiceSpy {

    public void fool(){
        log();
    }

    public void log(){
        System.out.println("i am console log");
    }
}
