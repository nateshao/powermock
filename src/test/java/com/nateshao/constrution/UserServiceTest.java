package com.nateshao.constrution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 13:58
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void save() throws Exception {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        String username = "nateshao";
        String password = "123456";
        PowerMockito.whenNew(UserDao.class).withArguments(username,password).thenReturn(userDao);
        PowerMockito.doNothing().when(userDao).insert();
        UserService userService = new UserService();
        userService.save(username,password);
        Mockito.verify(userDao).insert();
    }
}