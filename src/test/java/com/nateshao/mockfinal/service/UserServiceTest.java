package com.nateshao.mockfinal.service;

import com.nateshao.mockfinal.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 12:30
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {
    @Mock
    private UserDao userDao;

    @Test
    public void queryUserCount() throws Exception{
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(100);
        int result = userService.queryUserCount();
        assertEquals(10,result);
    }
    @Test
    public void queryUserCountWithPowerMock() throws Exception{
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(userDao.getCount()).thenReturn(100);
        UserService userService = new UserService(userDao);
        int result1 = userService.queryUserCount();
        assertEquals(100,result1);


    }

}