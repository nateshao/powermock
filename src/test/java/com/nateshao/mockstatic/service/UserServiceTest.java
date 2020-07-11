package com.nateshao.mockstatic.service;

import com.nateshao.common.User;
import com.nateshao.mockstatic.dao.UserDao;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 11:42
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    @Ignore
    @Test
    public void queryUserCount() {
        mockStatic(UserDao.class);
        PowerMockito.when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int result = userService.queryUserCount();
        assertEquals(10,result);
    }

    @Test
    public void saveInsert() {
        mockStatic(UserDao.class);
        User user = new User();
        doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveInsert(user);
        PowerMockito.verifyStatic();
    }
}