package com.nateshao.matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 14:16
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void find() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        try {
            PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            PowerMockito.when(userDao.query("nateshao")).thenReturn("natehshao");
            UserService userService = new UserService();
            String result = userService.find("nateshao");
            assertEquals("nateshao",result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}