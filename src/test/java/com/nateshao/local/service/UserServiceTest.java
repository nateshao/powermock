package com.nateshao.local.service;

import com.nateshao.common.User;
import com.nateshao.local.dao.UserDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
//import static org.powermock.api.mockito.powerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.configuration.ConfigurationType.Mockito;
import static org.powermock.configuration.ConfigurationType.PowerMock;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/11 9:36
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {


    @Ignore
    @Test
    public void testQueryUserCount() {

       try{
           UserService userService = new UserService();
           UserDao userDao = mock(UserDao.class);
           whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
           doReturn(10).when(userDao).getCount();
           int result = userService.queryUserCount();
           assertEquals(10,result);

       }catch (Throwable e){
            fail();
       }

    }

    @Test
    public void saveInsert() {

        try {
            User user = new User();
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
            doNothing().when(userDao).insertUser(user);
            userService.saveInsert(user);
            org.mockito.Mockito.verify(userDao, org.mockito.Mockito.times(1)).insertUser(user);

        }catch (Throwable e){
            fail();
        }
    }
}