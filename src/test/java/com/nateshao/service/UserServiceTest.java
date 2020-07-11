package com.nateshao.service;

import com.nateshao.common.User;
import com.nateshao.dao.UserDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import javax.management.OperationsException;
import java.lang.management.OperatingSystemMXBean;

import static org.junit.Assert.*;

/**
 * @Author TongJie Shao
 * Created by @Author  on 2020/7/10 7:51
 */
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;

    @Test
    public void testQueryUserCount_powermock(){
//        UserDao uDao = PowerMockito.mock(UserDao.class);
////        PowerMockito.doReturn(10).when(uDao).getCount();
//
//        PowerMockito.when(uDao.getCount()).thenReturn(10);
//        UserService service = new UserService(uDao);
//        int i = service.queryUserCount();
//        assertEquals(10,i);

        UserDao dao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(dao.getCount()).thenReturn(100);
        UserService service = new UserService(dao);
        int count = service.queryUserCount();
        assertEquals(100,count);
    }

    @Ignore
    @Test
    public void testQueryUserCount_mockito() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(userDao.getCount()).thenReturn(100);
        UserService service = new UserService(userDao);
        int rs = service.queryUserCount();
        assertEquals(100, rs);


//        MockitoAnnotations.initMocks(this);
//        UserService service = new UserService(userDao);
//        Mockito.when(userDao.getCount()).thenReturn(10);
//        int result = service.queryUserCount();
//        assertEquals(10,result);
    }


    @Before
    public void setup() {
        userService = new UserService(new UserDao());
    }

    @Ignore
    @Test
    public void queryUserCount_junit() {

//        int count = userService.queryUserCount();
//        assertEquals(0,count);

        try {
            userService.queryUserCount();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }

    }


    @Test
    public void saveInsert_junit() {
        try {
            userService.saveInsert(new User());
            fail("should not coming here!!!!!");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
}